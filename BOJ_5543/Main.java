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
		
		int burgerA = Integer.parseInt(br.readLine());
		int burgerB = Integer.parseInt(br.readLine());
		int burgerC = Integer.parseInt(br.readLine());
		int cola = Integer.parseInt(br.readLine());
		int cider = Integer.parseInt(br.readLine());
		
		int minBurgerCost = 0;
		int minJuiceCost = cola < cider ? cola : cider;
		
		if (burgerA <= burgerB && burgerA <= burgerC) minBurgerCost = burgerA;
		else if (burgerB <= burgerA && burgerB <= burgerC) minBurgerCost = burgerB;
		else if (burgerC <= burgerA && burgerC <= burgerB) minBurgerCost = burgerC;
		
		bw.write(String.valueOf(minBurgerCost + minJuiceCost - 50));
		
        bw.flush();
        bw.close();
	}

}
