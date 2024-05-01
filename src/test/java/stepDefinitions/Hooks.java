package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.DBUtils;
import utilities.Driver;

import java.time.Duration;

public class Hooks {



    @Before ("not @db_only and not @API")
    public void setupScenario(){

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();
    }

    @Before ("@API")
    public void setupAPI(){
        RestAssured.baseURI = ConfigReader.getProperty("api.base.uri");
    }



    @Before ("@db_only")
    public void db(){
        DBUtils.createConnection();
    }

    @After ("@db_only")
    public void db2(){
        DBUtils.close();
    }

    //Tagged Hook example
//    @Before ("@flaky or @failing")
//    public void setupScenario2(){
//        System.out.println("Hook for Flaky");
//        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        Driver.getDriver().manage().window().maximize();
//        Driver.getDriver().manage().deleteAllCookies();
//    }

    @After ("not @db_only and not @API")
    public void tearDownScenario(Scenario scenario){
        if(scenario.isFailed()){
            scenario.attach(((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES), "image/png", "failed");

        }

        Driver.quitDriver();

    }






//    @BeforeStep
//    public void setStep(){
//        System.out.println("Before Step");
//    }

//    @AfterStep ("@homepage") // tagged Hook
//    public void afterStep(){
//        System.out.println("After Step");
//    }


//    @BeforeAll
//    public static void setupAll(){
//        System.out.println("Before All Scenarios");
//    }
//
//    @AfterAll
//    public static void tearDownAll(){
//        System.out.println("After All Scenarios");
//
//    }


}
