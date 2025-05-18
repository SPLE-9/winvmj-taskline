module taskline.product.basic {
    requires vmj.auth.model;
    requires vmj.routing.route;
    requires vmj.hibernate.integrator;
    
    requires net.bytebuddy;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    requires com.fasterxml.classmate;
    requires jdk.unsupported;

    requires taskline.member.core;
    requires taskline.project.core;
    requires taskline.task.core;
    requires taskline.task.taskwithcomment;

}