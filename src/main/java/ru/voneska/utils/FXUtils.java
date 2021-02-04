package ru.voneska.utils;

import java.net.URL;

/**
 * // TODO : describe javaDocs.
 *
 * @author Aksenov Ivan
 * @since 0.0.1
 */
public final class FXUtils {


	/**
	 * Gets resource as {@link URL}
	 *
	 * @param resourceName resource name
	 * @return {@link URL} of given resource
	 */
	public static URL getResourceAsURI(String resourceName) {
		return Thread.currentThread().getContextClassLoader().getResource(resourceName);
	}

}
