package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Element;
import models.ListElement;

public class Accueil extends ControllerParent {

	//Permet de créer une nouvelle liste
    public static void createList(String text) {
    	ListElement newListeElement = new ListElement();
    	
    	//Description de la demande
    	newListeElement.setText(text); 
    	    	
    	//Enregistrement de la nouvelle Liste
    	newListeElement.save();
    	    	
        renderJSON(newListeElement.getUuid());
    }

    //Permet de visualiser la liste
    public static void showList(String idList) {
    	renderJSON(ListElement.findById(idList));
    }
    
    //Permet d'ajouter un élement à la liste
    public static void addElement(String idList, String textElement){
    	
    	//Création du nouvel élément
    	Element newEl = new Element();
    	newEl.setText(textElement);
    	
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