#include <bits/stdc++.h>
using namespace std;
string str;
char buf;
int buflag, chflag, cnt;
bool vflag, goodword;
int main(){
    //1. 입력받기
    while(cin >> str){
        if(str=="end") break;
        buf=' '; //기본값
        goodword=true; //기본값
        vflag=chflag=false;
        cnt=0;
        //2. 좋은 비밀번호 조건 체크하기
        for(char c:str){
            //2-1. 모음 포함 여부
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
                vflag=true;
                chflag=1; //모음이면 1
            }
            else {
                chflag=2; //자음이면 2
            }
            //2-2. 모음 or 자음 연속 3번인지 확인
            if(buf==' '); //첫 단어는 pass
            else{
                //모음 or 자음 3번 연속인지 확인
                if(buflag==chflag){
                    cnt++;
                    if(cnt==2) { //연속 3개 단어
                        goodword=false;
                        break;
                    } 
                }
                else{cnt=0;}         
                //2-3.같은 글자 연속인지 확인, ee또는 oo는 제외
                if(c==buf && (c!='e' && c!='o')){
                    goodword=false;
                    break;
                }
            }
            buf=c;
            buflag=chflag;
        }
        //3. 출력하기
        if(vflag && goodword) cout << "<" << str << "> is acceptable.\n";
        else cout << "<" << str << "> is not acceptable.\n";
    }
}
