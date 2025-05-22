package taskline.member.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.member.MemberFactory;
import taskline.member.core.MemberService;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class MemberResourceImpl extends MemberResourceComponent{
	
	private MemberService memberService = new MemberServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/member/list")
    public List<HashMap<String,Object>> getAllMember(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
		    return memberService.getAllMember();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

}
