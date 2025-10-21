class Solution {
    public int solution(int n, int w, int num) {
        int rows = (n + w - 1) / w;        // 총 행 수 (맨 위 행은 w 미만일 수 있음)
        int r = (num - 1) / w;             // num이 위치한 행 (0-based: 아래가 0)
        int rowPos = (num - 1) % w;        // 그 행 내의 배치 순서 (0..w-1)

        // 해당 행의 물리적 열(column) 위치
        int col = (r % 2 == 0) ? rowPos : (w - 1 - rowPos);

        int countAbove = 0;
        for (int i = r + 1; i < rows; i++) {
            int rowLen = (i == rows - 1) ? n - (rows - 1) * w : w; // i행의 실제 박스 개수
            // i행에서 '같은 물리적 열'이 차지하는 인덱스
            int offset = (i % 2 == 0) ? col : (w - 1 - col);
            if (offset < rowLen) countAbove++;
        }

        return 1 + countAbove; // 자기 자신 포함
    }
}