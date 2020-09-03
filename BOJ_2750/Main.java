import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(br.readLine());
		br.close();
		
		selectionSort(arr);
		//insertionSort(arr);
		//bubbleSort(arr);
		for (int i = 0; i < n; ++i)
			bw.write(arr[i] + "\n");
		
		bw.flush();
		bw.close();
	}
	
	static void selectionSort(int[] arr) {
		int lastIndex = arr.length - 1;
		
		while (lastIndex > 0) {
			int max = -1000;
			int maxIndex = 0;
			
			for (int i = 0; i <= lastIndex; ++i) {
				if (arr[i] > max) {
					max = arr[i];
					maxIndex = i;
				}
			}
			
			int temp = arr[lastIndex];
			arr[lastIndex] = max;
			arr[maxIndex] = temp;
			
			--lastIndex;
		}
	}
	
	static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; ++i) {
			int standard = arr[i];
			int j;
			
			for (j = i - 1; j >= 0; --j) {
				if (standard < arr[j])
					arr[j + 1] = arr[j];
				else
					break;
			}
			
			arr[j + 1] = standard;
		}
	}
	
	static void bubbleSort(int[] arr) {
		int lastIndex = arr.length - 1;
		
		while (lastIndex > 0) {
			int standardIndex = 0;
			
			for (int i = 1; i <= lastIndex; ++i, ++standardIndex) {
				if (arr[standardIndex] > arr[i]) {
					int temp = arr[standardIndex];
					arr[standardIndex] = arr[i];
					arr[i] = temp;
				}
			}
			
			--lastIndex;
		}
	}
}