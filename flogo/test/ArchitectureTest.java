import io.flogo.builder.model.architecture.ArchitectureView;
import io.flogo.builder.model.architecture.blocks.SimpleBlockView;
import io.flogo.builder.model.architecture.layers.activation.ReLULayerView;
import io.flogo.builder.model.architecture.layers.activation.SoftmaxLayerView;
import io.flogo.builder.model.architecture.layers.link.FlattenLayerView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.flogo.builder.model.architecture.layers.output.TwoDimensionsOutputView;
import io.flogo.builder.model.architecture.layers.processing.*;
import io.flogo.builder.model.architecture.sections.link.FlattenSectionView;
import io.flogo.builder.model.architecture.sections.processing.ConvolutionalSectionView;
import io.flogo.builder.model.architecture.sections.processing.LinearSectionView;
import io.flogo.builder.model.architecture.sections.processing.RecurrentSectionView;
import io.flogo.builder.operations.ArchitectureRenderer;
import org.junit.Test;

import java.util.List;

public class ArchitectureTest {
    @Test
    public void should_render_linear_architecture() {
        ArchitectureView architecture = new ArchitectureView(
                List.of(new LinearSectionView(
                        List.of(new SimpleBlockView(List.of(
                                        new LinearLayerView(new OneDimensionOutputView(12), new OneDimensionOutputView(30)),
                                        new BatchNormalizationLayerView(new OneDimensionOutputView(30), 0.1, 1.0E-5),
                                        new ReLULayerView(new OneDimensionOutputView(30)),
                                        new DropoutLayerView(new OneDimensionOutputView(30), 0.8))),
                                new SimpleBlockView(List.of(
                                        new LinearLayerView(new OneDimensionOutputView(30), new OneDimensionOutputView(10)),
                                        new BatchNormalizationLayerView(new OneDimensionOutputView(10), 0.1, 1.0E-5),
                                        new ReLULayerView(new OneDimensionOutputView(10)),
                                        new DropoutLayerView(new OneDimensionOutputView(10), 0.8))
                                ),
                                new SimpleBlockView(List.of(
                                        new LinearLayerView(new OneDimensionOutputView(10), new OneDimensionOutputView(1)),
                                        new ReLULayerView(new OneDimensionOutputView(1))
                                ))
                        ), new OneDimensionOutputView(8))), "Linear");
        System.out.println(new ArchitectureRenderer().render(architecture, "pytorch"));
    }

    @Test
    public void should_render_convolutional_architecture() {
        ArchitectureView architecture = new ArchitectureView(
                List.of(new ConvolutionalSectionView(
                        List.of(new SimpleBlockView(List.of(
                                    new ConvolutionalLayerView(new ThreeDimensionsOutputView(100, 100, 3), new ThreeDimensionsOutputView(75, 75, 40)),
                                    new ReLULayerView(new ThreeDimensionsOutputView(75, 75, 40)),
                                    new MaxPoolLayerView(new ThreeDimensionsOutputView(75, 75, 40), new ThreeDimensionsOutputView(50, 50, 40)))),
                                new SimpleBlockView(List.of(
                                        new ConvolutionalLayerView(new ThreeDimensionsOutputView(50, 50, 40), new ThreeDimensionsOutputView(25, 25, 80)),
                                        new ReLULayerView(new ThreeDimensionsOutputView(25, 25, 80)),
                                        new MaxPoolLayerView(new ThreeDimensionsOutputView(25, 25, 80), new ThreeDimensionsOutputView(10, 10, 80))))
                        ), new ThreeDimensionsOutputView(8, 8,8)), //TODO
                        new FlattenSectionView(List.of(new SimpleBlockView(List.of(new FlattenLayerView(new ThreeDimensionsOutputView(10, 10, 80), new OneDimensionOutputView(8000))))), new OneDimensionOutputView(9)),
                        new LinearSectionView(
                                List.of(new SimpleBlockView(List.of(
                                        new LinearLayerView(new OneDimensionOutputView(8000), new OneDimensionOutputView(150)),
                                        new ReLULayerView(new OneDimensionOutputView(150))
                                )),
                                        new SimpleBlockView(List.of(
                                                new LinearLayerView(new OneDimensionOutputView(150), new OneDimensionOutputView(10)),
                                                new ReLULayerView(new OneDimensionOutputView(10)),
                                                new SoftmaxLayerView(new OneDimensionOutputView(10))
                                        ))),
                                new OneDimensionOutputView(8))), "Convolutional");
        System.out.println(new ArchitectureRenderer().render(architecture,  "pytorch"));
    }

    @Test
    public void should_render_recurrent_architecture() {
        ArchitectureView architecture = new ArchitectureView(
                List.of(new RecurrentSectionView(
                        List.of(new SimpleBlockView(List.of(
                                new LSTMLayerView(new TwoDimensionsOutputView(6, 300), new TwoDimensionsOutputView(1, 20), 20, 4, RecurrentLayerView.OutputType.EndSequence, true, 0.5, List.of(new RecurrentLayerView.Reduce.SliceReduce(4, 6, new TwoDimensionsOutputView(6, 40)), new RecurrentLayerView.Reduce.LinearReduce(new TwoDimensionsOutputView(3, 40), 1, 40), new RecurrentLayerView.Reduce.LinearReduce(new TwoDimensionsOutputView(1, 40), 2, 20)))
                        ))), new OneDimensionOutputView(8)), //TODO
                        new FlattenSectionView(List.of(new SimpleBlockView(List.of(new FlattenLayerView(new OneDimensionOutputView(20), new OneDimensionOutputView(20))))), new OneDimensionOutputView(8)), //TODO
                        new LinearSectionView(
                                List.of(new SimpleBlockView(List.of(
                                                new LinearLayerView(new OneDimensionOutputView(20), new OneDimensionOutputView(150)),
                                                new ReLULayerView(new OneDimensionOutputView(150))
                                        )),
                                        new SimpleBlockView(List.of(
                                                new LinearLayerView(new OneDimensionOutputView(150), new OneDimensionOutputView(10)),
                                                new ReLULayerView(new OneDimensionOutputView(10)),
                                                new SoftmaxLayerView(new OneDimensionOutputView(10))
                                        )))
                        , new OneDimensionOutputView(8))), "Recurrent");
        System.out.println(new ArchitectureRenderer().render(architecture,  "pytorch"));
    }
}
