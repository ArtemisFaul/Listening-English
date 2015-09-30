package ru.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import ru.*;
import ru.model.ControlledScreen;
import ru.model.Popups;

public class MainController implements Initializable, ControlledScreen {
	ScreensController myController;
	static String _name;
	@FXML
	StackPane genEnglishButton;
	@FXML
	StackPane proEnglishButton;
	@FXML
	StackPane busEnglishButton;
	@FXML
	private BorderPane mCBP;
	@FXML
	protected Text userName;


	@FXML
	public void about() {
	}

	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}

	public static void setName(String name) {
		_name = name;
	}

	@FXML
	public void settings() {
		myController.setScreen(Main.screen6ID, Main.screen6File);
	}

	@FXML
	public void genEnglishLoad() {
		ExerciseListController.exAR = Main.genEnglish;
		myController.setScreen(Main.screen2ID, Main.screen2File);
		
	}

	@FXML
	public void proEnglishLoad() {
		ExerciseListController.exAR = Main.proEnglish;
		myController.setScreen(Main.screen2ID, Main.screen2File);
		
	}

	@FXML
	public void busEnglishLoad() {
		ExerciseListController.exAR = Main.busEnglish;
		myController.setScreen(Main.screen2ID, Main.screen2File);
		
	}

	

	@FXML
	public void login() {
		myController.setScreen(Main.screen5ID, Main.screen5File);
	}

	@FXML
	public void guidelinesButton() {
		Main.popup.setPopup();
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(this.toString() + " iniz");

		if (_name != null) {
			userName.setText(_name);
		}

	}

}
