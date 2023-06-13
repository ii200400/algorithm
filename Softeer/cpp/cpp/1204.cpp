// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=1204
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&psProblemId=1204&submissionSn=SW_PRBL_SBMS_180156
// ����Ƽ�� ������ǻ�� Ŭ������

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
��.. �ƹ��� �����غ��� �������� ����Ž�� ��������.
ai�� ���׷��̵带 �ִ�� �ص� 20���� ���� ���� �� ���Ƽ� int������ �ص� �� �� ����.
B�� long������ �����ϸ� �� �� ����.

��..? long�� 8����Ʈ�� �� �˾Ҵµ� int�� ���� 4����Ʈ�̴�.
long long���� �ٲ��־���.

�����÷ο� ������ ������ ������ �ִ� �� ����.. ��..

�����÷ο츦 �ȳ��� �� ���� ��� �׳� �������� �Ѿ�� break�� Ż���ϰ� ���� ó���ϵ��� �������.
�׷����� ���~
.. ����Ƽ��� �˰����� �ƴ϶� ������ ������ ���� ���ذ� �� ���� �� ����;
*/

#include <iostream>
#include <cmath>
using namespace std;

int main() {
	int n;
	long long b;
	cin >> n >> b;

	int* computers = new int[n];
	for (int i = 0; i < n; i++) {
		cin >> computers[i];
	}

	// from�� ������ �ִ� b, to�� �Ұ����� �ּ� b
	int from = 1, to = 2000000001;
	// ����Ž������ ������ �ִ� b�� ã�´�.
	loop: while (from + 1 < to) {
		//cout << from << " " << to << endl;
		// �ʿ��� ���
		long long cost = 0;
		int mid = ((long long) from + to) / 2;
		
		// �ʿ��� ����� ����ؼ�
		for (int i = 0; i < n; i++) {
			int diff = mid - computers[i];
			if (diff < 0) continue;
			cost += (long long) diff * diff;

			if (cost > b) break;
		}

		// ����� ���� ����� from�� �ƴ϶�� to�� �����ϰ� ����Ѵ�.
		//cout << cost << " " << b << endl;
		if (cost < b) from = mid;
		else if (cost > b) to = mid;
		else {
			from = mid;
			break;
		}
	}

	cout << from << endl;

	delete computers;

	return 0;
}