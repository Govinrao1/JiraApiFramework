package StepDefTests;

import java.io.IOException;

import org.testng.Assert;

import Utilities.EndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class GetIssueApi {
      public Shared sh;
      public String prKey;
      
      public GetIssueApi(Shared s) {
    	  this.sh=s;
      }
	// get the  exsting issue details
		@Given("User calls the Get api request")
	    public void user_calls_the_get_api_request() throws IOException {
			 prKey=sh.sheet.getLastValue();
			 sh.getResponse=EndPoints.getIssueDeatails(prKey);
			 sh.getResponse.then().log().body();
	    }

		@When("the api call got success with get Issue status code {int}")
		public void the_api_call_got_success_with_get_issue_status_code(Integer int1) {
	    	Assert.assertEquals(sh.getResponse.statusCode(),200);
	    }

	    @Then("Validate the content type is application\\/json")
	    public void validate_the_content_type_is_application_json() {
	    	Assert.assertEquals(sh.getResponse.contentType(), "application/json;charset=UTF-8");
	    }
}
