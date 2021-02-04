package ru.voneska.fx;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * // TODO : describe javaDocs.
 *
 * @author Aksenov Ivan
 * @since 0.0.1
 */
public class MainSceneController {

	HBox mainSceneHBox;

	@FXML
	BorderPane borderPane;

	@FXML
	ImageView imageView;

	@FXML
	MenuItem mainMenuOpenBtn;

	@FXML
	Label label;

	/**
	 *  Selected image file
	 */
	private File selectedFile;


	@FXML
	public void initialize() {
		System.out.println("MainSceneController.initialize");


//		Image image = new Image("file:///data/dev/everytag/ild-pack/protect-service/src/test/resources/sample.png");
////		Image image = new Image("/data/dev/everytag/ild-pack/protect-service/src/test/resources/sample.png");
//		imageView.setImage(image);

		label.setText(new Date().toString());

		mainMenuOpenBtn.setOnAction(e -> {
			System.out.println("mainMenuOpenBtn.setOnAction");
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			selectedFile = fileChooser.showOpenDialog(borderPane.getScene().getWindow());
			try (FileInputStream input = new FileInputStream(selectedFile.getAbsolutePath())) {
				imageView.setImage(new Image(input));
			} catch (IOException fileNotFoundException) {
				fileNotFoundException.printStackTrace();
			}
		});

	}


}
