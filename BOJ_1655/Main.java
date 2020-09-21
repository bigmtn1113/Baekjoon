import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 오름차순으로 정렬된 배열에서의 중앙값의 성질
		// [처음 ~ 중앙]에서 중앙값은 제일 크고 [중앙 ~ 끝]에서 중앙값은 제일 작음

		// [처음 ~ 중앙]을 max_heap, [중앙 ~ 끝]을 min_heap으로 구현
		// 그러므로 max_heap의 루트 원소는 min_heap의 루트 원소보다 작거나 같아야 함. 크면 두 원소끼리 교환.
		// max_heap의 루트 원소가 최종적으로 중앙값.

		// ex) 1 5 2 10 -99 7 5 4
		// 1	->	max_heap = { 1 }, min_heap = { }	->	1
		// 5	->	max_heap = { 1 }, min_heap = { 5 }	->	1
		// 2	->	max_heap = { 2, 1 }, min_heap = { 5 }	->	2
		// 10	->	max_heap = { 2, 1 }, min_heap = { 5, 10 }	->	2
		// -99	->	max_heap = { 2, 1, -99 }, min_heap = { 5, 10 }	->	2
		// 7	->	max_heap = { 2, 1, -99 }, min_heap = { 5, 7, 10 }	->	2
		// 5	->	max_heap = { 5, 2, -99, 1 }, min_heap = { 5, 7, 10 }	->	5
		// 4	->	max_heap = { 5, 2, -99, 1 }, min_heap = { 4, 5, 7, 10 }
		//		->	max_heap = { 4, 2, -99, 1 }, min_heap = { 5, 5, 7, 10 }	->	4
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minPq = new PriorityQueue<>();
		for (int i = 0; i < n; ++i) {
			int num = Integer.parseInt(br.readLine());
			
			if (maxPq.size() == minPq.size()) maxPq.offer(num);
			else minPq.offer(num);
			
			if (!maxPq.isEmpty() && !minPq.isEmpty() && maxPq.peek() > minPq.peek()) {
				maxPq.offer(minPq.poll());
				minPq.offer(maxPq.poll());	
			}
			
			bw.write(maxPq.peek() + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
}
