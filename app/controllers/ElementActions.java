package controllers;

import java.util.*;
import models.Element;
import models.ListElement;
import play.*;
import play.data.validation.*;

public class ElementActions extends ControllerParent {
    
    //Permet d'ajouter un élement à la liste
    public static void addElement(@Required String idList, @Required String text){
    	Logger.info("Controller : ElementActions - Method : addElement - format : " + request.format);

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
    	
    	//On mets à jour la date de MAJ
    	liste.dateUpdate = new Date();
    	liste.save();
    	
    	//On retourne la liste complète		
		if(!request.format.equals("json")){
			ListActions.showList(idList);
		}
    }
}