package taskline.analytic.burndownbymember;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import taskline.analytic.core.AnalyticDecorator;
import taskline.analytic.core.Analytic;
import taskline.analytic.core.AnalyticComponent;

import taskline.member.core.*;

@Entity(name="analytic_burndownbymember")
@Table(name="analytic_burndownbymember")
public class AnalyticImpl extends AnalyticDecorator {
	@OneToOne(targetEntity = taskline.member.core.MemberComponent.class)
	private Member member;

	public AnalyticImpl(){
        super();
        this.objectName = AnalyticImpl.class.getName();
    }
    
    public AnalyticImpl(Member member) {
    	super();
		this.member = member;
		this.objectName = AnalyticImpl.class.getName();
    }
	
	public AnalyticImpl(AnalyticComponent record, Member member) {
		super(record);
		this.member = member;
		this.objectName = AnalyticImpl.class.getName();
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "{"
			+ "id=" + getId()
			+ ", record=" + getRecord()
			+ ", member=" + getMember()
			+ "}";
	}

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> map = record.toHashMap();
		map.put("member", this.getMember());
		return map;
	}
}
