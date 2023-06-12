package StepDefTests;

import java.io.IOException;

import org.testng.Assert;

import Utilities.EndPoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateIssueApi {
	public Shared sh;
	public UpdateIssueApi(Shared s) {
		this.sh=s;
	}
       
	// update the existing issue
    @Given("User calls the Update the existing issue")
    public void user_calls_the_update_the_existing_issue() throws IOException {
    	String upKey=sh.sheet.getLastValue();
    	sh.updateRes=EndPoints.updateIssueInExistingIssue(upKey);
    	sh.updateRes.then().log().body();
    }

    @When("the update api call got success with status code {int}")
    public void the_update_api_call_got_success_with_status_code(Integer int1) {
    	Assert.assertEquals(sh.updateRes.statusCode(),204);
 
    }
    @Then("status in response body is {string}")
    public void respondMethod(String st) {
    	Assert.assertEquals(sh.updateRes.statusLine(), st);
    }

    @And("Validate Content-Type is application\\/json")
    public void validate_content_type_is_application_json() {
    	Assert.assertEquals(sh.updateRes.contentType(),"application/json;charset=UTF-8");
    }
}
