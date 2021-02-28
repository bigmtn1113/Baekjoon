import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		double previousTemperature = sc.nextDouble();
		
		while (true) {
			double temperature = sc.nextDouble();
			
			if (temperature == 999) {
				break;
			}
			
			System.out.format("%.2f\n", temperature - previousTemperature);
			
			previousTemperature = temperature;
		}
		
		sc.close();
	}
	
}
