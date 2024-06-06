package io.flogo.builder.operations;

import io.flogo.builder.model.laboratory.*;
import io.flogo.builder.model.laboratory.earlystoppers.LossDrivenEarlyStopperView;
import io.flogo.builder.model.laboratory.optimizers.*;
import io.flogo.builder.model.laboratory.strategies.RegressionStrategyView;
import io.flogo.model.RAdam;
import io.intino.itrules.FrameBuilder;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LaboratoryRenderer {

    public String render(LaboratoryView laboratoryView, String architecture){

        FrameBuilder builder = initFrameBuilder("main")
                .add("architecture", architecturesBuilder(architecture, laboratoryView.experimentViews()))
                .add("laboratory", laboratoryBuilder(laboratoryView))
                .add("experiment", experimentsBuilder(laboratoryView.name(), laboratoryView.experimentViews(), laboratoryView.earlyStopperView()))
                .add("optimizer", optimizerBuilders(experimentsOn(laboratoryView)))
                .add("strategy", strategyFrame(laboratoryView.strategyView(), laboratoryView.lossFunctionView()))
                .add("loss", lossBuilders(lossOn(laboratoryView)))
                .add("dataset", datasetBuilder(laboratoryView.datasetView()));
        createExperiment(laboratoryView, builder);
        return new LaboratoryTemplate().render(builder);
    }

    private List<LossFunctionView> lossOn(LaboratoryView laboratoryView){
        return laboratoryView.experimentViews().stream()
                .map(experimentView -> experimentView.lossFunctionView)
                .filter(distinctBy(LossFunctionView::getClass))
                .collect(Collectors.toList());
    }

    public static <T> Predicate<T> distinctBy(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    private List<ExperimentView> experimentsOn(LaboratoryView laboratoryView){
        return laboratoryView.experimentViews()
                .stream()
                .filter(distinctBy(experimentView -> experimentView.optimizerView.getClass()))
                .collect(Collectors.toList());
    }

    private FrameBuilder[] architecturesBuilder(String architectureName, List<ExperimentView> experimentViews) {
        return experimentViews.stream()
                .map(experimentView -> architectureBuilder(architectureName, experimentView))
                .toArray(FrameBuilder[]::new);
    }

    private FrameBuilder architectureBuilder(String architectureName, ExperimentView experimentView) {
        return initFrameBuilder("architecture")
                .add("name", experimentView.name);
        //.add("experiment_name", experimentView.name);
    }

    private FrameBuilder[] experimentsBuilder(String laboratoryName, List<ExperimentView> experimentViews, EarlyStopperView earlyStopperView) {
        return experimentViews.stream()
                .map(experimentView -> experimentBuilder(laboratoryName, experimentView, earlyStopperView))
                .toArray(FrameBuilder[]::new);
    }

    private FrameBuilder[] lossBuilders(List<LossFunctionView> lossFunctionViews){
        return lossFunctionViews.stream()
                .map(this::lossBuilder)
                .toArray(FrameBuilder[]::new);
    }

    private FrameBuilder[] optimizerBuilders(List<ExperimentView> experimentViews){
        return experimentViews.stream()
                .map(experimentView -> optimizerBuilder(experimentView.optimizerView, experimentView.name))
                .toArray(FrameBuilder[]::new);
    }

    private FrameBuilder experimentBuilder(String laboratoryName, ExperimentView experimentView, EarlyStopperView earlyStopperView) {
        FrameBuilder builder = initFrameBuilder("experiment")
                .add("experiment_name", experimentView.name)
                .add("architecture_name", experimentView.name)
                .add("optimizer", optimizerBuilder(experimentView.optimizerView, experimentView.name))
                .add("loss", lossBuilder(experimentView.lossFunctionView))
                .add("laboratory_name", laboratoryName);
        if (earlyStopperView == null) return builder;
        return builder.add("early_stopper", stopperBuilder(earlyStopperView));
    }

    private FrameBuilder stopperBuilder(EarlyStopperView earlyStopperView) {
        FrameBuilder builder = initFrameBuilder("early_stopper");
        switch (earlyStopperView){
            case LossDrivenEarlyStopperView lossDrivenEarlyStopperView -> builder
                    .add("patience", lossDrivenEarlyStopperView.patience)
                    .add("delta", lossDrivenEarlyStopperView.threshold);
            default -> {}
        }
        return builder;
    }

    private FrameBuilder laboratoryBuilder(LaboratoryView laboratoryView) {
        return initFrameBuilder("laboratory")
                .add("laboratoryName", laboratoryView.name())
                .add("eras", laboratoryView.eras())
                .add("epochs", laboratoryView.epochs())
                .add("strategy", strategyFrame(laboratoryView.strategyView(), laboratoryView.lossFunctionView()))
                .add("device", laboratoryView.deviceView().value());
    }

    private FrameBuilder initFrameBuilder(String ... type) {
        return new FrameBuilder(type).add("library", "pytorch");
    }

    private FrameBuilder strategyFrame(StrategyView strategyView, LossFunctionView lossFunctionView) {
        FrameBuilder builder = initFrameBuilder("strategy")
                .add("name", strategyName(strategyView));
        if (strategyView instanceof RegressionStrategyView) builder.add("loss", lossBuilder(lossFunctionView));
        return builder;
    }

    private FrameBuilder datasetBuilder(DatasetView datasetView) {
        return initFrameBuilder("dataset")
                .add("datasetName", datasetView.name())
                .add("batchSize", datasetView.batchSize())
                .add("seed", ThreadLocalRandom.current().nextInt(0, 1000 + 1))
                .add("trainProportion", datasetView.split().train)
                .add("valProportion", datasetView.split().validation)
                .add("testProportion", datasetView.split().test);
    }

    private FrameBuilder optimizerBuilder(OptimizerView optimizerView, String architectureName) {
        FrameBuilder builder = initFrameBuilder("optimizer", optimizerName(optimizerView))
                .add("architecture_name", architectureName)
                .add("name", optimizerName(optimizerView));
        switch (optimizerView){
            case SGDView sgdView -> builder.add("lr", sgdView.learningRate)
                        .add("momentum", sgdView.momentum)
                        .add("dampening", sgdView.momentumDecay)
                        .add("weight_decay", sgdView.weightDecay);
            case AdadeltaView adaDelta ->
                builder.add("lr", adaDelta.learningRate)
                        .add("rho", adaDelta.rho)
                        .add("eps", adaDelta.eps)
                        .add("weight_decay", adaDelta.weightDecay);
            case AdagradView adagrad ->
                builder.add("lr", adagrad.learningRate)
                        .add("lr_decay", adagrad.learningRateDecay)
                        .add("eps", adagrad.eps)
                        .add("weight_decay", adagrad.weightDecay);
            case AdamView adam ->
                builder.add("lr", adam.learningRate)
                        .add("b0", adam.beta0)
                        .add("b1", adam.beta1)
                        .add("eps", adam.eps)
                        .add("weight_decay", adam.weightDecay);
            case AdamaxView adamax ->
                    builder.add("lr", adamax.learningRate)
                            .add("b0", adamax.beta0)
                            .add("b1", adamax.beta1)
                            .add("eps", adamax.eps)
                            .add("weight_decay", adamax.weightDecay);
            case AdamWView adamW ->
                    builder.add("lr", adamW.learningRate)
                            .add("b0", adamW.beta0)
                            .add("b1", adamW.beta1)
                            .add("eps", adamW.eps)
                            .add("weight_decay", adamW.weightDecay);
            case AMSGradView amsGrad ->
                    builder.add("lr", amsGrad.learningRate)
                            .add("b0", amsGrad.beta0)
                            .add("b1", amsGrad.beta1)
                            .add("eps",  amsGrad.eps)
                            .add("weight_decay", amsGrad.weightDecay);
            case ASGDView asgdView ->
                    builder.add("lr", asgdView.learningRate)
                            .add("alpha", asgdView.alpha)
                            .add("t0", asgdView.learningRateDecay)
                            .add("weight_decay", asgdView.weightDecay);
            case NAdamView nAdam ->
                    builder.add("lr", nAdam.learningRate)
                            .add("b0", nAdam.beta0)
                            .add("b1", nAdam.beta1)
                            .add("eps", nAdam.eps)
                            .add("weight_decay", nAdam.weightDecay);
            case RPropView rProp ->
                    builder.add("lr", rProp.learningRate)
                            .add("eta0", rProp.eta0)
                            .add("eta1", rProp.eta1)
                            .add("step0", rProp.stepSize0)
                            .add("step1", rProp.stepSize1);
            case RAdam rAdam ->
                    builder.add("lr", rAdam.lr())
                            .add("b0", rAdam.betas().beta0())
                            .add("b1", rAdam.betas().beta1())
                            .add("eps", rAdam.eps())
                            .add("weight_decay", rAdam.weightDecay());
            case RMSPropView rmsProp ->
                builder.add("lr", rmsProp.learningRate)
                        .add("alpha", rmsProp.alpha)
                        .add("eps", rmsProp.eps)
                        .add("weight_decay", rmsProp.weightDecay)
                        .add("momentum", rmsProp.momentum);
            case SparseAdamView sparseAdam ->
                    builder.add("lr", sparseAdam.learningRate)
                            .add("b0", sparseAdam.beta0)
                            .add("b1", sparseAdam.beta1)
                            .add("eps", sparseAdam.eps);
            case LBFGSView lbfgs ->
                    builder.add("lr", lbfgs.learningRate)
                            .add("max_iterations", lbfgs.maxIter);

            default -> {}

        }
        return builder;
    }

    private FrameBuilder lossBuilder(LossFunctionView lossFunctionView){
        return initFrameBuilder("loss")
                .add("name", lossName(lossFunctionView));
    }

    private String lossName(ParameterView view) {
        String className = className(view);
        return functionName(className, className.indexOf("LossView"));
    }

    private String strategyName(ParameterView view) {
        String className = className(view);
        return functionName(className, className.indexOf("StrategyView"));
    }

    private String optimizerName(ParameterView view) {
        String className = className(view);
        return functionName(className, className.indexOf("View"));
    }


    private String functionName(String className, int index) {
        return className.substring(0, index);
    }

    private void createExperiment(LaboratoryView laboratoryView, FrameBuilder builder) {
        builder.add("experimentName", laboratoryView.experimentViews().getFirst().name);
    }

    public String className(Object object){
        return object.getClass().getSimpleName();
    }
}