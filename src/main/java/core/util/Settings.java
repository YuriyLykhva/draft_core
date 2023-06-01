package core.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {
    public static final Properties PROPERTIES = new Properties();

    static {
        try {
            FileInputStream file =
                    new FileInputStream("C:/1/ReportPortalTAF/core/src/main/resources/app.properties");
            PROPERTIES.load(file);
            file.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
