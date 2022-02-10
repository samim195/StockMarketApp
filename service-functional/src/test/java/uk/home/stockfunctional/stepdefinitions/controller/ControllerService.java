package uk.home.stockfunctional.stepdefinitions.controller;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uk.home.stockfunctional.utils.SpringIntegrationTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ControllerService {

    @When("^the client calls /stocks$")
    public void the_client_issues_GET_version() throws Throwable{
        SpringIntegrationTest.executeGet("http://localhost:8080/stocks");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        int currentStatusCode = SpringIntegrationTest.httpResponse.statusCode();
        assertThat("status code is incorrect : "+
                SpringIntegrationTest.httpResponse.toString(), currentStatusCode, is(statusCode));
    }

//    @And("^the client receives server version (.+)$")
//    public void the_client_receives_server_version_body(String version) throws Throwable {
//        assertThat(latestResponse.getBody(), is(version));
//    }
}
