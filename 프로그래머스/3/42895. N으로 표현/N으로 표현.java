import java.util.*;
class Solution {
    public int solution(int N, int number) {
        if (N==number) return 1;
        // 1. N이 커질때 가능한 숫자 생성하기
        ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
        for (int i=0;i<9;i++){
            list.add(new HashSet<Integer>());
        }
        list.get(1).add(N);
        for (int i=2;i<=8;i++){ 
            list.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            // 2. 숫자 만들기 
            for (int j=1;j<i;j++){
                for (int x:list.get(j)){
                    for (int y:list.get(i-j)){
                        list.get(i).add(x+y);
                        list.get(i).add(x-y);
                        list.get(i).add(x*y);
                        if (y!=0) list.get(i).add(x/y);
                    }
                }
            }
            if (list.get(i).contains(number)){
                return i;
            }
        }
        return -1;
    }
}