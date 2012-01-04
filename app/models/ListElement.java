package models;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;
@Entity
public class ListElement extends Model{
	
	//Description de la liste
	String text;
	
	//Liste d'élement
	@OneToMany
	List<Element> list;

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<Element> getList() {
		return list;
	}
	public void setList(List<Element> list) {
		this.list = list;
	}	
}
