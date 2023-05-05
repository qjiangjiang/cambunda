package de.flightright.example.delegate;

import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.engine.DecisionService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named("Poj")
@Component("Poj")
public class Poj implements JavaDelegate {
    @Autowired
    ProcessEngine processEngine;
    private static final Logger LOGGER = LoggerFactory.getLogger(Poj.class);
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // TODO logic: call rest api to get boolean value back.
        execution.setVariable("poj","DE");
        execution.setVariable("airline","Easyjet");
        LOGGER.warn("===start poj class===");
        LOGGER.warn("aireline received {}",execution.getVariable("airline"));
        LOGGER.warn("poj received {}",execution.getVariable("poj"));
        LOGGER.warn("===end in poj class===");

        VariableMap variables = Variables.createVariables()
                .putValue("airline", "Easyjet")
                .putValue("poj", "DE");

        DecisionService decisionService = processEngine.getDecisionService();
        DmnDecisionTableResult dishDecisionResult = decisionService.evaluateDecisionTableByKey("result_decision", variables);
        Boolean result = dishDecisionResult.getSingleEntry();

        LOGGER.warn("{} result===",result);
    }
}
