package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Element;

public class Accueil extends ControllerParent {

	//Permet de créer une nouvelle liste
    public static void createList(String text) {
        render();
    }

    //Permet de visualiser la liste
    public static void showList(Long idList) {
    	renderJSON(recupListeElement(idList));
    }
    
    //Permet d'ajouter un élement à la liste
    public static void addElement(Long idList, String textElement){
    	
    	//Création du nouvel élément
    	Element newEl = new Element();
    	newEl.setText(textElement);
    	
    	//Ajout dans la base
    	
    	
    	//On retourne la liste complète
    	renderJSON(recupListeElement(idList));
    }
    
    
    private static List<Element> recupListeElement(Long idList){
    	return new ArrayList<Element>();
    }
}