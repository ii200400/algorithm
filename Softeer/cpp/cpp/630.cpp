// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=630
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&psProblemId=630&submissionSn=SW_PRBL_SBMS_147216
// ����Ƽ�� �ڵ� �׽�Ʈ ��Ʈ

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
��..! ����Ž�� �������� ����.
�ִ밪 �ʱ�ȭ�� ��� ������ ����ϰ� �����ϸ� �� �� ����.

1��
�˰����� �߸��� �� ������ ������ ������ �� ���ͼ� ����..
min�� max�� �ʱⰪ�� �߸��Ǿ��ִ�.

2��
����? ������ �þ��� ������ ������ ����.
������ �����ؼ� ��.. �߸��Ǿ��� ���� �ִ�. �ٽú���.

�ƴ�.. long �̿��� �� ���� �ϳ��� int�̴�;

3��
������ ��-�� ����������, ������ ������ �����ִ�.
����ü ����..����..
��! 1���� �缳���ߴ� max�� 1500.. �����̸� �� �� �˾Ҵµ� �ٽ� �����غ���.. 166666.. �� �ִ밪�̴�!
�� �𸣰ھ �׳� 2000.. ���� �����ߴ�!

������,. ���..
�ʱⰪ ������ ���� Ÿ�Ը� �߸��Ἥ �̤� ������� �����������K!
*/

#include <iostream>
using namespace std;

int main() {
	// ���̵� ����, ���̵� �� ���� ��
	int n, tn;
	cin >> n >> tn;

	// �ó����� �� ��ŭ �ݺ� (�ε��� 0�� 2n�� 0���� �д�.)
	long long* problemNums = new long long[2 * n + 1];
	for (int i = 0; i < tn; i++)
	{
		// ���̵��� ���� �� �ʱ�ȭ
		problemNums[0] = 0, problemNums[2*n] = 0;
		long long min = 0, max = 2000000000001;
		for (int j = 1; j < 2 * n; j++)
		{
			cin >> problemNums[j];
		}

		// ����Ž�� ����
		search: while (min + 1 < max) {
			long long mid = (min + max) / 2;
			long long temp = 0;

			// �迭�� Ž���ϸ鼭 mid�� ��� �������� Ȯ���Ѵ�.
			for (int i = 1; i < 2 * n; i+=2) {
				// ���� ��Ʈ����⿡ �����ϴٸ� d�������� ������ ����Ѵ�.
				long long have = temp + problemNums[i];
				if (mid > have)
				{
					// ���� �� ���ٸ� �ٸ� ���� Ž���Ϸ� ��������.
					if (problemNums[i+1] < mid - have)
					{
						max = mid;
						goto search;
					}
					else { // n-n+1 �� ���� ���� d�������� �����Ѵ�.
						temp = problemNums[i + 1] - (mid - have);
					}
				}
				else { // ���� d �������� �����Ѵ�.
					temp = problemNums[i + 1];
				}
			}

			// mid ��ŭ�� �׽�Ʈ ��Ʈ ������ ���� �� �ִٸ� �����Ѵ�.
			min = mid;
		}

		// ������ �ִ� �ڵ� �׽�Ʈ ��Ʈ �� ���
		cout << min << endl;
	}

	return 0;
}