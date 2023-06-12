package StepDefTests;

import org.testng.Assert;

import Utilities.EndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class GetIssueScemaValidation {
   public Shared sh;
   public  Response response;
      public GetIssueScemaValidation(Shared s) {
    	  this.sh=s;
      }
      
   @Given("User calls get schema validation api call")
   public void givenMethod() {
	   String value=sh.sheet.getLastValue();
	   System.out.println("schema value: "+value);
	    response =EndPoints.getSchemaValidation(value);
   }
   @When("User check the status code of this api call")
   public void whenMethod() {
	 Assert.assertEquals(response.statusCode(),200);
	  
   }
}
