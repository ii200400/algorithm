// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=627
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_146837&psProblemId=627
// ����Ƽ�� �̹��� ���μ���

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
��.. ������ ��ȸ ���� �� Ǯ���� �޴µ� �ٷ� �������� ����� �־ Ǯ����� �Ѵ�.
�׷��� ��¥�� dfs, bfs�� �ذ�Ǵ� �������� �ǹ��̴�. �������δ� �ð��ʰ��� �ȳ���� �ϴµ�
�׷��ٰ� �ϸ� ���̵��� �ʹ� ����..

��.. ����ߴ�..
���� ��ȸ ���̵��� �ʹ� ���Ƽ� ���̵��� ���質..?
*/

#include <iostream>
using namespace std;

void dfs(int h, int w, int c, int cij);

int** map;

int main() {
	// ����, ����
	int h, w;
	cin >> h >> w;

	// �� ���� (�ܰ��� 0���� �ʱ�ȭ)
	map = new int* [h+2];
	for (int i = 1; i <= h; i++)
	{
		map[i] = new int[w + 2] {0};
		for (int j = 1; j <= w; j++)
		{
			cin >> map[i][j];
		}
	}
	map[0] = new int[w + 2] {0}, map[h + 1] = new int[w + 2] {0};

	// ������
	/*for (int i = 0; i < h+2; i++)
	{
		for (int j = 0; j < w + 2; j++) {
			cout << map[i][j] << ' ';
		}
		cout << endl;
	}*/

	// ���� ȸ��, �ȼ��� i/j/c
	int i;
	cin >> i;
	int pi, pj, pc;
	// cin�� �Ʒ�ó�� ����ص� �Ǵ��� �õ�
	for (; i > 0; i--)
	{
		cin >> pi >> pj >> pc;

		// ���� ���� ���� ������ �ٲٶ�� �ϸ� ��ȭ�� �����Ƿ� �����Ѵ�.
		if (map[pi][pj] == pc) continue;

		int temp = map[pi][pj];
		map[pi][pj] = pc;
		dfs(pi, pj, pc, temp);
		
	}

	// �� ���
	for (int i = 1; i <= h; i++)
	{
		for (int j = 1; j <= w; j++) {
			cout << map[i][j] << ' ';
		}
		cout << endl;
	}

	return 0;
}

// dfs �˰������� �ֺ� ������ Ž���ϸ鼭 ������ �������� ����
int dir[4][2] = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
void dfs(int h, int w, int c, int cij) {
	for (int i = 0; i < 4; i++)
	{
		int dh = h + dir[i][0], dw = w + dir[i][1];
		if (map[dh][dw] == cij)
		{
			map[dh][dw] = c;
			dfs(dh, dw, c, cij);
		}
	}
}