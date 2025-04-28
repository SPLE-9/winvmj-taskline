package taskline.appointment.core;
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
import taskline.appointment.AppointmentFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class AppointmentServiceImpl extends AppointmentServiceComponent{

    public List<HashMap<String,Object>> saveAppointment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Appointment appointment = createAppointment(vmjExchange);
		appointmentRepository.saveObject(appointment);
		return getAllAppointment(vmjExchange);
	}

    public Appointment createAppointment(Map<String, Object> requestBody){
		String description = (String) requestBody.get("description");
		
		//to do: fix association attributes
		Appointment Appointment = AppointmentFactory.createAppointment(
			"taskline.appointment.core.AppointmentImpl",
		startTime
		, endTime
		, description
		, userimpl
		);
		Repository.saveObject(appointment);
		return appointment;
	}

    public Appointment createAppointment(Map<String, Object> requestBody, int id){
		String description = (String) vmjExchange.getRequestBodyForm("description");
		
		//to do: fix association attributes
		
		Appointment appointment = AppointmentFactory.createAppointment("taskline.appointment.core.AppointmentImpl", startTime, endTime, description, userimpl);
		return appointment;
	}

    public HashMap<String, Object> updateAppointment(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		Appointment appointment = Repository.getObject(id);
		
		appointment.setDescription((String) requestBody.get("description"));
		
		Repository.updateObject(appointment);
		
		//to do: fix association attributes
		
		return appointment.toHashMap();
		
	}

    public HashMap<String, Object> getAppointment(Map<String, Object> requestBody){
		List<HashMap<String, Object>> appointmentList = getAllAppointment("appointment_impl");
		for (HashMap<String, Object> appointment : appointmentList){
			int record_id = ((Double) appointment.get("record_id")).intValue();
			if (record_id == id){
				return appointment;
			}
		}
		return null;
	}

	public HashMap<String, Object> getAppointmentById(int id){
		String idStr = vmjExchange.getGETParam(""); 
		int id = Integer.parseInt(idStr);
		Appointment appointment = appointmentRepository.getObject(id);
		return appointment.toHashMap();
	}

    public List<HashMap<String,Object>> getAllAppointment(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Appointment> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Appointment> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteAppointment(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllAppointment(requestBody);
	}

}
