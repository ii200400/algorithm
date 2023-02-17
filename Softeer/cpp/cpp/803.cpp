// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=803
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_146923&psProblemId=803
// ����Ƽ�� ������

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
��.. �ùķ��̼� �����̴�. �־������ �����ϴ� �ڵ常 �ۼ��ϸ� �� �� ����.
�ùķ��̼� ������ �������̶� ������ �߸� �ۼ����� �ʱ⸸�ϸ� ���� �� ����.

�Է¹��� ������ ������� ���� ��, ũ�⸦ �Ѿ�� ����� ����ó����
�����ο��� ������ ������ ������ ���� �ٷ� ť���� �������� ���� �ȵǴ� �������� �������� ���� ���� �����ϸ�
�������� �� �����Ͽ���.
*/

#include <iostream>
#include <queue>
using namespace std;

int main() {
	// �ڵ��� ��
	int n;
	cin >> n;

	// �� ��ġ�� ���� ��ȣ 0:A 1:B 2:C 3:D
	queue<int*> load[4];
	// �� ������ ���� �ð�
	int** cars = new int*[n];
	// �� ������ �����θ� ����� �ð�
	int* passTime = new int[n];
	for (int i = 0; i < n; i++)
	{
		passTime[i] = -1;
	}

	// ����, ���Խð�
	int inTime;
	char dir; // A:65
	for (int i = 0; i < n; i++)
	{
		cin >> inTime >> dir;
		cars[i] = new int[3] { inTime , dir - 65, i };
		//cout << cars[i][0] << ' ' << cars[i][1] << endl;
	}

	// �ð�, �Է����� �޾ƿ� �ڵ����� Ž���ϱ� ���� �ε���
	int time = 0, idx = 0;
	while (true) {
		for (;idx < n && time == cars[idx][0]; idx++) {
			load[cars[idx][1]].push(cars[idx]);
		}

		// �����ο��� �� �� �ִ� �ڵ����� Ž���Ѵ�.
		int isPass = 0; // ���� �����θ� ���������� ���� (��Ʈ����ŷ)
		for (int i = 0; i < 4; i++)
		{
			// �� ���⿡ �ڵ����� �ְ� �� ������ �����ʿ� �ڵ����� ���ٸ� �ڵ��� ���� 
			if (load[i].size() > 0 && load[(i + 3) % 4].size() == 0) {
				passTime[load[i].front()[2]] = time;
				isPass |= 1 << i;
			}
		}

		// ������ �ڵ����� ť���� ���Ž����ش�.
		for (int i = 0; i < 4; i++) {
			if (isPass & 1 << i) {
				load[i].pop();
			}
		}

		// � ���� �������� ���ߴµ�
		if (isPass == 0) {
			// ������ ��ü�Ǿ��ų� �� �̻� ������ ������ ���ٸ� �ݺ��� Ż��
			if (load[0].size() > 0 || idx >= n)
			{
				break;
			}
			// �׷��� ������(�׳� �����ο� ���� ���� ���) �ð��� ����(���� �����ϴ� �ð����� ��������)���ش�.
			else{
				time = cars[idx][0];
				continue;
			}
		}

		// �ð��� �帥��.
		time++;
	}

	// �ڵ����� �����θ� ������ �ð� ���
	for (int i = 0; i < n; i++)
	{
		cout << passTime[i] << endl;
	}

	return 0;
}