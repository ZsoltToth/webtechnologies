package hu.uni.miskolc.webtech.librarian.model;

public enum Nationality {
	Hungarian("Hungarian"),
	British("British"),
	American("American"),
	Spanish("Spanish"),
	Russian("Russian");
	
	private final String text;
	
	private Nationality(String text){
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
	
	
}
