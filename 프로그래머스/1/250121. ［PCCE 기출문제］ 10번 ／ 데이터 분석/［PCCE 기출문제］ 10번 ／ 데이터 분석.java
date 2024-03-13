import java.util.Arrays;


class Solution {
    public int getIndex(String columnName){
        switch(columnName){
            case "code": 
                return 0;
            case "date":
                return 1;
            case "maximum":
                return 2;
            case "remain":
                return 3;
            default: 
                return 0;
        }
    }
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIndex = getIndex(ext);
        int sortByIndex = getIndex(sort_by);
        
        return Arrays.stream(data)
            .filter(row -> row[extIndex] < val_ext)
            .sorted((row1, row2) -> row1[sortByIndex] - row2[sortByIndex])
            .toArray(int[][]::new);
    }
}