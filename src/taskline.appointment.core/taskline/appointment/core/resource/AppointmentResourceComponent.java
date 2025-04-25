package taskline.appointment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;

public abstract class AppointmentResourceComponent implements AppointmentResource{

    protected RepositoryUtil<Appointment> appointmentRepository;
	
	public AppointmentResourceComponent() {
        this.appointmentRepository = new RepositoryUtil<Appointment>(taskline.appointment.core.AppointmentComponent.class);
    }
 
    public abstract HashMap<String,Object> saveAppointment(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateAppointment(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getAppointmentById(VMJExchange vmjExchange);
    public abstract HashMap<String,Object> deleteAppointment(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllAppointment(VMJExchange vmjExchange);
}
