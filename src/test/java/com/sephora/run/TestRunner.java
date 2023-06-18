package com.sephora.run;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"classpath:features"},
		glue = {"com.sephora.stepsDefinitions"},
		plugin = {"pretty", "html:target/cucumber.html"}
		)
public class TestRunner {


}
