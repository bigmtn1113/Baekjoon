import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[10000];
		
		for (int i = 0; i < 10000; ++i) {
			String num = Integer.toString(i);
			int dn = i;
			
			for (int j = 0; j < num.length(); ++j)
				dn += num.charAt(j) - '0';
			
            if (dn < 10000)
            	++arr[dn];
		}
		
		for (int i = 1; i < 10000; ++i)
			if (arr[i] == 0)
				bw.write(i + "\n");
		
		bw.flush();
		bw.close();
	}
}