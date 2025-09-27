import java.util.*;

class Solution {

    static class UF {
        int[] parent, rank;
        UF(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int x, int y) {
            int rx = find(x), ry = find(y);
            if (rx == ry) return;
            if (rank[rx] < rank[ry]) parent[rx] = ry;
            else if (rank[rx] > rank[ry]) parent[ry] = rx;
            else { parent[ry] = rx; rank[rx]++; }
        }
    }

    public int solution(int n, int[][] computers) {
        UF uf = new UF(n);

        // 인접행렬: 자기 자신 1 포함. 대칭이므로 i<j만 보면 충분.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (computers[i][j] == 1) uf.union(i, j);
            }
        }

        // 각 노드의 루트를 세어 네트워크 개수 계산
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; i++) roots.add(uf.find(i));
        return roots.size();
    }
}