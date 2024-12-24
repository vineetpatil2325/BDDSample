package runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src//test//resources//taggedFeatures//",
		glue = {"stepDefs"},
		monochrome=true,
		dryRun=false,
		
		tags="@PhaseOne and not @SmokeTest"
		)

public class TaggedRunner extends AbstractTestNGCucumberTests {
  @Test
  public void f() {
  }
}
