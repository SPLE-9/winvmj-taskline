package taskline.analytic.burndownbymember;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import taskline.analytic.core.AnalyticDecorator;
import taskline.analytic.core.Analytic;
import taskline.analytic.core.AnalyticComponent;

@Entity(name="analytic_burndownbymember")
@Table(name="analytic_burndownbymember")
public class AnalyticImpl extends AnalyticDecorator {

	public AnalyticImpl(
        super();
        this.objectName = AnalyticImpl.class.getName();
    }
    
    public AnalyticImpl(UserImpl userimpl) {
    	super();
		this.objectName = AnalyticImpl.class.getName();
    }
	
	public AnalyticImpl(AnalyticComponent record, UserImpl userimpl) {
		super(record);
		this.objectName = AnalyticImpl.class.getName();
	}


	public void calculateBurndownData() {
		// TODO: implement this method
	}

}
