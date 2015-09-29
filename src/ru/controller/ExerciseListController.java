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
	public static ArrayList<Charters> exAR = new ArrayList<Charters>();
	public static String charter;

	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}

	public void load() {
		ObservableList<Charters> data = FXCollections.observableArrayList(exAR);
		final ListView<Charters> listView = new ListView<Charters>(data);
		listView.setCellFactory(new Callback<ListView<Charters>, ListCell<Charters>>() {

			@Override
			public ListCell<Charters> call(ListView<Charters> arg0) {
				return new ListCell<Charters>() {

					@Override
					protected void updateItem(Charters item, boolean bln) {
						super.updateItem(item, bln);
						if (item != null) {
							HBox hBoxRoot = new HBox(); 
							VBox vBoxExerciseName = new VBox();
							Label exerciseName = new Label(item.getName());
							Label modelName = new Label(item.getModelName());
							exerciseName.setId("exerciseName");
							modelName.setId("exerciseName");
							exerciseName.setWrapText(true);
							modelName.setWrapText(true);
							vBoxExerciseName.setSpacing(5);
							vBoxExerciseName.setMaxHeight(USE_COMPUTED_SIZE);
							vBoxExerciseName.getChildren().addAll(exerciseName, modelName);
							VBox vBoxButtonStart = new VBox();
							vBoxButtonStart.setId("buttonStart");
							vBoxButtonStart.setAlignment(Pos.CENTER);
							ImageView startButtonImage = new ImageView();
							startButtonImage.setImage(new Image(getClass().getResource("/ru/res/image/start_button.png").toString()));
							vBoxButtonStart.getChildren().add(startButtonImage);
							hBoxRoot.getChildren().addAll(vBoxExerciseName,vBoxButtonStart);
							setGraphic(hBoxRoot);
						}
						listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								nameex.setText(listView.getSelectionModel().getSelectedItem().getName());
								//modelName.setText(listView.getSelectionModel().getSelectedItem().getModelName());
								/*modelDescription
										.setText(listView.getSelectionModel().getSelectedItem().getModelDescription());*/
								mediaBul.setText(listView.getSelectionModel().getSelectedItem().getType());
								qestEx.setText(listView.getSelectionModel().getSelectedItem().getIntro());
								ExerciseController.setItem(listView.getSelectionModel().getSelectedItem());
								VarController.setExercise(listView.getSelectionModel().getSelectedItem().getId());
								startEx.setVisible(true);
								
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
	}

	@FXML
	public void startExer() {
		myController.setScreen(Main.screen3ID, Main.screen3File);
	}

	@FXML
	public void backButton() {
		System.out.println(myController + " parent");
		myController.setScreen(Main.screen1ID, Main.screen1File);
	}

	@FXML
	public void guidelinesButton() {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(this.toString() + " iniz");
		load();
	}

	

}
