// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=407
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_214045&psProblemId=407
// ����Ƽ�� ���̷���

// ����� Ǫ�� level 2����

/*
����� Ǭ�ٰ� ������ ��� level 3 ������.. (���� �� Ǯ�ڴ°� �����ϰ�) �ϳ� ���� �� Ǯ����.
������ ���� �ڵ��׽�Ʈ�� ������ ����2 ������ �ִ��� Ǯ����� �Ѵ�!
���� ����Ƽ� �ִ� ���� 2 ������ 9���̴� ���� ������ �� Ǯ�� ���� �� ����.

������ ������ long ���� ���� ������ �����÷ο�� ����޴� ��������.
�� �ܿ��� Ư���� ���� ������ �ʴ´�.
*/

#include <iostream>
using namespace std;

int main() {
	// ���̷��� ��, ������, �ð�
	int k, p, n;
	cin >> k >> p >> n;

	// int ���� ���� �����÷ο찡 �Ͼ ���� �����̹Ƿ� long long
	long long cnt = k;
	for (int i = 0; i < n; i++) {
		// ����� ������ �����ش�.
		cnt = (cnt * p) % 1000000007;
	}

	// ���̷��� ���� 1000000007�� ���� ��
	cout << cnt << endl;

	return 0;
}