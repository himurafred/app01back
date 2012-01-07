package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Element;
import models.ListElement;

public class ElementActions extends ControllerParent {
    
    //Permet d'ajouter un élement à la liste
    public static void addElement(String idList, String textElement){
    	
    	//Création du nouvel élément
    	Element newEl = new Element(textElement);
    	    	
    	//Ajout dans la base de l'élement
    	newEl.save();
    	
    	//Ajout dans la base
    	ListElement liste = ListElement.findById(idList);
    	liste.getList().add(newEl);
    	liste.save();
    	
    	//On retourne la liste complète
    	renderJSON(liste);
    }
}