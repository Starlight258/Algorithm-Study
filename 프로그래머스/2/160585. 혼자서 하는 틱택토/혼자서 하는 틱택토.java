class Solution {
    int checkWin(Character[][] mp, char c){
        // 가로
        int cnt = 0;
        for (int i=0;i<3;i++){
            if (mp[i][0] == c && mp[i][0] == mp[i][1] && mp[i][1]==mp[i][2]){
                cnt++;
            }
        }
        // 세로
        for (int i=0;i<3;i++){
            if (mp[0][i] == c && mp[0][i] == mp[1][i] && mp[1][i]==mp[2][i]){
                cnt++;
            }
        }
        // 대각선
        if (mp[0][0] == c && mp[0][0] == mp[1][1] && mp[1][1]==mp[2][2]) cnt++;
        if (mp[2][0] == c && mp[2][0] == mp[1][1] && mp[1][1] == mp[0][2]) cnt++;
        
        if (cnt>=1) return 1; // 우승함
        return 0; // 우승 안함
    }
    
    public int solution(String[] board) {
        int answer = 1;
        int ocnt = 0; int xcnt=0;
        //1. 판 만들기
        Character[][] mp = new Character[3][3];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<3;j++){
                mp[i][j] = board[i].charAt(j);
                if (mp[i][j] == 'O') ocnt++;
                if (mp[i][j] == 'X') xcnt++;
            }
        }
        if(ocnt==0 && xcnt==0) return 1;
        // 1번
        if (ocnt < xcnt || ocnt-xcnt>1) return 0;
        if ((ocnt+xcnt) % 2 ==0 && ocnt!=xcnt){
            return 0;
        }
        // 2번
        int c1 = checkWin(mp, 'O');
        int c2 = checkWin(mp, 'X');
        if (c1==1 && c2==1) return 0; // 둘 다 우승
        // 한명만 우승(1)했거나 둘 다 우승안했을 경우(0)
        if (c1==1){ // O 우승
            if (ocnt<=xcnt) return 0;
        }
        if (c2==1){ // X 우승
            if (ocnt>xcnt) return 0;
        }
        // 둘 다 우승안했을 경우
        return answer;
    }
}