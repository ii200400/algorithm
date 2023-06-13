// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=1309
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_181246&psProblemId=1309
// ����Ƽ�� ���� ��

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
���� ��ü�� ������ ���µ�, ���� �� �Է� ������ �°� ����ϴ� ���� �����̴�.
������ ���� ���� �迭�� ���ĵ� �迭�� ������ 
���ĵ� �迭�� ���������� ���캸�鼭 �� ���� �ٸ� ���� ������ Ű(����):��(����)���� ������ ��,
���ĵ��� ���� �迭�� ���������� ���캸�鼭 ������ ������ map�� �����Ͽ� ����ϸ� �ǰڴ�.
�޸𸮸� �� �Һ��ϱ�� ������, �����ϰ� �ذ��� �� ���� �� ����.
*/

#include <iostream>
#include <unordered_map>
using namespace std;

// https://en.cppreference.com/w/c/algorithm/qsort
int compare_ints(const void* a, const void* b)
{
	int arg1 = *(const int*)a;
	int arg2 = *(const int*)b;

	// ���������� ���� -1�� 1��, 1�� -1�� ����
	if (arg1 < arg2) return 1;
	if (arg1 > arg2) return -1;
	return 0;

	// return (arg1 > arg2) - (arg1 < arg2); // possible shortcut
	// return arg1 - arg2; // erroneous shortcut (fails if INT_MIN is present)
}

int main() {
	// ��� ��
	int n;
	cin >> n;
	// 3���� ��ȸ���� �� ������� ���� ����
	int* scoreSum = new int[n];
	// ������� ���� ���� �迭, �ش� �迭�� ������ �迭
	int* score = new int[n];
	int* sortedScore = new int[n];
	// Ű(����):��(����) �� �����ϴ� map ����
	unordered_map<int, int> m;

	// scoreSum �ʱ�ȭ
	for (int i = 0; i < n; i++) {
		scoreSum[i] = 0;
	}

	// 3���� ��ȸ�� �����Ƿ� 3�� �ݺ�
	for (int i = 0; i < 3; i++) {
		// �Է°� �ޱ�
		for (int i = 0; i < n; i++) {
			cin >> score[i];
			sortedScore[i] = score[i];
			scoreSum[i] += score[i];
		}

		// ����Ʈ�� ����
		qsort(sortedScore, n, sizeof(int), compare_ints);

		// ���� ���ڸ� �����ϴ� ����, �ش� ���ڰ� �� ��° ������� �����ϴ� ����
		int temp = -1, rank = 0;
		for (int i = 0; i < n; i++) {
			rank++;
			if (temp != sortedScore[i]) {
				temp = sortedScore[i];
				m[temp] = rank;
			}
		}

		for (int i = 0; i < n; i++) {
			cout << m[score[i]] << ' ';
		}
		cout << endl;

		m.clear();
	}

	//���������� ������ ���� ���� ������� ����Ѵ�.
	for (int i = 0; i < n; i++) {
		sortedScore[i] = scoreSum[i];
	}

	qsort(sortedScore, n, sizeof(int), compare_ints);

	int temp = -1, rank = 0;
	for (int i = 0; i < n; i++) {
		rank++;
		if (temp != sortedScore[i]) {
			temp = sortedScore[i];
			m[temp] = rank;
		}
	}

	for (int i = 0; i < n; i++) {
		cout << m[scoreSum[i]] << ' ';
	}

	delete scoreSum;
	delete score;
	delete sortedScore;

	return 0;
}