package models;
import java.util.List;
public class ListElement {

	//Identifiant de la liste 
	String id;
	
	//Description de la liste
	String text;
	
	//Liste d'élement
	List<Element> list;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
