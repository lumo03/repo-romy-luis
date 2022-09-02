
public class Main {
	
	public static void main(String[] args) {
		var greeting = "Hello World";
		System.out.println(greeting);
		var randomNum = Main.generateRandomNumber();
		System.out.println(randomNum);
	}
	
	public static int generateRandomNumber() {
		return (int) Math.random() * 1000;
	}
	
}
