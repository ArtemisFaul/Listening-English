package ru.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import ru.Main;
import ru.model.ControlledScreen;

public class LoginController  implements Initializable, ControlledScreen{
	ScreensController myController;
	@FXML
	TextField nameField;
	
	
	@FXML
	public void guidelinesButton() {
		
	}
	
	@FXML
	public void backButton() {
		System.out.println(myController+" parent");
		myController.setScreen(Main.screen1ID, Main.screen1File);
		
		
		//Main.scenes.get(0).setScene();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println(nameField);
		
	}
	@FXML
	public void buttonOk(){
		if (nameField != null){
			MainController.setName(nameField.getText());
		}
		backButton();
	}

	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
		
	}

}
