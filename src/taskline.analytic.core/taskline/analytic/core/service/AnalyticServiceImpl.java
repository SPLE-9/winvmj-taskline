package taskline.analytic.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.analytic.AnalyticFactory;
//add other required packages

public class AnalyticServiceImpl extends AnalyticServiceComponent{
	private AnalyticFactory analyticFactory = new AnalyticFactory();

   	public List<HashMap<String, Object>> getPlannedWork(HashMap<String, Object> requestBody){
		return null;
	}

	public List<HashMap<String, Object>> getActualWork(HashMap<String, Object> requestBody){
		return null;
	}
}