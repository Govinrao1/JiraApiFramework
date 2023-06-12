package StepDefTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;

import Utilities.EndPoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class CreateIssueApi {
	public Shared sh;
	Response res;
	String key;
	public CreateIssueApi(Shared s) {
		this.sh=s;
	}

	@Given("User calls Issue api with POST request")
	public void user_calls_issue_api_with_post_request() throws IOException {
		res=EndPoints.createIssue();
	    key=res.body().jsonPath().getString("key");
	    Reporter.log("latest Key: "+key);
    	sh.sheet.setValue(key, "Pro-Key");
    	res.then().log().body();
	}

	@When("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer num) {
	    Assert.assertEquals(res.statusCode(),201);
	}

	@Then("status in create response body is {string}")
	public void in_create_response_body_is(String string) {
	    Assert.assertEquals(res.statusLine(), string);
	}

	@And("Validate Content-Type is application\\/json and time consume")
	public void validate_content_type_is_application_json_and_time_consume() {
		Assert.assertEquals(res.contentType(), "application/json;charset=UTF-8");

	}

}
