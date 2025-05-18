package taskline.analytic.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class AnalyticResourceComponent implements AnalyticResource{
	protected RepositoryUtil repository;
	public AnalyticResourceComponent() {
        this.repository = new RepositoryUtil<Analytic>(taskline.analytic.core.AnalyticComponent.class);
     }
 
    public abstract List<HashMap<String, Object>> getPlannedWork(VMJExchange vmjExchange);
	public abstract List<HashMap<String, Object>> getActualWork(VMJExchange vmjExchange);
}
