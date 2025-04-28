package taskline.analytic.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class AnalyticResourceComponent implements AnalyticResource{
	
	public AnalyticResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveAnalytic(VMJExchange vmjExchange);
    public abstract Analytic createAnalytic(VMJExchange vmjExchange);
	public abstract Analytic createAnalytic(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateAnalytic(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getAnalytic(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllAnalytic(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteAnalytic(VMJExchange vmjExchange);

}
