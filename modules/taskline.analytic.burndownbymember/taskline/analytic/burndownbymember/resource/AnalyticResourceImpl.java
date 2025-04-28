package taskline.analytic.burndownbymember;
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
    @Route(url="call/burndownbymember/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		AnalyticBurndownByMember analyticburndownbymember = createAnalyticBurndownByMember(vmjExchange);
		analyticburndownbymemberRepository.saveObject(analyticburndownbymember);
		return getAllAnalyticBurndownByMember(vmjExchange);
	}

    public Analytic createAnalyticBurndownByMember(VMJExchange vmjExchange){
		
		AnalyticBurndownByMember analyticburndownbymember = record.createAnalyticBurndownByMember(vmjExchange);
		AnalyticBurndownByMember analyticburndownbymemberdeco = AnalyticBurndownByMemberFactory.createAnalyticBurndownByMember("taskline.burndownbymember.core.AnalyticImpl", analyticburndownbymember, analyticId, startDate, endDate, totalTasks, plannedWork, actualWork
		);
			return analyticburndownbymemberdeco;
	}


    public Analytic createAnalyticBurndownByMember(VMJExchange vmjExchange, int id){
		AnalyticBurndownByMember analyticburndownbymember = analyticburndownbymemberRepository.getObject(id);
		int recordAnalyticBurndownByMemberId = (((AnalyticBurndownByMemberDecorator) savedAnalyticBurndownByMember.getRecord()).getId();
		
		AnalyticBurndownByMember analyticburndownbymember = record.createAnalyticBurndownByMember(vmjExchange);
		AnalyticBurndownByMember analyticburndownbymemberdeco = AnalyticBurndownByMemberFactory.createAnalyticBurndownByMember("taskline.burndownbymember.core.AnalyticImpl", id, analyticburndownbymember, analyticId, startDate, endDate, totalTasks, plannedWork, actualWork
		);
			return analyticburndownbymemberdeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/burndownbymember/update")
    public HashMap<String, Object> updateAnalyticBurndownByMember(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("analyticId");
		int id = Integer.parseInt(idStr);
		
		AnalyticBurndownByMember analyticburndownbymember = analyticburndownbymemberRepository.getObject(id);
		analyticburndownbymember = createAnalyticBurndownByMember(vmjExchange, id);
		
		analyticburndownbymemberRepository.updateObject(analyticburndownbymember);
		analyticburndownbymember = analyticburndownbymemberRepository.getObject(id);
		//to do: fix association attributes
		
		return analyticburndownbymember.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/burndownbymember/detail")
    public HashMap<String, Object> getAnalyticBurndownByMember(VMJExchange vmjExchange){
		return record.getAnalyticBurndownByMember(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/burndownbymember/list")
    public List<HashMap<String,Object>> getAllAnalyticBurndownByMember(VMJExchange vmjExchange){
		List<AnalyticBurndownByMember> analyticburndownbymemberList = analyticburndownbymemberRepository.getAllObject("analyticburndownbymember_impl");
		return transformAnalyticBurndownByMemberListToHashMap(analyticburndownbymemberList);
	}

    public List<HashMap<String,Object>> transformAnalyticBurndownByMemberListToHashMap(List<AnalyticBurndownByMember> AnalyticBurndownByMemberList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < AnalyticBurndownByMemberList.size(); i++) {
            resultList.add(AnalyticBurndownByMemberList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/burndownbymember/delete")
    public List<HashMap<String,Object>> deleteAnalyticBurndownByMember(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("analyticId");
		int id = Integer.parseInt(idStr);
		analyticburndownbymemberRepository.deleteObject(id);
		return getAllAnalyticBurndownByMember(vmjExchange);
	}

	public void calculateBurndownData() {
		// TODO: implement this method
	}
	
}
