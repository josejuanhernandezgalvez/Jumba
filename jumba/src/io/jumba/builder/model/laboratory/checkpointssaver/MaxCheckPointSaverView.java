package io.jumba.builder.model.laboratory.checkpointssaver;

import io.jumba.builder.model.laboratory.CheckPointSaverView;
import io.jumba.model.CheckPointSaver;

public class MaxCheckPointSaverView implements CheckPointSaverView {

    public static MaxCheckPointSaverView from(CheckPointSaver checkPointSaver) {
        return new MaxCheckPointSaverView();
    }
}
