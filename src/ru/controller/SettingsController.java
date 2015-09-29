package ru.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ru.Main;
import ru.model.ControlledScreen;

public class SettingsController  implements Initializable, ControlledScreen {
	ScreensController myController;
	
	@FXML
	public void guidelinesButton() {
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	public void backButton() {
		System.out.println(myController+" parent");
		myController.setScreen(Main.screen1ID, Main.screen1File);
		
		//Main.scenes.get(0).setScene();
	}

	@Override
	public void setScreenParent(ScreensController screenParent) {
		// TODO Auto-generated method stub
		myController = screenParent;
		
	}

}
