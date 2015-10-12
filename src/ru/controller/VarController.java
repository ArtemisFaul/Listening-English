package ru.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.print.DocFlavor.CHAR_ARRAY;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class VarController extends ExerciseController implements Initializable {
	private static final DataFormat SERIALIZED_MIME_TYPE = new DataFormat("application/x-java-serialized-object");
	private String exercise;
	@FXML
	private VBox dragDrop;
	private Label dragLabel;
	@FXML
	private BorderPane varMain;
	@FXML
	private ToggleGroup tg1;
	@FXML
	private VBox vdolod;

	@FXML
	private void setDragDetected(MouseEvent event) {
		
		dragLabel = ((Label) event.getSource());
		dragLabel.setCursor(Cursor.CLOSED_HAND);
		Dragboard db = ((Label) event.getSource()).startDragAndDrop(TransferMode.MOVE);
		db.setDragView(((Label) event.getSource()).snapshot(null, null));
		ClipboardContent cc = new ClipboardContent();
		cc.put(SERIALIZED_MIME_TYPE, ((Label) event.getSource()).getText());
		db.setContent(cc);
		event.consume();
	}

	@FXML
	private void setDragOver(DragEvent event) {
		Dragboard db = event.getDragboard();
		if (db.hasContent(SERIALIZED_MIME_TYPE)) {
			if (((Label) event.getSource()).getText().equals(((String) db.getContent(SERIALIZED_MIME_TYPE))) == false) {
				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				event.consume();
			}
		}
	}

	@FXML
	private void setDragDropped(DragEvent event) {
		dragLabel.setCursor(Cursor.HAND);
		Dragboard db = event.getDragboard();
		dragDrop.getChildren().remove(dragDrop.getChildren().indexOf(dragLabel));
		dragDrop.getChildren().add(dragDrop.getChildren().indexOf((Label) event.getSource()), dragLabel);
	}

	
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}
	
	public boolean checkExercise(){
		boolean success = true;
		int count;
		switch (exercise) {
		case "A1":
			count = 0;
			TextField tf = new TextField();
			tf = (TextField) vdolod.getChildren().get(1);
			if (tf.getText().contains("up-to-date")){
				tf.setStyle("-fx-background-color: #E8F5E9;");
				count++;
			}else{
				tf.setStyle("-fx-background-color: #FFEBEE;");
			}
			tf = (TextField) vdolod.getChildren().get(3);
			if (tf.getText().contains("family") | tf.getText().contains("friends")){
				tf.setStyle("-fx-background-color: #E8F5E9;");
				count++;
			}else{
				tf.setStyle("-fx-background-color: #FFEBEE;");
			}
			tf = (TextField) vdolod.getChildren().get(5);
			if (tf.getText().contains("contacting")){
				tf.setStyle("-fx-background-color: #E8F5E9;");
				count++;
			}else{
				tf.setStyle("-fx-background-color: #FFEBEE;");
			}
			tf = (TextField) vdolod.getChildren().get(7);
			if (tf.getText().contains("music") | tf.getText().contains("entertainment")){
				tf.setStyle("-fx-background-color: #E8F5E9;");
				count++;
			}else{
				tf.setStyle("-fx-background-color: #FFEBEE;");
			}
			tf = (TextField) vdolod.getChildren().get(9);
			if (tf.getText().contains("buying") | tf.getText().contains("shops")){
				tf.setStyle("-fx-background-color: #E8F5E9;");
				count++;
			}else{
				tf.setStyle("-fx-background-color: #FFEBEE;");
			}
			if (count < 4){
				success = false;
			}
			break;
		case "A10":
			count = 0;
			Label lab = new Label();
			char s[];
			lab = (Label) dragDrop.getChildren().get(0);
			s = lab.getText().toCharArray();
			if (s[0] == 'C'){
				lab.setStyle("-fx-background-color: #E8F5E9;");
				count++;
			}else{
				lab.setStyle("-fx-background-color: #FFEBEE;");
			}
			lab = (Label) dragDrop.getChildren().get(1);
			s = lab.getText().toCharArray();
			if (s[0] == 'A'){
				lab.setStyle("-fx-background-color: #E8F5E9;");
				count++;
			}else{
				lab.setStyle("-fx-background-color: #FFEBEE;");
			}
			lab = (Label) dragDrop.getChildren().get(2);
			s = lab.getText().toCharArray();
			if (s[0] == 'D'){
				lab.setStyle("-fx-background-color: #E8F5E9;");
				count++;
			}else{
				lab.setStyle("-fx-background-color: #FFEBEE;");
			}
			lab = (Label) dragDrop.getChildren().get(3);
			s = lab.getText().toCharArray();
			if (s[0] == 'B'){
				lab.setStyle("-fx-background-color: #E8F5E9;");
				count++;
			}else{
				lab.setStyle("-fx-background-color: #FFEBEE;");
			}
			lab = (Label) dragDrop.getChildren().get(4);
			s = lab.getText().toCharArray();
			if (s[0] == 'F'){
				lab.setStyle("-fx-background-color: #E8F5E9;");
				count++;
			}else{
				lab.setStyle("-fx-background-color: #FFEBEE;");
			}
			lab = (Label) dragDrop.getChildren().get(5);
			s = lab.getText().toCharArray();
			if (s[0] == 'E'){
				lab.setStyle("-fx-background-color: #E8F5E9;");
				count++;
			}else{
				lab.setStyle("-fx-background-color: #FFEBEE;");
			}
			if (count < 5){
				success = false;
			}
			break;
		case "A19":
			count = 0;
			RadioButton rb = new RadioButton();
			for (int i = 0; i < vdolod.getChildren().size(); i++) {
				if (vdolod.getChildren().get(i) instanceof RadioButton){
					rb = (RadioButton) vdolod.getChildren().get(i);
					if (rb.isSelected()){
						if ((i == 1) | (i == 5) | (i == 11) | (i == 14) | (i == 17) | (i == 19)) {
							rb.setStyle("-fx-background-color: #E8F5E9;");
							count++;
						}else{
							rb.setStyle("-fx-background-color: #FFEBEE;");
						}
						
					}
			}
			}
			if (count < 5){
				success = false;
			}
			break;
		}
		return success;
	}
	
	public void setEasterEgg (){
		switch (exercise) {
		case "A1":
			TextField tf = new TextField();
			tf = (TextField) vdolod.getChildren().get(1);
			tf.setStyle("-fx-background-color: #E8F5E9;");
			tf.setText("For up-to-date news or references.");
			
			tf = (TextField) vdolod.getChildren().get(3);
			tf.setStyle("-fx-background-color: #E8F5E9;");
			tf.setText("For keeping in touch with family and friends.");
			
			tf = (TextField) vdolod.getChildren().get(5);
			tf.setStyle("-fx-background-color: #E8F5E9;");
			tf.setText("As a way of contacting old friends.");
			
			tf = (TextField) vdolod.getChildren().get(7);
			tf.setStyle("-fx-background-color: #E8F5E9;");
			tf.setText("As a source of free entertainment (music).");
			
			tf = (TextField) vdolod.getChildren().get(9);
			tf.setStyle("-fx-background-color: #E8F5E9;");
			tf.setText("As a way of buying things unavailable in shops.");
			break;
		case "A10":
			Label lab = new Label();
			lab = (Label) dragDrop.getChildren().get(0);
			lab.setStyle("-fx-background-color: #E8F5E9;");
			lab.setText("C. People do a lot of things online.");
			
			lab = (Label) dragDrop.getChildren().get(1);
			lab.setStyle("-fx-background-color: #E8F5E9;");
			lab.setText("A. The number of viruses are being discovered every year.");
			
			lab = (Label) dragDrop.getChildren().get(2);
			lab.setStyle("-fx-background-color: #E8F5E9;");
			lab.setText("D. Robert Schifreen names those he hacked.");
			
			lab = (Label) dragDrop.getChildren().get(3);
			lab.setStyle("-fx-background-color: #E8F5E9;");
			lab.setText("B. The corporations aren’t doing enough for their security.");
			
			lab = (Label) dragDrop.getChildren().get(4);
			lab.setStyle("-fx-background-color: #E8F5E9;");
			lab.setText("F. Malware and phishing attacks.");
			
			lab = (Label) dragDrop.getChildren().get(5);
			lab.setStyle("-fx-background-color: #E8F5E9;");
			lab.setText("E. The question you have to ask yourself about hackers.");
			break;
		case "A19":
			((RadioButton) vdolod.getChildren().get(1)).setSelected(true);
			((RadioButton) vdolod.getChildren().get(1)).setStyle("-fx-background-color: #E8F5E9;");
			
			((RadioButton) vdolod.getChildren().get(5)).setSelected(true);
			((RadioButton) vdolod.getChildren().get(5)).setStyle("-fx-background-color: #E8F5E9;");
			
			((RadioButton) vdolod.getChildren().get(11)).setSelected(true);
			((RadioButton) vdolod.getChildren().get(11)).setStyle("-fx-background-color: #E8F5E9;");
			
			((RadioButton) vdolod.getChildren().get(14)).setSelected(true);
			((RadioButton) vdolod.getChildren().get(14)).setStyle("-fx-background-color: #E8F5E9;");
			
			((RadioButton) vdolod.getChildren().get(17)).setSelected(true);
			((RadioButton) vdolod.getChildren().get(17)).setStyle("-fx-background-color: #E8F5E9;");
			
			((RadioButton) vdolod.getChildren().get(19)).setSelected(true);
			((RadioButton) vdolod.getChildren().get(19)).setStyle("-fx-background-color: #E8F5E9;");
			
			
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

	}

}
