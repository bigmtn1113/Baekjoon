import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int br = sc.nextInt();
		int bc = sc.nextInt();
		int dr = sc.nextInt();
		int dc = sc.nextInt();
		int jr = sc.nextInt();
		int jc = sc.nextInt();
		
		sc.close();
		
		int bessieCellCnt = (Math.abs((br - jr)) + Math.abs((bc - jc))) / 2;
		int daisyCellCnt = Math.abs((dr - jr)) + Math.abs((dc - jc));
		
		if ((Math.abs((br - jr)) + Math.abs((bc - jc))) % 2 > 0) {
			++bessieCellCnt;
		}
		
		String result = "";
		
		if (bessieCellCnt < daisyCellCnt) {
			result = "bessie";
		} else if (bessieCellCnt == daisyCellCnt) {
			result = "tie";
		} else {
			result = "daisy";
		}
		
		System.out.print(result);
	}
	
}
