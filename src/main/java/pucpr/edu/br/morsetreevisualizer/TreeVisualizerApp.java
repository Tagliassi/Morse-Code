package pucpr.edu.br.morsetreevisualizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TreeVisualizerApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TreeVisualizerApp.class.getResource("tree-visualizer-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800); // Tamanho maior
        stage.setTitle("Visualizador de Árvore Morse");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
