package taskline.analytic.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class AnalyticServiceComponent implements AnalyticService{
	protected RepositoryUtil<Analytic> repository;

    public AnalyticServiceComponent(){
        this.repository = new RepositoryUtil<Analytic>(taskline.analytic.core.AnalyticComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveAnalytic(HashMap<String, Object> requestBody);
	public abstract HashMap<String, Object> updateAnalytic(HashMap<String, Object> requestBody);
    public abstract HashMap<String, Object> getAnalytic(UUID id);
    public abstract List<HashMap<String,Object>> getAllAnalytic();
    public abstract List<HashMap<String,Object>> transformAnalyticListToHashMap(List<Analytic> list);
    public abstract List<HashMap<String,Object>> deleteAnalytic(UUID id);

}
