package pucpr.edu.br.morsetreevisualizer;

import Types.LinkedNode;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TreeVisualizer {

    static class MorseBST {
        private LinkedNode<Character> root = new LinkedNode<Character>(' ');

        public void insert(char letter, String morseCode) {
            LinkedNode<Character> current = root;
            for (char symbol : morseCode.toCharArray()) {
                if (symbol == '.') {
                    if (current.left == null) current.left = new LinkedNode<Character>(' ');
                    current = current.left;
                } else if (symbol == '-') {
                    if (current.right == null) current.right = new LinkedNode<Character>(' ');
                    current = current.right;
                }
            }
            current.value = letter;
        }

        public String decode(String morse) {
            StringBuilder result = new StringBuilder();
            String[] tokens = morse.trim().split(" ");
            for (String token : tokens) {
                LinkedNode<Character> current = root;
                for (char c : token.trim().toCharArray()) {
                    if (c == '.') current = current.left;
                    else if (c == '-') current = current.right;
                    if (current == null) break;
                }
                result.append(current != null ? current.value : '?');
            }
            return result.toString();
        }

        public String encode(String text) {
            StringBuilder result = new StringBuilder();
            for (char c : text.toCharArray()) {
                String morse = getMorseCodeForChar(root, c, "");
                if (morse != null) {
                    result.append(morse).append(" ");
                } else {
                    result.append("? ");
                }
            }
            return result.toString().trim();
        }

        private String getMorseCodeForChar(LinkedNode<Character> node, char target, String path) {
            if (node == null) return null;
            if (node.value == target) return path;
            String left = getMorseCodeForChar(node.left, target, path + ".");
            if (left != null) return left;
            return getMorseCodeForChar(node.right, target, path + "-");
        }

        public int getHeight() {
            return getHeight(root);
        }

        private int getHeight(LinkedNode<Character> node) {
            if (node == null) return 0;
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }

        public void drawTree(Canvas canvas) {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(2);
            drawNode(gc, root, canvas.getWidth() / 2, 40, canvas.getWidth() / 4);
        }

        private void drawNode(GraphicsContext gc, LinkedNode<Character> node, double x, double y, double xOffset) {
            if (node == null) return;

            gc.strokeOval(x - 15, y - 15, 30, 30);
            gc.strokeText(String.valueOf(node.value), x - 5, y + 5);

            if (node.left != null) {
                double newX = x - xOffset;
                double newY = y + 80;
                gc.strokeLine(x, y + 15, newX, newY - 15);
                drawNode(gc, node.left, newX, newY, xOffset / 2);
            }

            if (node.right != null) {
                double newX = x + xOffset;
                double newY = y + 80;
                gc.strokeLine(x, y + 15, newX, newY - 15);
                drawNode(gc, node.right, newX, newY, xOffset / 2);
            }
        }
    }
}