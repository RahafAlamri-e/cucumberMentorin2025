package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Driver;

import java.time.Duration;
import java.time.LocalDateTime;

public class Hooks {
    LocalDateTime start;
    LocalDateTime finished;
    @Before
    public void setUp(Scenario scenario){
        start = LocalDateTime.now();
        System.out.println("Test has started at : "+ start);
        System.out.println("Scenario: " + scenario.getName());

    }
    @After
    public void tearDown(Scenario scenario){
        finished = LocalDateTime.now();
        Duration duration = Duration.between(start,finished);
        System.out.println("Test finished at :" + finished);
        System.out.println("Duration : " + duration.toSeconds() + " seconds");
        Driver.quitDriver();
    }
}