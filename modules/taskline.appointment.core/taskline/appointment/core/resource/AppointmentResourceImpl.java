package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.appointment.AppointmentFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class AppointmentResourceImpl extends AppointmentResourceComponent{
	
	private AppointmentServiceImpl appointmentServiceImpl = new AppointmentServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/appointment/save")
    public List<HashMap<String,Object>> saveAppointment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Appointment appointment = createAppointment(vmjExchange);
		appointmentRepository.saveObject(appointment);
		return getAllAppointment(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/appointment")
    public HashMap<String,Object> appointment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Appointment result = appointmentServiceImpl.createAppointment(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Appointment createAppointment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Appointment result = appointmentServiceImpl.createAppointment(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Appointment createAppointment(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Appointment result = appointmentServiceImpl.createAppointment(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/appointment/update")
    public HashMap<String, Object> updateAppointment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return appointmentServiceImpl.updateAppointment(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/appointment/detail")
    public HashMap<String, Object> getAppointment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return appointmentServiceImpl.getAppointment(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/appointment/list")
    public List<HashMap<String,Object>> getAllAppointment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return appointmentServiceImpl.getAllAppointment(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/appointment/delete")
    public List<HashMap<String,Object>> deleteAppointment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return appointmentServiceImpl.deleteAppointment(requestBody);
	}


}
