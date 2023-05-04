package de.flightright.example.delegate;

import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named("Example")
@Component("Example")
public class Example implements JavaDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(Example.class);
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // TODO logic: call rest api to get boolean value back.
        Boolean result = true;
        execution.setVariable("payment_received", result);
        LOGGER.warn("payment received {}",result);
        // TODO: call rest api/db to get poj string
        execution.setVariable("poj", "DE");
        LOGGER.warn("poj {}","DE");
        //TODO: call airline api to get airline info
        //try-catch error handling
        execution.setVariable("airline", "Ryanair");
        LOGGER.warn("airline {}","Ryanair");
    }
}
