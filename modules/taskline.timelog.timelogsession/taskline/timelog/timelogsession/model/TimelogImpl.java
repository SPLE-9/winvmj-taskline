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

	public Date startTime;
	public Date endTime;
	public TimelogImpl(
        super();
        this.objectName = TimelogImpl.class.getName();
    }
    
    public TimelogImpl(Date startTime, Date endTime) {
    	super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.objectName = TimelogImpl.class.getName();
    }
	
	public TimelogImpl(TimelogComponent record, Date startTime, Date endTime) {
		super(record);
		this.startTime = startTime;
		this.endTime = endTime;
		this.objectName = TimelogImpl.class.getName();
	}


	public void calculateTotalDuration() {
		// TODO: implement this method
		if (startTime == null || endTime == null || endTime.toDate().before(startTime.toDate())) {
            return 0;
        }
        long durationInMillis = endTime.toDate().getTime() - startTime.toDate().getTime();
        return TimeUnit.MILLISECONDS.toMinutes(durationInMillis);
	}

	public void getIsOnGoing() {
		// TODO: implement this method
		if (endTime == null) {
            return true;
        }
        return endTime.toDate().after(new Date());
	}

	public void endSession() {
		// TODO: implement this method
		this.endTime = new Date(new Date());
	}

}
