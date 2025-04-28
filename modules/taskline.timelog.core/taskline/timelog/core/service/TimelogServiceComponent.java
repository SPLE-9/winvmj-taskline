package taskline.timelog.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class TimelogServiceComponent implements TimelogService{
	protected RepositoryUtil<Timelog> Repository;

    public TimelogServiceComponent(){
        this.Repository = new RepositoryUtil<Timelog>(taskline.timelog.core.TimelogComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveTimelog(VMJExchange vmjExchange);
    public abstract Timelog createTimelog(Map<String, Object> requestBodye);
	public abstract Timelog createTimelog(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateTimelog(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getTimelog(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllTimelog(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Timelog> List);
    public abstract List<HashMap<String,Object>> deleteTimelog(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getTimelogById(int id);

	public abstract void getTimelogDetail();

	public abstract void validateTimelog();
}
