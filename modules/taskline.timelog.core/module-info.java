module taskline.timelog.core {
	requires taskline.member.core;
	requires taskline.task.core;
	exports taskline.timelog;
    exports taskline.timelog.core;
	requires vmj.routing.route;
	requires vmj.hibernate.integrator;
	requires vmj.auth;
	requires prices.auth.vmj;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens taskline.timelog.core to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
}
