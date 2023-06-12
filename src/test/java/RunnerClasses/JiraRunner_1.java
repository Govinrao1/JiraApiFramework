package RunnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features={"C:\\Users\\HP\\eclipse-workspace\\Org.JiraApiProject_com\\src\\test\\resources\\Features\\File.feature"},
		glue={"StepDefTests"},
		//tags="@smoketest",
		monochrome=true,
		plugin={"pretty","html:target/passedtests",
				               "rerun:target/failedtestscenarios.txt"}
		)
public class JiraRunner_1 extends AbstractTestNGCucumberTests{

}
