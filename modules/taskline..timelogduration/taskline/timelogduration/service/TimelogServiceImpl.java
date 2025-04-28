package taskline..timelogduration;

import java.util.*;

import vmj.routing.route.VMJExchange;

import taskline..core.TimelogServiceDecorator;
import taskline..core.TimelogImpl;
import taskline..core.TimelogServiceComponent;

public class TimelogServiceImpl extends TimelogServiceDecorator {
    public TimelogServiceImpl (TimelogServiceComponent record) {
        super(record);
    }

    
	public void getTotalDuration() {
		// TODO: implement this method
	}
}
