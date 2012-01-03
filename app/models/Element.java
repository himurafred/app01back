package models;

public class Element {

	//Identifiant de l'élément
	private Long id;

	//Description de l'élément
	private String text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
