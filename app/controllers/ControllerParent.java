package controllers;

import java.util.ArrayList;
import java.util.Properties;

import play.Play;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Http;

public class ControllerParent extends Controller {
	
	//Ce champs sert seulement à avoir une meilleure compréhension lors de l'accès aux properties.
	protected static Properties properties = Play.configuration;
			
	@Before
	private static void setCORS() {		
		if(Play.mode.isDev()){
			Http.Header hd = new Http.Header(); 
			hd.name = "Access-Control-Allow-Origin"; 
			hd.values = new ArrayList<String>(); 
			hd.values.add("*"); 
			Http.Response.current().headers.put("Access-Control-Allow-Origin",hd);		
		}
	}	
}