package io.flogo.builder.model.renderers.architecture.blockrenderers;

import io.flogo.builder.CompilationContext;
import io.flogo.builder.model.architecture.LayerView;
import io.flogo.builder.model.architecture.OutputView;
import io.flogo.builder.model.architecture.blocks.ResidualBlockView;
import io.flogo.builder.model.renderers.architecture.LayerRenderer;
import io.flogo.model.ConvolutionalSection;
import io.flogo.model.LinearSection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResidualBlockRenderer {
    private static final LayerRenderer layerRenderer = new LayerRenderer();

    public ResidualBlockView render(List<LayerView> layerViewList, LinearSection.Block block, OutputView input, CompilationContext context) {
        return ResidualBlockView.from(layerViewList, linearResidualConnectionView(layerViewList, block, input, context));
    }

    private ResidualBlockView.ShortcutView linearResidualConnectionView(List<LayerView> layerViewList, LinearSection.Block block, OutputView inputView, CompilationContext context) {
        if (!block.asResidual().shortcut().toString().equals("Custom")) return ResidualBlockView.ShortcutView.from(block.asResidual().shortcut().toString(), inputView, layerViewList.getLast().getOutputView());
        return ResidualBlockView.ShortcutView.from(linearCustomDownSamplingLayerList((block.asResidual().customShortcut().layerList()).iterator(), inputView, new ArrayList<>(), context), layerViewList.getLast().getOutputView());
    }

    private List<LayerView> linearCustomDownSamplingLayerList(Iterator<LinearSection.Block.Residual.CustomShortcut.Layer> layersIterator, OutputView input, List<LayerView> layerViews, CompilationContext context) {
        if (!layersIterator.hasNext()) return layerViews;
        layerViews.add(layerRenderer.render(layersIterator.next(), input, context));
        return linearCustomDownSamplingLayerList(layersIterator, layerViews.getLast().getOutputView(), layerViews, context);
    }



    public ResidualBlockView render(List<LayerView> layerViewList, ConvolutionalSection.Block block, OutputView input, CompilationContext context) {
        return ResidualBlockView.from(layerViewList, residualConnectionView(layerViewList, block, input, context));
    }
    private ResidualBlockView.ShortcutView residualConnectionView(List<LayerView> layerViewList, ConvolutionalSection.Block block, OutputView inputView, CompilationContext context) {
        if (!block.asResidual().shortcut().toString().equals("Custom")) return ResidualBlockView.ShortcutView.from(block.asResidual().shortcut().toString(), inputView, layerViewList.getLast().getOutputView());
        return ResidualBlockView.ShortcutView.from(customDownSamplingLayerList((block.asResidual().customShortcut().layerList()).iterator(), inputView, new ArrayList<>(), context), layerViewList.getLast().getOutputView());
    }

    private List<LayerView> customDownSamplingLayerList(Iterator<ConvolutionalSection.Block.Residual.CustomShortcut.Layer> layersIterator, OutputView input, List<LayerView> layerViews, CompilationContext context) {
        if (!layersIterator.hasNext()) return layerViews;
        layerViews.add(layerRenderer.render(layersIterator.next(), input, context));
        return customDownSamplingLayerList(layersIterator, layerViews.getLast().getOutputView(), layerViews, context);
    }
}
