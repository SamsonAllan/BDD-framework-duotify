package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExampleStepdefs {


    @Given("I have {int} cucumbers in my belly")
    public void iHaveCucumbersInMyBelly(Integer noOfCukes) {
        System.out.println("I ate " + noOfCukes + " cucumbers");
    }

    @Given("I also have {long} tomatoes")
    public void i_also_have_tomatoes(Long int1) {
        System.out.println(int1);
    }
    @Given("I have a cucumber of type {string}")
    public void i_have_a_cucumber_of_type(String string) {
        System.out.println(string);
    }
    @When("I add {double} more")
    public void i_add_more(Double double1) {
        System.out.println(double1);
    }
    @Then("I should have {double} cucumbers")
    public void i_should_have_cucumbers(Double double1) {
        System.out.println(double1);
    }
    @Then("I should have also have some {word}")
    public void i_should_have_also_have_some_squashes(String word) {
        System.out.println(word);
    }

    @Then("I ate some/no banana(s)")
    public void i_ate_some_bananas() {

    }



}
