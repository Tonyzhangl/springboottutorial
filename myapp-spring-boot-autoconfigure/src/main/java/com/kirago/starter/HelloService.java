package com.kirago.starter;

public class HelloService {

    HelloProperties helloProperties;

    public String sayHello(String name) {
        return "Hello" + name + ", " + helloProperties.getSuffix();
    }

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }


}
