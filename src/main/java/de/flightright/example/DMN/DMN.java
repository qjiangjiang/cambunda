//package de.flightright.example.DMN;
//
//import org.camunda.bpm.application.PostDeploy;
//import org.camunda.bpm.application.ProcessApplication;
//import org.camunda.bpm.application.impl.ServletProcessApplication;
//import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
//import org.camunda.bpm.engine.DecisionService;
//import org.camunda.bpm.engine.ProcessEngine;
//import org.camunda.bpm.engine.delegate.DelegateExecution;
//import org.camunda.bpm.engine.variable.VariableMap;
//import org.camunda.bpm.engine.variable.Variables;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//@ProcessApplication("DMN")
//public class DMN extends ServletProcessApplication {
//    private static final Logger LOGGER = LoggerFactory.getLogger(DMN.class);
//    @PostDeploy
//    public void evaluateDecisionTable(ProcessEngine processEngine) {
//
//        DecisionService decisionService = processEngine.getDecisionService();
//
//        VariableMap variables = Variables.createVariables()
//                .putValue("airline", "")
//                .putValue("poj", "");
//        DmnDecisionTableResult dishDecisionResult = decisionService.evaluateDecisionTableByKey("result_decision", variables);
//        String result = dishDecisionResult.getSingleEntry();
//
//        LOGGER.warn("{} result===",result);
//    }
//}
