package org.beehyv.service;


import org.beehyv.models.HelloWorld;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Prasannajeet Meshram
 */
@Service
public class DroolTestService {

    @Autowired
    KieContainer kieContainer;

    public HelloWorld printMessage(HelloWorld helloWorld) {
        KieSession session = kieContainer.newKieSession();
        session.insert(helloWorld);
        session.fireAllRules();
        session.dispose();
        return helloWorld;
    }
}
