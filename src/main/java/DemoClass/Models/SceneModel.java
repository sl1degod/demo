package DemoClass.Models;

import javafx.scene.Scene;

public class SceneModel {
    public static Scene scene;

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        SceneModel.scene = scene;
    }
}
