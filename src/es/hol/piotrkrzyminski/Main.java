package es.hol.piotrkrzyminski;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primaryStage; //glowne okno aplikacjis
	private Parent parent; //zawartosc okna aplikacji

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException{
		this.primaryStage = primaryStage;
		
		loadFXML();
		drawGUI();
	}
	
	/**
	 * pobierz plik fxml definiujacy wyglad sceny i przypisz go do zmiennej parent
	 * rzuc wyjatkiem w razie niepowodzenia w odczytaniu pliku
	 */
	private void loadFXML() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("view/MainFXML.fxml"));
		parent = (Parent) loader.load();
	}
	
	/**
	 * stwórz nowa scene i przypisz ja do okna aplikacji
	 * ustaw apliakcje na widoczna
	 */
	private void drawGUI() {
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("PESEL");
		primaryStage.show();
	}	
}
