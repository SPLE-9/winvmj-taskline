package taskline..timelogduration;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import taskline..core.TimelogDecorator;
import taskline..core.Timelog;
import taskline..core.TimelogComponent;

@Entity(name="_timelogduration")
@Table(name="_timelogduration")
public class TimelogImpl extends TimelogDecorator {

	public EFloat timelogDuration;
	public TimelogImpl(
        super();
        this.objectName = TimelogImpl.class.getName();
    }
    
    public TimelogImpl(EFloat timelogDuration) {
    	super();
		this.timelogDuration = timelogDuration;
		this.objectName = TimelogImpl.class.getName();
    }
	
	public TimelogImpl(TimelogComponent record, EFloat timelogDuration) {
		super(record);
		this.timelogDuration = timelogDuration;
		this.objectName = TimelogImpl.class.getName();
	}


	public void getTotalDuration() {
		// TODO: implement this method
	}

}
