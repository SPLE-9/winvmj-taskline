package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface AppointmentService {
	Appointment createAppointment(Map<String, Object> requestBody);
	Appointment createAppointment(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getAppointment(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveAppointment(Map<String, Object> requestBody);
    HashMap<String, Object> updateAppointment(Map<String, Object> requestBody);
    HashMap<String, Object> getAppointmentById(int id);
    List<HashMap<String,Object>> getAllAppointment(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteAppointment(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
