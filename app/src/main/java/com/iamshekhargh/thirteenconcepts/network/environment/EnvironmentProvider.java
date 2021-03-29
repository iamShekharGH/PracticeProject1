package com.iamshekhargh.thirteenconcepts.network.environment;

/**
 * Created by <<-- iamShekharGH -->>
 * on 28 March 2021
 * at 2:28 AM.
 */
public class EnvironmentProvider {
    EnvironmentInterface environmentInterface;

    public String getEnvironment(EnvironmentEnum e) {
        if (e == EnvironmentEnum.STABLE) {
            environmentInterface = new StableEnvironment();
        } else {
            environmentInterface = new DevelopmentEnvironment();
        }
        return environmentInterface.getUrl();

    }
}
