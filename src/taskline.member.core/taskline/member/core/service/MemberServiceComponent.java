package taskline.member.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class MemberServiceComponent implements MemberService{
	protected RepositoryUtil<Member> memberRepository;

    public MemberServiceComponent(){
        this.memberRepository = new RepositoryUtil<Member>(taskline.member.core.MemberComponent.class);
    }	

    public abstract Member getMemberByEmail(String email);
    public abstract Member getMemberById(UUID memberId);
    public abstract List<HashMap<String,Object>> getAllMember();
    public abstract List<HashMap<String, Object>> transformListToHashMap(List<Member> memberList);

}
