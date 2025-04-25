package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class AppointmentResourceDecorator extends AppointmentResourceComponent{
	protected AppointmentResourceComponent record;

    public AppointmentResourceDecorator(AppointmentResourceComponent record) {
        this.record = record;
    }

    public HashMap<String,Object> saveAppointment(VMJExchange vmjExchange){
		return record.saveAppointment(vmjExchange);
	}

    public HashMap<String, Object> updateAppointment(VMJExchange vmjExchange){
		return record.updateAppointment(vmjExchange);
	}

    public HashMap<String, Object> getAppointmentById(VMJExchange vmjExchange){
		return record.getAppointmentById(vmjExchange);
	}

	public HashMap<String,Object> deleteAppointment(VMJExchange vmjExchange){
		return record.deleteAppointment(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllAppointment(VMJExchange vmjExchange){
		return record.getAllAppointment(vmjExchange);
	}
}
