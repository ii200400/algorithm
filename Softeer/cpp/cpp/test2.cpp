// n이 1만이니 완전탐색은 완전 아니고
// 왠지 모르게 이진탐색이 생각나는데 왜 인지 모르겠고..
// 우선 a와 b 각각에서 가장 작은.. 수를 선택하면 안되고.. (예제2)

// 각 입력을 받아오면서.. 나무블록의 가장 긴 변들 중에서 가장 작은 수를 뽑고 
// 그 수를 기준으로 최대한 적게 손실이 일어나도록 만들면? 될 것 같다...? 
// 예제2를 다시보니! 만들어지는 직사각형이 무조건 모든 나무블록을 사용해서 만드는 것이 아니었다!
// 세상에? 이진탐색이 맞네? 뭐야 어떻게 알았지? ㅇㅁㅇ????

// 진행하다보니 이진탐색이 아님을 알았다. set을 활용해서 후보인 것들을 고르고 모두 계산하는 방식으로 해보겠다.
// unordered_set을 사용해도 될 것 같긴한데..? 일단 한다.

#include <iostream>
#include <string>
#include <vector>
#include <set>

using namespace std;

long long solution(int n, vector<int> a, vector<int> b) {
    // 모든 나무블록의 길이가 직사각형의 세로 길이 후보(canBe!)라고 생각한다.
    set<int> canBe;
    for (int i = 0; i < n; i++) {
        canBe.insert(a[i]);
        canBe.insert(b[i]);
    }

    // 직사각형의 세로 길이(length) 후보와 직사각형의 크기
    long long answer = 0;
    
    for (int length : canBe) {
        long long boxSize = 0;

        cout << "length : " << length << " ";
        for (int i = 0; i < n; i++) {
            if (a[i] >= length) {
                // 둘 모두 직사각형의 세로 길이보다 크다면 더 작은 수를 수직으로 해서 이어붙인다.
                // 즉, 직사각형이 더 커지려면 더 큰 수를 수평으로 해주어야 한다.
                if (b[i] >= length) {
                    cout << " + " << length * std::max(a[i], b[i]) << " ";
                    boxSize += length * std::max(a[i], b[i]);
                } // 한 변만 길다면 그 변을 수직으로 해서 이어붙인다. (더 작은 수가 수평으로 붙여진다.)
                else {
                    cout << " + " << length * b[i] << " ";
                    boxSize += length * b[i];
                }
            } // 한 변만 길다면 그 변을 수직으로 해서 이어붙인다.
            else if (b[i] >= length) {
                cout << " + " << length * a[i] << " ";
                boxSize += length * a[i];
            }
            // 두 변 모두 직사각형의 세로 길이보다 작다면 그 블록은 버린다.
            // 정확히는 버리는 것이 아니라 한꺼번에 오른쪽 혹은 왼쪽에 두어 만들 직사각형에 포함시키지 않도록 만드는 것
        }
        cout << endl;

        if (boxSize > answer) {
            answer = boxSize;
        }
    }

    return answer;
}

void main() {
    long long ans = solution(4, vector<int> {3, 2, 4, 2}, vector<int> {3, 1, 7, 5});
    cout << ans << endl;
}