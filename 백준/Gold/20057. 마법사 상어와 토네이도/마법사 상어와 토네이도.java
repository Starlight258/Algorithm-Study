import java.io.*;

public class Main {

	static int N;
	static int[][] A;
	static int[][][] direct = { { { 1, -1, 2, -2, 0, 1, -1, 1, -1, 0 }, { 1, 1, 0, 0, -2, 0, 0, -1, -1, -1 } },
			{ { -1, -1, 0, 0, 2, 0, 0, 1, 1, 1 }, { -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 } },
			{ { 1, -1, 2, -2, 0, 1, -1, 1, -1, 0 }, { -1, -1, 0, 0, 2, 0, 0, 1, 1, 1 } },
			{ { 1, 1, 0, 0, -2, 0, 0, -1, -1, -1 }, { -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 } } };

	static int[] percent = { 1, 1, 2, 2, 5, 7, 7, 10, 10 };
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };
	static int total;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		A = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(input[j - 1]);
			}
		}

		solve();
		bw.write(total + "\n");
		bw.flush();

	}

	public static void solve() {

		int cnt = 0;
		int move = 1;
		int d = 0;
		int r = N / 2 + 1;
		int c = N / 2 + 1;

		while (true) {

			if (cnt == 2) {
				cnt = 0;
				if (r > 1)
					move++;
			}

			for (int i = 0; i < move; i++) {

				int nr = r + dr[d];
				int nc = c + dc[d];

				if (A[nr][nc] > 0) {
					moveSand(nr, nc, d);
				}

				r = nr;
				c = nc;
			}

			cnt++;
			d = (d + 1) % 4;

			if (r == 1 && c == 1)
				break;
		}

	}

	public static void moveSand(int r, int c, int d) {

		int rest = A[r][c];

		for (int i = 0; i < 9; i++) {
			int nr = r + direct[d][0][i];
			int nc = c + direct[d][1][i];

			int amount = (int) Math.floor(A[r][c] * (double) (percent[i] / 100.0));
			rest -= amount;

			if ((1 <= nr && nr <= N) && (1 <= nc && nc <= N)) {
				A[nr][nc] += amount;
			}

			else
				total += amount;
		}

		int nr = r + direct[d][0][9];
		int nc = c + direct[d][1][9];

		if ((1 <= nr && nr <= N) && (1 <= nc && nc <= N)) {
			A[nr][nc] += rest;
			A[r][c] = 0;
		}

		else
			total += rest;
	}

}