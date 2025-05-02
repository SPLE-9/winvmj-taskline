package taskline.timelog.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class TimelogResourceComponent implements TimelogResource{
	
	public TimelogResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveTimelog(VMJExchange vmjExchange);
    public abstract Timelog createTimelog(VMJExchange vmjExchange);
	public abstract Timelog createTimelog(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateTimelog(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getTimelog(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllTimelog(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteTimelog(VMJExchange vmjExchange);

	public abstract void getTimelogDetail();

	public abstract void validateTimelog();
}
