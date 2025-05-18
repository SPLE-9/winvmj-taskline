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

	public abstract List<HashMap<String, Object>> getPlannedWork(HashMap<String, Object> requestBody);
	public abstract List<HashMap<String, Object>> getActualWork(HashMap<String, Object> requestBody);
}
