#include <bits/stdc++.h>
using namespace std;

int n,m,a[300004], mm, ret=987654321;
int main(){
    ios_base::sync_with_stdio(0); cin.tie(NULL); cout.tie(NULL);
    //1. 입력받기
    cin >> n >> m;
    for(int i=0;i<m;i++){
        cin >> a[i];
        mm = max(a[i],mm); //총 보석 개수
    }
    //2. 이분탐색 수행 : 그룹으로 쪼개기
    int l=1; int r=mm;
    int mid=0;
    while(l<=r){
        mid = (l+r)/2; //나눌 보석 수
        int cnt=0;
        for(int i=0;i<m;i++){
            cnt += a[i]/mid;
            if(a[i]%mid) cnt++;
        }
        if(cnt<=n){ //묶음이 더 작으면(mid가 크면)
            r=mid-1; //
            ret = min(ret, mid);
        } else l=mid+1;
    }
    //3. 정답 출력
    cout << ret;


}