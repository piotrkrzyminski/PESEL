package es.hol.piotrkrzyminski.view;

import java.net.URL;
import java.util.ResourceBundle;

import es.hol.piotrkrzyminski.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Controller implements Initializable {
	
	/**
	 * zmienne uzyte podczas przypisywania elementom interfejsu nazw definiujacych je w tym pliku
	 */
	@FXML
	private TextField textField;
	@FXML
	private Label infoLabel;
	@FXML
	private Button checkButton;
	
	private Model model = new Model();
	
	/**
	 * akcja przypisana do przycisku wywoluje metode setInfoLabel()
	 * @param event
	 */
	@FXML
	void checkButtonAction(ActionEvent event) {
		setInfoLabel();
	}
	
	/**
	 * sprawdz czy podany ciag jest poprawnym peselem - jesli tak to wypisz informacje ponizej i ustaw kolor czcionki na zielony
	 * w przeciwnym razie poinformuj ze nie jest poprawny i ustaw czcionke na czerwonaW
	 */
	private void setInfoLabel() {
		if(model.checkPESEL(textField.getText())) {
			infoLabel.setText("Poprawny");
			infoLabel.setTextFill(Color.GREEN);
		} else {
			infoLabel.setText("Niepoprawny");
			infoLabel.setTextFill(Color.RED);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		infoLabel.setText("");
	}
}
