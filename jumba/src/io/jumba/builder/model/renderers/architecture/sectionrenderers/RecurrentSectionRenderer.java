package io.jumba.builder.model.renderers.architecture.sectionrenderers;

import io.jumba.builder.CompilationContext;
import io.jumba.builder.model.architecture.BlockView;
import io.jumba.builder.model.architecture.LayerView;
import io.jumba.builder.model.architecture.OutputView;
import io.jumba.builder.model.architecture.blocks.SimpleBlockView;
import io.jumba.builder.model.architecture.layers.processing.MapReduceGRULayerView;
import io.jumba.builder.model.architecture.layers.processing.MapReduceLSTMLayerView;
import io.jumba.builder.model.architecture.layers.processing.MapReduceRNNLayerView;
import io.jumba.builder.model.architecture.layers.processing.MapReduceRecurrentLayerView;
import io.jumba.builder.model.architecture.sections.processing.RecurrentSectionView;
import io.jumba.builder.model.renderers.architecture.SectionRenderer;
import io.jumba.model.RecurrentSection;
import io.jumba.model.RecurrentSection.Block;
import io.jumba.model.Section;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecurrentSectionRenderer extends SectionRenderer<RecurrentSectionView> {

    @Override
    public RecurrentSectionView render(Section section, OutputView input, CompilationContext context) {
        return renderSection(cast(section), input, context);
    }

    public RecurrentSectionView renderSection(RecurrentSection section, OutputView input, CompilationContext context) {
        if (section.isMapReduce()){
            SimpleBlockView firstBlock = new SimpleBlockView(List.of(renderMapReduceUnit(input, section.asMapReduce().unit(), context)));
            ArrayList<BlockView> blocks = new ArrayList<>();
            blocks.add(firstBlock);
            return new RecurrentSectionView(blockViews(section.blockList().iterator(), firstBlock.output(), blocks, context), input);
        }
        return null; // TODO
    }

    private MapReduceRecurrentLayerView renderMapReduceUnit(OutputView input, RecurrentSection.MapReduce.Unit unit, CompilationContext context) {
        if (unit.recurrent() instanceof RecurrentSection.MapReduce.Unit.LSTM lstm)
            return MapReduceLSTMLayerView.from(lstm, input, context);
        if (unit.recurrent() instanceof RecurrentSection.MapReduce.Unit.RNN rnn)
            return MapReduceRNNLayerView.from(rnn, input, context);
        if (unit.recurrent() instanceof RecurrentSection.MapReduce.Unit.GRU gru)
            return MapReduceGRULayerView.from(gru, input, context);
        throw new RuntimeException();
    }

    private List<BlockView> blockViews(Iterator<Block> blockIterator, OutputView input, ArrayList<BlockView> simpleBlockViews, CompilationContext context) {
        if (!blockIterator.hasNext()) return simpleBlockViews;
        Block nextBlock = blockIterator.next();
        simpleBlockViews.add(blockViewFor(blockLayerList(nextBlock.layerList().iterator(), input, new ArrayList<>(), context), nextBlock, input, context));
        return blockViews(blockIterator, simpleBlockViews.getLast().output(), simpleBlockViews, context);
    }

    private BlockView blockViewFor(List<LayerView> layerViews, Block block, OutputView input, CompilationContext context) {
        return new SimpleBlockView(layerViews);
    }

    private List<LayerView> blockLayerList(Iterator<Block.Layer> layersIterator, OutputView input, List<LayerView> layerViews, CompilationContext context) {
        if (!layersIterator.hasNext()) return layerViews;
        layerViews.add(render(layersIterator.next(), input, context));
        return blockLayerList(layersIterator, layerViews.getLast().getOutputView(), layerViews, context);
    }

    private RecurrentSection cast(Section section) {
        return (RecurrentSection) section;
    }
}
