import java.util.Scanner;

public class Main {
	static int[] inOrder = new int[100001];
	static int[] postOrder = new int[100001];
	
	public static void main(String[] args){
		// postOrder에서 마지막 노드: root 노드
		// root 노드 출력
		// 찾은 루트 노드를 inOrder에서 찾고 그 위치의 왼쪽 노드들: root 노드의 왼쪽 자식들
		// 찾은 루트 노드를 inOrder에서 찾고 그 위치의 오른쪽 노드들: root 노드의 오른쪽 자식들
		
		// 5
		// 1 4 3 2 5
		// 1 3 5 2 4
		
		// inBegin, inEnd, postBegin, postEnd
		// 0, 4, 0, 4	=> root = 4, index = 1
		// 0, 0, 0, 0	=> root = 1, index = 0
		// 2, 4, 1, 3	=> root = 2, index = 3
		// 2, 2, 1, 1	=> root = 3, index = 2
		// 4, 4, 2, 2	=> root = 5, index = 4
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for (int i = 0; i < n; ++i) inOrder[i] = sc.nextInt();
		for (int i = 0; i < n; ++i) postOrder[i] = sc.nextInt();
		sc.close();
		
		preOrder(0, n - 1, 0, n - 1);				
	}
	
	static void preOrder(int inBegin, int inEnd, int postBegin, int postEnd) {
		if (inBegin > inEnd || postBegin > postEnd) return;
		
		int root = postOrder[postEnd];
		System.out.print(root + " ");
		
		for (int i = inBegin; i <= inEnd; ++i) {
			if (inOrder[i] != root) continue;	// inOrder에서 root 위치 찾기
			
			preOrder(inBegin, i - 1, postBegin, postBegin + (i - 1) - inBegin);
			preOrder(i + 1, inEnd, postBegin + (i - 1) - inBegin + 1, postEnd - 1);
			return;
		}
	}
}
