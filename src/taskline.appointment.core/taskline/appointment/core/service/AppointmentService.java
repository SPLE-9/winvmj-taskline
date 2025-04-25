package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface AppointmentService {
	HashMap<String, Object> saveAppointment(Map<String, Object> requestBody);
    HashMap<String,Object> deleteAppointment(Map<String, Object> requestBody);
    HashMap<String, Object> updateAppointment(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllAppointment();
    HashMap<String, Object> getAppointmentById(String appointmentId);
    
	List<HashMap<String, Object>> transformListToHashMap(List<Appointment> appointmentList);
}
