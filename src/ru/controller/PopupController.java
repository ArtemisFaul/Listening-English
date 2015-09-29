package ru.controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Popup;

public class PopupController implements Initializable{
	public Popup popup = new Popup();

	
	@FXML
	private AnchorPane aP;
	@FXML
	private Button button;
	static String f;
	private static String type;
	
    MediaPlayer mediaPlayer;
	BorderPane bp = new BorderPane();
	
	@FXML
	public void close(){
		MainController.popup.closePopup();
	}
	
	
	

	



	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//aP.setEffect(new BoxBlur(60, 60, 3));
		
	}




	




	
}
