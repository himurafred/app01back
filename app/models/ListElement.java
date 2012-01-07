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
	public String uuid;
	
	//Description de la liste
	public String text;
	
	//Liste d'élement
	@OneToMany
	public List<Element> elements;
	
	
	public ListElement(String text){
		this.text = text;
	}
}
