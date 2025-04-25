package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface AppointmentResource {
    HashMap<String,Object> saveAppointment(VMJExchange vmjExchange);
    HashMap<String, Object> updateAppointment(VMJExchange vmjExchange);
    HashMap<String, Object> getAppointmentById(VMJExchange vmjExchange);
    HashMap<String,Object> deleteAppointment(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllAppointment(VMJExchange vmjExchange);
}
