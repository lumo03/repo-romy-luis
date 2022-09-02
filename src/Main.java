
public class Main {
	
	public static void main(String[] args) {
		var greeting = "Hello World";
		System.out.println(greeting);
		var randomNum = Main.generateRandomNumber();
		System.out.println(randomNum);
		Main.sayHello("Luis");
	}
	
	public static int generateRandomNumber() {
		return (int) Math.random() * 1000;
	}
	
	public static void sayHello(String name) {
		System.out.println(String.format("Hello %s!", name));
	}
	
	public static void sayGoodbye(String name) {
		System.out.println(String.format("Goodbye %s! See you later!", name));
	}
	
}
