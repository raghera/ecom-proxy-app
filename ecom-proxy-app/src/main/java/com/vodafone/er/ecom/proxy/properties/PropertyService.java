package com.vodafone.er.ecom.proxy.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import static com.vodafone.er.ecom.proxy.constants.PropertiesConstantsEnum.PROPERTIES_FILE_NAME;

/**
 * Created by Ravi Aghera
 *
 * Loads all system properties and returns them upon request
 *
 */
public class PropertyService {

    private static final Logger log = LoggerFactory.getLogger(PropertyService.class);

    private static Properties properties = new Properties();
    private static String propertyFileName = PROPERTIES_FILE_NAME.value();

    static {
        try {
            final InputStream in = PropertyService.class.getClassLoader().getResourceAsStream("env.properties");
            properties.load(in);
        } catch (IOException ioEx) {
            log.warn("Unable to load properties from file system - could not find propertyFileName: " + propertyFileName
                    + " Will use system defaults."
            );
        }
    }

    public static Optional<String> getProperty(String key, String defaultValue) {
        final String property = properties.getProperty(key, defaultValue);
        if(property != null) {
            return Optional.of(property);
        }
        log.info("Retrieved property using key={} value={}", key, property );
        return Optional.empty();
    }

    public static Optional<Boolean> getPropertyAsBoolean(String key, boolean defaultValue) {
        final String value = properties.getProperty(key, String.valueOf(defaultValue));

        if(value == null) {
            return Optional.empty();
        }
        final Boolean boolValue = Boolean.parseBoolean(value);

        log.info("Retrieved property using key={} value={}", key, boolValue);
        return Optional.of(boolValue);
    }


}
