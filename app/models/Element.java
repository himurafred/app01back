package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class Element extends Model{
	
	//Description de l'élément
	private String text;

	public Element(String text){
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
