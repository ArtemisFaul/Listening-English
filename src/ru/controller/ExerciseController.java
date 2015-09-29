package ru.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
	private Button vizKey;
	@FXML
	private Text nameEx;
	
	@FXML
	private Label questEx;
	@FXML
	private Label questIntro;
	@FXML
	private Label exKey;
	@FXML
	private Button viewAudioscriptButton;
	@FXML
	private ScrollPane SP;
	private Button playAudioButton;


	public MediaPlayer mediaPlayer;

	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}

	@FXML
	public void viewAudioscript() {
		
	}

	@FXML
	public void playAudio() {

		Status stat = mediaPlayer.getStatus();
		try {
			if (stat == Status.PLAYING) {
			mediaPlayer.stop();
			playAudioButton.setText("Play");
		} else {
			mediaPlayer.play();
			playAudioButton.setText("Stop");
		}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

	@FXML
	public void guidelinesButton() {
		
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
		//modelName.setText(item.getModelName());
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
		mediaPlayer = new MediaPlayer(new Media(getClass().getResource(item.getExAttachFile()).toString()));
		try {
			SP.setContent(FXMLLoader.load(PopupController.class.getResource(item.getVarFile().toString())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
