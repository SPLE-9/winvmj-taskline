package taskline.product.variantone;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Type;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import vmj.routing.route.VMJCors;
import vmj.routing.route.VMJServer;
import vmj.routing.route.Router;
import vmj.hibernate.integrator.HibernateUtil;
import org.hibernate.cfg.Configuration;

import vmj.auth.model.UserResourceFactory;
import vmj.auth.model.RoleResourceFactory;
import vmj.auth.model.core.UserResource;
import vmj.auth.model.core.RoleResource;

import taskline.member.MemberResourceFactory;
import taskline.member.core.MemberResource;
import taskline.member.MemberServiceFactory;
import taskline.member.core.MemberService;
import taskline.project.ProjectResourceFactory;
import taskline.project.core.ProjectResource;
import taskline.project.ProjectServiceFactory;
import taskline.project.core.ProjectService;
import taskline.task.TaskResourceFactory;
import taskline.task.core.TaskResource;
import taskline.task.TaskServiceFactory;
import taskline.task.core.TaskService;
import taskline.timelog.TimelogResourceFactory;
import taskline.timelog.core.TimelogResource;
import taskline.timelog.TimelogServiceFactory;
import taskline.timelog.core.TimelogService;
import taskline.task.taskwithcomment.CommentService;
import taskline.task.taskwithcomment.CommentServiceFactory;
import taskline.task.taskwithcomment.CommentResource;
import taskline.task.taskwithcomment.CommentResourceFactory;

public class Variantone {

	public static void main(String[] args) {

		// get hostAddress and portnum from env var
        // ex:
        // AMANAH_HOST_BE --> "localhost"
        // AMANAH_PORT_BE --> 7776
		String hostAddress= getEnvVariableHostAddress("AMANAH_HOST_BE");
        int portNum = getEnvVariablePortNumber("AMANAH_PORT_BE");
        activateServer(hostAddress, portNum);
		setCors();

		Configuration configuration = new Configuration();
		// panggil setter setelah membuat object dari kelas Configuration
        // ex:
        // AMANAH_DB_URL --> jdbc:postgresql://localhost:5432/superorg
        // AMANAH_DB_USERNAME --> postgres
        // AMANAH_DB_PASSWORD --> postgres123
		setDBProperties("AMANAH_DB_URL", "url", configuration);
        setDBProperties("AMANAH_DB_USERNAME", "username", configuration);
        setDBProperties("AMANAH_DB_PASSWORD","password", configuration);

		configuration.addAnnotatedClass(vmj.auth.model.core.Role.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.RoleComponent.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.RoleDecorator.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.RoleImpl.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRole.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRoleComponent.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRoleDecorator.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRoleImpl.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.User.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserComponent.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserDecorator.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserImpl.class);
        configuration.addAnnotatedClass(vmj.auth.model.passworded.UserImpl.class);

		configuration.addAnnotatedClass(taskline.member.core.Member.class);
		configuration.addAnnotatedClass(taskline.member.core.MemberComponent.class);
		configuration.addAnnotatedClass(taskline.member.core.MemberDecorator.class);
		configuration.addAnnotatedClass(taskline.member.core.MemberImpl.class);
		configuration.addAnnotatedClass(taskline.project.core.Project.class);
		configuration.addAnnotatedClass(taskline.project.core.ProjectComponent.class);
		configuration.addAnnotatedClass(taskline.project.core.ProjectDecorator.class);
		configuration.addAnnotatedClass(taskline.project.core.ProjectImpl.class);
		configuration.addAnnotatedClass(taskline.task.core.Status.class);
		configuration.addAnnotatedClass(taskline.task.core.Task.class);
		configuration.addAnnotatedClass(taskline.task.core.TaskComponent.class);
		configuration.addAnnotatedClass(taskline.task.core.TaskDecorator.class);
		configuration.addAnnotatedClass(taskline.task.core.TaskImpl.class);
		configuration.addAnnotatedClass(taskline.timelog.core.Timelog.class);
		configuration.addAnnotatedClass(taskline.timelog.core.TimelogComponent.class);
		configuration.addAnnotatedClass(taskline.timelog.core.TimelogDecorator.class);
		configuration.addAnnotatedClass(taskline.timelog.core.TimelogImpl.class);
		configuration.addAnnotatedClass(taskline.task.taskwithcomment.Comment.class);
		configuration.addAnnotatedClass(taskline.task.taskwithcomment.CommentComponent.class);
		configuration.addAnnotatedClass(taskline.task.taskwithcomment.CommentImpl.class);
		configuration.addAnnotatedClass(taskline.timelog.timelogduration.TimelogImpl.class);

		Map<String, Object> featureModelMappings = mappingFeatureModel();
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, Map<String, String[]>>>(){}.getType();
        String convertedFeatureModelMappings = gson.toJson(featureModelMappings, type);
		
        configuration.setProperty("feature.model.mappings", convertedFeatureModelMappings);
		configuration.buildMappings();
		HibernateUtil.buildSessionFactory(configuration);

		createObjectsAndBindEndPoints();
	}

