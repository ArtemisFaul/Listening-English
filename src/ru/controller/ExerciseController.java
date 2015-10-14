package ru.controller;

import java.awt.Checkbox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.text.Text;
import ru.Main;
import ru.model.Charters;
import ru.model.ControlledScreen;

public class ExerciseController implements Initializable, ControlledScreen {
	ScreensController myController;
	private static Charters item;
	@FXML
	private Text nameEx;
	@FXML
	private Button easterEgg;
	@FXML
	private Label questEx;
	@FXML
	private Label questIntro;
	@FXML
	private Label exKey;
	@FXML
	private Label message;
	@FXML
	private Button viewAudioscriptButton;
	@FXML
	private ScrollPane SP;
	private Button playAudioButton;
	private FXMLLoader myLoader = null;
	private VarController varController;
	private int count;


	public MediaPlayer mediaPlayer;

	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}

	@FXML
	public void viewAudioscript() {
			Main.popup.setAudioskript(item.getAudioscriptFile().toString());		
	}
	@FXML
	public void startEaster(){
		varController.setEasterEgg();
	}
	
	@FXML
	public void keyAction(KeyEvent keyEvent) {
		switch (keyEvent.getCode()) {
		case F4:
			easterEgg.setVisible(true);
			break;
		}
	}

	@FXML
	public void playAudio() {
		switch (item.getType()) {
		case "Video":
			Main.popup.setVideo(item.getExAttachFile().toString());	
			break;
		case "Audio":
		try {
			Status stat = mediaPlayer.getStatus();
			if (stat == Status.PLAYING) {
			mediaPlayer.stop();
			playAudioButton.setText("Play");
		} else {
			mediaPlayer.play();
			playAudioButton.setText("Stop");
		}
		} catch (Exception e) {
		}
		System.out.println(mediaPlayer.getMedia().getSource().toString());
		break;
		}
	}
	
	@FXML
	private void checkButtonClick(){
		if ((count < 2) & (varController.checkExercise() != true)){
		message.setText("Try again.");
		count++;
		}else{
			if (varController.checkExercise()){
				message.setText("Well done!");
			}
			startEaster();
			viewAudioscriptButton.setVisible(true);
			if (item.getType() == "Audio") {
				Status stat = mediaPlayer.getStatus();
				try {
					if (stat == Status.PLAYING) {
					mediaPlayer.stop();
					playAudioButton.setText("Play");
				} 
				} catch (Exception e) {
					// TODO: handle exception
				}
				if (item.getKeyAttachFile() != ""){
				mediaPlayer =  new MediaPlayer(new Media(getClass().getResource(item.getKeyAttachFile()).toString()));
				}
				System.out.println(mediaPlayer.getMedia().getSource().toString());
			}
		}
		
	}
	

	@FXML
	public void backButton() {
		try {
			Status stat = mediaPlayer.getStatus();
		if (stat == Status.PLAYING) {
			mediaPlayer.stop();
			playAudioButton.setText("Play");
		}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		myController.setScreen(Main.screen2ID, Main.screen2File);
	}


	public void load() {
		nameEx.setText(item.getName());
		questIntro.setText(item.getIntro());
		questEx.setText(item.getExercise());
	}

	public static void setItem(Charters item) {
		ExerciseController.item = item;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(this.toString() + " iniz");
		load();
		count = 0;
		switch (item.getType()) {
		case "Video":
			System.out.println("warning: Video content");
			break;

		case "Audio":
			mediaPlayer = new MediaPlayer(new Media(getClass().getResource(item.getExAttachFile()).toString()));
			System.out.println("warning: Audio content");
			break;
		}
		try {
			myLoader = new FXMLLoader(getClass().getResource(item.getVarFile().toString()));
			SP.setContent(myLoader.load());
			varController = myLoader.getController();
			varController.setExercise(item.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
