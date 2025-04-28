package taskline.analytic.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class AnalyticServiceComponent implements AnalyticService{
	protected RepositoryUtil<Analytic> Repository;

    public AnalyticServiceComponent(){
        this.Repository = new RepositoryUtil<Analytic>(taskline.analytic.core.AnalyticComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveAnalytic(VMJExchange vmjExchange);
    public abstract Analytic createAnalytic(Map<String, Object> requestBodye);
	public abstract Analytic createAnalytic(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateAnalytic(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getAnalytic(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllAnalytic(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Analytic> List);
    public abstract List<HashMap<String,Object>> deleteAnalytic(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getAnalyticById(int id);

}