	public static void activateServer(String hostName, int portNumber) {
		VMJServer vmjServer = VMJServer.getInstance(hostName, portNumber);
		try {
			vmjServer.startServerGeneric();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void createObjectsAndBindEndPoints() {
		System.out.println("== CREATING OBJECTS AND BINDING ENDPOINTS ==");
		UserResource userResource = UserResourceFactory
            .createUserResource("vmj.auth.model.core.UserResourceImpl"
			);

		RoleResource roleResource = RoleResourceFactory
        	.createRoleResource("vmj.auth.model.core.RoleResourceImpl"
			);
        
        UserResource userPasswordedResource = UserResourceFactory
	        .createUserResource("vmj.auth.model.passworded.UserResourceImpl"
			,
		    UserResourceFactory.createUserResource("vmj.auth.model.core.UserResourceImpl"));

        MemberService memberMember2Service = MemberServiceFactory
            .createMemberService("taskline.member.core.MemberServiceImpl"
            	);		

        MemberResource memberMember2Resource = MemberResourceFactory
            .createMemberResource("taskline.member.core.MemberResourceImpl"
                );
			
        ProjectService projectProject2Service = ProjectServiceFactory
            .createProjectService("taskline.project.core.ProjectServiceImpl"
            	);		

        ProjectResource projectProject2Resource = ProjectResourceFactory
            .createProjectResource("taskline.project.core.ProjectResourceImpl"
                );
			
        TaskService taskTask2Service = TaskServiceFactory
            .createTaskService("taskline.task.core.TaskServiceImpl"
            	);		

        TaskResource taskTask2Resource = TaskResourceFactory
            .createTaskResource("taskline.task.core.TaskResourceImpl"
                );
			
        // TimelogServiceDecorator timelogTimelogDecorator2Service = TimelogServiceDecoratorFactory
        //     .createTimelogServiceDecorator("taskline.timelog.core.TimelogServiceDecorator"
        //     	);		

        TimelogService timelogTimelog2Service = TimelogServiceFactory
            .createTimelogService("taskline.timelog.core.TimelogServiceImpl"
            	);		

        TimelogResource timelogTimelog2Resource = TimelogResourceFactory
            .createTimelogResource("taskline.timelog.core.TimelogResourceImpl"
                );
			
        CommentService taskwithcommentComment2Service = CommentServiceFactory
            .createCommentService("taskline.task.taskwithcomment.CommentServiceImpl"
            	);		

        CommentResource taskwithcommentComment2Resource = CommentResourceFactory
            .createCommentResource("taskline.task.taskwithcomment.CommentResourceImpl"
                );
			
        TimelogService timelogdurationTimelog2Service = TimelogServiceFactory
            .createTimelogService("taskline.timelog.timelogduration.TimelogServiceImpl"
            	, timelogTimelog2Service);		

        TimelogResource timelogdurationTimelog2Resource = TimelogResourceFactory
            .createTimelogResource("taskline.timelog.timelogduration.TimelogResourceImpl"
                , timelogTimelog2Resource, timelogTimelog2Service);
			

		System.out.println("timelogdurationTimelog2Resource endpoints binding");
		Router.route(timelogdurationTimelog2Resource);
		
		System.out.println("timelogdurationTimelog2Service endpoints binding");
		Router.route(timelogdurationTimelog2Service);
		
		System.out.println("taskwithcommentComment2Resource endpoints binding");
		Router.route(taskwithcommentComment2Resource);
		
		System.out.println("taskwithcommentComment2Service endpoints binding");
		Router.route(taskwithcommentComment2Service);
		
		System.out.println("timelogTimelog2Resource endpoints binding");
		Router.route(timelogTimelog2Resource);
		
		// System.out.println("timelogTimelogDecorator2Service endpoints binding");
		// Router.route(timelogTimelogDecorator2Service);
		
		System.out.println("timelogTimelog2Service endpoints binding");
		Router.route(timelogTimelog2Service);
		
		System.out.println("taskTask2Resource endpoints binding");
		Router.route(taskTask2Resource);
		
		System.out.println("taskTask2Service endpoints binding");
		Router.route(taskTask2Service);
		
		System.out.println("projectProject2Resource endpoints binding");
		Router.route(projectProject2Resource);
		
		System.out.println("projectProject2Service endpoints binding");
		Router.route(projectProject2Service);
		
		System.out.println("memberMember2Resource endpoints binding");
		Router.route(memberMember2Resource);
		
		System.out.println("memberMember2Service endpoints binding");
		Router.route(memberMember2Service);
		
		System.out.println("authResource endpoints binding");
		Router.route(userPasswordedResource);
		Router.route(roleResource);
		Router.route(userResource);
	}

	private static Map<String, Object> mappingFeatureModel() {
		Map<String, Object> featureModelMappings = new HashMap<>();

		featureModelMappings.put(
            taskline.member.core.MemberComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					taskline.member.core.MemberComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            taskline.project.core.ProjectComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					taskline.project.core.ProjectComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            taskline.task.core.TaskComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					taskline.task.core.TaskComponent.class.getName()
				});
				put("deltas", new String[] {
					taskline.task.taskwithcomment.CommentImpl.class.getName()
				});
			}}
        );

		featureModelMappings.put(
            taskline.timelog.core.TimelogComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					taskline.timelog.core.TimelogComponent.class.getName()
				});
				put("deltas", new String[] {
					taskline.timelog.timelogduration.TimelogImpl.class.getName()
				});
			}}
        );

		return featureModelMappings;
	}

	public static void setDBProperties(String varname, String typeProp, Configuration configuration) {
		String varNameValue = System.getenv(varname);
		String propertyName = String.format("hibernate.connection.%s",typeProp);
		if (varNameValue != null) {
			configuration.setProperty(propertyName, varNameValue);
		} else {
			String hibernatePropertyVal = configuration.getProperty(propertyName);
			if (hibernatePropertyVal == null) {
				String error_message = String.format("Please check '%s' in your local environment variable or "
                	+ "'hibernate.connection.%s' in your 'hibernate.properties' file!", varname, typeProp);
            	System.out.println(error_message);
			}
		}
	}

	// if the env variable for server host is null, use localhost instead.
    public static String getEnvVariableHostAddress(String varname_host){
            String hostAddress = System.getenv(varname_host)  != null ? System.getenv(varname_host) : "localhost"; // Host
            return hostAddress;
    }

    // try if the environment variable for port number is null, use 7776 instead
    public static int getEnvVariablePortNumber(String varname_port){
            String portNum = System.getenv(varname_port)  != null? System.getenv(varname_port)  : "7776"; //PORT
            int portNumInt = Integer.parseInt(portNum);
            return portNumInt;
    }

	public static void setCors() {
    	Properties properties = new Properties();
        String propertyValue = "";
        
        try (FileInputStream fileInput = new FileInputStream("cors.properties")) {
            properties.load(fileInput);
            propertyValue = properties.getProperty("allowedMethod");
            VMJCors.setAllowedMethod(propertyValue);
            
            propertyValue = properties.getProperty("allowedOrigin");
            VMJCors.setAllowedOrigin(propertyValue);
            
        } catch (IOException e) {
			VMJCors.setAllowedMethod("GET, POST, PUT, PATCH, DELETE");
			VMJCors.setAllowedOrigin("*");
			System.out.println("Buat file cors.properties terlebih dahulu pada src-gen/(namaProduk) dengan contoh sebagai berikut:");
			System.out.println("allowedMethod = GET, POST");
			System.out.println("allowedOrigin = http://example.com");
        }
    }


}