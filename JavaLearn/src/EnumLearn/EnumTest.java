package EnumLearn;

import java.util.Scanner;

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		deviceTypeTest();
	}
	
	
	public static void deviceTypeTest(){
		
		
	}
	public static void sizeTest(){
		System.out.println("Input a size : SMALL, MEDIUM, LARGE, EXTREMELARGE");
		Scanner inScanner = new Scanner(System.in);
		String input = inScanner.nextLine().toUpperCase();
		Size s = Enum.valueOf(Size.class, input);
		System.out.println("abbreviation is : " + s.getAbbreviation());
		if(s == Size.EXTREMELARGE)
			System.out.println("Good job, your attention is : _.");
	}

}

