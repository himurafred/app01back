package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Element;
import models.ListElement;

public class ListActions extends ControllerParent {

	//Permet de créer une nouvelle liste
    public static void createList(String text) {
    	ListElement newListeElement = new ListElement(text);
    	    	    	
    	//Enregistrement de la nouvelle Liste
    	newListeElement.save();
    	    	
        renderJSON(newListeElement.getUuid());
    }

    //Permet de visualiser la liste
    public static void showList(String idList) {
    	renderJSON(ListElement.findById(idList));
    }
    
}