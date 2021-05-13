import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Ranking implements Comparable<Ranking> {
	private int document;
	private int interview;
	
	public Ranking(int document, int interview) {
		this.document = document;
		this.interview = interview;
	}

	public int getDocument() {
		return document;
	}

	public int getInterview() {
		return interview;
	}

	@Override
	public int compareTo(Ranking o) {
		return this.document - o.document;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		// Scanner 사용 시, 시간초과
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder answer = new StringBuilder();
		
		int t = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < t; ++i) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			Ranking[] ranking = new Ranking[n];
			
			for (int j = 0; j < n; ++j) {
				st = new StringTokenizer(br.readLine());
				ranking[j] = new Ranking(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(ranking);
			
			int standard = ranking[0].getInterview();
			int cnt = 1;
			
			for (int j = 1; j < n; ++j) {
				if (ranking[j].getInterview() < standard) {
					++cnt;
					standard = ranking[j].getInterview();
				}
			}
			
			answer.append(cnt).append("\n");
		}
		
		br.close();
		
		System.out.print(answer);
	}

}
