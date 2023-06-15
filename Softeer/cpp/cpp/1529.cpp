// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=1529
// ���� ��ũ : 
// ����Ƽ�� ����ٱ�

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
�������ǻ� �����ķ� ������ ���־�� �޸� �ʰ��� �Ͼ�� ���� �� ����.
�׸��� ť�� Ȱ���� BFS�� �����/��������� �����ؼ� 
�����/������� �̹� �湮�ߴٰ� ó���ϰ� Ž���� �� �ִ� ��� ������ ����ϸ鼭 ������ ���̴�.
�׸��� �� Ž�� �������� ��ġ�� ������ ���� �� �� ����.

-- 1�� --
�����غ��� ���ٸ� �濡���� ��ΰ� ���� �� ���µ� ���� ����� ��Ŀ����� ����ٰ� �����ع�����.
bfs�� dfs�� �ٲٰ� ��ΰ� ���� �� �ִ��� Ȯ���� �� �ֵ��� ������ �ٲٰڴ�.

�ٽ� �����غ��� ���� �������� �ڵ带 �����ߴ�. �ǿ��� ��� �׷����ϴ�.

��� �����غ��� dfs �� �ƴ� �� ����. 
�Է¹��� �������� ������ Ư�� ������ �� �� �ִ���, �Է¹��� ������ �������� �ݴ���ؼ� Ư�� ��忡�� ȸ����� �� �� �ִ���
�� ���Ƽ� ������ ȸ����� Ư�� ��带 ��ġ���� Ȯ���ϰ�
�ݴ�� ȸ�翡�� �������� ���� ������� ��带 ��ġ���� Ȯ���ϴ� �������
�����غ��ƾ߰ڴ�.

-- 2, 3�� --
����..? �̷��� �´� �� ������.. ������ �����.
���� �𸣰ھ �˰�Ʃ�� ��� ���� �ô���.. ������ ���ݾƾƾ�Ł�J�R�R�J���椪����
��������..

*/

#include <iostream>
#include <queue>
#include <vector>
using namespace std;

// ���� ��, ���� ��
int n, m;
// bfs�� ����� ť
queue<int> q;

void bfs(bool* visited, vector<int>* edges) {
	while (!q.empty()) {
		int node = q.front();
		q.pop();

		for (int toNode : edges[node]) {

			// �̹� �湮�߾��ٸ� ����
			if (visited[toNode]) continue;

			visited[toNode] = true;
			q.push(toNode);
		}
	}
}

int main() {
	// ���, ���� �� �Է�
	cin >> n >> m;

	// ���� ���ڰ� 1���� �����ϹǷ� ���ǻ� n+1�� ũ��� ����
	// �湮�迭 / ȸ��, ������ 2�� Ž���ؾ��ϱ� ������ 2��
	bool* visitedToW = new bool[n + 1];
	bool* visitedToH = new bool[n + 1];
	for (int i = 1; i < n + 1; i++) {
		visitedToW[i] = false;
		visitedToH[i] = false;
	}

	// ���� ���߸���Ʈ (�湮�迭�� ���� ������ 2��)
	vector<int>* edges = new vector<int>[n + 1];
	vector<int>* edgesReverse = new vector<int>[n + 1];

	// ��, ȸ�� ��ġ
	int temp1, temp2;

	// ���� �ʱ�ȭ
	for (int i = 0; i < m; i++) {
		cin >> temp1 >> temp2;
		edges[temp1].push_back(temp2);
		edgesReverse[temp2].push_back(temp1);
	}

	// ���� ȸ�� ���
	cin >> temp1 >> temp2;

	// �� Ȥ�� ȸ�翡�� Ư�������� �� �� Ư����尡 ��λ� �ִ��� Ȯ���ϱ� ���� �湮�迭
	bool* visited = new bool[n + 1];
	bool* visitedReverse = new bool[n + 1];
	for (int i = 0; i < n + 1; i++) {
		visited[i] = false;
		visitedReverse[i] = false;
	}

	// ������ �� �� �ִ� ����
	// ������ �� ������, ������ ������ �ݴ�� �ϰ� ȸ�翡�� �� ������ �湮�迭�� �����
	// �� �湮�迭 ��� �湮�� ���� ������ ȸ����� ��λ� ������ �� �ִ� ����̴�.
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

	// ȸ�翡�� �����ؼ� ������ �湮�� �� �ִ� ��� Ž��
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

	// ���� ��� �� ���
	int answer = 0;
	cout << "result" << endl;
	for (int i = 1; i < n + 1; i++) {
		cout << visitedToW[i] << ' ' << visitedToH[i] << endl;
		if (visitedToH[i] == 1 && visitedToW[i] == 1)
			answer++;
	}

	// ���� ȸ��� �����ؾ��ϹǷ� -2
	cout << answer - 2;

	// �޸� ����
	delete visited, visitedReverse, visitedToW, visitedToW, edges;

	return 0;
}