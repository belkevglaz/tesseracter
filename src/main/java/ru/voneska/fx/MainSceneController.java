package ru.voneska.fx;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import ru.voneska.Runner;
import ru.voneska.service.TesseractRecognizer;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * // TODO : describe javaDocs.
 *
 * @author Aksenov Ivan
 * @since 0.0.1
 */
public class MainSceneController {


	@FXML
	Pane pane;
	@FXML
	Button startButton;

	@FXML
	BorderPane borderPane;

	@FXML
	ImageView imageView;

	@FXML
	MenuItem mainMenuOpenBtn;

	/**
	 *  Selected image file
	 */
	private File selectedFile;


	@FXML
	public void initialize() throws IOException {

//		Image image1 = new Image(Runner.class.getResourceAsStream());
		BufferedImage bufferedImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("image.png")));


		imageView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));

		imageView.setPreserveRatio(true);
		imageView.fitHeightProperty().bind(pane.heightProperty());
		imageView.fitWidthProperty().bind(pane.widthProperty());

		mainMenuOpenBtn.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open image File");
			selectedFile = fileChooser.showOpenDialog(borderPane.getScene().getWindow());
			try (FileInputStream input = new FileInputStream(selectedFile.getAbsolutePath())) {
				imageView.setImage(new Image(input));
			} catch (IOException fileNotFoundException) {
				fileNotFoundException.printStackTrace();
			}
		});

		startButton.setOnAction(event -> {
			TesseractRecognizer recognizer = new TesseractRecognizer();
			List<Rectangle> words = recognizer.getWords(bufferedImage);
		});

	}


}
