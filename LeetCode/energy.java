class Solution {
    public int solution(int targetDepth, int targetIndex, int[][] energyMatrix) {
        int rows = energyMatrix.length;
        int cols = energyMatrix[0].length;

        int[][] minEnergy = new int[rows][cols];
        for (int j = 0; j < cols; j++) {
            minEnergy[0][j] = energyMatrix[0][j];
        }

        if (targetDepth == 0) {
            return minEnergy[targetDepth][targetIndex];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    minEnergy[i][j] = energyMatrix[i][j] + Math.min(minEnergy[i - 1][j], minEnergy[i - 1][j + 1]);
                } else if (j == cols - 1) {
                    minEnergy[i][j] = energyMatrix[i][j] + Math.min(minEnergy[i - 1][j - 1], minEnergy[i - 1][j]);
                } else {
                    minEnergy[i][j] = energyMatrix[i][j] + Math.min(minEnergy[i - 1][j],
                            Math.min(minEnergy[i - 1][j - 1], minEnergy[i - 1][j + 1]));
                }
            }
        }

        return minEnergy[targetDepth][targetIndex];
    }
}
