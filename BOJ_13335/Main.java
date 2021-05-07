import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int w = sc.nextInt();
		int l = sc.nextInt();
		
		Queue<Integer> truckQueue = new LinkedList<>();
		
		for (int i = 0; i < n; ++i) {
			truckQueue.offer(sc.nextInt());
		}
		
		sc.close();
		
		Queue<Integer> bridgeQueue = new LinkedList<>();
		
		int[] trucksTime = new int[n];		// 각 트럭들이 다리 위에 있는 시간
		int veryFrontTruckIndex = 0;		// 다리 위에 있는 트럭 중 맨 앞에 있는 트럭
		
		int tempW = w;
		int tempL = l;
		int answer = 0;
		
		while (veryFrontTruckIndex < n) {
			// 다리 위에 있는 트럭 중 맨 앞에 있는 트럭이 다리를 통과할 경우
			if (!bridgeQueue.isEmpty() && trucksTime[veryFrontTruckIndex] == w) {
				++veryFrontTruckIndex;
				++tempW;
				tempL += bridgeQueue.poll();
			}
			
			// 추가로 다리 위로 트럭이 지나갈 수 있는 경우
			if (!truckQueue.isEmpty()) {
				if ((tempW > 0) && (tempL >= truckQueue.peek())) {
					--tempW;
					tempL -= truckQueue.peek();
					
					bridgeQueue.offer(truckQueue.poll());
				}
			}
			
			// 다리 위에 있는 트럭들의 다리 위에 있는 시간 1초 증가
			for (int i = veryFrontTruckIndex; i < veryFrontTruckIndex + bridgeQueue.size(); ++i) {
				++trucksTime[i];
			}
			
			++answer;
		}
		
		System.out.print(answer);
	}

}
