class Solution {
    public int solution(int numCastles, int[] treasures) {
        if (numCastles == 0) {
            return 0;
        }
        if (numCastles == 1) {
            return treasures[0];
        }

        int[] maxTreasureWithFirst = new int[treasures.length];
        maxTreasureWithFirst[0] = treasures[0];
        maxTreasureWithFirst[1] = Math.max(maxTreasureWithFirst[0], treasures[1]);
        for (int i = 2; i < numCastles - 1; i++) {
            maxTreasureWithFirst[i] = Math.max(maxTreasureWithFirst[i - 1], maxTreasureWithFirst[i - 2] + treasures[i]);
        }

        int[] maxTreasureWithoutFirst = new int[treasures.length];
        maxTreasureWithoutFirst[0] = 0;
        maxTreasureWithoutFirst[1] = treasures[1];
        for (int i = 2; i < numCastles; i++) {
            maxTreasureWithoutFirst[i] = Math.max(maxTreasureWithoutFirst[i - 1],
                    maxTreasureWithoutFirst[i - 2] + treasures[i]);
        }

        return Math.max(maxTreasureWithFirst[numCastles - 2], maxTreasureWithoutFirst[numCastles - 1]);
    }
}
