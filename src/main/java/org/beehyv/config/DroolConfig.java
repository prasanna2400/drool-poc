package org.beehyv.config;


import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for drool
 * @author Prasannajeet Meshram
 */
@Configuration
public class DroolConfig {

    public static final String DRL_URL="rules/helloworld.drl";

    @Bean
    KieContainer kieContainer(){
        final KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem= kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(DRL_URL));
        KieBuilder kieBuilder=kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule=kieBuilder.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }
}
