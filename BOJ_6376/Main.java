public class Main {
	
	public static void main(String[] args){
		System.out.println("n e");
		System.out.println("- -----------");
		
		double sum = 0;
		
		for (int i = 0; i < 10; ++i) {
			int factorial = 1;
			
			for (int j = 0; j <= i; ++j) {
				if ((j == 0) || (j == 1)) {
					continue;
				}
				
				factorial *= j;
			}
			
			sum += 1 / (double) factorial;
			
			switch (i) {
			case 0:
			case 1:
				System.out.format("%d %.0f\n", i, sum);
				break;
				
			case 2:
				System.out.format("%d %.1f\n", i, sum);
				break;

			default:
				System.out.format("%d %.9f\n", i, sum);
				break;
			}
		}
	}
	
}
