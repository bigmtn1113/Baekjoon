import java.util.Scanner;

public class Main {
	static int[] preOrder = new int[10001];
	
	public static void main(String[] args){
		// preOrder로 탐색하면 시작은 루트 노드가 된다.
		// 루트 노드보다 작으면 왼쪽 자식 노드들, 크면 오른쪽 자식 노드들이다.
		// postOrder순으로 출력하려면 왼쪽 자식 노드들을 방문한 뒤 오른쪽 자식 노드들을 방문하고
		// 그 후에 루트 노드를 출력하면 된다.
		// 이 과정을 반복한다.
		
		// 50, 30, 24, 5, 28, 45, 98, 52, 60
		
		// begin, end
		// 0, 8	=> root = 50, index = 6
		// 1, 5	=> root = 30, index = 5
		// 2, 4	=> root = 24, index = 4
		// 3, 3	=> root = 5, 5 출력
		// 4, 4	=> root = 28, 28 출력
		// 24 출력
		// 5, 5	=> root = 45, 45 출력
		// 30 출력
		// 6, 8	=> root = 98
		// 7, 8	=> root = 52, index = 8
		// 8, 8	=> root = 60, 60  출력
		// 52 출력
		// 98 출력
		// 50 출력
		
		Scanner sc = new Scanner(System.in);
		
		int index = 0;
		while (sc.hasNext())
			preOrder[index++] = sc.nextInt();
		sc.close();
		
		postOrder(0, index - 1);
	}
	
	static void postOrder(int begin, int end) {
		if (begin > end) return;
		
		int root = preOrder[begin];
		boolean canFindRightVertex = false;
		
		for (int i = begin + 1; i <= end; ++i) {
			if (preOrder[i] < root) continue;
			
			canFindRightVertex = true;
			postOrder(begin + 1, i - 1);
			postOrder(i, end);
			break;
		}
		
		if (!canFindRightVertex) postOrder(begin + 1, end);	// 오른쪽 자식이 없으면 왼쪽 자식 탐색
		System.out.println(root);
	}
}
