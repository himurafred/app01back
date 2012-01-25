package controllers;

import java.util.ArrayList;
import java.util.Properties;

import models.User;

import play.Play;
import play.data.validation.Required;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Http.Request;

public class ControllerParent extends Controller {
	
	//Ce champs sert seulement à avoir une meilleure compréhension lors de l'accès aux properties.
	protected static Properties properties = Play.configuration;
			
	@Before 
	private static void setCORS() {		
		//if(Play.mode.isDev()){
			Http.Header hd = new Http.Header(); 
			hd.name = "Access-Control-Allow-Origin"; 
			hd.values = new ArrayList<String>(); 
			hd.values.add("*"); 
			Http.Response.current().headers.put("Access-Control-Allow-Origin",hd);		
		//}
	}	
	
	/**
	 * Permet de récupérer le user courant .
	 * @return
	 */
	public static User getUser(){
		return SecurityPlugin.getUser();
	}
	
	public static void logout(){
		SecurityPlugin.logout();
		renderJSON(true);
	}
	
	public static void login(@Required String username, @Required String password){
    	renderJSON(SecurityPlugin.authenticate(username, password));
    }
}