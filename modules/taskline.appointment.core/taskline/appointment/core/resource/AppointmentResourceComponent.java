package taskline.appointment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class AppointmentResourceComponent implements AppointmentResource{
	
	public AppointmentResourceComponent() { }
 
    public abstract Appointment createAppointment(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateAppointment(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getAppointment(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllAppointment(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteAppointment(VMJExchange vmjExchange);

}
