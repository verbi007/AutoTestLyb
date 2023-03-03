package coreApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.io.IOException;

public class Configuration {

    public void  initRestAssured(String fileProperties, String baseUrl) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream(fileProperties));
//        RestAssured.authentication = RestAssured.basic(System.getProperty("username"), System.getProperty("password")) ;
        RestAssured.baseURI = System.getProperty(baseUrl);
    }

    public void authorizationBasic(String login, String password) {
        RestAssured.authentication = RestAssured.preemptive().basic(System.getProperty(login), System.getProperty(password));
    }
}
