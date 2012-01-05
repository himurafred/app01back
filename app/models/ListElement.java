package models;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import play.db.jpa.GenericModel;
@Entity
@Table(name="ListeElement")
public class ListElement extends GenericModel{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String uuid;
	
	//Description de la liste
	private String text;
	
	public ListElement(String text){
		this.text = text;
	}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	//Liste d'élement
	@OneToMany
	private List<Element> list;

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
