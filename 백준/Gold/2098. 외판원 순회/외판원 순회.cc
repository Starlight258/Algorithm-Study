#include <bits/stdc++.h>
#define MAX_N 16
using namespace std;

const int INF = 987654321;
int n, dp[MAX_N][1<<MAX_N], dist[MAX_N][MAX_N];

int tsp(int here, int visited){
    if(visited==(1<<n)-1){ //모두 방문하면 출발점으로 돌아오는 거리 리턴
        return dist[here][0] ? dist[here][0] : INF;
    }
    //현재 경로 비용 저장되어있으면
    int &ret = dp[here][visited];
    if(ret!=-1) return ret; //값 있으면 리턴
    ret = INF; //최소값을 구하기 위해 INF로 설정
    for(int i=0;i<n;i++){ //n개의 도시 방문
        if(visited & (1<<i)) continue; //이미 방문했으면 
        if(dist[here][i]==0) continue; //거리가 없으면 continue
        ret = min(ret, tsp(i, visited|(1<<i)) + dist[here][i]);
    }
    return ret;
}
int main(){
    ios_base::sync_with_stdio(0); cin.tie(NULL); cout.tie(NULL);
    //1. 입력받기
    cin >> n;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin >> dist[i][j]; //거리 입력받기 i->j
        }
    }
    //2. dp수행하기
    memset(dp, -1, sizeof(dp)); //초기화
    cout << tsp(0,1)<<"\n"; //회판원 순회 (0부터 시작)
}