import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String jaehwan = sc.next();
		String doctor = sc.next();
		
		sc.close();
		
		System.out.print((jaehwan.length() >= doctor.length()) ? "go" : "no");
	}
	
}
