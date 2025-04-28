package taskline.analytic.burndownbymember;

import java.util.*;

import vmj.routing.route.VMJExchange;

import taskline.analytic.core.AnalyticServiceDecorator;
import taskline.analytic.core.AnalyticImpl;
import taskline.analytic.core.AnalyticServiceComponent;

public class AnalyticServiceImpl extends AnalyticServiceDecorator {
    public AnalyticServiceImpl (AnalyticServiceComponent record) {
        super(record);
    }

    
	public void calculateBurndownData() {
		// TODO: implement this method
	}
}
