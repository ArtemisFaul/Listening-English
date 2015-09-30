package ru.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class VarController implements Initializable {
	private static final DataFormat SERIALIZED_MIME_TYPE = new DataFormat("application/x-java-serialized-object");
	static String exercise;
	@FXML
	private VBox dragDrop;
	private Label dragLabel;
	@FXML
	private BorderPane varMain;

	@FXML
	public void ololo() {

	}

	@FXML
	public void setDragDetected(MouseEvent event) {
		
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
	public void setDragOver(DragEvent event) {
		Dragboard db = event.getDragboard();
		if (db.hasContent(SERIALIZED_MIME_TYPE)) {
			if (((Label) event.getSource()).getText().equals(((String) db.getContent(SERIALIZED_MIME_TYPE))) == false) {
				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				event.consume();
			}
		}
	}

	@FXML
	public void setDragDropped(DragEvent event) {
		dragLabel.setCursor(Cursor.HAND);
		Dragboard db = event.getDragboard();
		dragDrop.getChildren().remove(dragDrop.getChildren().indexOf(dragLabel));
		dragDrop.getChildren().add(dragDrop.getChildren().indexOf((Label) event.getSource()), dragLabel);
	}

	
	public static void setExercise(String exercise) {
		VarController.exercise = exercise;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		switch (exercise) {
		case "A1":

			break;
		case "A2":

			break;
		case "A3":

			break;
		case "A4":

			break;
		case "A5":

			break;
		case "A6":

			break;
		case "A7":

			break;
		case "A8":

			break;
		case "A9":

			break;
		case "A10":

			break;
		case "A11":

			break;
		case "A12":

			break;
		case "A13":

			break;
		case "A14":

			break;
		case "A15":

			break;
		case "A16":

			break;
		case "A17":

			break;
		case "A18":

			break;
		case "A19":

			break;
		case "A20":

			break;
		case "A21":

			break;
		default:
			break;
		}

	}

}
