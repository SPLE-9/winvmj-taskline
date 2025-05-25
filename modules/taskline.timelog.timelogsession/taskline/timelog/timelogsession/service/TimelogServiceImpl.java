package taskline.timelog.timelogsession;

import java.util.*;

import vmj.routing.route.VMJExchange;

import taskline.timelog.core.TimelogServiceDecorator;
import taskline.timelog.core.TimelogImpl;
import taskline.timelog.core.TimelogServiceComponent;

public class TimelogServiceImpl extends TimelogServiceDecorator {
    public TimelogServiceImpl (TimelogServiceComponent record) {
        super(record);
    }

}
