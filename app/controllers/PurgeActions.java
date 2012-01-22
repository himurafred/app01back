package controllers;

import java.util.Date;
import java.util.List;

import models.ListElement;

import play.Logger;
import play.data.validation.Required;

public class PurgeActions extends ControllerParent {
    
    //Permet de purger les listes non modifiés depuis un certain temps
	//ExpirationTime est exprimé en seconde
    public static void execute(@Required Long expirationTime){
    	Logger.info("Controller : PurgeActions - Method : execute - expirationTime : " + expirationTime);

		if(validation.hasErrors()) {
			//TODO: Gestion des erreurs : à compléter.
			Logger.error("Erreur lors de la purge");
		}
		
    	Date dateCurrent = new Date();
    	
    	List<ListElement> listElement = ListElement.findAll();
    	//Pour chaque élément on vérifie que la date de la dernière MAJ n'a pas expirée
		for(ListElement oneList : listElement){			
			if(dateCurrent.getTime() - oneList.dateUpdate.getTime() > (expirationTime*1000)){
				Logger.info("Controller : PurgeActions - Method : execute - purge de l'élément : " + oneList.uuid);
				oneList.delete();
			}
		}		
    }
}