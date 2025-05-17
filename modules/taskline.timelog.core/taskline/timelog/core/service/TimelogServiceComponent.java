package taskline.timelog.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages
import java.time.LocalDateTime;

public abstract class TimelogServiceComponent implements TimelogService{
	protected RepositoryUtil<Timelog> timelogRepository;

    public TimelogServiceComponent(){
        this.timelogRepository = new RepositoryUtil<Timelog>(taskline.timelog.core.TimelogComponent.class);
    }	

    public abstract HashMap<String, Object> saveTimelog(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> updateTimelog(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getMyTimelog(String memberEmail);
    public abstract List<HashMap<String,Object>> getAllTimelog();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Timelog> timelogList);
    public abstract List<HashMap<String,Object>> deleteTimelog(Map<String, Object> requestBody);
	public abstract void validateTimelog(UUID taskId, LocalDateTime timelogDate, String timelogType);
}
