import java.util.Calendar;

public class Main {
	
	public static void main(String[] args){
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.print(cal.get(Calendar.DATE));
	}
	
}
