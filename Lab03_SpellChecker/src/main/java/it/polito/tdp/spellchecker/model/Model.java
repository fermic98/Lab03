package it.polito.tdp.spellchecker.model;

import java.util.*;

import it.polito.tdp.dati.LettoreFile;

public class Model {
	LettoreFile lf;
   public Model() {
	   this.lf = new LettoreFile();
   }
   
   
   public LettoreFile getLf() {
	return lf;
}


public void setLf(LettoreFile lf) {
	this.lf = lf;
}

public void setDictionary(String s) {
	lf.loadDictionary(s);
}



public List<String> verificaCorrettezza(String s){
	   //verifica stato (se non si è scelta la lingua);
	   if(!lf.isLoaded()) {
		   throw new IllegalStateException("Selezionare una lingua");
	   }   
	
	   LinkedList<String> result = new LinkedList<String>();
	   
	   //rimozione caratteri e passagio a minuscolo delle parole;
	   String s1  = s.replaceAll("[.,\\/#1$%\\^&\\*;:{}=\\-_'()\\[\\]\"]", " ");
	   String[] daVerificare = s1.toLowerCase().split(" ");
	   for(String z : daVerificare) {
		   if(!lf.getDizionario().contains(z)) {
			   result.add(z);
		   }
	   }
	   
	   
	   return result;
	   
   }
   
}
