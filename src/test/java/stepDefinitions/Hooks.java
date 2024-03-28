package stepDefinitions;

import io.cucumber.java.*;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.Duration;

public class Hooks {


    @Before ()
    public void setupScenario(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();
    }

    //Tagged Hook example
//    @Before ("@flaky or @failing")
//    public void setupScenario2(){
//        System.out.println("Hook for Flaky");
//        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        Driver.getDriver().manage().window().maximize();
//        Driver.getDriver().manage().deleteAllCookies();
//    }

    @After
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