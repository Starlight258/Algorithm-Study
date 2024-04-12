#include <bits/stdc++.h>
using namespace std;
int t,w,a[1004], dp[1004][2][34];

int go(int idx, int tree, int cnt){
    if(cnt<0) return -1e9;
    if(idx==t) return 0;
    int &ret = dp[idx][tree][cnt];
    if(~ret) return ret;
    return ret = max(go(idx+1, tree, cnt), go(idx+1, tree^1, cnt-1)) + (tree==a[idx]-1);
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(NULL); cout.tie(NULL);
    memset(dp, -1, sizeof(dp));
    //1. 입력하기
    cin >> t >> w; //t초 w번
    for(int i=0;i<t;i++) cin >> a[i];
    //2. dp 수행
    cout << max(go(0,0,w), go(0,1,w-1)) << "\n";
}
