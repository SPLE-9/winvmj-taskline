package taskline.timelog.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class TimelogResourceComponent implements TimelogResource{

    protected RepositoryUtil<Timelog> timelogRepository;
	
	public TimelogResourceComponent() { 
        this.timelogRepository = new RepositoryUtil<Timelog>(taskline.timelog.core.TimelogComponent.class);
    }
 
    public abstract HashMap<String,Object> saveTimelog(VMJExchange vmjExchange);
	public abstract HashMap<String, Object> updateTimelog(VMJExchange vmjExchange);
	public abstract HashMap<String, Object> getTimelog(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getMyTimelog(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllTimelog(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteTimelog(VMJExchange vmjExchange);
}
