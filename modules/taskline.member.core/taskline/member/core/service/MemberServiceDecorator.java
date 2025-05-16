package taskline.member.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class MemberServiceDecorator extends MemberServiceComponent{
	protected MemberServiceComponent record;

    public MemberServiceDecorator(MemberServiceComponent record) {
        this.record = record;
    }

	public Member getMemberByEmail(String email) {
		return record.getMemberByEmail(email);
	}

}
