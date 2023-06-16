// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=626
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_214539&psProblemId=626#hold
// ����Ƽ�� ȸ�ǽ� ����

// ����� Ǫ�� level 2����

/*
�׹�° ���� 2 ����

��! ���� ����! ȸ�ǽ�!
���� �����ϴ� �� ȸ�ǽǹ������� �ñ��ϴ�.

�ƴϴ�, �����ؼ� ��ġ���� Ȯ���ϴ� �� ������ �ƴ϶� �׳� ������ ����ϴ� �����̴�.
printf ��¹�� ��Ծ��� �� �˾Ҵµ� �ٷ� �������� �ǿܷ� �����!

�������� ����� ���� ���� ��-�� �������� ������� �ذ��Ϸ��� �Ѵ�.
map�� ���� ������ �ְ� ���డ���� �ð��븦 �迭�� �����صδ� ����̴�.

��� ��Ŀ� ���缭 �ϴٺ��� ���� ������ �ڵ尡 ������ ���Ҵ�;
*/

#include <iostream>
#include <map>
using namespace std;

int main() {
	// ���� ��, ȸ�� ��
	int n, m;
	cin >> n >> m;

	// ���� ������ �����ϴ� map ����
	map<string, bool*> rooms = map<string, bool*>();
	// �� �̸�
	string roomName;
	for (int i = 0; i < n; i++) {
		cin >> roomName;

		// ���� ȸ�ǽð� �ʱ�ȭ
		rooms[roomName] = new bool[10] {false, };
		rooms[roomName][9] = true;
	}

	// ȸ�� ���� / ���� �ð�
	int start, end;
	for (int i = 0; i < m; i++) {
		cin >> roomName >> start >> end;

		for (int j = start; j < end; j++) {
			rooms[roomName][j-9] = true;
		}
	}

	/*
	for (auto roomInfo : rooms) {
		cout << roomInfo.first << ' ';
		for (int i = 0; i < 10; i++) {
			cout << roomInfo.second[i] << ' ';
		}
		cout << endl;
	}
	*/
	
	// ----- �� �ϳ� �� ����ϰ� ����� ���ؼ� ���� ����..
	int size = rooms.size();
	int cnt = 0;
	// ���� �ð��� ���� ȸ�ǽ� �� ���� �ð��� ����Ѵ�.
	for (auto roomInfo : rooms) {
		cnt++;
		cout << "Room " << roomInfo.first << ":" << endl;

		// �ð��� ���캸�鼭 ���� �ð��� ���Ǿ����� ����
		bool pre = true;

		// ������ �ð��밡 � �ִ������� ���
		int timeCnt = 0;
		for (int i = 0; i < 10; i++) {
			if (pre == roomInfo.second[i]) continue;

			if (pre) { // ����� ����(treu���� false�� ��) ���̶��
				pre = false;
				timeCnt++;
			}
			else { // ����ϱ� ������(false���� true�� ��) ���̶��
				pre = true;
			}
		}

		// ���� ������ �ð��� ��
		if (timeCnt == 0) {
			cout << "Not available" << endl;
		}
		else {
			cout << timeCnt << " available:" << endl;
		}

		pre = true;
		for (int i = 0; i < 10; i++) {
			// ��� ����ϰų� ����� ���ϰ� �ִٸ� ������� �ʴ´�.
			if (pre == roomInfo.second[i]) continue;

			if (pre) { // ����� ����(treu���� false�� ��) ���̶��
				printf("%02d-", i + 9);
				pre = false;
			}
			else { // ����ϱ� ������(false���� true�� ��) ���̶��
				printf("%02d\n", i + 9);
				pre = true;
			}
		}

		if (cnt == size) break;
		cout << "-----" << endl;
	}
	
	return 0;
}