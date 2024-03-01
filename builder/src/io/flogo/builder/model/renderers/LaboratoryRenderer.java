package io.flogo.builder.model.renderers;

import io.flogo.builder.model.Renderer;
import io.flogo.builder.model.laboratory.*;
import io.flogo.builder.model.renderers.laboratory.ExperimentsRenderer;
import io.flogo.model.*;
import io.intino.magritte.framework.Layer;

import java.lang.reflect.Method;

public class LaboratoryRenderer implements Renderer {
    private static final LossFunctionRenderer lossFunctionRenderer = new LossFunctionRenderer();
    private static final OptimizerRenderer optimizerRenderer = new OptimizerRenderer();
    private static final CheckPointSaverRenderer checkPointSaverRenderer = new CheckPointSaverRenderer();
    private static final EarlyStopperRenderer earlyStopperRenderer = new EarlyStopperRenderer();
    private static final DatasetRenderer datasetRenderer = new DatasetRenderer();
    private static final ExperimentsRenderer experimentsRenderer = new ExperimentsRenderer(
            lossFunctionRenderer,
            optimizerRenderer);

    public LaboratoryView render(Laboratory laboratory) {
        try {
            LossFunctionView lossFunctionView = lossFunctionRenderer.render(laboratory.lossFunction());
            OptimizerView optimizerView = optimizerRenderer.render(laboratory.optimizer());
            return new LaboratoryView(
                    lossFunctionView,
                    optimizerView,
                    checkPointSaverRenderer.render(laboratory.checkPointSaver()),
                    earlyStopperRenderer.render(laboratory.earlyStopper()),
                    datasetRenderer.render(laboratory.dataset()),
                    experimentsRenderer.render(laboratory.experimentList(), lossFunctionView, optimizerView)
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
        public DatasetView render(Laboratory.Dataset dataset) throws Exception {
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
}
