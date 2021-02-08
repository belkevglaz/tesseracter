package ru.voneska.service;


import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

/**
 * // TODO : describe javaDocs.
 *
 * @author Aksenov Ivan
 * @since 0.0.1
 */
public interface CLibrary extends Library {
	CLibrary INSTANCE = Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"), CLibrary.class);

	int LC_CTYPE = 0;
	int LC_NUMERIC = 1;
	int LC_ALL = 6;

	String setlocale(int category, String locale);
}
