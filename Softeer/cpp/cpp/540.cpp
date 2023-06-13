// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=540
// ���� ��ũ : 
// ����Ƽ�� Garage game

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
����.. ����Ž���� dfs/bfs�� �簢�� ��꿡 ĭ �ű�Ⱑ ���̵� �ùķ��̼��̶��..
��ī���̿����� �簢�� Ȯ�ΰ� ĭ �߰��� ���� ����� ������ �־��µ� Ǯ �� �ƴ� ����� ���� ������ ����� �ִ�.
�̷� ���� ������ 3�ð��� �� �����ϴٰ� Ʋ���� ��찡 ������ ���ε� ���������̴�.
������ �����̹Ƿ� �����ϰ� �����ϰڴ�.

---�뷫 4�� ��---

�����غ����� �Ѵ�. ���� �������� ����� �޸𸮸� ���� �Ҹ��ϴ�.. ����Ž�� ����̴�.
3���ʸ� ����ǹǷ� �ð��ʰ��� ������ ���� ���̶�� �����߱� �����̴�.

����� �Ʒ��� ����.
1. ���� ���ο� ���� ������ �����ϴ� �迭�� ����� �ʱ�ȭ �Ѵ�.
���� ���ζ�� ���� ����Ž������ �ش� ���ʸ� �����ϸ鼭 �ڵ����� ����� ���θ� ���Ѵ�.
2. ���� ������ ������ �Ʒ����� ���������� ������ ���� ���ٸ� �����Ѵ�.
3. �迭�� ���� ����� ���� �迭�� �����ϰ� ����� �ڵ����� ���� �ڵ����� ���� ������Ʈ(������ ��������) ��Ų��.
3-1. �� �� �ְ�������� �������ְ� 3��° �����Ѵٸ� return �Ѵ�.
4. ���ο� �迭�� �ٽ� 2������ ���� �����Ѵ�. 

�󸶳� ���׸� ������ ������� ���ȴ� ^��^ b

nr�� n ���� Ư���� ������ �� ��Ծ 2*n��� 0 ���� ������ �ߺ����� �ۼ��ϰ� 
�湮�� ó�����־�� �� �� ���߸��� ���� ��������.

---1�� �õ�---
�޸� �ʰ��� ���� �����Ͽ����� �����. 
���ڲ��� delete�� ����ߴµ�.. �̰Ͱ��� �����ϰ� ����� ���ΰ�..?

�����غ��� �ùķ��̼��� 3�� �Ͼ�� �������� ��ġ�� 4���� 2���� �迭������ �ذ��� �� �ִٴ� ���� �˾Ҵ�.
�����ؾ���!

---2���õ�---
��.. �޸𸮴� Ȯ���ϰ� ���� �� �־���. 250mb�� ���ߴ� ���� �ִ� 32mb������ �ٿ���.
��� �ð��ʰ��� �����.

�����غ��� �湮�迭�� ���� ������� ���ϼ� �ֳ�..

�ƴ� �� �ð��ʰ��� ��ӳ��µ�, ��� ���̶�� ������ �� ���� ����. 
�׷��� 10�� ������ ������� ���̴µ�;

*/

#include <iostream>
#include <queue>
using namespace std;

// �ְ�����
int maxScore = 0;
// ���� ũ��
int n;
// ���� ����
int** carage[4];
// �湮 ����
bool** visited[4];

// ���簢���� ���̸� ���� �� ����ϴ� ������
int top, bot, lef, rit;
// �ڵ��� ���� ��ȣ, ����� �ڵ��� ��
int carNum, num;

int dr[4] = { 0, 0, 1, -1 };
int dc[4] = { 1, -1, 0, 0 };

