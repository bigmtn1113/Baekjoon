import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

class AbsHeap implements Comparable<AbsHeap>{
	int absNum;
	int num;
	
	AbsHeap(int absNum, int num) {
		this.absNum = absNum;
		this.num = num;
	}
	
	int getAbsNum() { return this.absNum; }
	int getNum() { return this.num; }

	@Override
	public int compareTo(AbsHeap o) {
		return (this.absNum == o.absNum) ? this.num - o.num : this.absNum - o.absNum;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<AbsHeap> pq = new PriorityQueue<>();
		for (int i = 0; i < n; ++i) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0) bw.write(pq.isEmpty() ? "0\n" : pq.poll().getNum() + "\n");
			else pq.offer(new AbsHeap(Math.abs(num), num));
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
}
