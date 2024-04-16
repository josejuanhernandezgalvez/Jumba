package io.flogo.builder.operations;

import io.flogo.builder.model.laboratory.*;
import io.flogo.builder.model.laboratory.optimizers.*;
import io.flogo.model.RAdam;
import io.intino.itrules.FrameBuilder;

import java.util.List;

public class LaboratoryRenderer {

    public String render(LaboratoryView view){
        FrameBuilder builder = initFrameBuilder("main")
                .add("laboratory", laboratoryBuilder(view))
                .add("experiment", experimentsBuilder(view.experimentViews()))
                .add("optimizer", optimizerFrame(view.optimizerView()))
                .add("strategy", strategyFrame(view.strategyView()))
                .add("loss", lossBuilder(view.lossFunctionView()))
                .add("dataset", datasetBuilder(view.datasetView()))
                .add("stopper", stopperBuilder(view.earlyStopperView()));
        createExperiment(view, builder);
        return new LaboratoryTemplate().render(builder);
    }

    private FrameBuilder[] experimentsBuilder(List<ExperimentView> experimentViews) {
        return experimentViews.stream()
                .map(this::experimentBuilder)
                .toArray(FrameBuilder[]::new);
    }

    private FrameBuilder experimentBuilder(ExperimentView experimentView) {
        return initFrameBuilder("experiment")
                .add("experimentName", experimentView.name)
                .add("optimizer", optimizerFrame(experimentView.optimizerView))
                .add("loss", lossBuilder(experimentView.lossFunctionView))
                .add("epochs", 10) // earlyStopperView.stopperEpochs
                .add("patience", 0.01)
                .add("path", "C:/Users/juanc/Downloads/folder/test.pt");
    }

    private FrameBuilder stopperBuilder(EarlyStopperView earlyStopperView) {
        return initFrameBuilder("stopper")
                .add("epochs", 10) // earlyStopperView.stopperEpochs
                .add("patience", 0.01);
    }

    private FrameBuilder laboratoryBuilder(LaboratoryView laboratoryView) {
        return initFrameBuilder("laboratory")
                .add("laboratoryName", "LaboratoryName") // view.name
                .add("eras", 1)
                .add("epochs", 10) // view.epochs
                .add("path", "C:/Users/juanc/Downloads/folder/result.tsv")
                .add("strategy", strategyFrame(laboratoryView.strategyView()));
    }

    private FrameBuilder initFrameBuilder(String ... type) {
        return new FrameBuilder(type).add("library", "pytorch");
    }

    private FrameBuilder strategyFrame(StrategyView strategyView) {
        return initFrameBuilder("strategy")
                .add("name", strategyName(strategyView));
    }

    private FrameBuilder datasetBuilder(DatasetView datasetView) {
        return initFrameBuilder("dataset")
                .add("datasetName", datasetView.name())
                .add("batchSize", datasetView.batchSize())
                .add("trainProportion", datasetView.split().train)
                .add("valProportion", datasetView.split().validation)
                .add("testProportion", datasetView.split().test);
    }

    private FrameBuilder optimizerFrame(OptimizerView optimizerView) {
        FrameBuilder builder = initFrameBuilder("optimizer", optimizerName(optimizerView));
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
                        .add("eps", "00.1") //TODO
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
                            .add("eps",  0.01)//TODO
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
        createEarlyStopper(laboratoryView.earlyStopperView(), builder);
    }

    private void createEarlyStopper(EarlyStopperView earlyStopperView, FrameBuilder builder) {
        builder.add("stopperEpochs", 10); // earlyStopperView.stopperEpochs
        builder.add("patiente", 0.01); // earlyStopperView.patience
    }

    public String className(Object object){
        return object.getClass().getSimpleName();
    }
}