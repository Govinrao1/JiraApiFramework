package StepDefTests;

import java.util.ResourceBundle;

import Utilities.ExcelSheet;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Shared {
	public ExcelSheet sheet;
	public  Response getResponse;
	public Response updateRes;
	public Response deleteRes;
	static ResourceBundle getUrl()
	{
		ResourceBundle routes =ResourceBundle.getBundle("Property"); // load properties file
		return routes;
	}

    @Before
    public void beforeHook() {
    	String base_url =getUrl().getString("base_url");
    	RestAssured.baseURI = base_url;
    	RestAssured.authentication = RestAssured.preemptive().basic("testerbatch262@gmail.com", "ATATT3xFfGF0ArZ_of1o84Lk8-VlJ7_4iyGrV9gLcWd2t_YsPx2bdxw66TKEWkxj8sheEV57UvanW0cyA0vG-efmDlvnvyJOyhs_1aNvGj11Svp7i_egaGvumNc0kF7oLQr1VWKyailejnAESBSkkWbftqMkWVMS3U5TzPMMpzQj_MMyzXbPviI=2C00DEDE");
    	sheet=new ExcelSheet();
    }
}
