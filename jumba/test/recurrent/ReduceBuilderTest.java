package recurrent;

import io.jumba.builder.model.architecture.layers.output.TwoDimensionsOutputView;
import io.jumba.builder.model.architecture.layers.processing.RecurrentLayerView;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.jumba.builder.model.architecture.layers.processing.RecurrentLayerView.OutputType.*;

public class ReduceBuilderTest {
    private final TwoDimensionsOutputView previousOutputView = new TwoDimensionsOutputView(8, 20);
    private final TwoDimensionsOutputView previousOutputViewForEndSequence = new TwoDimensionsOutputView(6, 20);

    @Test
    public void last_hidden_state_bidirectional_true_flatten() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                LastHiddenState,
                true,
                "flatten",
                7,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(7, 8, previousOutputView),
                new RecurrentLayerView.Reduce.FlattenReduce(new TwoDimensionsOutputView(2,20)));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void last_hidden_state_bidirectional_true_linear() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                LastHiddenState,
                true,
                "linear",
                7,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(7, 8, previousOutputView),
                new RecurrentLayerView.Reduce.LinearReduce(new TwoDimensionsOutputView(2,20), 1, 1));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void last_hidden_state_bidirectional_false_flatten() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                LastHiddenState,
                false,
                "flatten",
                8,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(8, 8, previousOutputView));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
    }

    @Test
    public void last_hidden_state_bidirectional_false_linear() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                LastHiddenState,
                false,
                "linear",
                8,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(8, 8, previousOutputView),
                new RecurrentLayerView.Reduce.LinearReduce(new TwoDimensionsOutputView(1, 20), 1, 1));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void last_cell_state_bidirectional_true_flatten() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                LastCellState,
                true,
                "flatten",
                7,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(7, 8, previousOutputView),
                new RecurrentLayerView.Reduce.FlattenReduce(new TwoDimensionsOutputView(2,20)));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void last_cell_state_bidirectional_true_linear() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                LastCellState,
                true,
                "linear",
                7,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(7, 8, previousOutputView),
                new RecurrentLayerView.Reduce.LinearReduce(new TwoDimensionsOutputView(2,20), 1, 1));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void last_cell_state_bidirectional_false_flatten() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                LastCellState,
                false,
                "flatten",
                8,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(8, 8, previousOutputView));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
    }

    @Test
    public void last_cell_state_bidirectional_false_linear() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                LastCellState,
                false,
                "linear",
                8,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(8, 8, previousOutputView),
                new RecurrentLayerView.Reduce.LinearReduce(new TwoDimensionsOutputView(1, 20), 1, 1));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void hidden_states_bidirectional_true_flatten() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                HiddenStates,
                true,
                "flatten",
                1,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.FlattenReduce(previousOutputView));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
    }

    @Test
    public void hidden_states_bidirectional_true_linear() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                HiddenStates,
                true,
                "linear",
                1,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.LinearReduce(previousOutputView, 1, 1));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
    }

    @Test
    public void hidden_states_bidirectional_false_flatten() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                HiddenStates,
                false,
                "flatten",
                1,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.FlattenReduce(previousOutputView));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
    }

    @Test
    public void hidden_states_bidirectional_false_linear() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                HiddenStates,
                true,
                "linear",
                1,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.LinearReduce(previousOutputView, 1, 1));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
    }

    @Test
    public void hidden_states_bidirectional_true_flatten_with_slice() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                HiddenStates,
                true,
                "flatten",
                5,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(5, 8, previousOutputView),
                new RecurrentLayerView.Reduce.FlattenReduce(new TwoDimensionsOutputView(4, 20)));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void hidden_states_bidirectional_true_linear_with_slice() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                HiddenStates,
                true,
                "linear",
                5,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(5, 8, previousOutputView),
                new RecurrentLayerView.Reduce.LinearReduce(new TwoDimensionsOutputView(4, 20), 1, 1));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void hidden_states_bidirectional_false_flatten_with_slice() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                HiddenStates,
                false,
                "flatten",
                5,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(5, 8, previousOutputView),
                new RecurrentLayerView.Reduce.FlattenReduce(new TwoDimensionsOutputView(4, 20)));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void hidden_states_bidirectional_false_linear_with_slice() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                HiddenStates,
                false,
                "linear",
                5,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(5, 8, previousOutputView),
                new RecurrentLayerView.Reduce.LinearReduce(new TwoDimensionsOutputView(4, 20), 1, 1));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void cell_states_bidirectional_true_flatten() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                CellStates,
                true,
                "flatten",
                1,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.FlattenReduce(previousOutputView));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
    }

    @Test
    public void cell_states_bidirectional_true_linear() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                CellStates,
                true,
                "linear",
                1,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.LinearReduce(previousOutputView, 1, 1));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
    }

    @Test
    public void cell_states_bidirectional_false_flatten() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                CellStates,
                false,
                "flatten",
                1,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.FlattenReduce(previousOutputView));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
    }

    @Test
    public void cell_states_bidirectional_false_linear() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                CellStates,
                false,
                "linear",
                1,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.LinearReduce(previousOutputView, 1, 1));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
    }

    @Test
    public void cell_states_bidirectional_true_flatten_with_slice() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                CellStates,
                true,
                "flatten",
                5,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(5, 8, previousOutputView),
                new RecurrentLayerView.Reduce.FlattenReduce(new TwoDimensionsOutputView(4, 20)));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }


    @Test
    public void cell_states_bidirectional_true_linear_with_slice() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                CellStates,
                true,
                "linear",
                5,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(5, 8, previousOutputView),
                new RecurrentLayerView.Reduce.LinearReduce(new TwoDimensionsOutputView(4, 20), 1, 1));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void cell_states_bidirectional_false_flatten_with_slice() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                CellStates,
                false,
                "flatten",
                5,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(5, 8, previousOutputView),
                new RecurrentLayerView.Reduce.FlattenReduce(new TwoDimensionsOutputView(4, 20)));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }


    @Test
    public void cell_states_bidirectional_false_linear_with_slice() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputView,
                CellStates,
                false,
                "linear",
                5,
                8).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(5, 8, previousOutputView),
                new RecurrentLayerView.Reduce.LinearReduce(new TwoDimensionsOutputView(4, 20), 1, 1));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void end_sequence_bidirectional_true_flatten() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputViewForEndSequence,
                EndSequence,
                true,
                "flatten",
                1,
                6).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.FlattenReduce(previousOutputViewForEndSequence));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
    }

    @Test
    public void end_sequence_bidirectional_true_linear() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputViewForEndSequence,
                EndSequence,
                true,
                "linear",
                1,
                6).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.LinearReduce(previousOutputViewForEndSequence, 1, 1),
                new RecurrentLayerView.Reduce.LinearReduce(new TwoDimensionsOutputView(1, 20), 2, 10));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void end_sequence_bidirectional_false_flatten() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputViewForEndSequence,
                EndSequence,
                false,
                "flatten",
                1,
                6).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.FlattenReduce(previousOutputViewForEndSequence));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
    }

    @Test
    public void end_sequence_bidirectional_false_linear() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputViewForEndSequence,
                EndSequence,
                false,
                "linear",
                1,
                6).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.LinearReduce(previousOutputViewForEndSequence, 1, 1));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
    }

    @Test
    public void end_sequence_bidirectional_true_flatten_with_slice() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputViewForEndSequence,
                EndSequence,
                true,
                "flatten",
                5,
                6).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(5, 6, previousOutputViewForEndSequence),
                new RecurrentLayerView.Reduce.FlattenReduce(new TwoDimensionsOutputView(2, 20)));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void end_sequence_bidirectional_true_linear_with_slice() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputViewForEndSequence,
                EndSequence,
                true,
                "linear",
                5,
                6).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(5, 6, previousOutputViewForEndSequence),
                new RecurrentLayerView.Reduce.LinearReduce(new TwoDimensionsOutputView(2, 20), 1, 1),
                new RecurrentLayerView.Reduce.LinearReduce(new TwoDimensionsOutputView(1, 20), 2, 10));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
        Assert.assertEquals(expected.get(2), result.get(2));
    }

    @Test
    public void end_sequence_bidirectional_false_flatten_with_slice() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputViewForEndSequence,
                EndSequence,
                false,
                "flatten",
                5,
                6).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(5, 6, previousOutputViewForEndSequence),
                new RecurrentLayerView.Reduce.FlattenReduce(new TwoDimensionsOutputView(2, 20)));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    public void end_sequence_bidirectional_false_linear_with_slice() {
        List<RecurrentLayerView.Reduce> result = new RecurrentLayerView.Reduce.Builder(
                previousOutputViewForEndSequence,
                EndSequence,
                false,
                "linear",
                5,
                6).build();
        List<RecurrentLayerView.Reduce> expected = List.of(
                new RecurrentLayerView.Reduce.SliceReduce(5, 6, previousOutputViewForEndSequence),
                new RecurrentLayerView.Reduce.LinearReduce(new TwoDimensionsOutputView(2, 20), 1, 1));
        Assert.assertEquals(expected.getFirst(), result.getFirst());
    }
}
