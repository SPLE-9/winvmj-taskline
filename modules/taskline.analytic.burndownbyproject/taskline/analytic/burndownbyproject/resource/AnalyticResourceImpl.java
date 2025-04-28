package taskline.analytic.burndownbyproject;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import taskline.analytic.core.AnalyticResourceDecorator;
import taskline.analytic.core.AnalyticImpl;
import taskline.analytic.core.AnalyticResourceComponent;

public class AnalyticResourceImpl extends AnalyticResourceDecorator {
    public AnalyticResourceImpl (AnalyticResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/burndownbyproject/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		AnalyticBurndownByProject analyticburndownbyproject = createAnalyticBurndownByProject(vmjExchange);
		analyticburndownbyprojectRepository.saveObject(analyticburndownbyproject);
		return getAllAnalyticBurndownByProject(vmjExchange);
	}

    public Analytic createAnalyticBurndownByProject(VMJExchange vmjExchange){
		
		AnalyticBurndownByProject analyticburndownbyproject = record.createAnalyticBurndownByProject(vmjExchange);
		AnalyticBurndownByProject analyticburndownbyprojectdeco = AnalyticBurndownByProjectFactory.createAnalyticBurndownByProject("taskline.burndownbyproject.core.AnalyticImpl", analyticburndownbyproject, analyticId, startDate, endDate, totalTasks, plannedWork, actualWork
		);
			return analyticburndownbyprojectdeco;
	}


    public Analytic createAnalyticBurndownByProject(VMJExchange vmjExchange, int id){
		AnalyticBurndownByProject analyticburndownbyproject = analyticburndownbyprojectRepository.getObject(id);
		int recordAnalyticBurndownByProjectId = (((AnalyticBurndownByProjectDecorator) savedAnalyticBurndownByProject.getRecord()).getId();
		
		AnalyticBurndownByProject analyticburndownbyproject = record.createAnalyticBurndownByProject(vmjExchange);
		AnalyticBurndownByProject analyticburndownbyprojectdeco = AnalyticBurndownByProjectFactory.createAnalyticBurndownByProject("taskline.burndownbyproject.core.AnalyticImpl", id, analyticburndownbyproject, analyticId, startDate, endDate, totalTasks, plannedWork, actualWork
		);
			return analyticburndownbyprojectdeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/burndownbyproject/update")
    public HashMap<String, Object> updateAnalyticBurndownByProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("analyticId");
		int id = Integer.parseInt(idStr);
		
		AnalyticBurndownByProject analyticburndownbyproject = analyticburndownbyprojectRepository.getObject(id);
		analyticburndownbyproject = createAnalyticBurndownByProject(vmjExchange, id);
		
		analyticburndownbyprojectRepository.updateObject(analyticburndownbyproject);
		analyticburndownbyproject = analyticburndownbyprojectRepository.getObject(id);
		//to do: fix association attributes
		
		return analyticburndownbyproject.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/burndownbyproject/detail")
    public HashMap<String, Object> getAnalyticBurndownByProject(VMJExchange vmjExchange){
		return record.getAnalyticBurndownByProject(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/burndownbyproject/list")
    public List<HashMap<String,Object>> getAllAnalyticBurndownByProject(VMJExchange vmjExchange){
		List<AnalyticBurndownByProject> analyticburndownbyprojectList = analyticburndownbyprojectRepository.getAllObject("analyticburndownbyproject_impl");
		return transformAnalyticBurndownByProjectListToHashMap(analyticburndownbyprojectList);
	}

    public List<HashMap<String,Object>> transformAnalyticBurndownByProjectListToHashMap(List<AnalyticBurndownByProject> AnalyticBurndownByProjectList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < AnalyticBurndownByProjectList.size(); i++) {
            resultList.add(AnalyticBurndownByProjectList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/burndownbyproject/delete")
    public List<HashMap<String,Object>> deleteAnalyticBurndownByProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("analyticId");
		int id = Integer.parseInt(idStr);
		analyticburndownbyprojectRepository.deleteObject(id);
		return getAllAnalyticBurndownByProject(vmjExchange);
	}

	public void calculateBurndownData() {
		// TODO: implement this method
	}
	
}
