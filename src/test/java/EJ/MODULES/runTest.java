package EJ.MODULES;

import org.junit.runner.RunWith; 

import cucumber.api.CucumberOptions;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "junit:target/cucumber1"},  //to generate different reports - html/json, xml
features = {"src/test/resources/Features/Login.feature"},
strict = true, //it will fail the execution if there are any pending/undefined steps
tags={"@SmokeTest"},
glue = {""},//path of the definition/methods file/class stepDefinitions
monochrome= true, //display the output on console in readable format
dryRun = false //to check mapping of step definition file and feature file is correct or not, when set to true it does dry run
)
public class runTest {
}
/*
@RunWith(Cucumber.class) 
@CucumberOptions.Options(format = {"pretty", "html:target/html"},
features = {"FeatureCollections"},
tags={"@SmokeTest"}
	) 
public class runTest {

}
*/