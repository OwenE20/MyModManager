package Window;

import Utilities.GameListGen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        ManagerScene scene = new ManagerScene();


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene.getScene());



        GameListGen.generateList();
        scene.addGameElement(GameListGen.pathArrayList);


        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}

