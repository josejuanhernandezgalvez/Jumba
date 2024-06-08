package io.flogo.builder.model.laboratory.checkpointssaver;

import io.flogo.builder.model.laboratory.CheckPointSaverView;
import io.flogo.model.CheckPointSaver;

public class MaxCheckPointSaverView implements CheckPointSaverView {

    public static MaxCheckPointSaverView from(CheckPointSaver checkPointSaver) {
        return new MaxCheckPointSaverView();
    }
}
