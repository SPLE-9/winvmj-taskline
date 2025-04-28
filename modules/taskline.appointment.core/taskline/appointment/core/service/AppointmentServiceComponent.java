package taskline.appointment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class AppointmentServiceComponent implements AppointmentService{
	protected RepositoryUtil<Appointment> Repository;

    public AppointmentServiceComponent(){
        this.Repository = new RepositoryUtil<Appointment>(taskline.appointment.core.AppointmentComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveAppointment(VMJExchange vmjExchange);
    public abstract Appointment createAppointment(Map<String, Object> requestBodye);
	public abstract Appointment createAppointment(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateAppointment(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getAppointment(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllAppointment(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Appointment> List);
    public abstract List<HashMap<String,Object>> deleteAppointment(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getAppointmentById(int id);

}
