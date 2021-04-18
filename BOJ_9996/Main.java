import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String pattern = sc.next();
		
		String frontStr = pattern.substring(0, pattern.indexOf("*"));
		String backStr = pattern.substring(pattern.indexOf("*") + 1);
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; i < n; ++i) {
			String fileName = sc.next();
			
			if (fileName.length() < frontStr.length() + backStr.length()) {
				answer.append("NE").append("\n");
				continue;
			}
			
			String fileNameFrontStr = fileName.substring(0, frontStr.length());
			String fileNameBackStr = fileName.substring(fileName.length() - backStr.length());
			
			if (fileNameFrontStr.equals(frontStr) && fileNameBackStr.equals(backStr)) {
				answer.append("DA").append("\n");
			} else {
				answer.append("NE").append("\n");
			}
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
