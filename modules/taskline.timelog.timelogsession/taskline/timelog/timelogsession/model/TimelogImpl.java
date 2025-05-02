package taskline.timelog.timelogsession;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import taskline.timelog.core.TimelogDecorator;
import taskline.timelog.core.Timelog;
import taskline.timelog.core.TimelogComponent;

@Entity(name="timelog_timelogsession")
@Table(name="timelog_timelogsession")
public class TimelogImpl extends TimelogDecorator {

	public EDate startTime;
	public EDate endTime;
	public TimelogImpl(
        super();
        this.objectName = TimelogImpl.class.getName();
    }
    
    public TimelogImpl(EDate startTime, EDate endTime) {
    	super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.objectName = TimelogImpl.class.getName();
    }
	
	public TimelogImpl(TimelogComponent record, EDate startTime, EDate endTime) {
		super(record);
		this.startTime = startTime;
		this.endTime = endTime;
		this.objectName = TimelogImpl.class.getName();
	}


	public void calculateTotalDuration() {
		// TODO: implement this method
	}

	public void getIsOnGoing() {
		// TODO: implement this method
	}

	public void endSession() {
		// TODO: implement this method
	}

}
