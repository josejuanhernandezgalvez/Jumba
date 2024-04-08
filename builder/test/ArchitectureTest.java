import io.flogo.builder.model.architecture.ArchitectureView;
import io.flogo.builder.model.architecture.BlockView;
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
                        List.of(new BlockView(List.of(
                                        new LinearLayerView(new OneDimensionOutputView(12), new OneDimensionOutputView(30)),
                                        new BatchNormalizationLayerView(new OneDimensionOutputView(30), 0.1, 1.0E-5),
                                        new ReLULayerView(new OneDimensionOutputView(30)),
                                        new DropoutLayerView(new OneDimensionOutputView(30), 0.8))),
                                new BlockView(List.of(
                                        new LinearLayerView(new OneDimensionOutputView(30), new OneDimensionOutputView(10)),
                                        new BatchNormalizationLayerView(new OneDimensionOutputView(10), 0.1, 1.0E-5),
                                        new ReLULayerView(new OneDimensionOutputView(10)),
                                        new DropoutLayerView(new OneDimensionOutputView(10), 0.8))
                                ),
                                new BlockView(List.of(
                                        new LinearLayerView(new OneDimensionOutputView(10), new OneDimensionOutputView(1)),
                                        new ReLULayerView(new OneDimensionOutputView(1))
                                ))
                        ))));
        System.out.println(new ArchitectureRenderer().render(architecture, "LinearArchitecture", "pytorch"));
    }

    @Test
    public void should_render_convolutional_architecture() {
        ArchitectureView architecture = new ArchitectureView(
                List.of(new ConvolutionalSectionView(
                        List.of(new BlockView(List.of(
                                    new ConvolutionalLayerView(new ThreeDimensionsOutputView(100, 100, 3), new ThreeDimensionsOutputView(75, 75, 40)),
                                    new ReLULayerView(new ThreeDimensionsOutputView(75, 75, 40)),
                                    new MaxPoolLayerView(new ThreeDimensionsOutputView(75, 75, 40), new ThreeDimensionsOutputView(50, 50, 40)))),
                                new BlockView(List.of(
                                        new ConvolutionalLayerView(new ThreeDimensionsOutputView(50, 50, 40), new ThreeDimensionsOutputView(25, 25, 80)),
                                        new ReLULayerView(new ThreeDimensionsOutputView(25, 25, 80)),
                                        new MaxPoolLayerView(new ThreeDimensionsOutputView(25, 25, 80), new ThreeDimensionsOutputView(10, 10, 80))))
                        )),
                        new FlattenSectionView(List.of(new BlockView(List.of(new FlattenLayerView(new ThreeDimensionsOutputView(10, 10, 80), new OneDimensionOutputView(8000)))))),
                        new LinearSectionView(
                                List.of(new BlockView(List.of(
                                        new LinearLayerView(new OneDimensionOutputView(8000), new OneDimensionOutputView(150)),
                                        new ReLULayerView(new OneDimensionOutputView(150))
                                )),
                                        new BlockView(List.of(
                                                new LinearLayerView(new OneDimensionOutputView(150), new OneDimensionOutputView(10)),
                                                new ReLULayerView(new OneDimensionOutputView(10)),
                                                new SoftmaxLayerView(new OneDimensionOutputView(10))
                                        )))
                        )));
        System.out.println(new ArchitectureRenderer().render(architecture, "ConvolutionalArchitecture", "pytorch"));
    }

    @Test
    public void should_render_recurrent_architecture() {
        ArchitectureView architecture = new ArchitectureView(
                List.of(new RecurrentSectionView(
                        List.of(new BlockView(List.of(
                                new LSTMLayerView(new TwoDimensionsOutputView(6, 300), new TwoDimensionsOutputView(1, 20), 4, RecurrentLayerView.OutputType.EndSequence, true, 0.5, List.of(new RecurrentLayerView.Reduce.SliceReduce(4, 6, new TwoDimensionsOutputView(6, 40)), new RecurrentLayerView.Reduce.LinearReduce(new TwoDimensionsOutputView(3, 40), 1, 40), new RecurrentLayerView.Reduce.LinearReduce(new TwoDimensionsOutputView(1, 40), 2, 20)))
                        )))),
                        new FlattenSectionView(List.of(new BlockView(List.of(new FlattenLayerView(new OneDimensionOutputView(20), new OneDimensionOutputView(20)))))),
                        new LinearSectionView(
                                List.of(new BlockView(List.of(
                                                new LinearLayerView(new OneDimensionOutputView(20), new OneDimensionOutputView(150)),
                                                new ReLULayerView(new OneDimensionOutputView(150))
                                        )),
                                        new BlockView(List.of(
                                                new LinearLayerView(new OneDimensionOutputView(150), new OneDimensionOutputView(10)),
                                                new ReLULayerView(new OneDimensionOutputView(10)),
                                                new SoftmaxLayerView(new OneDimensionOutputView(10))
                                        )))
                        )));
        System.out.println(new ArchitectureRenderer().render(architecture, "RecurrentArchitecture", "pytorch"));
    }
}
