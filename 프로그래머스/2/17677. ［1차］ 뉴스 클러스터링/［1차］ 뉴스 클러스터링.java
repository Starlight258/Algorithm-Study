import java.util.*;
import java.util.regex.*;

class Solution {
    private final String REGEX = "[a-z]+";
    private final Pattern PATTERN = Pattern.compile(REGEX);
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> words1 = findWords(str1);
        List<String> words2 = findWords(str2);
        double rate = calculateJaccard(words1, words2);
        return  (int) (rate * 65536);
    }
    
    private List<String> findWords(String str){
        List<String> words = new ArrayList<>();
        for (int i=0;i<str.length()-1;i++){
            String word = str.substring(i, i+2).toLowerCase();
            if (Pattern.matches(REGEX, word)){
                words.add(word);   
            };
        }
        return words;
    }
    private double calculateJaccard(List<String> words1, List<String> words2){
        if (words1.isEmpty() && words2.isEmpty()){
            return 1.0;
        }
        Map<String, Integer> counts1 = new HashMap<>();
        for (String word:words1){
            counts1.put(word, counts1.getOrDefault(word, 0)+1);
        }
        Map<String, Integer> counts2 = new HashMap<>();
        for (String word:words2){
            counts2.put(word, counts2.getOrDefault(word, 0)+1);
        }
        
        int intersection = 0;
        int union = 0;
        Set<String> allKeys = new HashSet<>(counts1.keySet());
        allKeys.addAll(counts2.keySet());
        
        for (String key:allKeys){
            int count1 = counts1.getOrDefault(key, 0);
            int count2 = counts2.getOrDefault(key, 0);
            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }
   
        return (double)intersection / union;
        
    }
    private List<String> getIntersection(Map<String, Integer> counts1, Map<String, Integer> counts2){
        List<String> intersection = new ArrayList<>();
        for (String key:counts1.keySet()){
            if (counts2.containsKey(key)){
                int minValue = Math.min(counts1.get(key), counts2.get(key));
                for (int i=0;i<minValue;i++){
                    intersection.add(key);                    
                }
            }
        }
        return intersection;
    }
    
}