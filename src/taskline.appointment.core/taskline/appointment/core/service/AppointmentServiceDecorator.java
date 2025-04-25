package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class AppointmentServiceDecorator extends AppointmentServiceComponent{
	protected AppointmentServiceComponent record;

    public AppointmentServiceDecorator(AppointmentServiceComponent record) {
        this.record = record;
    }

	public HashMap<String,Object> saveAppointment(Map<String, Object> requestBody){
		return record.saveAppointment(requestBody);
	}

	public HashMap<String,Object> deleteAppointment(Map<String, Object> requestBody) {
		return record.deleteAppointment(requestBody);
	}

	public HashMap<String, Object> updateAppointment(Map<String, Object> requestBody){
		return record.updateAppointment(requestBody);
	}

	public HashMap<String, Object> getAppointmentById(String appointmentId){
        return record.getAppointmentById(appointmentId);
    }

	public List<HashMap<String,Object>> getAllAppointment(){
		return record.getAllAppointment();
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Appointment> appointmentList){
		return record.transformListToHashMap(appointmentList);
	}

	
}
