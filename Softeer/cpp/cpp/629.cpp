// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=629
// 제출 링크 : 
// 소프티어 로드 밸런서 트래픽 예측

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
... 문제 좀 각색해서 이해하기 쉽게끔 만들거나 아니면 변수를 잘 설명하거나 둘 중 하나 해주시면 좋겠는데..
설명이 확실하게 부족해서 유추를 하면서 읽어야 한다;;
어후.. 아무래도 pi,j가 n이 i인 서버와 j인 서버의 간선을 의미하는 것 같다. 
이해가 덜 되어서 pi와 j인줄;; 입력형식에서도 똑같이 당했..

N이 서버의 수
K가 요청 수
rn은 분산가능한 서버 수, 각 서버가 워커노드인지 로드벨런서인지 구별하고 xi 값을 계산할 때도 쓰인다.
xi rn에 연결된 서버가 다음 서버로 트래픽을 전달할 때, 어떤 서버로 전달할지 정하는 변수
	'(xi mod ri)+1'는 연결된 순서대로 전달한다는 의미이다.
pi,j ri에서 연결된 rj 서버로 연결된 간선을 의미

.. 각 서버마다 동적할당으로 배열을 만들어서 전송을 반복하는 방식으로 진행하면 될 것 같다.
문제이해가 2배는 더 걸린 것 같다;

1,2차
Aㅏ;; 범위보고 int 넘는 것은 봤는데 까먹어서 한참 해맷다;; 하지만 어림없이 시간체한 초과 당하였다!
하나씩 진행해서 시간초과 난것 같은데.., 
어차피 수식으로 다음 서버에 보낼 요청 수를 계산할 수 있으니 그것을 활용해보아야겠다.
연결된 서버를 1번씩만 탐색해서 계산하면 되는데 dfs가 구현하기 개인적으로 더 편해서 그것으로 하겠다.

3, 4차
어우; 위의 알고리즘 구조를 생각해보니 한번 탐색한 곳을 다시 탐색하는 경우가 많았다.
한 서버와 연결된 다른 서버의 수가 많을수록 더 심한데 이것 때문에 시간초과가 더 많이 생기는 것 같다.
이번에는 반대로 rn이 0인 작업 노드인 곳부터 탐색하면서 서버의 요청수를 한번에 계산할 수 있도록 만들어보겠다.

5차
시간초과는 나오지 않았으나 오답이 있었다. 다른 어떤 코드보다도 통과한 테스트케이스는 많았으니 진전이라고 생각한다.
문제는 오답의 이유인데.. 곤란하다.. 이유를 잘 모르겠다.. 문제를 잘못이해했거나 특정 코드에 작은 실수가 있거나같은데..

어머나 세상에나 ri와 pi,j를 이해하는데 너무 힘들었어서 중간에 들어간 '1 ≤ j ≤ ri'조건을 간과했다.
사진과 코딩하면서 이해를 했으니 어쩔 수 없다. 다음에 나오면 그냥 틀리던가 해야지;;
로직은 틀리지 않은 것 같고 입력방식만 조금 바꾸면 될 것 같다.

6차 중
음? 입력이 아니라.. 알고리즘이 틀렸나..? 같은 부분을 또 틀렸다.
찾아보니 위상정렬을 사용하라고 하는데.. 패스한다. 시간을 이미 너무 많이 들였다.
*/

#include <iostream>
#include <stack>
using namespace std;

class Server {
public:
	// 트래픽을 보낼 수 있는 서버 수
	int r;
	//서버에 요청이 온 회수
	long long requestCnt = -1;
	// 해당 서버에 트래픽을 보내는 서버와 그때의 순서를 저장한다.
	stack<int*> edges;
};

// 서버 정보, 현재 탐색중인 서버 인덱스
void dfs(Server* server, int serverIdx);

int main() {
	// 서버의 수 , 요청의 수
	int n;
	long long k;
	cin >> n >> k;

	// 서버별 정보 (서버 숫자가 1부터 시작하므로 +1)
	Server* server = new Server[n+1];

	// 서버 정보 초기화, 작업노드는 따로 저장해둔다.
	stack<int> workNode;
	for (int i = 1; i <= n; i++)
	{
		int r;
		cin >> r;
		server[i].r = r;

		int edgeIdx, j = 0;
		for (int j = 0; j < r; j++) {
			cin >> edgeIdx;
			int* temp = new int[2] {i, j};
			server[edgeIdx].edges.push(temp);
		}

		if (server[i].r == 0)
		{
			workNode.push(i);
		}
	}

	/*for (int i = 1; i <= n; i++) {
		cout << i << ' ' << server[i].r << ' ' << server[i].edges.size() << endl;
	}*/

	// 요청은 처음에 무조건 서버 1로, 서버 1은 k번 요청하는 것을 알고 있으므로
	server[1].requestCnt = k;
	for (int i = workNode.size()-1; i >= 0 ; i--) {
		dfs(server, workNode.top());
		workNode.pop();
	}

	// 각 서버별로 요청을 받은 회수 출력
	for (int i = 1; i <= n; i++) {
		cout << server[i].requestCnt << ' ';
	}

	return 0;
}

// 모든 서버를 돌면서 요청이 얼마나 들어가는지 계산한다.
void dfs(Server* server, int serverIdx) {
	// 연결되어있는 서버들의 요청수를 계산해서 초기화해준다.
	int size = server[serverIdx].edges.size();
	int requestCnt = 0;
	for (int i = 1; i <= size; i++)
	{
		int* edge = server[serverIdx].edges.top();
		server[serverIdx].edges.pop();
		//cout << serverIdx<< ':'<< i << ' ' << edge[0] << ' ' << edge[1] << endl;
		if (server[edge[0]].requestCnt == -1) {
			dfs(server, edge[0]);
		}

		// 어흑.. 요청을 보낸 서버가 현 서버에 얼마나 요청을 보냈는지 계산하는 건데 너무 복잡하게 되서 슬프다.
		requestCnt += server[edge[0]].requestCnt / server[edge[0]].r +
			((server[edge[0]].requestCnt % server[edge[0]].r >= edge[1]) ? 1 : 0);
	}

	server[serverIdx].requestCnt = requestCnt;
}
