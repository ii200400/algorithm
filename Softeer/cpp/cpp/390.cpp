// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=390
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&psProblemId=390&submissionSn=SW_PRBL_SBMS_101428
// ����Ƽ�� ¡�˴ٸ�

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
��ü�� ����غ��� �; ����غ��Ҵ�. �Ʒ��� ��α׸� �����Ͽ���.
https://ffoorreeuunn.tistory.com/366
*/

#include <iostream>

using namespace std;

// ���� ���� ���̿� ���� ���� �����鼭 �̰����� ���� ���� ���� ���� ��
class HeighestStep
{
public:
	int height;
	int step;
};
/* �������� �Ʒ��� ���� �ۼ��Ͽ���.
	struct heightStep
	{
		int height;
		int step;
	};
*/
int main() {
	int n;
	cin >> n;
	
	// �� ��ġ�� ���� ���� �迭
	HeighestStep* heighestStep = new HeighestStep[n];
	for (int i = 0; i < n; i++)
	{
		cin >> heighestStep[i].height;
	}
	// ���� ù ���� ������ ���� ������ 1���� ���� �� �����Ƿ�
	heighestStep[0].step = 1;
	
	// ���� �� ������ �� �� ���̰� �� �����鼭 ���� ū step�� �����ϴ� ����
	int maxStep;
	// ������ �����ϴ� ����
	int answer = 1;
	for (int i = 1; i < n; i++)
	{
		maxStep = 0;

		// maxStep�� ã��
		for (int j = 0; j < i; j++) {
			if (heighestStep[j].height < heighestStep[i].height && maxStep < heighestStep[j].step)
			{
				maxStep = heighestStep[j].step;
			}
		}
		// i ��°(���� ��)�� step�� +1�Ͽ� �����Ѵ�.
		heighestStep[i].step = maxStep + 1;
		//cout << heighestStep[i].step << endl;
		// ���� ���� step�� ���� ũ�� answer�� �����Ѵ�.
		if (answer < heighestStep[i].step)
		{
			answer = heighestStep[i].step;
		}
	}

	// ���� ���
	cout << answer << endl;

	delete[] heighestStep;

	return 0;
}