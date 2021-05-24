package otherPackage;

public class PowerPointTest {

	public static void main(String[] args) {
		
		String stringG = "abcd";
		
		StringBuilder builderG =new StringBuilder(stringG);
		builderG.deleteCharAt(2);
		System.out.println("String now after delete:  " + builderG.toString());
		
		StringBuilder builderG2 = new StringBuilder(stringG);
		builderG2.setCharAt(2, '#');
		System.out.println("String now after set:  " + builderG2);
	}
}