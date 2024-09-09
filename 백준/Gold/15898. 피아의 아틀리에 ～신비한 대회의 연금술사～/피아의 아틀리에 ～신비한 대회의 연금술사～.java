import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int answer;
    private static Ingredient[][] ingredientArr;
    private static boolean[] permVisited;
    private static Gama gama;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N개의 재료
        ingredientArr = new Ingredient[N][4]; // 회전
        permVisited = new boolean[N];
        gama = new Gama();

        for (int kind = 0; kind < N; kind++) {
            ingredientArr[kind][0] = new Ingredient();

            for (int row = 0; row < 4; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < 4; col++) {
                    int input = Integer.parseInt(st.nextToken());
                    ingredientArr[kind][0].quality[row][col] = input; // 정방향일때 재료 quality
                }
            }

            for (int row = 0; row < 4; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < 4; col++) {
                    char input = st.nextToken().charAt(0);
                    ingredientArr[kind][0].kind[row][col] = input; // 정방향일때 재료 모양
                }
            }

            for (int dir = 1; dir < 4; dir++) {
                ingredientArr[kind][dir] = rotateBy90Degree(ingredientArr[kind][dir - 1]);
            }
        }

        simulate(0);
        System.out.println(answer);
    }

    private static void simulate(final int level) {
        if (level == 3) {
            int R = 0, B = 0, G = 0, Y = 0, W = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (gama.kind[i][j] == 'R') {
                        R += gama.quality[i][j];
                    } else if (gama.kind[i][j] == 'B') {
                        B += gama.quality[i][j];
                    } else if (gama.kind[i][j] == 'G') {
                        G += gama.quality[i][j];
                    } else if (gama.kind[i][j] == 'Y') {
                        Y += gama.quality[i][j];
                    } else if (gama.kind[i][j] == 'W') {
                        W += gama.quality[i][j];
                    }
                }
            }
            int bombResult = 7 * R + 5 * B + 3 * G + 2 * Y + 0 * W;
            answer = Math.max(answer, bombResult);
            return;
        }

        // 현재 가마값 저장
        Gama storeGamma = new Gama();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                storeGamma.quality[i][j] = gama.quality[i][j];
                storeGamma.kind[i][j] = gama.kind[i][j];
            }
        }

        // 재료 넣는 순서 고려해서 짜야한다
        for (int i = 0; i < N; i++) {
            if (!permVisited[i]) {
                permVisited[i] = true;
                // 넣을 수 있는 위치는 정해져있다
                for (int row = 0; row < 2; row++) {
                    for (int col = 0; col < 2; col++) {

                        // 재료를 가마에 너흔다. 회전 4방향까지 신경쓴다
                        for (int dir = 0; dir < 4; dir++) {
                            putIngredient(i, dir, row, col); // startR, startC

                            simulate(level + 1);

                            // 원상복구
                            for (int j = 0; j < 5; j++) {
                                for (int k = 0; k < 5; k++) {
                                    gama.kind[j][k] = storeGamma.kind[j][k];
                                    gama.quality[j][k] = storeGamma.quality[j][k];
                                }
                            }
                        }
                    }
                }
                permVisited[i] = false;
            }
        }


    }

    private static void putIngredient(final int ingredientIdx, final int dirIdx, final int startR, final int startC) {
        for (int row = startR; row < startR + 4; row++) {
            for (int col = startC; col < startC + 4; col++) {
                int qualityResult =
                        gama.quality[row][col] + ingredientArr[ingredientIdx][dirIdx].quality[row - startR][col
                                - startC];
                if (qualityResult < 0) {
                    qualityResult = 0;
                } else if (qualityResult > 9) {
                    qualityResult = 9;
                }
                gama.quality[row][col] = qualityResult;

                char kindResult = ingredientArr[ingredientIdx][dirIdx].kind[row - startR][col - startC];
                if (kindResult != 'W') {
                    gama.kind[row][col] = kindResult; // 격자의 색은 흰색이 아닐 경우 칠해진다.
                }
            }
        }
    }

    private static Ingredient rotateBy90Degree(final Ingredient ingredient) {
        Ingredient temp = new Ingredient();

        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                temp.quality[c][4 - r - 1] = ingredient.quality[r][c];
                temp.kind[c][4 - r - 1] = ingredient.kind[r][c];
            }
        }
        return temp;
    }
}

class Ingredient {
    int[][] quality = new int[4][4];
    char[][] kind = new char[4][4];

    public Ingredient() {
    }
}

class Gama {
    int[][] quality = new int[5][5];
    char[][] kind = new char[5][5];

    public Gama() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.kind[i][j] = 'W'; // 초기화
            }
        }
    }
}
