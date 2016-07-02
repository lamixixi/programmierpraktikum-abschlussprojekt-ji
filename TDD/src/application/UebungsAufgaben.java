package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UebungsAufgaben {
	
	private StringProperty Name;
	
	public UebungsAufgaben(String Name){
		this.Name = new SimpleStringProperty(Name);
	}
	
	public StringProperty NameProperty(){
		return Name;
	}
	
	public String getName(){
		return Name.get();
	}
}
