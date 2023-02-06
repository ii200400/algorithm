// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=411
// ���� ��ũ : 
// ����Ƽ�� ���� �׽�Ʈ ���� ����

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
Ž�������� ���δ�. dfs�� bfs�� �ذ��ϸ� �� �� ������..
dfs�� �ذ��غ��ڴ�.

�߰��� Ʋ���� �������� ����غ���.. 
do-while ������ �ۼ��ؼ� ������ ���� ���� �ð��� �ּ� 1���̻����� ��µǴ� ���� ���÷ȴ�.
�̰͸� ��ġ�� �¾Ҵ�! ��ȣ~
*/

#include <iostream>
using namespace std;

// ȭ���� ����, ���� ũ��, ���� ��
int n, m, cnt;
// ��, �湮����
int** map;
bool** visited;

// ���� Ž��
void dfs(int r, int c);
int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

int main() {
	cin >> n >> m;

	// ��, �湮 ���� �ʱ�ȭ
	map = new int* [n];
	visited = new bool* [n];
	
	for (int i = 0; i < n; i++)
	{
		map[i] = new int[m];
		visited[i] = new bool[m];
		for (int j = 0; j < m; j++)
		{
			cin >> map[i][j];
			if (map[i][j] == 1)
				cnt++;
		}
	}

	// �ð��� �����ϴ� ����
	int time = 0;
	// ������ ���� ���������� �ݺ��Ѵ�.
	while (cnt > 0) {
		// �湮���� �ʱ�ȭ
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				visited[i][j] = false;
			}
		}

		// ������ ��� ���� Ž���Ѵ�.
		dfs(0, 0);
		time++;
	}

	cout << time << endl;

	// �Ҵ� ����
	for (int i = 0; i < n; i++)
	{
		delete[] map[i];
	}
	delete[] map;

	return 0;
}

void dfs(int r, int c) {
	// 4������ Ž���ϸ鼭
	int dr, dc;
	for (int i = 0; i < 4; i++) {
		dr = r + dir[i][0], dc = c + dir[i][1];
		// ���� Ž���� ���� �� ���� �Ѿ�� �н�
		if (dr < 0 || n <= dr)
			continue;
		if (dc < 0 || m <= dc)
			continue;

		// ������ �ִ� ����ε�
		if (map[dr][dc] == 1)
		{
			// 2��° �湮(����� 2�� ����)�̸� ������ ������� �� �� �ִ�.
			if (visited[dr][dc]) {
				map[dr][dc] = 0;
				cnt--;
			}
			else { // ������ ����� 1�� �����̶�� �ϴ� �湮ó���� �صд�.
				visited[dr][dc] = true;
			}
		}
		// ������ ���� ����ε� �湮���� �ʾҴٸ� Ž������
		else if(!visited[dr][dc]) {
			visited[dr][dc] = true;
			dfs(dr, dc);
		}
	}
}