// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=414
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_143270&psProblemId=414
// ����Ƽ�� ����Ʈ ����

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
��.. �ϴ� �κ��� �տ��ִ� ��ǰ����� ���� ���� ���� �ִ� �κ����� �� ���� �������� �����ϹǷ� 
�ִ��� ���� ��ǰ����� ���� ������ �Ѵ�.
���� 2���� Ȱ���ؼ� �ϳ��� ��ǰ�� �����ϵ��� �ٸ� �ϳ��� �κ��� �����ϵ��� ���� �����̴�.
*/

#include <iostream>
#include <queue>

using namespace std;

int main() {
	// ������ ����, ��ǰ�� ���� �� �ִ� �Ÿ�
	int n, k;
	cin >> n >> k;

	// Ž���� �κ��� ��ǰ�� k�Ÿ� ��ŭ �����ϴ� ����
	queue<int> robots, parts;
	// �ӽ÷� �Է��� �����ϴ� ����, ��ǰ�� ���� �κ� ��
	char c;
	int cnt = 0;

	// ������� ������ ��ǰ�̳� �κ��� ť�� �����ϰų� ���鼭 
	// ��� �κ��� ��ǰ�� �������� ����.
	for (int i = 0; i < n; i++)
	{
		cin >> c;
		if (c == 'H')	// ��ǰ
		{
			if (robots.size() > 0) {
				robots.pop();
				cnt++;
			}
			else {
				parts.push(i);
			}
		}
		else { // �κ�
			if (parts.size() > 0) {
				parts.pop();
				cnt++;
			}
			else {
				robots.push(i);
			}
		}

		// �ʹ� �� ��ǰ�̳� �κ��� ť���� ����.
		if (robots.size() > 0 && i - robots.front() >= k)
			robots.pop();
		if (parts.size() > 0 && i - parts.front() >= k)
			parts.pop();
	}

	// �κ��� ���� ��ǰ�� �� ���
	cout << cnt << endl;

	return 0;
}