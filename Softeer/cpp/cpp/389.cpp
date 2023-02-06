// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=389
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&psProblemId=389&submissionSn=SW_PRBL_SBMS_101120
// ����Ƽ�� �������

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
cpp�� ��ﳪ�� �ʴµ� C��� �ڵ������� �� �������� �ǿܷ� �� Ǯ���� �ִ�.
������ Ǭ �� ���������� �ѹ� �� Ǯ���� �Ͽ���.

���� ��ü�� ������ Ǯ�̴� ���� �ʰڴ�.

�Ҽ��� �Ʒ� �ڸ��� �����ϴ� ����� ��α׿��� ã�Ƽ� �����Ͽ���.
https://semaph.tistory.com/7
*/

#include <iostream>
// #include <math> �ݿø� �Լ� ����ؾ��ϴ� �� �˾Ҵµ� �ƴϴ�.
using namespace std;

int main() {
	// �л� ��, ���� ��
	int n, k;
	cin >> n >> k;

	// ������� ���� n��° �л������� ���� �ջ��� �����ϴ� �迭
	// ù ��°�� 0���� �ʱ�ȭ
	int* sum = new int[n + 1];
	sum[0] = 0;

	// sum �迭 �ʱ�ȭ
	int temp;
	for (int i = 1; i <= n; i++) {
		cin >> temp;
		sum[i] = sum[i - 1] + temp;
	}

	// ������ ������ ���� ��
	int start, end;
	// �Ҽ��� �Ʒ� �ڸ����� �� �ڸ��� �����Ͽ���.
	// �ݿø��� �ڵ����� ����Ǵ� �� �ϴ�.
	cout << fixed;
	cout.precision(2);
	for (int i = 0; i < n; i++) {
		cin >> start >> end;
		// �� ���� ������ �л��� ���� �л��� ����ŭ ������ ���
		cout << float(sum[end] - sum[start - 1]) / (end - start + 1) << endl;
	}

	delete[] sum;

	return 0;
}