package dev.yavuztas.spring.context;

public class SampleBean {

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

}
