package ru.controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Popup;
import ru.Main;

public class PopupsController {
	public BorderPane borderPane;
	public Popup popup = new Popup();
	
	public void closepopup(){
		popup.hide();
	}

	public void setPopup(){
		System.out.println(this.toString() + " iniz");
		try {
			borderPane = new BorderPane((BorderPane)FXMLLoader.load(PopupController.class.getResource("Popup.fxml")));
			
			borderPane.getStylesheets().add(PopupController.class.getResource("Popup.css").toExternalForm());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		popup.setAutoHide(true);
		popup.getContent().addAll(borderPane);
		System.out.println(borderPane.toString() + " Poppane loaded");
		
		popup.show(Main.primaryStage);
	}
}
