package controllers;

import java.util.*;
import models.Element;
import models.ListElement;
import play.*;
import play.data.validation.*;

public class ElementActions extends ControllerParent {
    
    //Permet d'ajouter un élement à la liste
    public static void addElement(@Required String idList, @Required String text){
    	Logger.debug("Controller : ElementActions - Method : addElement");

		if(validation.hasErrors()) {
			//TODO: Gestion des erreurs : à compléter.
		}
		
    	//Création du nouvel élément
    	Element newEl = new Element(text);
    	    	
    	//Ajout dans la base de l'élement
    	newEl.save();
    	
    	//Ajout dans la base
    	ListElement liste = ListElement.findById(idList);
		notFoundIfNull(liste);
    	liste.elements.add(newEl);
    	liste.save();
    	
    	//On retourne la liste complète
    	//tmp: renderJSON(liste);
		ListActions.showList(idList);
    }
}