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
		Logger.debug("Controller : ListActions - Method : createList");
		
		if(validation.hasErrors()) {
			//TODO: Gestion des erreurs : à compléter.
			System.out.println("erreur ! ");
		}
	
    	ListElement newListElement = new ListElement(text);    	    	    
		//Enregistrement de la nouvelle Liste
    	newListElement.save();
  	    renderJSON(newListElement);	
        //showList(newListElement.uuid);
    }

    //Permet de visualiser la liste
    public static void showList(@Required String idList) {
    	Logger.debug("Controller : ListActions - Method : showList");
		
		if(validation.hasErrors()) {
			//TODO: Gestion des erreurs : à compléter.
		}
		
		ListElement list = ListElement.findById(idList);
	
		notFoundIfNull(list);
	
		System.out.println("list : " + list.toString());
		
		List<Element> elements = list.elements;
		//renderResult(list, elements);
		renderJSON(list);
    }
}