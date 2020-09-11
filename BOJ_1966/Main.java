import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Document {
	private int priority;
	private int index;
	
	Document(int priority, int index) {
		this.priority = priority;
		this.index = index;
	}

	public int getPriority() { return priority; }
	public int getIndex() { return index; }
}

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Document> queue = new LinkedList<>();
		StringTokenizer st;
		
		// ex) 1 1 9 1 1 1
		// �켱����(�ε���): 1(0) 1(1) 9(2) 1(3) 1(4) 1(5)
		// 9(2) 1(3) 1(4) 1(5) 1(0) 1(1) -> 9
		// 1(3) 1(4) 1(5) 1(0) 1(1) -> 1
		// 1(4) 1(5) 1(0) 1(1) -> 1
		// 1(5) 1(0) 1(1) -> 1
		// 1(0) 1(1) -> 1
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; ++i) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int max = 0;
			for (int j = 0; j < n; ++j) {
				int num = Integer.parseInt(st.nextToken());
				queue.offer(new Document(num, j));
				
				if (num > max) max = num;
			}
			
			int cnt = 0;
			while (queue.size() > 0) {
				if (queue.peek().getPriority() == max) {	// �켱������ ���� ���� ������ ���
					++cnt;
					
					if (queue.peek().getIndex() == m) {	// ã���� �ϴ� ������ ���
						bw.write(cnt + "\n");
						break;
					}
					
					queue.poll();	// �켱������ ���� ���� ���� ���
					
					max = 0;	// �켱������ ���� ���� ������ ã��
					for (int j = 0; j < queue.size(); ++j) {
						int priority = queue.peek().getPriority();
						queue.offer(queue.poll());
						
						if (priority > max)
							max = priority;
					}
				} else {	// �켱������ ���� ���� ������ �ƴ� ���
					queue.offer(queue.poll());	// ť�� �� �ڷ� ������
				}
			}
			queue.clear();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}