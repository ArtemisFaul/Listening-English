package ru.model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import ru.Main;
import ru.controller.PopupController;

public class Popups {

	
	public Popup popup;
	public PopupController popupController;
	
	private AnchorPane anchorPane;
	
	public void closePopup(){
		popup.hide();
	}

	public Popup getPopup() {
		return popup;
	}
	
	public void setGuideline(){
		popup.setAutoHide(true);
		popupController.setPopupTitleText("Guidelines");
		popupController.setGuideline();
		setPopup();
	}
	public void setAudioskript(String filename){
		popup.setAutoHide(true);
		popupController.setPopupTitleText("Audioskript");
		popupController.setAudioscript(filename);
		setPopup();
		
	}
	
	public void setVideo(String file){
		popup.setAutoHide(false);
		popupController.setPopupTitleText("Video");
		popupController.setVideo(file);
		setPopup();
	}
	
	private void setPopup() {
		popup.show(Main.primaryStage);
		popupController.setGlassBackground((int) popup.getX(),(int) popup.getY());
	}
	
	public Popups() {
		super();
		popup = new Popup();
		System.out.println(this.toString() + " iniz");
		System.out.println(popup.toString() + " iniz1");
		FXMLLoader myLoader = null;
		try {
			myLoader = new FXMLLoader(getClass().getResource("/ru/view/Popup.fxml"));
			anchorPane = new AnchorPane((AnchorPane) myLoader.load());
			popup.getContent().addAll(anchorPane);
			anchorPane.getStylesheets().add(getClass().getResource("/ru/view/css/Popup.css").toExternalForm());
		} catch (IOException e) {
			e.printStackTrace();
		}
		popupController = myLoader.getController();
	}

	
}
