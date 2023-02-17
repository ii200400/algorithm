// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=580
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_147997&psProblemId=580
// ����Ƽ�� ���������� ������ ������ ������ ����ý���

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
����.. ���ؿ��� �̸��� �𸣰ڴµ� cctv�� �������� ����� ������ ��ﳭ��.
��Ȳ�� �����ϰ� �ùķ��̼� �ڵ��ε�.. ������ Ȱ���� �����̰�.. �̰Ŵ� 3�� ���������� �𸣰ڴ�;;

���ش� ���.. �����ϱ�� ���� �� �ϱ� ���������� ���̴�.
�Դٰ�, ���� �ð��ʰ� ������ ������� �� �𸣰ڴ�.
�ùķ��̼� ������� ������! �ð��ʰ��� �� ����ϴ� ������ �Ϲ����̹Ƿ� �����ϰ� �����ϰڴ�!

.. ��� �ߴµ� �����ϸ鼭 �湮ó���ؼ� ����� ����ϴ� �� ������ �ڿ������� �����ϰ� �Ǿ���.
ó�� �����ߴ� �Ͱ��� �ٸ��� �ð��������ִ� ����� ����ȭ �� �� �ִ� ����� �����ؼ� ũ�� ��ư� ���������� �ʾҴ�.


�ƴ�?? �̰� �ٷ� ����ǳ�? ��ȣ!
�߰��� �ּ� �ۼ��ϸ鼭 turn �迭�� ����ؾ��ϴ� �κ��� �־��µ� ���Ծ��� ���� ���� ������ ����������.
��.. ���߿� �̰�.. ���� �˾ƺ� �� ������ �𸣰ڴ�;; 
�̷����� �׻� �̷������� Ǯ� ���ش� �ϰڴµ� ����� ���� �� ����;
*/

#include <iostream>
#include <queue>
using namespace std;

// ���ϼ��� �� �̵� ��� (�������� ��ȣ 1,2,3,4�� ���� ����� �����ؾ߸� ��)
int dir[4][2] = { {0, 1}, {-1, 0}, {0, -1}, {1, 0} };
// ��ȸ��, ����, ��ȸ�� �� ���� ��ȯ
int turn[3] = { 1, 0, 3 };
// ��ȣ 1, 5, 9 ���� (��ȸ��, ����, ��ȸ���� �������� ����, ��ȣ 1,2,3,4�� ������ �����Ƿ� ��ȣ 1,5,9 �� �Է�)
bool sign[3][3] = { {true, true, true}, {true, true, false}, {false, true, true} };

int main() {
	// ������ ũ��, �־��� �ð�
	int n, t;
	cin >> n >> t;

	// ������ �湮 ���� (��,��, �ð��� �湮���� - �������� �ð� �����ϰ� �湮�� �� ��츦 ����)
	bool*** visited = new bool** [n];
	// ������ ��ȣ ����
	int*** crossSign = new int** [n];
	for (int i = 0; i < n; i++)
	{
		crossSign[i] = new int* [n];
		visited[i] = new bool* [n];
		for (int j = 0; j < n; j++)
		{
			crossSign[i][j] = new int [4];
			visited[i][j] = new bool[5] {false, false, false, false, false};
			for (int k = 0; k < 4; k++)
			{
				int temp;
				cin >> temp;
				crossSign[i][j][k] = temp - 1;
			}
		}
	}
	
	// {���� �������� ��, ���� �������� ��, ���� ����}
	// ���� ó���� ������ �ٶ󺸸� ���� ���� ���� �����ο� �ִ�.
	queue<int*> q;
	q.push(new int[3] {0, 0, 1});

	// ���� �ð�
	int time = 0; 

	// ���� ����
	while (time <= t) {
		int qSize = q.size();

		for (int i = 0; i < qSize; i++) {
			// ���� ���� ��ġ�� ����
			int x = q.front()[0], y = q.front()[1], carDir = q.front()[2];
			q.pop();

			visited[x][y][4] = true;

			// �ش� �������� ���� ��ȣ�� �����ʴ� ��ȣ��� ����
			if (crossSign[x][y][time % 4] % 4 != carDir) continue;

			// �ش� �������� �ش� ��ȣ�� �޾Ҿ��ٸ� ���� (�湮ó��)
			if (visited[x][y][time % 4]) continue;
			visited[x][y][time % 4] = true;

			// ��ȣ�� �޾Ƽ� �ڵ����� �����δ�.
			bool* s = sign[crossSign[x][y][time % 4] / 4];
			for (int i = 0; i < 3; i++)
			{
				// (��ȸ��/����/��ȸ��)�� �� �� ���ٸ� ����
				if (s[i] == false) continue;

				// ���⿡ ���� �� ��ġ�� �������ְ� ������ ť�� �־��ش�.
				int tempDir = (carDir + turn[i]) % 4;
				int dx = x + dir[tempDir][0], dy = y + dir[tempDir][1];

				// ���� ������ ������ ��쵵 ����
				if (dx < 0 || n <= dx || dy < 0 || n <= dy) continue;

				q.push(new int[3] {dx, dy, tempDir});
			}
		}

		time++;
	}

	// �湮�� ������ ��
	int cnt = 0;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (visited[i][j][4]) {
				// ������
				//cout << i << ' ' << j << endl;
				cnt++;
			}
		}
	}

	cout << cnt << endl;

	return 0;
}