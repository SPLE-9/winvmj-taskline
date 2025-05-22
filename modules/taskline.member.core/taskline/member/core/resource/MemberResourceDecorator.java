package taskline.member.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class MemberResourceDecorator extends MemberResourceComponent{
	protected MemberResourceComponent record;

    public MemberResourceDecorator(MemberResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> getAllMember(VMJExchange vmjExchange){
		return record.getAllMember(vmjExchange);
	}

}
