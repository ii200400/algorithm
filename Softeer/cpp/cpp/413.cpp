// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=413
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_214726&psProblemId=413
// ����Ƽ�� ���� �ڵ� ����

// ����� Ǫ�� level 2����

/*
������° ���� 2 ����

��.. ����2�� �³�..? ���� �������� ������ �� �ľ��ؼ� ���̵��� ���� �������� �ǰ�..?
������ �ְ���~
*/

#include <iostream>
using namespace std;

int main() {
	// �ܰ� �Է�
	int n;
	cin >> n;

	// �� ���� �����ϴ� ���� ��
	int dotWidth = 3;
	for (int i = 1; i < n; i++) {
		dotWidth = dotWidth * 2 - 1;
	}

	cout << dotWidth * dotWidth << endl;

	return 0;
}