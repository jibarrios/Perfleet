package com.perfleet.library.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/feature",
            glue = "com/perfleet/library/step_definitions",
            dryRun = false,
            tags = "@LoginFunc" //@Regression,@Smoke,@AC454,@BA86

    )
    public class CukeRunner {}


