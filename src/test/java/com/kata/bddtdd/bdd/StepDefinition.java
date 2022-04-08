package com.kata.bddtdd.bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinition {

    String namePrefix = null;
    RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity response;

    @Given("Student enters name prefix {string}")
    public void student_enters_the_roll_number(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    @When("The student makes a call to {string} get the details")
    public void the_student_makes_a_call_to_get_the_details(String url) {
        response = restTemplate.getForEntity(url + this.namePrefix, List.class);
    }

    @Then("The API should return the student details and response code {int}")
    public void the_api_should_return_the_student_details_and_name_as(int statusCode) {
        assertEquals(statusCode, response.getStatusCodeValue());
    }
}
