class Solution {
    char[] wordArray= {'A', 'E', 'I', 'O', 'U'};
    int count = 0;
    boolean flag = false;
    int dfs(StringBuilder word, int depth, String target){
        if (depth>5) return -1; 
        if (word.toString().equals(target)){
            flag = true;
            return count;
        } 
        count++;
        for (int i=0;i<5 && !flag;i++){
            dfs(word.append(wordArray[i]), depth+1, target);
            word.deleteCharAt(word.length()-1);
        }
        return count;
    }
    public int solution(String target) {
        int answer = 0;
        answer = dfs(new StringBuilder(), 0, target);
        return answer;
    }
}