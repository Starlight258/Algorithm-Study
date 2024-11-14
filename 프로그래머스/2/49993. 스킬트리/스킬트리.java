class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String tree:skill_trees){
            String concat = tree.replaceAll("[^"+skill+"]", "");
            if (skill.startsWith(concat)) answer++;
        }
        return answer;
    }
}