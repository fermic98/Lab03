package it.polito.tdp.dati;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class LettoreFile {
	boolean loaded ;
	List<String> dizionario;
   public LettoreFile() {
	   dizionario = new ArrayList<String>();
	   loaded= false;
   }
      
   
public boolean isLoaded() {
	return loaded;
}


public void setLoaded(boolean loaded) {
	this.loaded = loaded;
}


public List<String> getDizionario() {
	return dizionario;
}
public void setDizionario(List<String> dizionario) {
	this.dizionario = dizionario;
}
   
   public void loadDictionary(String s) {
	   dizionario.clear();
	try {
		FileReader fr =  new FileReader ("src/main/resources/"+s+".txt");
		BufferedReader br = new BufferedReader(fr);
		String word;
		
		while((word = br.readLine())!= null) {
			dizionario.add(word.toLowerCase());
		}
		br.close();
		
		
	} catch (IOException e) {
		System.out.println("Errore nella lettura del file");
		e.printStackTrace();
	}
	 this.loaded=true;
   }
   
   
   
}
