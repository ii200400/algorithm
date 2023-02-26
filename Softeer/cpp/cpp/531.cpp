// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=531
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_148486&psProblemId=531
// ����Ƽ�� �繰�ν� �ּ� ���� ���� ���α׷�

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
��.. ����Ž�� ����. �̰� ������� �� �� �ִ� ���� �ƴϴ�;
�׷���..x�� y�� ������ -1000~1000 �̶� ������ ��� ���簢���� ����鼭 ��� Ž���ϸ� �ð��ʰ��� �˳��ϰ� �Ͼ��.
�� ���� ���� �ϳ��� �����ؼ� �ּ����� ���簢���� ����� ����� �ð��ʰ��� �˳��ϰ� �����.
������ 10���� ���󸶴� 10���� ���� �ִٸ� 10^10�̴�; 20���� ���󸶴� 5���� ���� �ִٸ� 5^20(1���� ����)�̴�.
����.. ����Ž���ΰ�? �ƴѰ� ����. �ƹ��� �����ص� �̷� ������ ����Ž����.. �ƴ� �� ����.
�簢���� ������ 4���ε� ��, �Ʒ� ������ ������ ���߸鼭 4�� ��� ����Ž���� �ִ´�? 
���󿡳�.. �л��� Ǯ ���̵��� �ƴ� �� ����.

�׷�.. ����?

�˻��ؼ� ���� �ι�° �����ߴ� ���󸶴� ���� �����ϴ� ������� Ǯ���ٰ� �Ѵ�.
..? �������� �� �� �ֽŰ� �ƴϽ��� �ǽ��ߴ�.. �ϴ� Ǯ��ڴ�.

1��
���� �ð��ʰ��� �����. �׷� ����ġ�� ������� �ð��� ���̴� ����ۿ��� ����.
����� �����ϱ� ���� �ش� ������ ���� �ƴ϶�� ����.. �� �� �ֱ���? ����������!

����Ͽ���. ȣ�P.. ����Ž�� �ð����⵵�� �̷л� ���ΰ� �ƴ��� ����ؾ߰ڴ�.
*/

#include<iostream>
#include<list>

using namespace std;

void dfs(int fromX, int toX, int fromY, int toY, int cnt);

// �� ���󸶴� ���� �����ϴ� ����
list<int*>* dotSet;
// ������ ���� �� �ִ� ������ �� ����, ����
int k, answer = 4000000;

int main()
{
	// ���� ����
	int n;
	cin >> n >> k;

	// �� ���󸶴� ���� �����ϴ� ����
	dotSet = new list<int*>[k + 1];
	for (int i = 1; i <= k; i++) {
		list<int*> templist;
		dotSet[i] = templist;
	}

	// dotSet �ʱ�ȭ
	int x, y, color;
	for (int i = 0; i < n; i++) {
		cin >> x >> y >> color;
		dotSet[color].push_back(new int[2] {x, y});
	}

	dfs(1001, -1001, 1001, -1001, 1);

	cout << answer << endl;

	return 0;
}

// ���簢���� �� ���� 4���� �� ���� ���� ������ ȸ��
void dfs(int fromX, int toX, int fromY, int toY, int cnt) {
	// ��� ������ ���� �����ߴٸ� ���簢���� �ʺ� ����Ͽ� ����
	if (k + 1 == cnt) {
		if (answer > (toX - fromX) * (toY - fromY))
			answer = (toX - fromX) * (toY - fromY);

		return;
	}

	// cnt ��° ���� �����Ѵ�.
	for (auto it : dotSet[cnt]) {
		// cout << it[0] << ' ' << it[1] << endl;
		int tempFx = fromX, tempTx = toX, tempFy = fromY, tempTy = toY;

		// ���� ��ġ�� �°� �簢���� ������ �����ϰ�
		if (it[0] < tempFx) tempFx = it[0];
		if (tempTx < it[0]) tempTx = it[0];
		if (it[1] < tempFy) tempFy = it[1];
		if (tempTy < it[1]) tempTy = it[1];

		// �簢�� ũ��� ���� ������ ������ Ŀ���⸸ �ϹǷ� ������� ���� ���亸�� ũ�ٸ� �����Ѵ�.
		if (answer <= (tempTx - tempFx) * (tempTy - tempFy)) continue;

		// ���� ������ ���� �����Ϸ� ����.
		dfs(tempFx, tempTx, tempFy, tempTy, cnt + 1);
	}

	return;
}