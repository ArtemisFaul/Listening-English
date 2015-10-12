package ru.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import ru.Main;
import ru.model.Charters;
import ru.model.ControlledScreen;

public class ExerciseListController implements Initializable, ControlledScreen {
	ScreensController myController;
	@FXML
	private Label nameex;
	@FXML
	private Label modelName;
	@FXML
	private Label modelDescription;
	@FXML
	private Label qestEx;
	@FXML
	public Text mediaBul;
	@FXML
	private AnchorPane listViewAnchor;
	@FXML
	private Button startEx;
	private ObservableList<Charters> data = FXCollections.observableArrayList(exAR);
	private ListView<Charters> listView = new ListView<Charters>(data);
	public static ArrayList<Charters> exAR = new ArrayList<Charters>();
	public static String charter;
	

	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}

	public void load() {
		listView.setCellFactory(new Callback<ListView<Charters>, ListCell<Charters>>() {

			@Override
			public ListCell<Charters> call(ListView<Charters> arg0) {
				return new ListCell<Charters>() {
					@Override
					protected void updateItem(Charters item, boolean bln) {
						super.updateItem(item, bln);
						if (item != null) {
							this.setId("exerciseNameItem");
							VBox vBoxExerciseName = new VBox();
							vBoxExerciseName.setPrefWidth(USE_COMPUTED_SIZE);
							Label exerciseName = new Label(item.getName());
							Label modelName = new Label(item.getModelName());
							exerciseName.setId("exerciseName");
							modelName.setId("exerciseName");
							exerciseName.setWrapText(true);
							modelName.setWrapText(true);
							vBoxExerciseName.setSpacing(5);
							vBoxExerciseName.setMaxHeight(USE_COMPUTED_SIZE);
							vBoxExerciseName.getChildren().addAll(exerciseName, modelName);							
							setGraphic(vBoxExerciseName);
						}
						
						listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								setSelectionItem();
								if(event.getClickCount() == 2){
					                startExer();
					            }
							}
						});
						listView.setOnKeyPressed(new EventHandler<KeyEvent>() {
							public void handle (KeyEvent keyEvent) {
								if(keyEvent.getCode() == KeyCode.ENTER){
									startExer();
								}							
							}
						});
						listView.setOnKeyReleased(new EventHandler<KeyEvent>() {
							public void handle (KeyEvent keyEvent) {
								switch (keyEvent.getCode()) {
								case UP:
									setSelectionItem();
									break;
								case DOWN:
									setSelectionItem();
									break;
								}
							
							
							}
						});
					}

				};
			}

		});
		AnchorPane.setTopAnchor(listView, 0.0);
		AnchorPane.setLeftAnchor(listView, 0.0);
		AnchorPane.setRightAnchor(listView, 0.0);
		AnchorPane.setBottomAnchor(listView, 0.0);
		listViewAnchor.getChildren().add(listView);
		listView.getSelectionModel().select(0);
		setSelectionItem();
	}

	@FXML
	public void startExer() {
		myController.setScreen(Main.screen3ID, Main.screen3File);
	}
	public void setSelectionItem(){
		nameex.setText(listView.getSelectionModel().getSelectedItem().getName());
		//modelName.setText(listView.getSelectionModel().getSelectedItem().getModelName());
		/*modelDescription
				.setText(listView.getSelectionModel().getSelectedItem().getModelDescription());*/
		mediaBul.setText(listView.getSelectionModel().getSelectedItem().getType());
		qestEx.setText(listView.getSelectionModel().getSelectedItem().getIntro());
		ExerciseController.setItem(listView.getSelectionModel().getSelectedItem());
		startEx.setVisible(true);
	}
	@FXML
	public void backButton() {
		System.out.println(myController + " parent");
		myController.setScreen(Main.screen1ID, Main.screen1File);
	}
	@FXML
	public void backButtonKeyboard(KeyEvent keyEvent) {
		if (keyEvent.getCode() == KeyCode.BACK_SPACE){
			backButton();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(this.toString() + " iniz");
		load();
		
	}

	

}
