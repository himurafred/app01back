package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class Element extends Model{
	
	//Description de l'élément
	public String text;

	public Element(String text){
		this.text = text;
	}
	
}
