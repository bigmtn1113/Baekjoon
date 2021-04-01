import java.util.Scanner;

class QnA {
	private String num;
	private int strike;
	private int ball;
	
	public QnA(String num, int strike, int ball) {
		super();
		this.num = num;
		this.strike = strike;
		this.ball = ball;
	}

	public String getNum() {
		return num;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
}

public class Main {
	
	public static boolean check(String s, QnA qna) {
		String num = qna.getNum();
		int strike = 0;
		int ball = 0;
		
		for (int i = 0; i < 3; ++i) {
			if (s.charAt(i) == num.charAt(i)) {
				++strike;
			}
		}
		
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (i == j) {
					continue;
				}
				
				if (s.charAt(i) == num.charAt(j)) {
					++ball;
				}
			}
		}
		
		return ((strike == qna.getStrike()) && (ball == qna.getBall())) ? true : false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		QnA[] qna = new QnA[n];
		
		for (int i = 0; i < n; ++i) {
			qna[i] = new QnA(sc.next(), sc.nextInt(), sc.nextInt());
		}
		
		sc.close();
		
		int answer = 0;
		
		for (int i = 1; i < 10; ++i) {
			for (int j = 1; j < 10; ++j) {
				if (i == j) {
					continue;
				}
				
				for (int k = 1; k < 10; ++k) {
					if ((i == k) || (j == k)) {
						continue;
					}
					
					String s = "" + i + j + k;
					boolean temp = true;
					
					for (int l = 0; l < n; ++l) {
						if (!check(s, qna[l])) {
							temp = false;
							break;
						}
					}
					
					if (temp) {
						++answer;
					}
				}
			}
		}
		
		System.out.print(answer);
	}
	
}
