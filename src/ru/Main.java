package ru;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.controller.ScreensController;
import ru.model.Charters;
import ru.model.Popups;

public class Main extends Application {
	public static ArrayList<Charters> genEnglish = new ArrayList<Charters>();
	public static ArrayList<Charters> proEnglish = new ArrayList<Charters>();
	public static ArrayList<Charters> busEnglish = new ArrayList<Charters>();
	public static Popups popup = new Popups();
	public static Stage primaryStage;
	public static String screen1ID = "Main";
	public static String screen1File = "/ru/view/MainController.fxml";
	public static String screen2ID = "ExerciseListController";
	public static String screen2File = "/ru/view/ExerciseListController.fxml";
	public static String screen3ID = "ExerciseController";
	public static String screen3File = "/ru/view/ExerciseController.fxml";
	public static String screen5ID = "LoginController";
	public static String screen5File = "/ru/view/Login.fxml";
	public static String screen6ID = "SettingsController";
	public static String screen6File = "/ru/view/Settings.fxml";
	
	public ArrayList<Charters> parse(String charter) {
		ArrayList<Charters> exAR = new ArrayList<Charters>();
		try {
			InputStream in = getClass().getResourceAsStream("/ru/res/data/Charters.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(in);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName(charter);
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					exAR.add(new Charters(eElement.getElementsByTagName("id").item(0).getTextContent(),
							eElement.getElementsByTagName("name").item(0).getTextContent(),
							eElement.getElementsByTagName("modelName").item(0).getTextContent(),
							eElement.getElementsByTagName("modelDescription").item(0).getTextContent(),
							eElement.getElementsByTagName("intro").item(0).getTextContent(),
							eElement.getElementsByTagName("exercise").item(0).getTextContent(),
							eElement.getElementsByTagName("key").item(0).getTextContent(),
							eElement.getElementsByTagName("varFile").item(0).getTextContent(),
							eElement.getElementsByTagName("type").item(0).getTextContent(),
							eElement.getElementsByTagName("exAttachFile").item(0).getTextContent(),
							eElement.getElementsByTagName("keyAttachFile").item(0).getTextContent(),
							eElement.getElementsByTagName("audioscriptFile").item(0).getTextContent()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(charter + " chapter parsed.");
		return exAR;
	}
	
	@Override
	public void start(Stage primaryStage) {
		genEnglish = (parse("GenEnglish"));
		proEnglish = (parse("ProEnglish"));
		busEnglish = (parse("BusEnglish"));
		Main.primaryStage = primaryStage;
		primaryStage.setTitle("Listening English");
		primaryStage.centerOnScreen();
		primaryStage.setMinHeight(626);
		primaryStage.setMinWidth(840);
		primaryStage.setResizable(false);
		primaryStage.setMaximized(false);
		ScreensController mainContainer = new ScreensController();
		mainContainer.setScreen(Main.screen1ID, Main.screen1File);
		Scene scene = new Scene(mainContainer);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
