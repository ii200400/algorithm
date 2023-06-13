// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=1256
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&psProblemId=1256&submissionSn=SW_PRBL_SBMS_180323
// ����Ƽ�� ���� ó��

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
��ȭ����Ʈ���� ���� �������� ������.
���� �ް��� ���� �־��µ� ��Ȳ��, �۾��� ó���ϴ� ���� �Ϸ羿 �ɸ��� 
�۾��� ��簡 ������ �۾��� �����ϴ� �͵� ������ �ϴ� �� ����.
1�Ͽ� ���� a�� b�� �����ٰ� �׳��� ��簡 ������ �����ϴ� ���� �ƴ϶� 2�Ͽ� �����Ѵٴ� ��.

��.. ������(��Ʈ����ŷ)���ε� �ۼ��ؼ� �����ȵǰ� ������ ������ ���� �ִ� �� �����ѵ�.. 
�ʹ� ��ư� �����ϰ� �ִ� �� ����.
�պ�����ó�� ���ڸ� �պ��س����鼭 ���������� ������ �μ��忡�� ���� ������ ã�� ����ؾ߰ڴ�.

���� ���
h�� 2�̸�
���������� 4���̰� ���ʺ��� 0, 1, 2, 3 ��° �����̶�� �Ҷ�
�μ��忡�� ���� ���������� ������ 1, 3, 0, 2�� ���� ���̴�.
������ �ٲ��� �����Ƿ� ������ ���� ã�� ������� ���ذ� �����̴�.

����.. �迭�� ���������� �����ϴ� �κ��� �ް����� �����ɷȴ�.
�� ������ �����ϴ� ����� �ְ����� 5ms�� �����ٰ� �����Ѵ�. ��������� �Ѿ��!

*/

#include <iostream>
#include <cmath>
using namespace std;

int main() {
	int h, k, r;
	cin >> h >> k >> r;

	// �������� ���̺��� ���� ���� ��¥�� �� ������ �μ������ ������ �� �ð��� ����;
	if (r < h+1) {
		cout << 0 << endl;
		return 0;
	}

	// ���������� ������ �μ��忡�� ���� ����
	// 2,4,6,.. �̶�� 2��°, 4��°, 6��°.. ���������� ������ �μ��忡�� ������� ���ٴ� ��
	// ������ ���ڴ� 0���� �����Ѵ�.
	int total = pow(2, h); // �� ���� ������ ��
	int* order = new int[total];
	int* newOrder = new int[total];
	for (int i = 0; i < total; i++) {
		order[i] = i;
	}

	// ��.. ������ �� ���� �׷��� ũ��
	int size = 1;
	// ¦�������� �ƴ��� ����
	bool rit = true;

	// �������� ã��
	while (size < total) {
		// �� �׷��� ����
		for (int i = 0; i < total; i += size * 2) {
			for (int j = 0; j < size; j++) {
				if (rit) {
					newOrder[i + j * 2] = order[i + j + size];
					newOrder[i + j * 2 + 1] = order[i + j];
				}
				else {
					newOrder[i + j * 2] = order[i + j];
					newOrder[i + j * 2 + 1] = order[i + j + size];
				}
			}
		}

		// ������ �׷����� �迭�� ��ü
		int* temp = order;
		order = newOrder;
		newOrder = temp;

		// ������
		cout << "order : ";
		for (int j = 0; j < total; j++) {
			cout << order[j] << " ";
		}
		cout << endl;
		cout << rit << endl;

		// ���� �����ϴ� ũ��� 2�迡 �ݴ������ ����
		size *= 2;
		rit = !rit;
	}

	// �������� ���̸�ŭ ���� �۾� �ð����� ������ �ȴ�.
	r -= h;
	// �Ϸ�� ������ ��ȣ ��
	int sum = 0;

	// ������������ ���� ������ �����Ѵ�.
	int** works = new int*[total];
	for (int i = 0; i < total; i++) {
		works[i] = new int[k];
		for (int j = 0; j < k; j++) {
			cin >> works[i][j];
		}
	}

	// �����ϰ� �� ������ ������� ���ذ���.
	for (int i = 0; i < k ; i++) {
		for (int j = 0; j < total && r > 0; r--, j++) {
			sum += works[order[j]][i];
			//cout << works[order[j]][i] << " ";
		}
	}

	cout << sum << endl;

	// ���������� ����
	delete order;
	delete newOrder;
	for (int i = 0; i < total; i++) {
		delete works[i];
	}
	delete works;

	return 0;
}