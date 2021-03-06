import java.util.ArrayList;
import java.util.Scanner;

class Resistance {
	private String color;
	private int value;
	private int multiple;
	
	public Resistance(String color, int value, int multiple) {
		this.color = color;
		this.value = value;
		this.multiple = multiple;
	}

	public String getColor() {
		return color;
	}

	public int getValue() {
		return value;
	}

	public int getMultiple() {
		return multiple;
	}
}

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Resistance> resistance = new ArrayList<>();
		
		resistance.add(new Resistance("black", 0, 1));
		resistance.add(new Resistance("brown", 1, 10));
		resistance.add(new Resistance("red", 2, 100));
		resistance.add(new Resistance("orange", 3, 1000));
		resistance.add(new Resistance("yellow", 4, 10000));
		resistance.add(new Resistance("green", 5, 100000));
		resistance.add(new Resistance("blue", 6, 1000000));
		resistance.add(new Resistance("violet", 7, 10000000));
		resistance.add(new Resistance("grey", 8, 100000000));
		resistance.add(new Resistance("white", 9, 1000000000));
		
		String result = "";
		
		for (int i = 0; i < 3; ++i) {
			String input = sc.next();
			
			if (i < 2) {
				for (Resistance r : resistance) {
					if (r.getColor().equals(input)) {
						result += r.getValue();
						break;
					}
				}
			} else {
				for (Resistance r : resistance) {
					if (r.getColor().equals(input)) {
						result = String.valueOf((Double.parseDouble(result) * r.getMultiple()));
						break;
					}
				}
			}
		}
		
		sc.close();
		
		System.out.format("%.0f", Double.parseDouble(result));
	}
	
}
