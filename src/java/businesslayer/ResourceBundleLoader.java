package businesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

/**
 *
 * @author liyingguo
 */
public class ResourceBundleLoader {
    private static ResourceBundleLoader instance;
    private Properties messages;

    private ResourceBundleLoader() {
        // Private constructor to prevent instantiation from outside
        messages = new Properties();
    }

    public static ResourceBundleLoader getInstance() {
        if (instance == null) {
            synchronized (ResourceBundleLoader.class) {
                if (instance == null) {
                    instance = new ResourceBundleLoader();
                }
            }
        }
        return instance;
    }

    public void loadResourceBundle(Locale locale) {
        try {
            String resourceName = "/messages_" + locale + ".properties";
            try (InputStream inputStream = getClass().getResourceAsStream(resourceName)) {
                messages.load(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as needed
        }
    }

    public String getMessage(String key) {
        return messages.getProperty(key);
    }
}
