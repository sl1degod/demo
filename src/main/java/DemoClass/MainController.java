package DemoClass;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import DemoClass.Models.StageModel;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class MainController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private AnchorPane root;

    @FXML
    private URL location;

    @FXML
    private Button buttonFields, buttonButtons, buttonTabPane, buttonListView;

    @FXML
    void initialize() {
        if (!Counts.isSplashLoaded){
            loadSplashScreen();
        }
        buttonFields.setOnAction(e-> openNewScene(buttonFields,"/screens/text-screen.fxml"));
        buttonButtons.setOnAction(e-> openNewScene(buttonFields,"/screens/buttons-screen.fxml"));
        buttonTabPane.setOnAction(e-> openNewScene(buttonFields,"/screens/TabPaneController.fxml"));
        buttonListView.setOnAction(e-> openNewScene(buttonFields,"/screens/ListViewController.fxml"));
    }

    private void loadSplashScreen() {
        Stage stage = StageModel.getStage();
        Counts.isSplashLoaded = true;
        try {
            stage.initStyle(StageStyle.UNDECORATED);
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/screens/splash-screen.fxml")));
            root.getChildren().setAll(pane);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(1.5), pane);
            fadeIn.setFromValue(0.3);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(1.5), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0.3);
            fadeOut.setCycleCount(1);

            fadeIn.play();
            fadeIn.setOnFinished(e-> fadeOut.play());
            fadeOut.setOnFinished(e-> {
                try {
                    Stage newStage = new Stage();
                    newStage.setScene(root.getScene());
                    newStage.setTitle("Компоненты");
                    newStage.initStyle(StageStyle.DECORATED);
                    StageModel.setStage(newStage);
                    new Loader().setIcon(newStage);
                    stage.hide();
                    newStage.show();
                    AnchorPane parentContent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/screens/main-screen.fxml")));
                    root.getChildren().setAll(parentContent);
                }catch (IOException ex) {
                    throw new RuntimeException();
                }
            });
        } catch(IOException ex) {
            throw new RuntimeException();
        }
    }

    public void openNewScene(Button button, String window){
        button.getScene().getWindow().hide();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try{
            loader.load();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        Parent root=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
