package DemoClass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;

public class TextController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Spinner<Integer> ageSpinner;

    @FXML
    private ChoiceBox<String> cityChoice;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button saveButton;

    @FXML
    void initialize() {
        installSpinner();
        installChoseBox();
        saveButton.setOnAction(event -> {
            if (validation()) new Loader().BackToMainScreen(saveButton);


        });
    }

    private void installSpinner() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000);
        ageSpinner.setValueFactory(valueFactory);
        ageSpinner.setStyle("-fx-font: 20 system");
    }

    private void installChoseBox() {
        ObservableList<String> listCities = FXCollections.observableArrayList("Альметьевск", "Казань", "Москва", "Санкт-Петербург", "Нижний Новгород");
        cityChoice.setItems(listCities);
        cityChoice.setStyle("-fx-font: 20 system");
        cityChoice.setValue("Выберите город");
    }

    private Boolean validation() {
        String login = loginField.getText();
        String password = passwordField.getText();
        String city = cityChoice.getValue();
        String age = ageSpinner.getValue().toString();

        if(login.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка!");
            alert.setHeaderText("Заполните все поля!");
            alert.setContentText("Чтобы сохранить данные, заполните все поля!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            new Loader().setIcon(stage);
            alert.showAndWait();
            return false;
        } else {
            System.out.println(login + " " + password + " " + city + " " + age);
            return true;
        }
    }
}

