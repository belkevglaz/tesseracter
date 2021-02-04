package ru.voneska;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ru.voneska.utils.FXUtils;

import java.util.Objects;

/**
 * // TODO : describe javaDocs.
 *
 * @author <a href="mailto:belkevglaz@gmail.com">Aksenov Ivan</a>
 * @since 0.0.1
 * @see <a href="https://fxdocs.github.io/docs/html5/#_introduction">JavaFX Documentation Project</a>
 * @see <a href="http://tutorials.jenkov.com/javafx/overview.html">JavaFX Overview</a>
 */
public class Runner extends Application {

	@FXML
	Pane mainPane;


	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(Objects.requireNonNull(FXUtils.getResourceAsURI("main.fxml")));

		primaryStage.setTitle("Hello World");
		primaryStage.setScene(new Scene(root, 300, 275));
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
