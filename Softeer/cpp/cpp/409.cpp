// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=409
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_233578&psProblemId=409
// ����Ƽ�� ��ֹ� �ν� ���α׷�

// ����� Ǫ�� level 2����

/*
�ټ���° ���� 2 ����

Ǯ�ٰ� �ڵ��׽�Ʈ �����ϰ� �״�� ��Ծ�������. �̾ �����ϰڴ�.
�����ϴ� �״�� �����ؼ� ��Ȱ�ϰ� ����Ͽ���.
����� ��ֹ� ���� �ڵ带 �� ���Ӱ� �غ��Ҵµ�.. ���� �˰����� ���� ���������� �� ����� ����.
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { 1, -1, 0, 0 };

// ���� ����
int n;

// 0�� 1 �ۿ� ��� �׳� bool �迭�� �������.
// ���� ����
vector<bool>* map;

// ���Ž��, ����� ��ֹ� ���� ��ȯ�Ѵ�.
int dfs(int x, int y, int cnt) {
	for (int i = 0; i < 4; i++) {
		int nx = dx[i] + x;
		int ny = dy[i] + y;

		// �� ���� Ž���ϰų� ��ֹ��� ���ٸ� ����
		if (ny < 0 || ny >= n || nx < 0 || nx >= n || !map[ny][nx])
			continue;

		map[ny][nx] = 0;
		cnt = dfs(nx, ny, cnt+1);
	}

	return cnt;
}

int main() {
	cin >> n;

	map = new vector<bool>[n];
	for (int i = 0; i < n; i++) {
		// �Է� ���̻��̿� ���Ⱑ ��� string ������ ��� �޾ƿ� ��
		string temp;
		cin >> temp;

		// ���ڰ� 1�� ������ true�� �ƴϸ� false�� �Է��ϵ��� ����
		for (int j = 0; j < n; j++) {
			map[i].push_back(temp[j]=='1');
		}
	}

	// ������
	/*
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << map[i][j];
		}
		cout << endl;
	}
	*/

	vector<int> blockCnt;
	// ��ֹ��� ã�Ҵٸ� ����� ã�� ��ֹ� ���� �����Ѵ�.
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (map[i][j]) {
				map[i][j] = 0;
				blockCnt.push_back(dfs(j, i, 1));
			}
		}
	}

	sort(blockCnt.begin(), blockCnt.end());

	cout << blockCnt.size() << endl;
	for (int i = 0; i < blockCnt.size(); i++) {
		cout << blockCnt[i] << endl;
	}

	// �޸� ����, ���߿� ������ �־��µ� delete�� �߸� ����ϰ� �־���.
	// https://stackoverflow.com/questions/53057590/cant-delete-pointer-has-triggered-a-breakpoint
	delete[] map;

	return 0;
}