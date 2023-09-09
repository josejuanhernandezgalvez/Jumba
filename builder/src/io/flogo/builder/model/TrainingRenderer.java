package io.flogo.builder.model;

import io.flogo.blatt.model.EarlyStopping;
import io.flogo.blatt.model.Training;

public class TrainingRenderer implements Renderer {

    public void render(Training training) {
        render(training.earlyStopping());
    }

    private void render(EarlyStopping earlyStopping) {

    }
}
