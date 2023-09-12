package io.flogo.builder.model;

import io.flogo.blatt.model.*;
import io.flogo.builder.model.architecture_views.*;
import io.intino.magritte.framework.Layer;

import java.lang.reflect.Method;

public class TrainingRenderer implements Renderer {
    EarlyStopperRenderer earlyStopperRenderer = new EarlyStopperRenderer();
    LossFunctionRenderer lossFunctionRenderer = new LossFunctionRenderer();
    OptimizerRenderer optimizerRenderer = new OptimizerRenderer();

    public TrainingView render(Training training) {
        try { return new TrainingView(
                    lossFunctionRenderer.render(training.lossFunction()),
                    optimizerRenderer.render(training.optimizer()),
                    earlyStopperRenderer.render(training.earlyStopper())
            );
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public static abstract class TrainingParameterTraining implements Renderer {
        protected ParameterView createViewFor(Layer layer) throws Exception {
            return (ParameterView) getMethodToCreateView(layer).invoke(null, layer);
        }

        protected static String getName(Layer layer) {
            return layer.core$().conceptList().get(0).toString().split("\\{")[0] + "View";
        }

        protected Method getMethodToCreateView(Layer layer) throws Exception {
            return Class.forName(getClassName(layer)).getDeclaredMethod("from", layer.getClass().getSuperclass());
        }

        protected String getClassName(Layer layer) {
            return null;
        }
    }

    public static class EarlyStopperRenderer extends TrainingParameterTraining {
        public EarlyStopperView render(EarlyStopper earlyStopper) throws Exception {
            return (EarlyStopperView) createViewFor(earlyStopper);
        }

        protected String getClassName(Layer layer) {
            return EarlyStopperView.packageRoute + getName(layer);
        }
    }

    public static class LossFunctionRenderer extends TrainingParameterTraining {
        public LossFunctionView render(LossFunction lossFunction) throws Exception {
            return (LossFunctionView) createViewFor(lossFunction);
        }

        protected String getClassName(Layer layer) {
            return LossFunctionView.packageRoute + getName(layer);
        }
    }

    public static class OptimizerRenderer extends TrainingParameterTraining {
        public OptimizerView render(Optimizer optimizer) throws Exception {
            return (OptimizerView) createViewFor(optimizer);
        }

        protected String getClassName(Layer layer) {
            return OptimizerView.packageRoute + getName(layer);
        }
    }
}
