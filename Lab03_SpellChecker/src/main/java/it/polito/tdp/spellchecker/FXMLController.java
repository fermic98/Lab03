package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.dati.LettoreFile;
import it.polito.tdp.spellchecker.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Model model;
	
	private ObservableList<String> languages = FXCollections.observableArrayList("Italian","English");
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextArea txtParole;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtErrori;

    @FXML
    private Button btnClearText;

    @FXML
    void CancellaTxtarea(ActionEvent event) {
         this.txtErrori.clear();
         this.txtParole.clear();
    }

    @FXML
    void changeLanguage(ActionEvent event) {
         this.model.setDictionary(comboBox.getValue());
         this.txtParole.clear();
        		 }

    @FXML
    void verificacorrettezza(ActionEvent event) {
        LinkedList<String> result = new LinkedList<String>();  
        try {
    	result = (LinkedList<String>) this.model.verificaCorrettezza(this.txtParole.getText());
        } catch (IllegalStateException e) {
        	txtErrori.setText(e.getMessage());
        	return;
        }
        
        String elenco = "";
        for(String s : result) {
        	elenco+=s+"\n";
        }
        this.txtErrori.setText(elenco);
    }

    @FXML
    void initialize() {
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParole != null : "fx:id=\"txtParole\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrori != null : "fx:id=\"txtErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";
        
        comboBox.setItems(languages);
        this.model= new Model();
    }
    
}
