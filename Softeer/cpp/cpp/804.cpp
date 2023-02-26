// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=804
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_148710&psProblemId=804
// 소프티어 플레이페어 암호

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
어휴.. 신기한 문제 많네..
지문대로 코드를 작성하면 될 것 같다. 
메시지가 얼마나 길어질지 모르겠으니 리스트를 활용하고 
키의 크기는 무조건 5*5이니 따로 별도의 시간을 줄이는 연산은 하지 않으려고 한다.

구현하다가 중간에 암호표를 만들면서 알파벳별 암호표 위치를 저장하는 것이 좋을 것 같아 이렇게 구현하였다.
중간엨ㅋㅋ %를 &로 넣는 바람에 입력이 굉장히 이상하게 되어 힘들었다.
어떻게 % 대신 &를 넣었는지는 지금도 의문이다;;

*/

#include <iostream>
#include <list>
#include <string>
using namespace std;

int main() {
	// 메시지와 키
	string message, key;

	cin >> message;
	cin >> key;

	// 메시지를 두 문자씩 짝 맞추기
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

	// 키를 활용하여 암호표 만들기
	// 암호표, 알파벳 별 암포표에서의 위치
	char excel[5][5];
	int alphabet[26][2];
	for (int i = 0; i < 26; i++) {
		alphabet[i][0] = -1, alphabet[i][1] = -1;
	}
	alphabet['J' - 65][0] = 0;

	// 키를 암호표로 변환
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

	// 키에서 나타나지 않은 알파벳을 암호표에 추가
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

	// 디버깅용
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
	// 각 알파벳의 위치는 알고있으니, 암호를 만든다.
	for (int i = 0; i < size; i++) {
		char p[2]{ l.front()[0], l.front()[1] };
		l.pop_front();

		// 두 알파벳의 암호표에서의 행이 같다면
		int a1[2] = { alphabet[p[0] - 65][0], alphabet[p[0] - 65][1] };
		int a2[2] = { alphabet[p[1] - 65][0], alphabet[p[1] - 65][1] };
		// cout << p[0] << p[1] << endl;
		// cout << a1[0] << a1[1] << ' ' << a2[0] << a2[1] << endl;
		if (a1[0] == a2[0]) {
			// 한칸씩 오른쪽의 문자를 출력
			cout << excel[a1[0]][(a1[1] + 1) % 5] << excel[a2[0]][(a2[1] + 1) % 5];
		}
		// 두 알파벳의 암호표에서의 열이 같다면
		else if (a1[1] == a2[1]) {
			// 한칸씩 아래쪽의 문자를 출력
			cout << excel[(a1[0] + 1) % 5][a1[1]] << excel[(a2[0] + 1) % 5][a2[1]];
		}
		else {	// 위치가 따로 논다면
			// 서로의 열 위치를 바꾸어 출력
			cout << excel[a1[0]][a2[1]] << excel[a2[0]][a1[1]];
		}
	}

	return 0;
}