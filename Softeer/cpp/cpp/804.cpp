// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=804
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_148710&psProblemId=804
// ����Ƽ�� �÷������ ��ȣ

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
����.. �ű��� ���� ����..
������� �ڵ带 �ۼ��ϸ� �� �� ����. 
�޽����� �󸶳� ������� �𸣰����� ����Ʈ�� Ȱ���ϰ� 
Ű�� ũ��� ������ 5*5�̴� ���� ������ �ð��� ���̴� ������ ���� �������� �Ѵ�.

�����ϴٰ� �߰��� ��ȣǥ�� ����鼭 ���ĺ��� ��ȣǥ ��ġ�� �����ϴ� ���� ���� �� ���� �̷��� �����Ͽ���.
�߰������� %�� &�� �ִ� �ٶ��� �Է��� ������ �̻��ϰ� �Ǿ� �������.
��� % ��� &�� �־������� ���ݵ� �ǹ��̴�;;

*/

#include <iostream>
#include <list>
#include <string>
using namespace std;

int main() {
	// �޽����� Ű
	string message, key;

	cin >> message;
	cin >> key;

	// �޽����� �� ���ھ� ¦ ���߱�
	list<char*> l;
	for (int i = 0; i < message.size();) {
		char* msg = new char[2] {' ', ' '};
		msg[0] = message[i];

		i++;
		if (i >= message.size()) {
			msg[1] = 'X';
			l.push_back(msg);
			break;
		}

		if (msg[0] == message[i]) {
			if (msg[0] == 'X')
				msg[1] = 'Q';
			else
				msg[1] = 'X';
		}
		else {
			msg[1] = message[i++];
		}

		l.push_back(msg);
	}

	// Ű�� Ȱ���Ͽ� ��ȣǥ �����
	// ��ȣǥ, ���ĺ� �� ����ǥ������ ��ġ
	char excel[5][5];
	int alphabet[26][2];
	for (int i = 0; i < 26; i++) {
		alphabet[i][0] = -1, alphabet[i][1] = -1;
	}
	alphabet['J' - 65][0] = 0;

	// Ű�� ��ȣǥ�� ��ȯ
	int cnt = 0;
	for (int i = 0; i < key.size(); i++) {
		if (alphabet[key[i] - 65][0] != -1) continue;

		int x = cnt / 5, y = cnt % 5;
		alphabet[key[i] - 65][0] = x, alphabet[key[i] - 65][1] = y;
		excel[x][y] = (char)key[i];
		//cout << x << ' ' << y << ' ' << excel[x][y] << endl;
		cnt++;
		if (cnt == 25) break;
	}

	// Ű���� ��Ÿ���� ���� ���ĺ��� ��ȣǥ�� �߰�
	if (cnt < 25) {
		for (int i = 0; i < 26; i++) {
			if (alphabet[i][0] != -1) continue;

			int x = cnt / 5, y = cnt % 5;
			alphabet[i][0] = x, alphabet[i][1] = y;
			excel[x][y] = (char)(i + 65);
			// cout << x << ' ' << y << ' ' << excel[x][y] << endl;
			cnt++;
		}
	}

	// ������
	// for(auto it : l){
	// 	cout << it[0] << ' ' << it[1] << endl;
	// }
	// for(int i = 0; i<5; i++){
	// 	for(int j = 0; j<5; j++){
	// 		cout << i << j << ' ' << excel[i][j] << ' ';
	// 	}
	// 	cout << endl;
	// }

	int size = l.size();
	// �� ���ĺ��� ��ġ�� �˰�������, ��ȣ�� �����.
	for (int i = 0; i < size; i++) {
		char p[2]{ l.front()[0], l.front()[1] };
		l.pop_front();

		// �� ���ĺ��� ��ȣǥ������ ���� ���ٸ�
		int a1[2] = { alphabet[p[0] - 65][0], alphabet[p[0] - 65][1] };
		int a2[2] = { alphabet[p[1] - 65][0], alphabet[p[1] - 65][1] };
		// cout << p[0] << p[1] << endl;
		// cout << a1[0] << a1[1] << ' ' << a2[0] << a2[1] << endl;
		if (a1[0] == a2[0]) {
			// ��ĭ�� �������� ���ڸ� ���
			cout << excel[a1[0]][(a1[1] + 1) % 5] << excel[a2[0]][(a2[1] + 1) % 5];
		}
		// �� ���ĺ��� ��ȣǥ������ ���� ���ٸ�
		else if (a1[1] == a2[1]) {
			// ��ĭ�� �Ʒ����� ���ڸ� ���
			cout << excel[(a1[0] + 1) % 5][a1[1]] << excel[(a2[0] + 1) % 5][a2[1]];
		}
		else {	// ��ġ�� ���� ��ٸ�
			// ������ �� ��ġ�� �ٲپ� ���
			cout << excel[a1[0]][a2[1]] << excel[a2[0]][a1[1]];
		}
	}

	return 0;
}