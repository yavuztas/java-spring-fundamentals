package dev.yavuztas.spring.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("--- postProcessBeforeInitialization executed ---");

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("--- postProcessAfterInitialization executed ---");

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

}
