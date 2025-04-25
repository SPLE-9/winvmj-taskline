package taskline.appointment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class AppointmentServiceComponent implements AppointmentService{
	protected RepositoryUtil<Appointment> appointmentRepository;

    public AppointmentServiceComponent(){
        this.appointmentRepository = new RepositoryUtil<Appointment>(taskline.appointment.core.AppointmentComponent.class);
    }	

    public abstract HashMap<String,Object> saveAppointment(Map<String, Object> requestBody);
    public abstract HashMap<String,Object> deleteAppointment(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> updateAppointment(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getAppointmentById(String appointmentId);
    public abstract List<HashMap<String,Object>> getAllAppointment();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Appointment> appointmentList);
}
