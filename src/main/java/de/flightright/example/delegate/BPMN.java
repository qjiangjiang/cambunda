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
public class BPMN implements JavaDelegate {
    @Autowired
    ProcessEngine processEngine;
    private static final Logger LOGGER = LoggerFactory.getLogger(BPMN.class);
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // TODO logic: call rest api to get boolean value back.
        execution.setVariable("poj","DE");
        execution.setVariable("airline","Easyjet");

        LOGGER.warn("aireline received {}",execution.getVariable("airline"));
        LOGGER.warn("poj received {}",execution.getVariable("poj"));

        VariableMap variables = Variables.createVariables()
                .putValue("airline", execution.getVariable("airline"))
                .putValue("poj", execution.getVariable("poj"));

        DecisionService decisionService = processEngine.getDecisionService();
        DmnDecisionTableResult dishDecisionResult = decisionService.evaluateDecisionTableByKey("result_decision", variables);
        Boolean result = dishDecisionResult.getSingleEntry();
        execution.setVariable("close_close",result);
        LOGGER.warn("====result is {}===",result);
    }
}
