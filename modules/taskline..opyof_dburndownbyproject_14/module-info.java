module taskline..opyof_dburndownbyproject_14 {
	requires taskline..core;
    exports taskline..opyof_dburndownbyproject_14;

	requires vmj.routing.route;
	requires vmj.hibernate.integrator;
	requires vmj.auth;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens taskline..opyof_dburndownbyproject_14 to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
}
