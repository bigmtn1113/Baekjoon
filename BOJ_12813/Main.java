import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		sc.close();
		
		char[] aCharArray = new char[100000];
		char[] bCharArray = new char[100000];
		
		for (int i = 0; i < 100000; ++i) {
			aCharArray[i] = a.charAt(i);
			bCharArray[i] = b.charAt(i);
		}
		
		for (int i = 0; i < 100000; ++i) {
			System.out.print((char) (aCharArray[i] & bCharArray[i]));
		}
		
		System.out.println();
		
		for (int i = 0; i < 100000; ++i) {
			System.out.print((char) (aCharArray[i] | bCharArray[i]));
		}
		
		System.out.println();
		
		for (int i = 0; i < 100000; ++i) {
			System.out.print(aCharArray[i] ^ bCharArray[i]);
		}
		
		System.out.println();
		
		for (int i = 0; i < 100000; ++i) {
			System.out.print((aCharArray[i] == '0') ? '1' : '0');
		}
		
		System.out.println();
		
		for (int i = 0; i < 100000; ++i) {
			System.out.print((bCharArray[i] == '0') ? '1' : '0');
		}
	}
	
}
