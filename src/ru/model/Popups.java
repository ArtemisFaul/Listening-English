package ru.model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import ru.Main;

public class Popups {

	public Popup popup = new Popup();
	
	private AnchorPane anchorPane;
	
	public void closePopup(){
		popup.hide();
	}

	public Popup getPopup() {
		return popup;
	}
	/*
	public void web(){
		WebView wV = new WebView();
		WebEngine webEngine = wV.getEngine();
		webEngine.load(PopupController.class.getResource(f).toExternalForm());
		AnchorPane.setTopAnchor(wV, 0.0);
		AnchorPane.setLeftAnchor(wV, 0.0);
		AnchorPane.setRightAnchor(wV, 0.0);
		AnchorPane.setBottomAnchor(wV, 0.0);
		anchorPane.getChildren().add(wV);
	}
	
	public void video(){
		mediaPlayer = new MediaPlayer(new Media(getClass()
					.getResource(f).toString()));
        mediaPlayer.setAutoPlay(true);
        MediaControl mediaControl = new MediaControl(mediaPlayer);
       	AnchorPane.setTopAnchor(mediaControl, 0.0);
		AnchorPane.setLeftAnchor(mediaControl, 0.0);
		AnchorPane.setRightAnchor(mediaControl, 0.0);
		AnchorPane.setBottomAnchor(mediaControl, 0.0);
		aP.getChildren().add(mediaControl);		
	}

	
	
	public void setVideoPopup(){
	popup.setAutoHide(true);
	//popup.getContent().addAll(borderPane);
	popup.show(Main.primaryStage);
	}
*/
	public void setPopup() {
		System.out.println(this.toString() + " iniz");
		try {
			anchorPane = new AnchorPane((AnchorPane)FXMLLoader.load(getClass().getResource("/ru/view/Popup.fxml")));
			popup.getContent().addAll(anchorPane);
			anchorPane.getStylesheets().add(getClass().getResource("/ru/view/css/Popup.css").toExternalForm());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(AP.toString() + " Poppane loaded");
		popup.setAutoHide(true);
		//popup.getContent().addAll(borderPane);
		popup.show(Main.primaryStage);
	}

	public Popups() {
		
	}
}
