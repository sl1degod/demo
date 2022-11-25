package DemoClass.Models;

import javafx.stage.Stage;

public class StageModel {
    public static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        StageModel.stage = stage;
    }
}