// �ֺ��� ���� �ڵ����� Ȯ���ϰ� �����Ѵٸ� ��� �� ������ ��ȯ�Ѵ�.
// ���� �迭, �湮 ����, ����, ����
void dfs(int r, int c, int time) {
	// �ֺ� �ڵ����� ���캸�µ�
	for (int i = 0; i < 4; i++) {
		int nr = r + dr[i], nc = c + dc[i];

		// ���� ������ ����ٸ� �����Ѵ�.
		if (nr < 2 * n || nr >= 3 * n || nc < 0 || nc >= n) continue;
		// ���� ������ �޶� ����, �湮 ������ �־ ����
		if (carage[time][nr][nc] != carNum || visited[time-1][nr - 2 * n][nc]) continue;

		// �湮ó��
		visited[time-1][nr - 2 * n][nc] = true;
		carage[time][nr][nc] = 0;
		num++;

		
		// ������
		// cout << rit << " " << lef << ' ' << top << ' ' << bot << ' ' << num << endl;
		// cout << nr << " " << nc << endl;

		// ���簢�� ���
		if (top > nr) top = nr;
		else if (bot < nr) bot = nr;
		if (lef > nc) lef = nc;
		else if (rit < nc) rit = nc;

		// ��� ���캸��
		dfs(nr, nc, time);
	}
}

// �ڵ����� �����ϰ� ������ ���� ���� ����
// ���� �迭, ����, �ùķ��̼� ȸ��
void game(int score, int time) {

	// �湮�迭 �ʱ�ȭ
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			visited[time-1][i][j] = false;
		}
	}

	// �ڵ����� �����غ���.
	for (int i = 2 * n; i < 3 * n; i++) {
		for (int j = 0; j < n; j++) {
			// �̹� ���������� �ִ� �ڵ������ ����
			if (visited[time-1][i-2*n][j] || carage[time-1][i][j] == 0) continue;

			// �� �迭 �ʱ�ȭ
			for (int k = 0; k < 3 * n; k++) {
				for (int l = 0; l < n; l++) {
					carage[time][k][l] = carage[time - 1][k][l];
				}
			}

			// �湮ó��
			visited[time-1][i - 2 * n][j] = true;
			carage[time][i][j] = 0;

			lef = j, rit = j, top = i, bot = i;
			carNum = carage[time-1][i][j], num = 1;

			dfs(i, j, time);

			// ���� ����ϱ�
			int tempScore = score + (rit - lef + 1) * (bot - top + 1) + num;

			// ������
			// cout << rit << " " << lef << ' ' << top << ' ' << bot << ' ' << num << endl;
			// cout << "time : " << time << ", score : " << tempScore << endl;

			// �ùķ��̼��� ��� ���ƴٸ� �ְ��������� Ȯ���Ѵ�.
			if (time == 3) {
				if (maxScore < tempScore) maxScore = tempScore;
				continue;
			}

			// ����� �ڵ��� ������ ä���.
			for (int k = lef; k <= rit; k++) {
				queue<int> q;

				// �ڵ����� �߰��ϸ� ť�� �־��ٰ�
				for (int m = 3 * n - 1; m >= 0; m--) {
					if (carage[time][m][k] != 0) {
						q.push(carage[time][m][k]);
						carage[time][m][k] = 0;
					}
				}
				
				// ���ʴ�� �׾��ش�.
				for (int m = 3 * n - 1; !q.empty(); m--) {
					int temp = q.front();
					q.pop();
					carage[time][m][k] = temp;
				}
			}

			// ������ (���� ���)
			/*
			for (int k = 0; k < 3 * n; k++) {
				for (int l = 0; l < n; l++) {
					cout << newCarage[k][l] << ' ';
				}
				cout << endl;
			}
			*/
			
			game(tempScore, time + 1);

		}
	}
}

int main() {
	cin >> n;
	// ���� �迭 ����(�����Ҵ�)
	for (int i = 0; i < 4; i++) {
		carage[i] = new int* [3 * n];
		for (int j = 0; j < 3 * n; j++) {
			carage[i][j] = new int[n];
		}
	}

	// ���� ù��° �迭 �ʱ�ȭ
	for (int j = 0; j < 3 * n; j++) {
		for (int k = 0; k < n; k++) {
			cin >> carage[0][j][k];
		}
	}

	// �湮 �迭 ���� �� �ʱ�ȭ
	for (int i = 0; i < 4; i++) {
		visited[i] = new bool* [n];
		for (int j = 0; j < n; j++) {
			visited[i][j] = new bool[n];
		}
	}

	// cout << "gamestart" << endl;
	// ���� ����
	game(0, 1);

	cout << maxScore << endl;

	// ����, �湮 �迭 ����
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 3 * n; j++) {
			delete carage[i][j];
		}
		delete carage[i];
	}

	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < n; j++) {
			delete visited[i][j];
		}
		delete visited[i];
	}

	return 0;
}