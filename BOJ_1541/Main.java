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
			
			if (Character.isDigit(temp) == true)	// ���� ���ڰ� �����̸�
				num += temp;
			else {	// ���� ���ڰ� '+'�� '-'��
				int numToInt = Integer.parseInt(num);
				num = "";
				
				if (!isMinus && temp == '-') {	// '-'�� ó�� ������
					sum += numToInt;
					isMinus = true;
					continue;
				} 
				
				if (isMinus) sum -= numToInt;	// '-'�� ���� ���� ������ �� �ڷ� �� ���� ���� ����
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