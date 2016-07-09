package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.control.TextArea;

public class Einlesen_speichern {
	private static BufferedReader br;

	public static String einlesen(String dateipfad) throws IOException{
	String inhalt = "";
	String zeile;
	FileReader fr = new FileReader(dateipfad);
    br = new BufferedReader(fr);
	while( (zeile = br.readLine()) != null ){
	      inhalt += zeile + "\n";
	}
	br.close();
	return inhalt;
	}
	
	
	public static void speichern(String dateipfad, TextArea textarea) throws IOException{	
		dateipfad = dateipfad.substring(0,dateipfad.length()-5) + "neu.java";
	    FileWriter fw = new FileWriter(dateipfad);
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write(textarea.getText());
	    bw.close();
	}

}
