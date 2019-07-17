package dev.yavuztas.spring.context;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class SampleBean implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void saySomething(String message) {
		setMessage(message);
		System.out.println(getMessage());
	}

	@Override
	public void setBeanName(String name) {

		System.out.println("--- setBeanName executed ---");

	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

		System.out.println("--- setBeanFactory executed ---");

	}

	@PostConstruct
	public void postConstruct() {

		System.out.println("--- @PostConstruct executed ---");

	}

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("--- afterPropertiesSet executed ---");

	}

	public void initMethod() {

		System.out.println("--- init-method executed ---");

	}

	@PreDestroy
	public void preDestroy() {

		System.out.println("--- @PreDestroy executed ---");

	}

	@Override
	public void destroy() throws Exception {

		System.out.println("--- destroy executed ---");

	}

	public void destroyMethod() {

		System.out.println("--- destroy-method executed ---");

	}

}
