import java.util.*;

class Solution {
    
    private static List<Character> alphabets;
    private List<List<String>> menus;
    
    public String[] solution(String[] orders, int[] courses) {
        Set<Character> alphabetForUnique = new HashSet<>();
        for (String order:orders){
            for (char c:order.toCharArray()){
                alphabetForUnique.add(c);
            }
        }
        alphabets = new ArrayList<>(alphabetForUnique);
        Collections.sort(alphabets);
        
        // 1. 모든 조합 만들기
        menus = new ArrayList<>();
        List<Map<String, Integer>> combs = new ArrayList<>();
        for (int course:courses){
            menus.add(new ArrayList<>());
            combs.add(new HashMap<>());
            makeMenu(course, 0, "", menus.get(menus.size()-1));
        }

        // 2. 조합 개수 구하기
        for (String order:orders){
            for (int i=0;i<menus.size();i++){
                for (String menu:menus.get(i)){
                    boolean isValid = true;
                    for (char c:menu.toCharArray()){
                        if (order.indexOf(c)==-1) {
                            isValid = false;
                            break;
                        }
                    }
                    if (isValid){
                    combs.get(i).put(menu, combs.get(i).getOrDefault(menu, 0) + 1);
                }
                }
            }
        }
        // 3. value 순으로 내림차순 정렬하기
        List<String> answers = new ArrayList<>();
        for (int i=0;i<combs.size();i++){
            int max = 2;
            for (Map.Entry<String, Integer> entry:combs.get(i).entrySet()){
                if (entry.getValue()>=max){
                    max = entry.getValue();
                }
            }
            if (max>=2){
                for (Map.Entry<String, Integer> entry:combs.get(i).entrySet()){
                    if (entry.getValue()==max){
                        answers.add(entry.getKey());
                    }
                }
            }
        }
        
        // 3. 가장 많이 주문한 조합 구하기 + 오름차순 정렬
        Collections.sort(answers);
        return answers.toArray(new String[0]);
    }
    
    private void makeMenu(int count, int depth, String key, List<String> menu){
        if (key.length()==count){
            menu.add(key);
            return;
        }
        if (depth>=alphabets.size()) return;
        makeMenu(count, depth+1, key+alphabets.get(depth), menu);
        makeMenu(count, depth+1, key, menu);
    }
}