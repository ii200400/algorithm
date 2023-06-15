// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=1529
// 제출 링크 : 
// 소프티어 출퇴근길

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
제약조건상 희소행렬로 진행을 해주어야 메모리 초과가 일어나지 않을 것 같다.
그리고 큐를 활용한 BFS를 출근지/퇴근지부터 시작해서 
퇴근지/출근지는 이미 방문했다고 처리하고 탐색할 수 있는 모든 정점을 기록하면서 진행할 것이다.
그리고 두 탐색 과정에서 겹치는 정점을 세면 될 것 같다.

-- 1차 --
생각해보니 막다른 길에서는 경로가 생길 수 없는데 내가 사용한 방식에서는 생긴다고 가정해버린다.
bfs를 dfs로 바꾸고 경로가 생길 수 있는지 확인할 수 있도록 구현을 바꾸겠다.

다시 생각해보니 정말 생각없이 코드를 구상했다. 의욕이 없어서 그런듯하다.

계속 생각해보니 dfs 좀 아닌 것 같다. 
입력받은 간선으로 집에서 특정 노드까지 갈 수 있는지, 입력받은 간선의 방향으로 반대로해서 특정 노드에서 회사까지 갈 수 있는지
를 보아서 집에서 회사까지 특정 노드를 거치는지 확인하고
반대로 회사에서 집까지도 같은 방법으로 노드를 거치는지 확인하는 방식으로
진행해보아야겠다.

-- 2, 3차 --
뭘까..? 이론은 맞는 것 같은데.. 오답이 생긴다.
정말 모르겠어서 알고튜더 라는 것을 봤더니.. 과정이 같잖아아아흟긇긓긓긇ㄱ흑ㄺㄹ르
왜지감자..

*/

#include <iostream>
#include <queue>
#include <vector>
using namespace std;

// 정점 수, 간선 수
int n, m;
// bfs에 사용할 큐
queue<int> q;

void bfs(bool* visited, vector<int>* edges) {
	while (!q.empty()) {
		int node = q.front();
		q.pop();

		for (int toNode : edges[node]) {

			// 이미 방문했었다면 생략
			if (visited[toNode]) continue;

			visited[toNode] = true;
			q.push(toNode);
		}
	}
}

int main() {
	// 노드, 간선 수 입력
	cin >> n >> m;

	// 정점 숫자가 1부터 시작하므로 편의사 n+1의 크기로 설정
	// 방문배열 / 회사, 집에서 2번 탐색해야하기 때문에 2개
	bool* visitedToW = new bool[n + 1];
	bool* visitedToH = new bool[n + 1];
	for (int i = 1; i < n + 1; i++) {
		visitedToW[i] = false;
		visitedToH[i] = false;
	}

	// 간선 이중리스트 (방문배열과 같은 이유로 2개)
	vector<int>* edges = new vector<int>[n + 1];
	vector<int>* edgesReverse = new vector<int>[n + 1];

	// 집, 회사 위치
	int temp1, temp2;

	// 간선 초기화
	for (int i = 0; i < m; i++) {
		cin >> temp1 >> temp2;
		edges[temp1].push_back(temp2);
		edgesReverse[temp2].push_back(temp1);
	}

	// 집과 회사 노드
	cin >> temp1 >> temp2;

	// 집 혹은 회사에서 특정노드까지 갈 때 특정노드가 경로상에 있는지 확인하기 위한 방문배열
	bool* visited = new bool[n + 1];
	bool* visitedReverse = new bool[n + 1];
	for (int i = 0; i < n + 1; i++) {
		visited[i] = false;
		visitedReverse[i] = false;
	}

	// 집에서 갈 수 있는 노드들
	// 집에서 각 노드까지, 간선의 방향을 반대로 하고 회사에서 각 노드까지 방문배열을 만들고
	// 두 방문배열 모두 방문한 곳이 집에서 회사까지 경로상에 존재할 수 있는 노드이다.
	visited[temp1] = true;
	visited[temp2] = true;
	q.push(temp1);
	bfs(visited, edges);

	visitedReverse[temp1] = true;
	visitedReverse[temp2] = true;
	q.push(temp2);
	bfs(visitedReverse, edgesReverse);

	cout << "To Work" << endl;
	for (int i = 1; i < n + 1; i++) {
		cout << visited[i] << ' ' << visitedReverse[i] << endl;
		if (visited[i] && visitedReverse[i])
			visitedToW[i] = true;
	}

	// 회사에서 시작해서 집까지 방문할 수 있는 노드 탐색
	for (int i = 0; i < n + 1; i++) {
		visited[i] = false;
		visitedReverse[i] = false;
	}

	visited[temp1] = true;
	visited[temp2] = true;
	q.push(temp2);
	bfs(visited, edges);
	
	visitedReverse[temp1] = true;
	visitedReverse[temp2] = true;
	q.push(temp1);
	bfs(visitedReverse, edgesReverse);

	cout << "Tohome" << endl;
	for (int i = 1; i < n + 1; i++) {
		cout << visited[i] << ' ' << visitedReverse[i] << endl;
		if (visited[i] && visitedReverse[i])
			visitedToH[i] = true;
	}

	// 정답 계산 후 출력
	int answer = 0;
	cout << "result" << endl;
	for (int i = 1; i < n + 1; i++) {
		cout << visitedToW[i] << ' ' << visitedToH[i] << endl;
		if (visitedToH[i] == 1 && visitedToW[i] == 1)
			answer++;
	}

	// 집과 회사는 제외해야하므로 -2
	cout << answer - 2;

	// 메모리 해제
	delete visited, visitedReverse, visitedToW, visitedToW, edges;

	return 0;
}