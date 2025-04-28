package taskline..opyof_dburndownbyproject_15;

import java.util.*;

import vmj.routing.route.VMJExchange;

import taskline..core.AnalyticServiceDecorator;
import taskline..core.AnalyticImpl;
import taskline..core.AnalyticServiceComponent;

public class AnalyticServiceImpl extends AnalyticServiceDecorator {
    public AnalyticServiceImpl (AnalyticServiceComponent record) {
        super(record);
    }

    
	public void calculateBurndownData() {
		// TODO: implement this method
	}
}
