package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import play.db.jpa.GenericModel;

@Entity
public class ListElement extends GenericModel{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String uuid;
	
	//Date de création de la liste
	public Date dateUpdate;
	
	//Description de la liste
	public String text;
	
	//Liste d'élement
	@OneToMany (cascade = CascadeType.ALL)
	public List<Element> elements;
	
	
	public ListElement(String text){
		this.text = text;
		this.dateUpdate = new Date();
	}
}
