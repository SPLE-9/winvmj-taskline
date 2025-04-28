package taskline..taskwithcomment;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class CommentResourceComponent implements Resource{
	protected RepositoryUtil<> Repository;

    public CommentResourceComponent(){
        this.Repository = new RepositoryUtil<>(taskline.taskwithcomment.core.CommentComponent.class);
    }	

    public abstract List<HashMap<String,Object>> save(VMJExchange vmjExchange);
    public abstract  create(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> update(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> get(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAll(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<> List);
    public abstract List<HashMap<String,Object>> delete(VMJExchange vmjExchange);

}
