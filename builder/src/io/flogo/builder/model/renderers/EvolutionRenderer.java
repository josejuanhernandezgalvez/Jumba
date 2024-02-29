package io.flogo.builder.model.renderers;

import io.flogo.builder.model.Renderer;
import io.flogo.builder.model.evolution.*;
import io.flogo.model.*;
import io.flogo.model.Evolution.Cycle;
import io.flogo.model.Evolution.Dataset;
import io.intino.magritte.framework.Layer;

import java.lang.reflect.Method;

public class EvolutionRenderer implements Renderer {
    LossFunctionRenderer lossFunctionRenderer = new LossFunctionRenderer();
    OptimizerRenderer optimizerRenderer = new OptimizerRenderer();
    CycleRenderer cycleRenderer = new CycleRenderer();
    CheckPointSaverRenderer checkPointSaverRenderer = new CheckPointSaverRenderer();
    EarlyStopperRenderer earlyStopperRenderer = new EarlyStopperRenderer();
    DatasetRenderer datasetRenderer = new DatasetRenderer();

    public EvolutionView render(Evolution evolution) {
        try {
            return new EvolutionView(
                    lossFunctionRenderer.render(evolution.lossFunction()),
                    optimizerRenderer.render(evolution.optimizer()),
                    cycleRenderer.render(evolution.cycle()),
                    checkPointSaverRenderer.render(evolution.checkPointSaver()),
                    earlyStopperRenderer.render(evolution.earlyStopper()),
                    datasetRenderer.render(evolution.dataset())
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static abstract class TrainingParameterTraining implements Renderer {
        protected ParameterView createViewFor(Layer layer) throws Exception {
            return (ParameterView) getMethodToCreateView(layer).invoke(null, layer);
        }

        protected static String getName(Layer layer) {
            return layer.core$().conceptList().getFirst().toString().split("\\{")[0] + "View";
        }

        protected Method getMethodToCreateView(Layer layer) throws Exception {
            return Class.forName(getClassName(layer)).getDeclaredMethod("from", layer.getClass().getSuperclass());
        }

        abstract String getClassName(Layer layer);
    }

    public static class EarlyStopperRenderer extends TrainingParameterTraining {
        public EarlyStopperView render(EarlyStopper earlyStopper) throws Exception {
            return earlyStopper != null ? (EarlyStopperView) createViewFor(earlyStopper) : null;
        }

        @Override
        protected String getClassName(Layer layer) {
            return EarlyStopperView.packageRoute + getName(layer);
        }
    }

    public static class LossFunctionRenderer extends TrainingParameterTraining {
        public LossFunctionView render(LossFunction lossFunction) throws Exception {
            return (LossFunctionView) createViewFor(lossFunction);
        }

        @Override
        protected String getClassName(Layer layer) {
            return LossFunctionView.packageRoute + getName(layer);
        }
    }

    public static class OptimizerRenderer extends TrainingParameterTraining {
        public OptimizerView render(Optimizer optimizer) throws Exception {
            return (OptimizerView) createViewFor(optimizer);
        }

        @Override
        protected String getClassName(Layer layer) {
            return OptimizerView.packageRoute + getName(layer);
        }
    }

    public static class DatasetRenderer extends TrainingParameterTraining {
        public DatasetView render(Dataset dataset) throws Exception {
            return (DatasetView) createViewFor(dataset);
        }

        @Override
        protected String getClassName(Layer layer) {
            return DatasetView.class.getName();
        }
    }

    public static class CheckPointSaverRenderer extends TrainingParameterTraining {
        public CheckPointSaverView render(CheckPointSaver checkPointSaver) throws Exception {
            return checkPointSaver != null ? (CheckPointSaverView) createViewFor(checkPointSaver) : null;
        }

        @Override
        String getClassName(Layer layer) {
            return CheckPointSaverView.packageRoute + getName(layer);
        }
    }

    public static class CycleRenderer extends TrainingParameterTraining {
        public CycleView render(Cycle cycle) throws Exception {
            return (CycleView) createViewFor(cycle);
        }

        @Override
        String getClassName(Layer layer) {
            return CycleView.class.getName();
        }
    }
}
