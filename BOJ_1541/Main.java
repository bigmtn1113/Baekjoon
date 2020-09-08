import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		br.close();
		
		int sum = 0;
		String num = "";
		boolean isMinus = false;
		for (int i = 0; i < str.length(); ++i) {
			char temp = str.charAt(i);
			
			if (Character.isDigit(temp) == true)	// 현재 문자가 숫자이면
				num += temp;
			else {	// 현재 문자가 '+'나 '-'면
				int numToInt = Integer.parseInt(num);
				num = "";
				
				if (!isMinus && temp == '-') {	// '-'가 처음 나오면
					sum += numToInt;
					isMinus = true;
					continue;
				} 
				
				if (isMinus) sum -= numToInt;	// '-'가 나온 적이 있으면 그 뒤론 다 빼기 연산 수행
				else sum += numToInt;
			}
		}
		
		if (isMinus) sum -= Integer.parseInt(num);
		else sum += Integer.parseInt(num);
		
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}