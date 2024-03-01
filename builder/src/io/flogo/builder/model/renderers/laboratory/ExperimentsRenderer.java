package io.flogo.builder.model.renderers.laboratory;

import io.flogo.builder.model.Renderer;
import io.flogo.builder.model.laboratory.ExperimentView;
import io.flogo.builder.model.laboratory.LossFunctionView;
import io.flogo.builder.model.laboratory.OptimizerView;
import io.flogo.builder.model.laboratory.SubstituteView;
import io.flogo.model.Laboratory;
import io.flogo.model.Laboratory.Experiment.Substitute;

import java.util.List;

import static io.flogo.builder.model.renderers.LaboratoryRenderer.*;

public class ExperimentsRenderer implements Renderer {
    private final ExperimentRenderer experimentRenderer;

    public ExperimentsRenderer(LossFunctionRenderer lossFunctionRenderer, OptimizerRenderer optimizerRenderer) {
        experimentRenderer = new ExperimentRenderer(lossFunctionRenderer, optimizerRenderer);
    }

    public List<ExperimentView> render(List<Laboratory.Experiment> experiments, LossFunctionView lossFunctionView, OptimizerView optimizerView) {
        experimentRenderer.set(lossFunctionView, optimizerView);
        return experiments.stream().map(experimentRenderer::render).toList();
    }


    private static class ExperimentRenderer {
        private final LossFunctionRenderer lossFunctionRenderer;
        private final OptimizerRenderer optimizerRenderer;
        private LossFunctionView lossFunctionView;
        private OptimizerView optimizerView;

        public ExperimentRenderer(LossFunctionRenderer lossFunctionRenderer, OptimizerRenderer optimizerRenderer) {
            this.lossFunctionRenderer = lossFunctionRenderer;
            this.optimizerRenderer = optimizerRenderer;
        }

        public void set(LossFunctionView lossFunctionView, OptimizerView optimizerView) {
            this.lossFunctionView = lossFunctionView;
            this.optimizerView = optimizerView;
        }

        private ExperimentView render(Laboratory.Experiment experiment) {
            return new ExperimentView(name(experiment),
                    lossFunctionView(experiment, lossFunctionView),
                    optimizerView(experiment, optimizerView),
                    substitutes(experiment.substituteList()));
        }

        private List<SubstituteView> substitutes(List<Substitute> substitutes) {
            return substitutes.stream().map(SubstituteRenderer::render).toList();
        }

        private OptimizerView optimizerView(Laboratory.Experiment experiment, OptimizerView optimizerView) {
            try {
                return experiment.optimizer() == null ? optimizerView : optimizerRenderer.render(experiment.optimizer());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }    }

        private LossFunctionView lossFunctionView(Laboratory.Experiment experiment, LossFunctionView lossFunctionView) {
            try {
                return experiment.lossFunction() == null ? lossFunctionView : lossFunctionRenderer.render(experiment.lossFunction());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private static String name(Laboratory.Experiment experiment) {
            return experiment.toString().split("\\$")[1];
        }

        private static class SubstituteRenderer {
            public static SubstituteView render(Substitute substitute) {
                return new SubstituteView(substitute.id(), substitute.layer());
            }
        }
    }



}
