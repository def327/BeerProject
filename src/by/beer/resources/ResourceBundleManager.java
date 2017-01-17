package by.beer.resources;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class {@code ResourceBundleManager} provides methods to get an inizialized
 * {@code ResourceBundle} object and get the properties.
 * 
 * @author Dmitry Zyablov
 *
 */
public class ResourceBundleManager {

	/**
	 * A instanse of {@code ResourceBundleManager}.
	 */
	private static ResourceBundleManager resourceManager;

	static {
		resourceManager = new ResourceBundleManager();
	}

	/**
	 * This field is a {@code ResourceBundle} object to get the properties.
	 */
	private ResourceBundle resourceBundle;

	/**
	 * Return's a property, finding by a key from resources.
	 * 
	 * @param key
	 *            - a unique key to get property
	 * 
	 * @return a {@code String} object, which was found by a key.
	 */
	public static String getProperty(String key) {
		return resourceManager.resourceBundle.getString(key);
	}

	/**
	 * This static method initializes a resourceBundle field, using a path to a
	 * folder with properties , a standart {@code Locale} object with "en" and
	 * "US" parameters and the class loader.
	 * 
	 * @return a initialized {@code ResourceBundle} object.
	 */
	private static ResourceBundle getInitResourceBundle() {

		ResourceBundle initResBundle = null;
		try {

			File file = new File("resources");
			URL[] urls = new URL[] { file.toURI().toURL() };

			ClassLoader loader = new URLClassLoader(urls);
			initResBundle = ResourceBundle.getBundle("appMessagesText", new Locale("en", "US"), loader);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return initResBundle;
	}

	/**
	 * Constructs a default <code>ResourceBundleManager</code> using
	 * {@link ResourceBundleManager#getInitResourceBundle()
	 * getInitResourceBundle()} method to initialize field.
	 */
	private ResourceBundleManager() {
		this.resourceBundle = getInitResourceBundle();
	}

}
