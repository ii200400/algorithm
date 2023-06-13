// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=1526
// ���� ��ũ : 
// ����Ƽ�� ���⼭�� Ŀ��

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
��.. ����� ������ ���ǿ� �´� �ʿ��⼭���� ���ϴ� ��İ� ���� ����� �� �� ����.
������ ����ӵ��� ���̱� ���ؼ� ������ ���� �߰��ؾ� �Ѵٴ� �� �������� ������..?

�� ���� ���⼭���� �����ؼ� �ʿ��⼭���� �����. 
���� a..tt �� gc... �� ù��° �ڸ����� �浹�ǹǷ� �Ұ����ϰ� 
a..tt�� a.g.t ���� ���� �浹�� �Ͼ�� �ʴ� �͵�� ������ �������.. ����Ž���� �����ϴµ�
���߿� ���� �ʿ��⼭���� �������� �ʰ��ϸ� return �ϴ� ������� ������ ���δ�.

���� ���� �׷��� ���� �ڵ��� ���ߴµ��� ���� �Ӹ��� ������;

---1�� �õ�---
��ü ������ Ʋ���� ���� �� ������ �������� �κп��� �߸��� ������ ���䵵 ���䵵 ���� ���´�.

string �ʱ�ȭ�� �Ǽ��� �κ��� ã�Ҵ�. �����ֱ�� �ߴµ�
���䳪�� ���� ��� ������ ���°���..

---2�� �õ�---
�ʱ�ȭ�� �����ϰ� Ʋ�� ���� ����. �ʱ�ȭ ������ �ƴϾ�������; (�̰ʹ�� �ű��ϳ�..)

����! ���� ���⼭�� �ĺ��� ã�� for������ �湮ó���� �Ǽ��Ͽ���.

---3�� �õ�---
����� ������ �ð� �ð��ʰ��� �����. 
������ Ǯ�� ������ �׷��� �ð��ʰ��� ���̸� ���� ������;

*/

#include <iostream>
#include <string>
using namespace std;

// ���⼭�� ���� ����
int n, m;
// ���⼭�� ����
string* order;
// ���⼭�� ��� ����
bool* visited;
// ����
int answer;

// �ʿ��⼭���� ���� �� ������ �����
// �ʿ��⼭�� �ĺ�, ���� ���⼭�� �ε���, ���θ��� �ʿ��⼭�� ���� ����
bool making(string superOrder, int num, string* temp) {
	// superOrder�� order[num]�� ������ �� �ִ��� ����.
	for (int i = 0; i < m; i++) {
		if (superOrder[i] == '.') {
			(*temp)[i] = order[num][i];
		}
		else if (order[num][i] == '.') {
			(*temp)[i] = superOrder[i];
		}
		else if (superOrder[i] == order[num][i]) {
			(*temp)[i] = superOrder[i];
		}
		else {
			// �� �Ǹ� false ��ȯ
			return false;
		}
	}

	// �Ǹ� true ��ȯ
	return true;
}

// Ž�������� �ε���, ������� ���⼭�� ����, ���� �ʿ��⼭�� ����, ���� ����� ���� �ʿ��⼭��
void dfs(int from, int used, int sNum, string superOrder) {
	// cout << "sNum: " << sNum << ", super : " << superOrder << endl;

	// ���� �ĺ��� �ƴ϶�� return
	if (answer <= sNum) return;

	// ��� ���⼭���� ����ߴٸ� ����� �����ϰ� Ž���� ����Ѵ�.
	if (used == n) {
		answer = sNum;
		return;
	}

	// �ʿ��⼭���� �Ͻ������� �����ϴ� ����
	string temp(m, '.');
	// �ʿ��⼭���� ã�ƺ���.
	for (int i = from; i < n; i++) {
		if (visited[i]) continue;

		if (making(superOrder, i, &temp)) {
			visited[i] = true;
			dfs(i + 1, used+1, sNum, temp);
			visited[i] = false;
		}
	}

	// ���� �ʿ��⼭�� Ž���� ������ ���� ���⼭�� �ĺ��� ã�´�.
	for (int i = sNum; i < n; i++) {
		if (visited[i]) continue;

		visited[i] = true;
		dfs(i + 1, used + 1, sNum + 1, order[i]);
		visited[i] = false;
	}
}

int main() {
	cin >> n >> m;
	answer = n;

	// ���⼭�� ����
	order = new string[n];
	visited = new bool[n];
	for (int i = 0; i < n; i++) {
		cin >> order[i];
		visited[i] = false;
	}

	// ���⼭�� Ž�� ����
	visited[0] = true;
	dfs(1, 1, 1, order[0]);

	cout << answer << endl;

	return 0;
}