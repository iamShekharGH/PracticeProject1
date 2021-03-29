package com.iamshekhargh.thirteenconcepts.network.environment;

/**
 * Created by <<-- iamShekharGH -->>
 * on 28 March 2021
 * at 2:29 AM.
 */
public class DevelopmentEnvironment implements EnvironmentInterface {

    final String url = "";

    @Override
    public String getUrl() {
        return url;
    }
}
