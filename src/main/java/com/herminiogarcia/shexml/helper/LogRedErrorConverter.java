package com.herminiogarcia.shexml.helper;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

public class LogRedErrorConverter extends ForegroundCompositeConverterBase<ILoggingEvent> {

    @Override
    protected String getForegroundColorCode(ILoggingEvent event) {
        if (event.getLevel().equals(Level.ERROR)) {
            return ANSIConstants.RED_FG;
        }
        return ANSIConstants.DEFAULT_FG; // default color for everything else
    }

}
