package taskline.project.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class ProjectResourceDecorator extends ProjectResourceComponent{
	protected ProjectResourceComponent record;

    public ProjectResourceDecorator(ProjectResourceComponent record) {
        this.record = record;
    }

    public Project createProject(VMJExchange vmjExchange){
		return record.createProject(vmjExchange);
	}

    public HashMap<String, Object> updateProject(VMJExchange vmjExchange){
		return record.updateProject(vmjExchange);
	}

    public HashMap<String, Object> getProject(VMJExchange vmjExchange){
		return record.getProject(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllProject(VMJExchange vmjExchange){
		return record.getAllProject(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteProject(VMJExchange vmjExchange){
		return record.deleteProject(vmjExchange);
	}

}
