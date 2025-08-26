package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties props = new Properties();

    static {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (in != null) props.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String baseUrl() {
        return props.getProperty("baseUrl", "https://www.saucedemo.com/");
    }

    public static String username() {
        return props.getProperty("username", "standard_user");
    }

    public static String password() {
        return props.getProperty("password", "secret_sauce");
    }

    public static String browser() {
        return props.getProperty("browser", "chrome");
    }

    public static boolean headless() {
        return Boolean.parseBoolean(props.getProperty("headless", "false"));
    }
}