// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=308
// ���� ��ũ : 
// ����Ƽ�� 8�� ���ӱ�

// ����� Ǫ�� level 2����

/*
��.. �� ���� 1�� �ƴұ�..?
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