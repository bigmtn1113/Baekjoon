import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] array = new int[10001];
		
		for (int i = 0; i < n; ++i) {
			++array[Integer.parseInt(br.readLine())];
		}
		
		br.close();
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 1; i < 10001; ++i) {
			for (int j = 0; j < array[i]; ++j) {
				answer.append(i).append("\n");
			}
		}
		
		System.out.print(answer);
	}
	
}
