package test.java;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
//@Cucumber.Options(features={"features"})
@CucumberOptions(
	      plugin = {"pretty", "html:target/cucumber-htmlreport","json:target/cucumber-report.json"},
	      features={"features"},
	      glue={"stepDefinition"}
	)
public class TestRunner{

}
