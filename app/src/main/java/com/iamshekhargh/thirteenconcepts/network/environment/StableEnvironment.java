package com.iamshekhargh.thirteenconcepts.network.environment;

/**
 * Created by <<-- iamShekharGH -->>
 * on 28 March 2021
 * at 2:28 AM.
 */
class StableEnvironment implements EnvironmentInterface {
    final String url = "https://jsonplaceholder.typicode.com/";

    @Override
    public String getUrl() {
        return url;
    }
}
