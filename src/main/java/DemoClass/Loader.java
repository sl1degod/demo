package DemoClass;

import DemoClass.Models.SceneModel;
import DemoClass.Models.StageModel;
import DemoClass.interfacesMethods.BackToMainScreen;
import DemoClass.interfacesMethods.IconProgram;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Calendar;
import java.util.Objects;

public class Loader extends Application implements IconProgram, BackToMainScreen{
    @Override
    public void start(Stage stage) throws IOException {
        StageModel.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(Loader.class.getResource("/screens/Main-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        SceneModel.setScene(scene);
        stage.setTitle("Components");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void BackToMainScreen(Node node){
        Scene myScene = SceneModel.getScene();
        if(myScene != null) {
            node.getScene().getWindow().hide();
            Stage stage = StageModel.getStage();
            stage.setScene(myScene);
            stage.show();
        } else {
            System.out.println("Сцена пустая");
        }
    }

    @Override
    public void setIcon(Stage stage){
        stage.getIcons().add(new Image(Objects.requireNonNull(Loader.class.getResourceAsStream("/images/logoJava.png"))));
    }



}
