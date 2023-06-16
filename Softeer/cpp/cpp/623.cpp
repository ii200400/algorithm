// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=623
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_214605&psProblemId=623
// ����Ƽ�� ��� �޴�

// ����� Ǫ�� level 2����

/*
�ټ���° ���� 2 ����

�и���.. ���� ����������.. ��������� ����.. 
�׳�Ǯ��!

������ ���ڿ� ��Ī �˰����� ����������.. 
���������� ���� �ش� �˰����� Ȱ������ �ʾƵ� �� �� ����
�������� ���ڿ� ��Ī �˰����� �����ϱ⿡ ���ذ� �� �Ǿ� �ð��� �ɸ� �� ����
����Ž������ �����Ͽ���.
*/

#include <iostream>
using namespace std;

int main() {
	// ��ư ��, ���۹� ����, ��ư ���� ����
	int k, m, n;
	cin >> m >> n >> k;

	// ��и޴� ���۹�, ��ư �Է�
	int* secret = new int[m];
	int* click = new int[n];

	for (int i = 0; i < m; i++) {
		cin >> secret[i];
	}
	for (int i = 0; i < n; i++) {
		cin >> click[i];
	}

	// n<m�� ��츦 ����Ͽ� false�� �ʱ�ȭ
	bool isSecret = false;
	for (int i = 0; i <= n - m; i++) {
		isSecret = true;

		// ��и޴� ���۹��� �ִ��� Ȯ���ؼ�
		for (int j = 0; j < m; j++) {
			if (secret[j] != click[i + j]) {
				isSecret = false;
				break;
			}
		}

		// ���۹��� �ִٸ� Ż��
		if (isSecret) {
			break;
		}
	}

	// ���۹� ���� ���ο� �°� ���
	if (isSecret) {
		cout << "secret" << endl;
	}
	else {
		cout << "normal" << endl;
	}

	delete secret, click;

	return 0;
}