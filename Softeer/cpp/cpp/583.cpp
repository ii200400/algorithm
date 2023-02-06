// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=583
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_143459&psProblemId=583
// ����Ƽ�� GINI�� ������

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
W(������)���� H(��)���� *(�ҳ���)�� X(��)�� ���ؼ� �ּ����� �ð����� �� �� �ִ� ���α׷�..�� ����� �ȴ�.
���� �������� DFS�� ����ߴ��� �̹����� BFS�� ����ϴ� ������ ���ͼ� ����.

��.. cpp������ �ڹٿʹ� �ٸ��� �����Ҵ��� ����ؾ� ���ϴ� ����� ���´�;;
����� ����� �ش� ������ ���ǰ��ִٰ� �ٽ� �� ��Ͽ� ���� ������ ����� ������ �״�� ����ϴ� �� ����.
�� ������ ���� �ȳ����� �ߴ��� �ش� ��Ͽ� �� ������ ����� ���� ���� ����������� ����;

����; �Դٰ� �ڵ� �����ϴٰ� ���߸� �κе� �־ ������ �´µ� �� �Ӹ��� ������ �¾Ƽ� ����� �ȵǰ� �־���.
*/

#include <iostream>
#include <queue>

using namespace std;

int main() {
	// ���� ����, ����
	int r, c;
	cin >> r >> c;

	// �ҳ��� ť�� ���� �� �� �ִ� ��ġ ť
	queue<int*> rains, car;
	// �� �迭
	char** map = new char* [r];

	// �ʰ� ť�� �ʱ�ȭ
	for (int i = 0; i < r; i++) {
		map[i] = new char[c];
		for (int j = 0; j < c; j++) {
			cin >> map[i][j];

			if (map[i][j] == 'W')
			{
				int* temp = new int[2] { i, j };
				car.push(temp);
			}
			else if (map[i][j] == '*') {
				int* temp = new int[2] { i, j };
				rains.push(temp);
			}
		}
	}

	// 4���� 
	int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	// �ڵ��� ť�� ũ��, �̵� ȸ��
	int size, cnt = 0;
	// �ڵ��� ��ġ ����/����, �ڵ��� ������ ��ġ ����/����
	int currentR, currentC, dr, dc;

	// �ڵ����� �� ������ ������ �ݺ�
	while (car.size() > 0) {
		cnt++;
		// �ҳ��Ⱑ �����δ�.
		size = rains.size();
		for (int i = 0; i < size; i++) {
			currentR = rains.front()[0], currentC = rains.front()[1];
			rains.pop();

			// 4�������� ���������µ�
			for (int j = 0; j < 4; j++) {
				dr = currentR + dir[j][0];
				dc = currentC + dir[j][1];

				// �� ���� ����� �н�
				if (dr < 0 || r <= dr)
					continue;
				if (dc < 0 || c <= dc)
					continue;

				// .�� ���� ������������ �Ѵ�.
				if (map[dr][dc] == '.'){
					int* temp = new int[2] {dr, dc};
					rains.push(temp);
					// �ҳ��� ǥ�ø� �ʿ� ���ܺ���.
					map[dr][dc] = '*';
				}
			}
		}

		// ���� �����δ�.
		size = car.size();
		for (int i = 0; i < size; i++) {
			currentR = car.front()[0], currentC = car.front()[1];
			car.pop();

			// 4�������� �� �� �ִµ�
			for (int j = 0; j < 4; j++)
			{
				// �����̴� ��ġ��
				dr = currentR + dir[j][0];
				dc = currentC + dir[j][1];

				// �� ���� ����� �н�
				if (dr < 0 || r <= dr)
					continue;
				if (dc < 0 || c <= dc)
					continue;

				// ���̸� �������
				if (map[dr][dc] == 'H') {
					cout << cnt << endl;
					return 0;
				}

				// .�� ���� �̵� 
				if (map[dr][dc] == '.') {
					int* temp = new int[2] {dr, dc};
					car.push(temp);
					// ���� �����Դٴ� ǥ�ø� �ʿ� ���ܺ���.
					map[dr][dc] = 'W'; 
				}
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				cout << map[i][j] << ' ';
			}
			cout << endl;
		}
	}

	// ���� ���� �������� ���ϸ� FAIL ���
	cout << "FAIL" << endl;

	return 0;
}