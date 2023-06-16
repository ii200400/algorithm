// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=584
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_214079&psProblemId=584
// ����Ƽ�� GBC

// ����� Ǫ�� level 2����

/*
�ι�° ���� 2 ����

���� ������ �� ����� ����� ���..

�����ϴ� �׳� ������.. ���ǹ�������.
�������� �ӵ��� ���� ���� ū �κ��� ã�Ƽ� ����ϵ��� ������־���.
*/

#include <iostream>
using namespace std;

int main() {
	// ���Ѽӵ� ���� ��, �ӵ� �˻� ���� ��
	int n, m;
	cin >> n  >> m;

	// ���Ѽӵ��� �ӵ��˻� ���� �ʱ�ȭ
	pair<int, int>* limits = new pair<int, int>[n];
	pair<int, int>* speeds = new pair<int, int>[m];

	for (int i = 0; i < n; i++) {
		cin >> limits[i].first >> limits[i].second;
	}
	for (int i = 0; i < m; i++) {
		cin >> speeds[i].first >> speeds[i].second;
	}

	// �������� ���Ѽӵ��� �ӵ��˻� ���� ���

	// ����
	int answer = 0;
	// ���� �������� �Ѱ�ӵ��� �ӵ��˻� �ε���
	int limiteIdx = -1, speedIdx = -1;
	// �Ѱ�ӵ��� �ӵ��˻� ���� (���� ���ؼ� ���� ������ ���ϰų� �Ѵ�.)
	int limiteLen = 0, speedLen = 0;
	do {
		// �� ������ ���� ������ ���� ���� ������ �����ش�.
		if (limiteLen == speedLen) {
			limiteIdx++;
			speedIdx++;
			limiteLen += limits[limiteIdx].first;
			speedLen += speeds[speedIdx].first;
		}
		else if (limiteLen > speedLen) {
			speedIdx++;
			speedLen += speeds[speedIdx].first;
		}
		else {
			limiteIdx++;
			limiteLen += limits[limiteIdx].first;
		}

		// cout << "len : " << limiteLen << ' ' << speedLen << endl;
		// cout << "speed: " << limits[limiteIdx].second << ' ' << speeds[speedIdx].second << endl;

		// ���� ������ �ӵ� ���� ���ϰ� �� ���� ũ�� �����Ѵ�.
		int diff = speeds[speedIdx].second - limits[limiteIdx].second;
		if (diff > answer) {
			answer = diff;
		}

		// ���� ����� ��� ����(100m)�� Ž���� ������ �ݺ��Ѵ�.
	} while (limiteLen != 100 || speedLen != 100);

	cout << answer << endl;

	delete limits, speeds;

	return 0;
}