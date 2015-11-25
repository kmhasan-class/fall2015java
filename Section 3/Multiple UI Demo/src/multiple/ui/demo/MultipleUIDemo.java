/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiple.ui.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kmhasan
 */
public class MultipleUIDemo extends Application {
    private static Stage mainStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        
        Parent root = FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getMainStage() {
        return mainStage;
    }
    
}
