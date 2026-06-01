package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingPane;

    @FXML
    private RadioButton radioBtnPen;

    @FXML
    private RadioButton radioBtnEraser;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        if (radioBtnEraser != null && radioBtnEraser.isSelected()) {
            // Eraser: draw with white color
            Circle eraser = new Circle(x, y, 8, Color.WHITE);
            drawingPane.getChildren().add(eraser);
        } else {
            // Pen: draw with black color
            Circle newCircle = new Circle(x, y, 4, Color.BLACK);
            drawingPane.getChildren().add(newCircle);
        }
    }
}
