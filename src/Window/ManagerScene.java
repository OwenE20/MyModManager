package Window;

import Utilities.FindAndExecute;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by Mike-Owen on 7/28/2018.
 */
public class ManagerScene {

    private Scene scene;
    private Group root;
    private BorderPane pane;
    private ToggleGroup group;
    private ArrayList<RadioButton> buttons;
    private ArrayList<Label> labels;
    private Button launchButton;
    private FindAndExecute FAE;
    private Path selectedPath;




    public ManagerScene(){

         FAE = new FindAndExecute();

        root = new Group();
        scene = new Scene(root,1000,1000);

        pane = new BorderPane();
        root.getChildren().add(pane);

        selectedPath = null;

        group = new ToggleGroup();
        group.selectedToggleProperty().addListener( (observable, oldValue, newValue) -> {
            selectedPath = (Path) newValue.getUserData();
            FAE.findExecPath(selectedPath);
            System.out.println(selectedPath);
        });




        launchButton = new Button("Launch");
        root.getChildren().add(launchButton);
        launchButton.relocate(30,900);
        launchButton.setOnAction( e -> {
            if(selectedPath != null && FAE.getExecPath() != null){
                FAE.execute();
            }
        });




    }


    public Scene getScene(){

        return scene;
    }

    public void addGameElement(ArrayList<Path> paths){
        buttons = new ArrayList<>();
        labels = new ArrayList<>();

        int y = 0, labelNum = 0;

        for(Path path: paths){
            buttons.add(new RadioButton(path.toString()));
        }
        for (RadioButton button: buttons) {
            button.setToggleGroup(group);
            button.setUserData(Paths.get(button.getText()));

            pane.getChildren().add(button);
            y += 20;
            button.setLayoutY(y);


            labels.add(new Label(button.getText()));
            labels.get(labelNum).relocate(button.getLayoutX() + 30, button.getLayoutY() - 10);
            root.getChildren().add(labels.get(labelNum));
            labelNum++;

        }



        }

    }

