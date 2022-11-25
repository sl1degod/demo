package DemoClass;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox CSharpCheckBox;

    @FXML
    private CheckBox JavaCheckBox;

    @FXML
    private CheckBox PythonCheckBox;

    @FXML
    private Button checkButton;

    @FXML
    private RadioButton girlRadioButton;

    @FXML
    private RadioButton manRadioButton;

    @FXML
    private ToggleButton studyButton;

    private ToggleGroup group;

    @FXML
    void initialize() {
        checkButton.graphicProperty().setValue(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/check_ic.png")))));
        installRadioButton();
        installToggleButton();
        checkButton.setOnAction(e -> {
            System.out.println(getSelectedCheckBox() + " " + getSelectedRadioButton() + " " + getValueToggleButton());
            new Loader().BackToMainScreen(checkButton);
        });
    }

    private void installToggleButton() {
        studyButton.setOnAction(e -> {
            if (studyButton.isSelected()) studyButton.setStyle("-fx-background-color: #43a047");
            else studyButton.setStyle("-fx-background-color: #f39c63");
        });
    }

    private void installRadioButton() {
        group = new ToggleGroup();
        manRadioButton.setToggleGroup(group);
        girlRadioButton.setToggleGroup(group);
    }

    private String getSelectedCheckBox() {
        String allSelected = "";
        if(JavaCheckBox.isSelected()) allSelected += "Java ";
        if(PythonCheckBox.isSelected()) allSelected += "Python ";
        if(CSharpCheckBox.isSelected()) allSelected += "C# ";
        if(allSelected.isEmpty()) allSelected = "Ничего ";
        return allSelected;
    }

    private String getSelectedRadioButton() {
        return ((RadioButton) group.getSelectedToggle()).getText();
    }

    private String getValueToggleButton(){
        return studyButton.isSelected() ? "Да" : "Нет";
    }

}
