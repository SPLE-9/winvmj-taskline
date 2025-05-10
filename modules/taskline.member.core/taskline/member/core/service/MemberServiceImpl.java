package taskline.member.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.member.MemberFactory;
//add other required packages

public class MemberServiceImpl extends MemberServiceComponent{

    public Member getMemberByEmail(String email) {
		try {
			List<Member> members = memberRepository.getListObject("member_comp", "email", email);
			
			if (members == null || members.isEmpty()) {
				throw new NotFoundException("Member with email " + email + " does not exist.");
			}

			return members.get(0);
		} catch (NotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Failed to retrieve member due to system error.", e);
		}
	}

}
