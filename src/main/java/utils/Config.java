package utils;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class Config {
    private static final Properties props = new Properties();

    static {
        try (InputStream in = Config.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (in != null) {
                props.load(in);
            }
        } catch (IOException ignored) { }
    }

    public static String baseUrl() {
        return props.getProperty("baseUrl", "https://the-internet.herokuapp.com");
    }

    public static String browser() {
        return props.getProperty("browser", "chrome");
    }

    public static boolean headless() {
        return Boolean.parseBoolean(props.getProperty("headless", "true"));
    }

    public static Duration explicitWait() {
        return Duration.ofSeconds(Long.parseLong(props.getProperty("explicitWaitSec", "10")));
    }

    public static Duration implicitWait() {
        return Duration.ofSeconds(Long.parseLong(props.getProperty("implicitWaitSec", "0")));
    }
}
