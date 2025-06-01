package taskline.timelog.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages
import java.time.LocalDate;

public class TimelogServiceDecorator extends TimelogServiceComponent {
    protected TimelogServiceComponent record;
    
    public TimelogServiceDecorator(TimelogServiceComponent record) {
        this.record = record;
    }

    public HashMap<String, Object> saveTimelog(Map<String, Object> requestBody) {
        return record.saveTimelog(requestBody);
    }

    public HashMap<String, Object> updateTimelog(Map<String, Object> requestBody) {
        return record.updateTimelog(requestBody);
    }

    public List<HashMap<String,Object>> getMyTimelog(String memberEmail) {
        return record.getMyTimelog(memberEmail);
    }

    public List<HashMap<String,Object>> getAllTimelog() {
        return record.getAllTimelog();
    }
    public List<HashMap<String,Object>> transformListToHashMap(List<Timelog> timelogList) {
        return record.transformListToHashMap(timelogList);
    }

    public List<HashMap<String,Object>> deleteTimelog(Map<String, Object> requestBody) {
        return record.deleteTimelog(requestBody);
    }

	public void validateTimelog(UUID taskId, LocalDate timelogDate) {
        record.validateTimelog(taskId, timelogDate);
    }
}
