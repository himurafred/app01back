package controllers;

import play.data.validation.Required;
import models.SecurityIdent;
import play.mvc.Controller;

public class Application extends Controller {

    public static void login(@Required String username, @Required String password){
    	renderJSON(SecurityPlugin.authenticate(username, password));
    }
}
