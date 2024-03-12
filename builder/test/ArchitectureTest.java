import io.flogo.builder.model.architecture.ArchitectureView;
import io.flogo.builder.model.architecture.BlockView;
import io.flogo.builder.model.architecture.layers.activation.ReLULayerView;
import io.flogo.builder.model.architecture.layers.link.FlattenLayerView;
import io.flogo.builder.model.architecture.layers.link.SoftmaxLayerView;
import io.flogo.builder.model.architecture.layers.output.OneDimensionOutputView;
import io.flogo.builder.model.architecture.layers.output.ThreeDimensionsOutputView;
import io.flogo.builder.model.architecture.layers.processing.*;
import io.flogo.builder.model.architecture.sections.link.ClassificationSectionView;
import io.flogo.builder.model.architecture.sections.link.FlattenSectionView;
import io.flogo.builder.model.architecture.sections.processing.ConvolutionalSectionView;
import io.flogo.builder.model.architecture.sections.processing.LinearSectionView;
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
                                        new NormalizationLayerView(new OneDimensionOutputView(30), 0.1, 1.0E-5),
                                        new ReLULayerView(new OneDimensionOutputView(30)),
                                        new DropoutLayerView(0.8, new OneDimensionOutputView(30)))),
                                new BlockView(List.of(
                                        new LinearLayerView(new OneDimensionOutputView(30), new OneDimensionOutputView(10)),
                                        new NormalizationLayerView(new OneDimensionOutputView(10), 0.1, 1.0E-5),
                                        new ReLULayerView(new OneDimensionOutputView(10)),
                                        new DropoutLayerView(0.8, new OneDimensionOutputView(10)))
                                ),
                                new BlockView(List.of(
                                        new LinearLayerView(new OneDimensionOutputView(10), new OneDimensionOutputView(1)),
                                        new ReLULayerView(new OneDimensionOutputView(1))
                                ))
                        ))));
        System.out.println(new ArchitectureRenderer().render(architecture, "pytorch"));
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
                        new FlattenSectionView(new BlockView(List.of(new FlattenLayerView(new ThreeDimensionsOutputView(10, 10, 80), new OneDimensionOutputView(8000))))),
                        new LinearSectionView(
                                List.of(new BlockView(List.of(
                                        new LinearLayerView(new OneDimensionOutputView(8000), new OneDimensionOutputView(150)),
                                        new ReLULayerView(new OneDimensionOutputView(150))
                                )),
                                        new BlockView(List.of(
                                                new LinearLayerView(new OneDimensionOutputView(150), new OneDimensionOutputView(10)),
                                                new ReLULayerView(new OneDimensionOutputView(10))
                                        )))
                        ),
                        new ClassificationSectionView(new BlockView(List.of(
                                new SoftmaxLayerView(new OneDimensionOutputView(10))
                        )))));
        System.out.println(new ArchitectureRenderer().render(architecture, "pytorch"));
    }
}
