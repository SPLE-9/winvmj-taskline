package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface AppointmentResource {
    List<HashMap<String,Object>> saveAppointment(VMJExchange vmjExchange);
    HashMap<String, Object> updateAppointment(VMJExchange vmjExchange);
    HashMap<String, Object> getAppointment(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllAppointment(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteAppointment(VMJExchange vmjExchange);
	HashMap<String, Object> Appointment(VMJExchange vmjExhange);
}
