package test;

public class GreetingApplication {

	public static void main(String [] args) {
		GreetingApplication greetingApplication = new GreetingApplication();
		greetingApplication.greetCustomer(greetingApplication.getGreeting());
	}
	
	public Greeter getGreeting() {
		Greeter greeter = () -> {
			return "Hello";
		};
		return greeter;
	}
	
	public Greeter welcomeUser() {
		Greeter greeter = () -> {
			return "Welcome User";
		};
		return greeter;
	}
	
	public void greetCustomer(Greeter greeter) {
		System.out.println(greeter.greetCustomer());
	}
}
