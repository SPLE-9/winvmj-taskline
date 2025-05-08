package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class AppointmentResourceDecorator extends AppointmentResourceComponent{
	protected AppointmentResourceComponent record;

    public AppointmentResourceDecorator(AppointmentResourceComponent record) {
        this.record = record;
    }

    public Appointment createAppointment(VMJExchange vmjExchange){
		return record.createAppointment(vmjExchange);
	}

    public HashMap<String, Object> updateAppointment(VMJExchange vmjExchange){
		return record.updateAppointment(vmjExchange);
	}

    public HashMap<String, Object> getAppointment(VMJExchange vmjExchange){
		return record.getAppointment(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllAppointment(VMJExchange vmjExchange){
		return record.getAllAppointment(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteAppointment(VMJExchange vmjExchange){
		return record.deleteAppointment(vmjExchange);
	}

}
