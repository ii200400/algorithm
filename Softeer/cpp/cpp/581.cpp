// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=581
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_143136&psProblemId=581
// ����Ƽ�� �ù� ������ ����

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
���.. n�� 3~10�ε� �߸����� 3~50���� �˰� ����Ž�� �ƴ϶�� �����ؼ� �ظž���;
����Ž������ ������ ��� ����(����)�� ã�� �� ���� ���찡 �ű�� ���Ը� ����� �����̴�.

�������� ���� �����ϴ� ���� ��������. �������� ���� �ް����� �ʰ� ������ �ؾ߰ڴ�.
*/

#include <iostream>
using namespace std;

// ���� ����, �ٱ��� ����, ���� ���� ȸ��, ����(���� 2500�����̹Ƿ� ���� 3000���� �ʱ�ȭ)
int n, m, k, answer = 3000;

// �ù� ������ ���� ���� �迭
int* weights;
// ���� ��� ���ο� ������ ���� �迭
bool* used;
int* ordered;

void permutation(int cnt);
void work();

int main() {
	// ������ �迭 �ʱ�ȭ
	cin >> n >> m >> k;
	
	weights = new int[n];
	used = new bool[n];
	ordered = new int[n];
	for (int i = 0; i < n; i++)
	{
		cin >> weights[i];
		used[i] = false;
	}

	// ������ ���� ����
	permutation(0);

	// ���� ���
	cout << answer << endl;

	return 0;
}

// ������ ������ ����� ����Լ�
void permutation(int cnt) {
	if (cnt == n) {
		work();
		return;
	}

	for (int i = 0; i < n; i++)
	{
		if (used[i])
			continue;

		used[i] = true;
		ordered[cnt] = weights[i];
		permutation(cnt + 1);
		used[i] = false;
	}
}

// ������ ���� ������� ���찡 ���� �� �� �ű� ���� ���
void work() {
	// ������
	/*for (int i = 0; i < n; i++)
	{
		cout << ordered[i] << " ";
	}
	cout << endl;*/

	// ���� ȸ��, �ٱ��Ͽ� ��� ������ �� ����, ���� ����
	int workCnt = 0, basketSum, weightSum = 0, idx = 0;

	// ���� ȸ���� k�� �� ������ ���Ѵ�.
	do
	{
		basketSum = 0;

		// �ٱ��Ͽ� ��� ���԰� m ������ ������ ������ ��´�.
		do
		{
			basketSum += ordered[idx];
			idx = (idx + 1) % n;
		} while (basketSum + ordered[idx] <= m);

		// �ű� ���Ը� ���ϰ� ���� ȸ���� 1 �ø���.
		weightSum += basketSum;
		workCnt++;
	} while (workCnt != k);

	// �������� ���� ���Է� ���ߴٸ� �����Ѵ�.
	if (answer > weightSum)
		answer = weightSum;

	// ������
	//cout << weightSum << " " << answer << endl;
}