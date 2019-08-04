package dev.yavuztas.spring.context;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SampleClassPathApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        appContext.registerShutdownHook();

        assert appContext.containsBean("sampleBean");

        SampleBean sampleBean = appContext.getBean("sampleBean", SampleBean.class);
        sampleBean.saySomething("Hello World!");

        assert sampleBean.getMessage() == "Hello World!";

    }

}
