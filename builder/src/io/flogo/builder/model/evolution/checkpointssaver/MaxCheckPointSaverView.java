package io.flogo.builder.model.evolution.checkpointssaver;

import io.flogo.builder.model.evolution.CheckPointSaverView;
import io.flogo.model.CheckPointSaver;

public class MaxCheckPointSaverView implements CheckPointSaverView {

    public static MaxCheckPointSaverView from(CheckPointSaver checkPointSaver) {
        return new MaxCheckPointSaverView();
    }
}
