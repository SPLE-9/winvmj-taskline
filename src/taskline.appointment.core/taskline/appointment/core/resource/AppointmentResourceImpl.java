package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.appointment.AppointmentFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class AppointmentResourceImpl extends AppointmentResourceComponent{
	
	private AppointmentServiceImpl appointmentService = new AppointmentServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/appointment/save")
    public HashMap<String,Object> saveAppointment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return appointmentService.saveAppointment(requestBody);
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/appointment/update")
    public HashMap<String, Object> updateAppointment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("PUT")){
			Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return appointmentService.updateAppointment(requestBody);
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/appointment/detail")
    public HashMap<String, Object> getAppointmentById(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
		    String appointmentIdStr = vmjExchange.getGETParam("appointmentId");
			return appointmentService.getAppointmentById(appointmentIdStr);
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/appointment/list")
    public List<HashMap<String,Object>> getAllAppointment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
			return appointmentService.getAllAppointment();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    
	// @Restriced(permission = "")
    @Route(url="call/appointment/delete")
    public HashMap<String,Object> deleteAppointment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("DELETE")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return appointmentService.deleteAppointment(requestBody);
		}

		throw new NotFoundException("Route tidak ditemukan");
	}
}
