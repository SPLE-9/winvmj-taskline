package taskline.timelog.timelogduration;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import taskline.timelog.core.TimelogDecorator;
import taskline.timelog.core.Timelog;
import taskline.timelog.core.TimelogComponent;

@Entity(name="timelog_duration")
@Table(name="timelog_duration")
public class TimelogImpl extends TimelogDecorator {

	public Float timelogDuration;
	
	public TimelogImpl() {
        super();
        this.objectName = TimelogImpl.class.getName();
    }

	public TimelogImpl(TimelogComponent record) {
		super(record);
		this.objectName = TimelogImpl.class.getName();
	}

	public TimelogImpl(UUID id, TimelogComponent record) {
		super(id, record);
		this.objectName = TimelogImpl.class.getName();
	}
    
    public TimelogImpl(Float timelogDuration) {
    	super();
		this.timelogDuration = timelogDuration;
		this.objectName = TimelogImpl.class.getName();
    }
	
	public TimelogImpl(TimelogComponent record, Float timelogDuration) {
		super(record);
		this.timelogDuration = timelogDuration;
		this.objectName = TimelogImpl.class.getName();
	}

	public TimelogImpl(UUID id, TimelogComponent record, Float timelogDuration) {
		super(id, record);
		this.timelogDuration = timelogDuration;
		this.objectName = TimelogImpl.class.getName();
	}

	public Float getTimelogDuration() {
		return this.timelogDuration;
	}
	
	public void setTimelogDuration(Float timelogDuration) {
		this.timelogDuration = timelogDuration;
	}
}
