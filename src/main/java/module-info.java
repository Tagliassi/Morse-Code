module pucpr.edu.br.morsetreevisualizer {
    requires javafx.controls;
    requires javafx.fxml;


    opens pucpr.edu.br.morsetreevisualizer to javafx.fxml;
    exports pucpr.edu.br.morsetreevisualizer;
}