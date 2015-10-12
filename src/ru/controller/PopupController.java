package ru.controller;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import ru.Main;

public class PopupController implements Initializable {
	@FXML
	private ImageView popupBackground;
	@FXML
	private AnchorPane aP;
	@FXML
	private Text popupTitleText;
	MediaPlayer mediaPlayer;
	BorderPane bp = new BorderPane();

	@FXML
	public void close() {
		
		try {
			Status stat = mediaPlayer.getStatus();
			if (stat == Status.PLAYING) {
			mediaPlayer.stop();
			
		}
			} catch (Exception e) {
		}
		Main.popup.closePopup();
		
	}
	public void setGuideline(){
		WebView wV = new WebView();
		WebEngine webEngine = wV.getEngine();
		webEngine.load(PopupController.class.getResource("/ru/res/text/100515.html").toExternalForm());
		AnchorPane.setTopAnchor(wV, 0.0);
		AnchorPane.setLeftAnchor(wV, 0.0);
		AnchorPane.setRightAnchor(wV, 0.0);
		AnchorPane.setBottomAnchor(wV, 0.0);
		aP.getChildren().add(wV);
	}
	public void setAudioscript(String filename){
		WebView wV = new WebView();
		WebEngine webEngine = wV.getEngine();
		webEngine.load(PopupController.class.getResource(filename).toExternalForm());
		AnchorPane.setTopAnchor(wV, 0.0);
		AnchorPane.setLeftAnchor(wV, 0.0);
		AnchorPane.setRightAnchor(wV, 0.0);
		AnchorPane.setBottomAnchor(wV, 0.0);
		aP.getChildren().add(wV);
	}
	public void setVideo(String file){
		mediaPlayer = new MediaPlayer(new Media(getClass()
					.getResource(file).toString()));
        mediaPlayer.setAutoPlay(true);
        MediaControl mediaControl = new MediaControl(mediaPlayer);
       	AnchorPane.setTopAnchor(mediaControl, 0.0);
		AnchorPane.setLeftAnchor(mediaControl, 0.0);
		AnchorPane.setRightAnchor(mediaControl, 0.0);
		AnchorPane.setBottomAnchor(mediaControl, 0.0);
		aP.getChildren().add(mediaControl);		
	}
	
	public void setPopupTitleText(String text) {
		popupTitleText.setText(text);
	}
	
	public void setGlassBackground(int X,int Y){
		try {
			Robot robot = new Robot();
			java.awt.image.BufferedImage image = robot.createScreenCapture(new Rectangle(X+10,Y+10, (int) popupBackground.getFitWidth(), (int) popupBackground.getFitHeight()));
			popupBackground.setImage(SwingFXUtils.toFXImage(image, null));
		} catch (AWTException e) {
			System.out.println("The robot of doom strikes!");
			e.printStackTrace();
		}
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		popupBackground.setEffect(new BoxBlur(10, 10, 3));
		
	}

}
