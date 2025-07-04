#include <bits/stdc++.h>
using namespace std;

int n, a[1004], cnt[1004], ret;
int main(){
    ios_base::sync_with_stdio(0); cin.tie(NULL); cout.tie(NULL);
    //1. 입력받기
    cin >> n;
    for(int i=0;i<n;i++) cin>>a[i];
    //2. 증가하는 부분수열의 길이 구하기
    for(int i=0;i<n;i++){
        int maxValue=0;
        for(int j=0;j<i;j++){
            if(a[j]<a[i] && maxValue<cnt[j]) maxValue=cnt[j];
        }
        cnt[i] = ++maxValue;
        ret = max(cnt[i],ret) ;
    }
    //3. 정답 출력하기
    cout << ret;

}
