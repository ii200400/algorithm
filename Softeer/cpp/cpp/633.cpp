// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=633
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_147080&psProblemId=633
// ����Ƽ�� ��� �޴�2

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
��..? �׳�.. ���������ΰǰ�?
�ε����� �� �����ϸ鼭 ī�����ϱ⸸ �ϸ� �� �� ����. �ð��ʰ��� ������ ���� �� ������..
�̰�.. ��������?

���.. ���� �ް�����;; ���� ��� �״�� �����ؼ� �ذ��Ͽ���.
*/

#include <iostream>
using namespace std;

int main() {
	// ��ư ����1, ��ư ����2, ���� ����
	int n, m, k;
	cin >> n >> m >> k;

	// ������ ���� �� �ʱ�ȭ
	int* button1 = new int[n];
	int* button2 = new int[m];

	for (int i = 0; i < n; i++) {
		cin >> button1[i];
	}
	for (int i = 0; i < m; i++) {
		cin >> button2[i];
	}

	// �׻� ���� 1�� ����2���� ª�� ���� ������ �Ѵ�.
	int size1 = n, size2 = m;
	if (n > m) {
		int* temp = button1;
		button1 = button2;
		button2 = temp;

		size1 = m, size2 = n;
	}

	int cnt = 0, max = 0;
	// ������� ���캻��.
	// ���� 1�� 2 2 3 4 5, ���� 2�� 1 1 6 7 8 �̶��
	// 2 2 3 4 5
	//         1 1 6 7 8 �� ���� ������� ��
	for (int i = size1 - 1; i > 0; i--) {
		for (int j = 0; j < size1 - i; j++) {
			//cout << button1[i + j] << ' ' << button2[j] << endl;
			if (button1[i + j] == button2[j]) cnt++;
			else {
				if (max < cnt) max = cnt;
				cnt = 0;
			}
		}

		if (max < cnt) max = cnt;
		cnt = 0;
	}

	// ���� 1�� 2 2 3 4 5, ���� 2�� 1 1 6 7 8 9 1 �̶��
	//   2 2 3 4 5
	// 1 1 6 7 8 9 1�� ���� ������� ��
	for (int i = 0; i <= size2 - size1; i++) {
		for (int j = 0; j < size1; j++) {
			//cout << button1[j] << ' ' << button2[i + j] << endl;
			if (button1[j] == button2[i+j]) cnt++;
			else {
				if (max < cnt) max = cnt;
				cnt = 0;
			}
		}

		if (max < cnt) max = cnt;
		cnt = 0;
	}

	// ���� 1�� 2 2 3 4 5, ���� 2�� 1 1 6 7 8 9 1 �̶��
	//         2 2 3 4 5
	// 1 1 6 7 8 9 1�� ���� ������� ��
	for (int i = 1; i < size1; i++) {
		for (int j = 0; j < size1 - i; j++) {
			//cout << button1[j] << ' ' << button2[size2 - (size1 - i) + j] << endl;
			if (button1[j] == button2[size2 - (size1 - i) + j]) cnt++;
			else {
				if (max < cnt) max = cnt;
				cnt = 0;
			}
		}

		if (max < cnt) max = cnt;
		cnt = 0;
	}

	// ���� �� �κм��� ���� ���
	cout << max << endl;

	return 0;
}