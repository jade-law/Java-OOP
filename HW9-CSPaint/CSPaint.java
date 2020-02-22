//I worked on the homework assignment alone, using only course materials.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.image.Image;

/**
 * CSPaint application
 * @author Jade Law (jlaw39)
 * @version 1.0
 */
public class CSPaint extends Application {
    private int shapes = 0;
    private Text numShapes = new Text("Number of shapes: " + shapes);
    private Text coordinates = new Text();
    private Image shrek = new Image("shrek.png");
    private Image datboi = new Image("datboi.png");
    private Image unicorn = new Image("unicorn.png");
    private Image doge = new Image("doge.png");

    /**
     * start method
     * @param primaryStage is the stage
     * throws Illegal Argument Exception
     */
    @Override
    public void start(Stage primaryStage) throws IllegalArgumentException {
        //Setting up the pane and canvas
        Canvas canvas = new Canvas(650, 450);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        BorderPane pane = new BorderPane();
        canvas.setVisible(true);
        initialCanvas(gc, canvas);

        HBox textPane = new HBox(10);
        textPane.setStyle("-fx-background-color: LIGHTGREY; -fx-border-width: 2px;");

        canvas.setOnMouseMoved(e -> {
                double x = e.getX();
                double y = e.getY();
                String c = "(" + x + "," + y + ")";
                coordinates.setText(c);
            });


        //Toolkit on side of canvas
        VBox toolKit = new VBox(20);
        toolKit.setPadding(new Insets(5, 5, 5, 5));
        toolKit.setStyle("-fx-background-color: LIGHTGREY; -fx-border-width: 2px;");

        //Clear button
        Button clearBtn = new Button("Clear");
        clearBtn.setOnAction(e -> {
                clearCanvas(gc, canvas, clearBtn);
            });

        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Invalid Color");
        alert.setContentText("Invalid color entered!");

        //For getting the color of the brush
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        TextField tf = new TextField();

        tf.setOnAction(a -> {
                try {
                    gc.setStroke(Color.valueOf(tf.getText()));
                    gc.setFill(Color.valueOf(tf.getText()));
                } catch (IllegalArgumentException iae) {
                    alert.showAndWait();
                }
            });

        //Radio button set up
        RadioButton drawRBtn = new RadioButton("Draw");
        drawRBtn.setSelected(true);
        drawErase(gc, canvas, drawRBtn);
        RadioButton eraseRBtn = new RadioButton("Erase");
        RadioButton circleRBtn = new RadioButton("Circle");
        RadioButton shrekRBtn = new RadioButton("Cute Man");
        RadioButton dabRBtn = new RadioButton("Dab");
        RadioButton dogeRBtn = new RadioButton("Handsome Boy");
        RadioButton datboiRBtn = new RadioButton("Here he comes");

        drawRBtn.setOnAction(e -> {
                drawErase(gc, canvas, drawRBtn);
            });
        eraseRBtn.setOnAction(e -> {
                gc.setStroke(Color.WHITE);
                drawErase(gc, canvas, eraseRBtn);
            });
        circleRBtn.setOnAction(e -> {
                drawCircle(gc, canvas, circleRBtn);
            });
        shrekRBtn.setOnAction(e -> {
                drawShrek(gc, canvas, shrekRBtn);
            });
        dabRBtn.setOnAction(e -> {
                drawDab(gc, canvas, dabRBtn);
            });
        dogeRBtn.setOnAction(e -> {
                drawDoge(gc, canvas, dogeRBtn);
            });
        datboiRBtn.setOnAction(e -> {
                drawDatBoi(gc, canvas, datboiRBtn);
            });

        //grouping of the radio buttons
        ToggleGroup group = new ToggleGroup();
        drawRBtn.setToggleGroup(group);
        eraseRBtn.setToggleGroup(group);
        circleRBtn.setToggleGroup(group);
        shrekRBtn.setToggleGroup(group);
        dabRBtn.setToggleGroup(group);
        dogeRBtn.setToggleGroup(group);
        datboiRBtn.setToggleGroup(group);

        //adding everything above to the pane
        toolKit.getChildren().addAll(drawRBtn, eraseRBtn, circleRBtn, shrekRBtn, dabRBtn,
            dogeRBtn, datboiRBtn, tf, clearBtn);
        textPane.getChildren().addAll(coordinates, numShapes);
        pane.setLeft(toolKit);
        pane.setCenter(canvas);
        pane.setBottom(textPane);


        //rest of setting up the app
        Scene scene = new Scene(pane);

        primaryStage.setTitle("CSPaint");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * method for draw and erase buttons
     * @param gc the Graphic Context
     * @param canvas the canvas
     * @param btn the given radio button that is selected
     */
    public void drawErase(GraphicsContext gc, Canvas canvas, RadioButton btn) {
        if (btn.isSelected()) {
            gc.setLineCap(StrokeLineCap.ROUND);
            gc.setLineWidth(4);
            canvas.requestFocus();
            canvas.setOnMousePressed(e -> {
                    gc.beginPath();
                    gc.moveTo(e.getX(), e.getY());
                    gc.stroke();
                });
            canvas.setOnMouseDragged(e -> {
                    gc.lineTo(e.getX(), e.getY());
                    gc.stroke();
                    String c = "(" + e.getX() + "," + e.getY() + ")";
                    coordinates.setText(c);
                });
            canvas.setOnMouseReleased(e -> {
                    gc.lineTo(e.getX(), e.getY());
                    gc.closePath();
                });
            canvas.setOnMouseClicked(e -> {
                    gc.closePath();
                });
        }
    }

    /**
     * method for the drawing circles button
     * @param gc the Graphic Context
     * @param canvas the canvas
     * @param btn the given radio button that is selected
     */
    public void drawCircle(GraphicsContext gc, Canvas canvas, RadioButton btn) {
        if (btn.isSelected()) {
            canvas.setOnMouseClicked(e -> {
                    gc.fillOval(e.getX(), e.getY(), 30, 30);
                    shapes++;
                    numShapes.setText("Number of shapes: " + shapes);
                });
            canvas.setOnMousePressed(e -> {
                    gc.closePath();
                });
            canvas.setOnMouseDragged(e -> {
                    gc.closePath();
                });
            canvas.setOnMouseReleased(e -> {
                    gc.closePath();
                });
        }
    }

    /**
     * method for the drawing Shrek button
     * @param gc the Graphic Context
     * @param canvas the canvas
     * @param btn the given radio button that is selected
     */
    public void drawShrek(GraphicsContext gc, Canvas canvas, RadioButton btn) {
        if (btn.isSelected()) {
            canvas.setOnMouseClicked(e -> {
                    gc.drawImage(shrek, e.getX(), e.getY());
                    shapes++;
                    numShapes.setText("Number of shapes: " + shapes);
                });
            canvas.setOnMousePressed(e -> {
                    gc.closePath();
                });
            canvas.setOnMouseDragged(e -> {
                    gc.closePath();
                });
            canvas.setOnMouseReleased(e -> {
                    gc.closePath();
                });
        }
    }

    /**
     * method for the drawing unicorn dab button
     * @param gc the Graphic Context
     * @param canvas the canvas
     * @param btn the given radio button that is selected
     */
    public void drawDab(GraphicsContext gc, Canvas canvas, RadioButton btn) {
        if (btn.isSelected()) {
            canvas.setOnMouseClicked(e -> {
                    gc.drawImage(unicorn, e.getX(), e.getY());
                    shapes++;
                    numShapes.setText("Number of shapes: " + shapes);
                });
            canvas.setOnMousePressed(e -> {
                    gc.closePath();
                });
            canvas.setOnMouseDragged(e -> {
                    gc.closePath();
                });
            canvas.setOnMouseReleased(e -> {
                    gc.closePath();
                });
        }
    }

    /**
     * method for the drawing doge button
     * @param gc the Graphic Context
     * @param canvas the canvas
     * @param btn the given radio button that is selected
     */
    public void drawDoge(GraphicsContext gc, Canvas canvas, RadioButton btn) {
        if (btn.isSelected()) {
            canvas.setOnMouseClicked(e -> {
                    gc.drawImage(doge, e.getX(), e.getY());
                    shapes++;
                    numShapes.setText("Number of shapes: " + shapes);
                });
            canvas.setOnMousePressed(e -> {
                    gc.closePath();
                });
            canvas.setOnMouseDragged(e -> {
                    gc.closePath();
                });
            canvas.setOnMouseReleased(e -> {
                    gc.closePath();
                });
        }
    }

    /**
     * method for the drawing dat boi button
     * @param gc the Graphic Context
     * @param canvas the canvas
     * @param btn the given radio button that is selected
     */
    public void drawDatBoi(GraphicsContext gc, Canvas canvas, RadioButton btn) {
        if (btn.isSelected()) {
            canvas.setOnMouseClicked(e -> {
                    gc.drawImage(datboi, e.getX(), e.getY());
                    shapes++;
                    numShapes.setText("Number of shapes: " + shapes);
                });
            canvas.setOnMousePressed(e -> {
                    gc.closePath();
                });
            canvas.setOnMouseDragged(e -> {
                    gc.closePath();
                });
            canvas.setOnMouseReleased(e -> {
                    gc.closePath();
                });
        }
    }

    /**
     * method for clearing the canvas
     * @param gc the Graphic Context
     * @param canvas the canvas
     * @param btn the given radio button that is selected
     */
    public void clearCanvas(GraphicsContext gc, Canvas canvas, Button btn) {
        initialCanvas(gc, canvas);
    }

    /**
     * method for what the initial canvas will look like
     * @param gc the Graphic Context
     * @param canvas the canvas
     */
    public void initialCanvas(GraphicsContext gc, Canvas canvas) {
        double width = gc.getCanvas().getWidth();
        double height = gc.getCanvas().getHeight();

        gc.setFill(Color.WHITE);
        gc.fill();
        gc.fillRect(0, 0, width, height);
        shapes = 0;
        numShapes.setText("Number of shapes: " + shapes);
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);
    }

    /**
     * main method for just in case using IDE
     * @param args is for opening the app
     */
    public static void main(String[] args) {
        launch(args);
    }
}