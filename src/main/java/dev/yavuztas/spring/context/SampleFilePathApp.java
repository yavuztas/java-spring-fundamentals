package dev.yavuztas.spring.context;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SampleFilePathApp {

    public static void main(String[] args) {

        FileSystemXmlApplicationContext appContext = new FileSystemXmlApplicationContext("src/main/resources/beans.xml");
        appContext.registerShutdownHook();

        assert appContext.containsBean("sampleBean");

        SampleBean sampleBean = appContext.getBean("sampleBean", SampleBean.class);
        sampleBean.saySomething("Hello World!");

        assert sampleBean.getMessage() == "Hello World!";

    }

}
