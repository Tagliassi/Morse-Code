package pucpr.edu.br.morsetreevisualizer;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TreeVisualizerController {

    @FXML private Canvas treeCanvas;
    @FXML private TextField morseInput;
    @FXML private Label decodedOutput;
    @FXML private TextField textInput;

    private TreeVisualizer.MorseBST morseTree;

    @FXML
    public void initialize() {
        morseTree = new TreeVisualizer.MorseBST();

        // Inserir alfabeto
        String[][] morseAlphabet = {
                {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."},
                {"E", "."}, {"F", "..-."}, {"G", "--."}, {"H", "...."},
                {"I", ".."}, {"J", ".---"}, {"K", "-.-"}, {"L", ".-.."},
                {"M", "--"}, {"N", "-."}, {"O", "---"}, {"P", ".--."},
                {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
                {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"},
                {"Y", "-.--"}, {"Z", "--.."}, {"1", ".----"}, {"2", "..---"},
                {"3", "...--"}, {"4", "....-"}, {"5", "....."}, {"6", "-...."},
                {"7", "--..."}, {"8", "---.."}, {"9", "----."}, {"0", "-----"}
        };

        for (String[] pair : morseAlphabet) {
            morseTree.insert(pair[0].charAt(0), pair[1]);
        }

        // Desenha a árvore
        morseTree.drawTree(treeCanvas);
    }

    @FXML
    protected void onDecodeClick() {
        String input = morseInput.getText();
        String decoded = morseTree.decode(input);
        decodedOutput.setText("Decodificado: " + decoded);
    }

    @FXML
    protected void onEncodeClick() {
        String input = textInput.getText().toUpperCase().replaceAll("[^A-Z0-9]", "");
        String encoded = morseTree.encode(input);
        decodedOutput.setText("Codificado: " + encoded);
    }
}
