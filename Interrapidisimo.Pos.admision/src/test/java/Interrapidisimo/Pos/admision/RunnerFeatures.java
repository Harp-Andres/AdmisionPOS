package Interrapidisimo.Pos.admision;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions; 
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class) 
@CucumberOptions (features = "./feature", 
				  glue = { "Interrapidisimo.Pos.admision.definition" }, 
				  plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
			      monochrome = true)

public class RunnerFeatures {
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("Config/report.xml"));
    }
	
}

