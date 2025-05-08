package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class AppointmentServiceDecorator extends AppointmentServiceComponent{
	protected AppointmentServiceComponent record;

    public AppointmentServiceDecorator(AppointmentServiceComponent record) {
        this.record = record;
    }

	public AppointmentImpl createAppointment(Map<String, Object> requestBody){
		return record.createAppointment(requestBody);
	}

    public Appointment createAppointment(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createAppointment(requestBody, response);
	}

	public HashMap<String, Object> getAppointment(Map<String, Object> requestBody){
		return record.getAppointment(requestBody);
	}

	public List<HashMap<String,Object>> getAllAppointment(Map<String, Object> requestBody){
		return record.getAllAppointment(requestBody);
	}

    public List<HashMap<String,Object>> saveAppointment(VMJExchange vmjExchange){
		return record.saveAppointment(vmjExchange);
	}

    public HashMap<String, Object> updateAppointment(Map<String, Object> requestBody){
		return record.updateAppointment(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Appointment> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteAppointment(Map<String, Object> requestBody){
		return record.deleteAppointment(requestBody);
	}

	public HashMap<String, Object> getAppointmentById(int id){
        return record.getAppointmentById(id);
    }

}
