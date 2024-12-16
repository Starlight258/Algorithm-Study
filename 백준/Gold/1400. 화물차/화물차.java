import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int dy[] = { 0, 0, 1, -1, 0 };
	static int dx[] = { 1, -1, 0, 0, 0 };

	static int N, M;

	static char[][] map;
	static boolean visit[][];

	static int cnt;

	static class Pair {
		int y;
		int x;

		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	// 최대 800초
	static int sy, sx;
	static int ey, ex;

	static class Signal {
		int dir;
		int a;
		int b;

		public Signal(int dir, int a, int b) {
			super();
			this.dir = dir;
			this.a = a;
			this.b = b;
		}
	}

	static Signal sig[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			cnt = 0;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0)
				break;

			map = new char[N][M];
			visit = new boolean[N][M];

			for (int i = 0; i < N; i++)
				map[i] = br.readLine().toCharArray();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] >= '0' && map[i][j] <= '9') {
						cnt++;
					}

					if (map[i][j] == 'A') {
						sy = i;
						sx = j;
					}

					if (map[i][j] == 'B') {
						ey = i;
						ex = j;
					}
				}
			}

			sig = new Signal[cnt];

			for (int i = 0; i < cnt; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int d = st.nextToken().equals("-") ? 0 : 1;
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				sig[n] = new Signal(d, a, b);
			}
			br.readLine();

			int ans = BFS();
			if (ans == -1) {
				sb.append("impossible\n");
			} else {
				sb.append(ans).append('\n');
			}
		}
		System.out.println(sb.toString());
	}

	public static int BFS() {
		int time = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(sy, sx));
		visit[sy][sx] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Pair cur = q.poll();

				if (cur.y == ey && cur.x == ex) {
					return time;
				}

				// 이동한다.
				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];
					if (ny < 0 || nx < 0 || ny >= N || nx >= M)
						continue;
					if (visit[ny][nx])
						continue;
					if (map[ny][nx] == '.')
						continue;
					if (map[ny][nx] == '#' || map[ny][nx] == 'A' || map[ny][nx] == 'B') {
						visit[ny][nx] = true;
						q.add(new Pair(ny, nx));
					}

					if (map[ny][nx] >= '0' && map[ny][nx] <= '9' && d != 4) {
						int snum = map[ny][nx] - '0';
						if (checkSignal(snum, d, time)) {
							visit[ny][nx] = true;
							q.add(new Pair(ny, nx));
						}else {
							q.add(new Pair(cur.y,cur.x));
						}
					}
				}
			}
			time++;
		}

		return -1;
	}

	public static boolean checkSignal(int snum, int d, int time) {

		// dir ==0 동서 dir == 1 남북
		int dir = sig[snum].dir;
		int a = sig[snum].a;
		int b = sig[snum].b;
		int ans = 0;
		time = time % (a + b);

		// 동서가 먼저일때
		if (dir == 0) {
			if (time - a >= 0) {
				ans = (dir + 1) % 2;
			} else {
				ans = dir;
			}

		} else {
			if (time - b >= 0) {
				ans = (dir + 1) % 2;
			} else {
				ans = dir;
			}
		}

		if (ans == 0 && (d == 0 || d == 1))
			return true;
		if (ans == 1 && (d == 2 || d == 3))
			return true;

		return false;
	}

}