// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=362
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&psProblemId=362&submissionSn=SW_PRBL_SBMS_213953
// ����Ƽ�� A+B

// cpp ��� �׽�Ʈ

/*
���� �ʹ� ����� ������ Ǯ� ��δϸ� ���ؼ� ����� ���� Ǯ���� �Ѵ�!

�׷��� �ʹ� ����; ������ 2�� �Ǿ���ϴ� �� ����.
�׷��� �ϴ� ����1 ������ 3�����̴� �� Ǯ����� �Ѵ�.
*/

#include <iostream>
using namespace std;

int main() {
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int temp1, temp2;
		cin >> temp1 >> temp2;

		cout << "Case #" << i + 1 << ": " << temp1 + temp2 << endl;
	}

	return 0;
}