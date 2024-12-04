import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static int N,M,T;
	static String[][] map;
	static boolean[][] visit;
	static PriorityQueue<int[]>q;
	static int answer=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		StringTokenizer st=new StringTokenizer(s);
		StringBuilder sb=new StringBuilder();
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
	
		q=new PriorityQueue<>(new Comparator<>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				 return o1[2]-o2[2];
			}
			
		});
		map=new String[N][M];
		visit=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			s=br.readLine();
			
			map[i]=s.split(" ");
		}
		visit[0][0]=true;
		q.add(new int[] {0,0,0,0});
		bfs(0,0,0);
		
		
		if(answer==0)
		System.out.println("Fail");
		else System.out.println(answer);
	
	}
	static void bfs(int x, int y, int weapon) {

		while(!q.isEmpty()) {
			
			int[] qq=q.poll();
	
			if(qq[2]>T) break;
			
	
			if(qq[0]==N-1 && qq[1]==M-1) {
				answer=qq[2];
				break;
			}
			
		 	for(int i=0;i<4;i++) {
				int nx=qq[0]+dx[i];
				int ny=qq[1]+dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M ) continue;
				
		
				if(map[nx][ny].equals("1") || visit[nx][ny]) continue;
		
				
				visit[nx][ny]=true;
				if(map[nx][ny].equals("2")) { 
					visit[nx][ny]=true;
					qq[2]+=((N-1-nx) + (M-1-ny)); 
					nx=N-1; ny=M-1;
					qq[3]=1;

				}	
			
				q.add(new int[] {nx,ny,qq[2]+1, qq[3]});
		}
			
		}
	}
}