package cucumber;


import io.cucumber.java.AfterAll;
import utils.Driver;

public class Hooks {

    @AfterAll
    public static void teardown(){
        Driver.quitDriver();
    }

}
