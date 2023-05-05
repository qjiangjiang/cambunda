package de.flightright.example.delegate;

import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named("Airline")
@Component("Airline")
public class Airline implements JavaDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(Airline.class);
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        VariableMap variables = Variables.createVariables()
                .putValue("airline", "Easyjet");
        // TODO logic: call rest api to get boolean value back.
        execution.setVariable("airline","Easyjet");
        LOGGER.warn("===start airline class===");
        LOGGER.warn("aireline received {}",execution.getVariable("airline"));
        LOGGER.warn("poj received {}",execution.getVariable("poj"));
        LOGGER.warn("===end airline class===");
    }
}
