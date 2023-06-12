package Utilities;

import java.io.File;
import java.util.ResourceBundle;
import static io.restassured.RestAssured.given;
import Payloads.ApiIssuesPayloads;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class EndPoints {
	static ResourceBundle getUrl()
	{
		ResourceBundle routes =ResourceBundle.getBundle("Property"); // load properties file
		return routes;
	}
	public static Response createIssue() {
		
		String post_url =getUrl().getString("issuecreate_url");
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(ApiIssuesPayloads.createPayload().toString());

		Response response = request.post(post_url);
		         response.then().extract().response().asString();
		return response;
	}
	public static Response getIssueDeatails(String issueKey) {
		String get_url =getUrl().getString("getIssue_url");
		     Response response=given().header("Accept", "application/json").pathParam("issueKey", issueKey).when().get(get_url);
			return response;
		
	}
	public static Response updateIssueInExistingIssue(String key) {
		String put_url =getUrl().getString("updateIssue_url");
		Response response= given().contentType(ContentType.JSON).pathParam("issueKey",key) 
		.body(ApiIssuesPayloads.updateIssue().toString())
        .when().put(put_url);
		return response;
	}
	public static Response  deleteIssue(String issueKey) {
		String delete_url =getUrl().getString("delete_url");
	     Response response=given().pathParam("issueKey", issueKey).when().delete(delete_url);
		return response;
	}
	public static Response createSchemaValidation() {
		String schemaVal_url =getUrl().getString("createIssueScheme_url");
		File payload=new File("C:\\Users\\HP\\eclipse-workspace\\Org.JiraApiProject_com\\src\\test\\resources\\TestData\\schemaPayload.json");
		Response response =(Response) given()
         .contentType(ContentType.JSON)
         .body(payload)
         .post(schemaVal_url)
         .then()
         .assertThat()
         .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("src/test/resources/TestData/schema.json"));
		return response;

	}
	public static Response getSchemaValidation(String issueKey) {
		
		String get_url =getUrl().getString("getIssueScema_url");
	    Response response= (Response) given().header("Accept", "application/json").pathParam("issueKey", issueKey).when().get(get_url)
	    		 .then()
	             .assertThat()
	             .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("C:\\Users\\HP\\eclipse-workspace\\Org.JiraApiProject_com\\src\\test\\resources\\TestData\\GetIssueSchema.json"));
	    		return response;
		
	}
	public static void main(String[] args) {
		Response res=EndPoints.createSchemaValidation();
		res.then().log().body();
	}
}
