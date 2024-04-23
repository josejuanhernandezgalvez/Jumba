import io.flogo.builder.model.laboratory.DatasetView;
import io.flogo.builder.model.laboratory.ExperimentView;
import io.flogo.builder.model.laboratory.LaboratoryView;
import io.flogo.builder.model.laboratory.checkpointssaver.MaxCheckPointSaverView;
import io.flogo.builder.model.laboratory.earlystoppers.LossDrivenEarlyStopperView;
import io.flogo.builder.model.laboratory.lossfunctions.MSELossView;
import io.flogo.builder.model.laboratory.optimizers.AdadeltaView;
import io.flogo.builder.model.laboratory.optimizers.SGDView;
import io.flogo.builder.model.laboratory.strategies.ClassificationStrategyView;
import io.flogo.builder.model.laboratory.strategies.RegressionStrategyView;
import io.flogo.builder.operations.LaboratoryRenderer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LaboratoryTest {

    @Test
    public void should_render_laboratory() {
        List<ExperimentView> experiments = new ArrayList<>();
        ExperimentView experimentTest = new ExperimentView("ExperimentTest", new MSELossView(), new AdadeltaView(0.01, 0.05, 0.0001, 0.5),
                new ArrayList<>());
        experiments.add(experimentTest);
        LaboratoryView laboratoryView = new LaboratoryView(new MSELossView(),
                new SGDView(0.01, 0.05, 0.0001, 0.5),
                new MaxCheckPointSaverView(),
                new LossDrivenEarlyStopperView(10, 0.01),
                new DatasetView("TestDataset", new DatasetView.SplitView(0.7, 0.2, 0.1), 50),
                experiments,
                new RegressionStrategyView());
        System.out.println(new LaboratoryRenderer().render(laboratoryView, "testing"));
    }
}
