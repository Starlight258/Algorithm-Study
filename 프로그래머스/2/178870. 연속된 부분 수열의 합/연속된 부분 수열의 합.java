class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0; int right = -1;
        int length = 1000001;
        int sLeft = 0; int sRight = 0;
        int sum = 0;
        while (right<sequence.length){
            if (sum==k){
                if (right - left<length){
                    sLeft = left;
                    sRight = right;
                    length = right - left;
                }
                sum -= sequence[left++];
            }
            else if (sum<k){
                if (++right < sequence.length) sum += sequence[right];
            } else {
                sum -= sequence[left++];
            } 
        }
        return new int[]{sLeft, sRight};
    }
}