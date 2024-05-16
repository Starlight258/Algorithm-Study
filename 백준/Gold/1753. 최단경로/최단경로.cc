#include <bits/stdc++.h>
using namespace std;

int a,b,n,u,w,v;
vector<pair<int,int>> adj[20004];
int dist[20004];
const int INF = 987654321;
priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(NULL); cout.tie(NULL);
    //1. 입력받기
    cin >> a >> b; //정점의 개수, 간선의 개수
    cin >> n; //시작 정점의 번호
    fill(dist, dist+20004,INF); //거리 INF로
    for(int i=0;i<b;i++){
        cin >> u >> v >> w;
        adj[u].push_back(make_pair(w,v)); //u->v, 가중치 w, 인접정점
    }
    //2. 우선순위 큐 수행
    pq.push({0,n}); //가중치 0, 시작위치
    dist[n]=0; //시작정점의 거리는 0
    while(pq.size()){
        int here = pq.top().second; //위치
        int here_dist = pq.top().first; //거리
        pq.pop();
        if(dist[here] != here_dist) continue;
        //인접한 점에 대해
        for(pair<int,int> there:adj[here]){
            int _dist = there.first;
            int _there = there.second;
            //거리 작은 걸로 업데이트
            if(dist[_there]>dist[here]+_dist){
                dist[_there]=dist[here]+_dist;
                pq.push({dist[_there], _there});
            }
        }
    }
    //2. 출력
    for(int i=1;i<=a;i++){
        if(dist[i]==INF) cout << "INF\n";
        else cout << dist[i]<<"\n";
    }
    return 0;
}