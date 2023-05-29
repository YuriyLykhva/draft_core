package core.util;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "credentials")
    public Object[][] credentials() {
        return new String[][]{
                {"default", "1q2w3e"},
                {"superadmin", "erebus"}
        };
    }
}
