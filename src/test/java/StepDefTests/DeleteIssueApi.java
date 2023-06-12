package StepDefTests;

import java.io.IOException;

import org.testng.Assert;

import Utilities.EndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DeleteIssueApi {
       public Shared sh;
       public DeleteIssueApi(Shared s) {
    	   this.sh=s;
       }
	// delete issue
    @Given("User calls delete api request")
    public void user_calls_delete_api_request() throws IOException {
    	String delKey=sh.sheet.getLastValue();
    	sh.deleteRes=EndPoints.deleteIssue(delKey);
    	sh.deleteRes.then().log().body();
    }

    @When("the the api call got success with delete Issue status code {int}")
    public void the_the_api_call_got_success_with_delete_issue_status_code(Integer int1) {
    	Assert.assertEquals(sh.deleteRes.statusCode(),204);
    }
}
