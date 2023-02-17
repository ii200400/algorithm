// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=577
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_146117&psProblemId=577
// ����Ƽ�� �κ��� ������ ���

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
����Ž�� �ۿ� �������� ���� ���µ�.. ��¥ ��Ž���� �����ϳ�..? ���� ���� ������ �ʹ� ū��;

������ �� �� �� �о�����!
�κ��� ���� ��ɿ� 2ĭ�� �̵��ϴ� �Ͱ� ���� ĭ�� �ι� �湮���� �ʴ� �������� ���ؼ�
��Ž�� �ƴ϶�� ���� �� �� �־���!

������ ���� �������� ������ ������ #�� ���� ��ġ�� �ʰ� ��� �������� �����ߴ��� �ľ��ϱ� ���� ����!
#�� ������ ���鼭 #�� ĭ�̸鼭 �ֺ��� #�� ĭ�� 1�� �ۿ� ���ٸ� �װ����� Ž���ϵ��� �ϸ� �ȴ�.
���� ���ϸ�, (���� �������� �ʴ�) �Ѻױ׸����� �������� ������ Ȯ���ؼ� �װ��� ���������� ������ �ȴ�.
���������� ������ ���� 2���� �����ٵ� ��.. �����̵� ����ó���� ���شٰ� �ϴ� ������ ���� �� ����.

�߰��� == �� ���� = ���� �ؼ� �ظ˴�;;
������ �ʹ� ���Ƽ� 1�� ���Ա⵵ �ߴµ� �ݹ� �ذ��ؼ� Ǯ �� �־���.
�׷��� �ѹ��� ����ؼ� ��δϴ� ����!
*/

#include <iostream>
using namespace std;

int main() {
	// ��, ����
	int w, h;
	cin >> h >> w;

	// �� �ʱ�ȭ
	char** map = new char* [h+2];
	int hashCnt = 0;
	map[0] = new char[w + 2];
	map[h+1] = new char[w + 2];
	for (int i = 1; i <= h; i++)
	{
		map[i] = new char [w+2];
		for (int j = 1; j <= w; j++)
		{
			cin >> map[i][j];
			if (map[i][j] == '#') hashCnt++;
		}
	}

	/*for (int i = 1; i <= h; i++)
	{
		for (int j = 1; j <= w; j++)
		{
			cout << map[i][j];
		}
		cout << endl;
	}*/


	// ���� Ȥ�� ���� ã��
	int dir[4][2] = {{0, 1}, {1, 0}, {0, -1} , {-1, 0}};
	char heading[4] = { '>', 'v', '<', '^' };
	int start[2] = { 0, 0 };
	int go = 0;
	for (int i = 1; i <= h; i++)
	{
		for (int j = 1; j <= w; j++)
		{
			int cnt = 0;
			if (map[i][j] == '#') {
				// ���� ��ġ���� �ֺ��� # ���� ����
				for (int k = 0; k < 4; k++) {
					if (map[i + dir[k][0]][j + dir[k][1]] == '#') {
						cnt++;
					}
				}

				// ������ ��ġ�� ã���� �������� ������ �����ϰ� �ݺ��� Ż��
				if (cnt == 1)
				{
					start[0] = i;
					start[1] = j;

					for (int k = 0; k < 4; k++) {
						if (map[i + dir[k][0]][j + dir[k][1]] == '#') {
							go = k;
						}
					}

					goto escape;
				}
			}
		}
	}

escape:

	cout << start[0] << ' ' << start[1] << endl;
	cout << heading[go] << endl;

	hashCnt--;
	while (hashCnt != 0) {

		// �κ��� �̵��� ������ Ž���Ѵ�.
		for (int k = 0; k < 4; k++) {
			int dh = start[0] + dir[k][0];
			int dw = start[1] + dir[k][1];

			// �̵��� ��ġ�� ã���� 
			if (map[dh][dw] == '#') {
				// ������ �ٲ���ϴ��� Ȯ���ϰ�
				int diff = go - k;
				if (diff == -1 || diff == 3) {
					cout << 'R';
				}
				else if (diff == 1 || diff == -3) {
					cout << 'L';
				}
				else if (abs(diff) == 2) {
					cout << "LL";
				}
				// ���� �� �� �� �Ŀ�
				cout << 'A';

				// ������ ������ �� �����ְ�
				map[start[0]][start[1]] = '.';
				map[dh][dw] = '.';

				// # ������ ���� �̵��� �� ������ �������Ѵ�.
				hashCnt-=2;
				start[0] += dir[k][0]*2, start[1] += dir[k][1] * 2;
				go = k;

				break;
			}
		}
	}

	return 0;
}