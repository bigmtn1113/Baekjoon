import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// java 11이 느려서 버퍼 사용.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input1 = br.readLine().split(" ");
		String[] input2 = br.readLine().split(" ");
		
		int w = Integer.parseInt(input1[0]);
		int h = Integer.parseInt(input1[1]);
		int p = Integer.parseInt(input2[0]);
		int q = Integer.parseInt(input2[1]);
		int t = Integer.parseInt(br.readLine());
		
		br.close();
		
		if (((p + t) / w) % 2 == 0) {
			p = (p + t) % w;
		} else {
			p = w - ((p + t) % w);
		}
		
		if (((q + t) / h) % 2 == 0) {
			q = (q + t) % h;
		} else {
			q = h - ((q + t) % h);
		}
		
		StringBuilder answer = new StringBuilder();
		
		answer.append(p).append(" ").append(q);
		
		System.out.print(answer);
	}
	
}
