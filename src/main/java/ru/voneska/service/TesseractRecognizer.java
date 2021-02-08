package ru.voneska.service;


import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.Word;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * // TODO : describe javaDocs.
 *
 * @author Aksenov Ivan
 * @since 0.0.1
 */
public class TesseractRecognizer {

	ITesseract engine = new Tesseract1();

	public TesseractRecognizer() {
		Locale defaultLocale = Locale.getDefault();
		CLibrary.INSTANCE.setlocale(CLibrary.LC_ALL, "C");
		CLibrary.INSTANCE.setlocale(CLibrary.LC_NUMERIC, "C");
		CLibrary.INSTANCE.setlocale(CLibrary.LC_CTYPE, "C");
		assert defaultLocale == Locale.getDefault();
	}

	public List<Rectangle> getLines(BufferedImage image) {
		return null;
	}


	/**
	 * todo :
	 * @param image
	 * @return
	 */
	public List<Rectangle> getWords(BufferedImage image) {
		List<Word> words = engine.getWords(image, ITessAPI.TessPageIteratorLevel.RIL_WORD);
		return words.stream().map(Word::getBoundingBox).collect(Collectors.toList());
	}

	public List<Rectangle> getSymbols(BufferedImage image) {
		return null;
	}


}
