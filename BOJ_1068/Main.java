import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean[] visited;
    public static int answer = 0;
    
    public static void dfs(ArrayList<Integer>[] tree, int parentNode) {
        boolean isLeafNode = true;
        
        for (int childNode : tree[parentNode]) {
            if (!visited[childNode]) {
                visited[childNode] = true;
                dfs(tree, childNode);
                
                isLeafNode = false;
            }
        }
        
        if (isLeafNode) {
            ++answer;
        }
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] parentNodes = new int[n];
        int rootNode = 0;
		
		for (int i = 0; i < n; ++i) {
			parentNodes[i] = sc.nextInt();
            
            if (parentNodes[i] == -1) {
                rootNode = i;
            }
		}
        
        int deleteNode = sc.nextInt();
		
		sc.close();
		
		// 지울 노드와 그의 자식 노드들을 애초에 tree에 포함시키지 않고 진행한다.
		// 즉, 이미 다 지워진 tree로 탐색을 시작하는 것이다.
		// dfs를 진행할 때 자식 노드가 없는 노드의 숫자를 새면 된다.
		
		ArrayList<Integer>[] tree = new ArrayList[n];
        
        for (int i = 0; i < n; ++i) {
            tree[i] = new ArrayList<>();
        }
        
        visited = new boolean[n];
        visited[deleteNode] = true;
        
        for (int i = 0; i < n; ++i) {
            if (visited[i]) {
                continue;
            }
            
            if (parentNodes[i] > -1) {
	            if (visited[parentNodes[i]]) {
	                visited[i] = true;
	                continue;
	            }
	            
	            tree[parentNodes[i]].add(i);
	            tree[i].add(parentNodes[i]);
            }
        }
        
        if (rootNode != deleteNode) {
			visited[rootNode] = true;
	        dfs(tree, rootNode);
        }
        
		System.out.print(answer);
	}

}
