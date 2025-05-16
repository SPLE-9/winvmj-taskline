module taskline.project.projectwithmembers {
	requires taskline.project.core;
	requires taskline.member.core;
    exports taskline.project.projectwithmembers;

	requires vmj.routing.route;
	requires vmj.hibernate.integrator;
	requires vmj.auth;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens taskline.project.projectwithmembers to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
}
