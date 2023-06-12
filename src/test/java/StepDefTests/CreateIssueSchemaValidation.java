package StepDefTests;

import org.testng.Assert;

import Utilities.EndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class CreateIssueSchemaValidation {
	public Shared sh;
	public Response schemaresponse;
	public CreateIssueSchemaValidation(Shared s) {
		this.sh=s;
	}
	
	@Given("User calls the create user scheme validation")
	public void givenMethod() {
	    schemaresponse=EndPoints.createSchemaValidation();
	    schemaresponse.then().log().body();
	}
	
    @When("Validate the status code is 201")
    public void statusValidation() {
    	int code=schemaresponse.statusCode();
    	if(code==201) {
    		Assert.assertTrue(true);
    	}else {
    		Assert.assertTrue(false);
    	}
    	
    }
    
    @Then("Validate the content-Type is application\\/json")
    public void validate_the_content_type_is_application_json() {
    	String type=schemaresponse.contentType();
        if(type.equalsIgnoreCase("application/json;charset=UTF-8")) {
            Assert.assertTrue(true);
        } else {
        	Assert.assertTrue(false);
        }
    }
}
