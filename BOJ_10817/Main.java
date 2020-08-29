import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int secondNum = 0;
		if (a <= b && a >= c || a <= c && a >= b) secondNum = a;
		else if (b <= a && b >= c || b <= c && b >= a) secondNum = b;
		else if (c <= a && c >= b || c <= b && c >= a) secondNum = c;
		
		bw.write(String.valueOf(secondNum));
		
        bw.flush();
        bw.close();
	}

}
