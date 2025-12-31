package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverFactory;

public class Hooks {

    @Before
    public void setUp() throws Exception {
    	System.out.println("Hooks executed");
        DriverFactory.initDriver();
    }

    @After
    public void tearDown() {
    	
        DriverFactory.quitDriver();
    }
}
