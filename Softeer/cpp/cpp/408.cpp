// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=308
// 제출 링크 : 
// 소프티어 8단 변속기

// 쉬어갈겸 푸는 level 2문제

/*
어.. 왜 레벨 1이 아닐까..?
*/

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int nums[8];
	for (int i = 0; i < 8; i++) {
		cin >> nums[i];
	}

	if (nums[0] == 1) {
		bool asc = true;
		for (int i = 1; i < 8; i++) {
			if (nums[i] != i + 1) {
				asc = false;
				break;
			}
		}

		if (asc) {
			cout << "ascending" << endl;
		}
		else {
			cout << "mixed" << endl;
		}

	}
	else if (nums[0] == 8) {
		bool desc = true;
		for (int i = 1; i < 8; i++) {
			if (nums[i] != 8 - i) {
				desc = false;
				break;
			}
		}

		if (desc) {
			cout << "descending" << endl;
		}
		else {
			cout << "mixed" << endl;
		}
	}
	else {
		cout << "mixed" << endl;
	}

	return 0;
}