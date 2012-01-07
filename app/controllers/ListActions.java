package controllers;

import java.util.ArrayList;
import java.util.List;
import models.Element;
import models.ListElement;
import play.*;
import play.data.validation.*;

public class ListActions extends ControllerParent {

	//Permet de créer une nouvelle liste
    public static void createList(@Required String text) {
		Logger.info("Controller : ListActions - Methode : createList");
		
		if(validation.hasErrors()) {
			//TODO: Gestion des erreurs : à compléter.
		}
	
    	ListElement newListElement = new ListElement(text);    	    	    	

		//Enregistrement de la nouvelle Liste
    	newListElement.save();
  	    	
        renderJSON(newListElement.uuid);
    }

    //Permet de visualiser la liste
    public static void showList(@Required String idList) {
		Logger.info("Controller : ListActions - Methode : showList");
		
		if(validation.hasErrors()) {
			//TODO: Gestion des erreurs : à compléter.
		}
		
		ListElement list = ListElement.findById(idList);
		notFoundIfNull(list);
    	render(list);
    }
    
}