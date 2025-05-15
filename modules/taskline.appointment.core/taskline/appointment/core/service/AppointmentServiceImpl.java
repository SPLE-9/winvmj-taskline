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
import java.text.ParseException;
import java.text.SimpleDateFormat;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.appointment.AppointmentFactory;
import taskline.member.core.*;

public class AppointmentServiceImpl extends AppointmentServiceComponent{

	private AppointmentFactory appointmentFactory = new AppointmentFactory();
	MemberService memberService = new MemberServiceImpl();

    public HashMap<String,Object> saveAppointment(Map<String, Object> requestBody){
		if (!requestBody.containsKey("startTime")) {
            throw new FieldValidationException("Field 'startTime' not found in the request body.");
        }
		if (!requestBody.containsKey("endTime")) {
            throw new FieldValidationException("Field 'endTime' not found in the request body.");
        }
		if (!requestBody.containsKey("description")) {
            throw new FieldValidationException("Field 'description' not found in the request body.");
        }
		String startTimeStr = (String) requestBody.get("startTime");
		String endTimeStr = (String) requestBody.get("endTime");
		String description = (String) requestBody.get("description");

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date startTime;
		Date endTime;
		try {
			startTime = formatter.parse(startTimeStr);
			endTime = formatter.parse(endTimeStr);
		} catch (ParseException e) {
			throw new FieldValidationException("Invalid date format. Please use yyyy-MM-dd' 'HH:mm:ss");
		}

		Appointment appointment = appointmentFactory.createAppointment("taskline.appointment.core.AppointmentImpl", startTime, endTime, description);
		appointmentRepository.saveObject(appointment);
		return appointment.toHashMap();
	}

    public HashMap<String, Object> updateAppointment(Map<String, Object> requestBody){
		if (!requestBody.containsKey("appointmentId")) {
    		throw new NotFoundException("Field 'appointmentId' not found in the request body.");
    	}

		String appointmentIdStr = (String) requestBody.get("appointmentId");
		UUID appointmentId = UUID.fromString(appointmentIdStr);

		Appointment appointment = appointmentRepository.getObject(appointmentId);

		if (appointment == null) {
	        throw new NotFoundException("Appointment with appointmentId " + appointmentId +" not found");
	    }
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date startTime;
		Date endTime;

		if (requestBody.containsKey("startTime")) {
        	String startTimeStr = (String) requestBody.get("startTime");
			try {
				startTime = formatter.parse(startTimeStr);
			} catch (ParseException e) {
				throw new FieldValidationException("Invalid date format. Please use yyyy-MM-dd' 'HH:mm:ss");
			}
            appointment.setStartTime(startTime);
        }
		
		if (requestBody.containsKey("endTime")) {
        	String endTimeStr = (String) requestBody.get("endTime");
			try {
				endTime = formatter.parse(endTimeStr);
			} catch (ParseException e) {
				throw new FieldValidationException("Invalid date format. Please use yyyy-MM-dd' 'HH:mm:ss");
			}
            appointment.setEndTime(endTime);
        }

		if (requestBody.containsKey("description")) {
			String description = (String) requestBody.get("description");
			appointment.setDescription(description);
		}

		appointmentRepository.updateObject(appointment);
		
		return appointment.toHashMap();
	}

    public HashMap<String, Object> getAppointmentById(String appointmentIdStr){
		UUID appointmentId = UUID.fromString(appointmentIdStr);

		Appointment appointment = appointmentRepository.getObject(appointmentId);
		if (appointment == null) {
			throw new NotFoundException("Appointment with appointmentId " + appointmentId +" not found");
		}

		return appointment.toHashMap();
	}

    public List<HashMap<String,Object>> getAllAppointment(){
		List<Appointment> appointmentList = appointmentRepository.getAllObject("appointment_impl");
		return transformListToHashMap(appointmentList);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Appointment> appointmentList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(Appointment appointment : appointmentList) {
            resultList.add(appointment.toHashMap());
        }

        return resultList;
	}

    public HashMap<String,Object> deleteAppointment(Map<String, Object> requestBody){
		String appointmentIdStr = (String) requestBody.get("appointmentId");
    	UUID appointmentId = UUID.fromString(appointmentIdStr);
		
		Appointment appointment = appointmentRepository.getObject(appointmentId);
		if (appointment == null) {
			throw new NotFoundException("Appointment with appointmentId " + appointmentId +" not found");
		}

		appointmentRepository.deleteObject(appointmentId);

		Appointment deletedAppointment = appointmentRepository.getObject(appointmentId);
		if (deletedAppointment != null) {
			throw new NotFoundException("Appointment with appointmentId " + appointmentId +" still has invited users, delete all invited users to delete this appointment.");
		}

		return appointment.toHashMap();
	}
}
