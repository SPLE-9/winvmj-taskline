package taskline..opyof_dburndownbyproject_14;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import taskline..core.AnalyticDecorator;
import taskline..core.Analytic;
import taskline..core.AnalyticComponent;

@Entity(name="_opyof_dburndownbyproject_14")
@Table(name="_opyof_dburndownbyproject_14")
public class AnalyticImpl extends AnalyticDecorator {

	public AnalyticImpl(
        super();
        this.objectName = AnalyticImpl.class.getName();
    }
    
    public AnalyticImpl() {
    	super();
		this.objectName = AnalyticImpl.class.getName();
    }
	
	public AnalyticImpl(AnalyticComponent record, ) {
		super(record);
		this.objectName = AnalyticImpl.class.getName();
	}


	public void calculateBurndownData() {
		// TODO: implement this method
	}

}
