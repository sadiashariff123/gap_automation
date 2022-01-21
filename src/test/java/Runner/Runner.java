package Runner;



import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="FeaturesFolder",glue = {"Project1.Gap"}, plugin= {"pretty","html:target/GapReport.html"})
public class Runner extends AbstractTestNGCucumberTests{
	@Test
	public void t() {
		
	}
	
}
