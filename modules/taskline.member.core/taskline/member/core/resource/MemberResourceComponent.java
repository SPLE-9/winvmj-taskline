package taskline.member.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class MemberResourceComponent implements MemberResource{
    protected RepositoryUtil<Member> memberRepository;
	
	public MemberResourceComponent() {
        this.memberRepository = new RepositoryUtil<Member>(taskline.member.core.MemberComponent.class);
    }

    public abstract List<HashMap<String,Object>> getAllMember(VMJExchange vmjExchange);

}
