// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=395
// ���� ��ũ : 
// ����Ƽ�� �ݰ�����

// ����� Ǫ�� level 2����

/*
�ϰ���° ���� 2 ����

������° ������ �ʹ� ������ ���ݴ� ��������� �ʹ�.
�� �������� �������� ���Ҵ�.
�׷���, �ִ� ������.. ���Դ� �����̶��? ���İ��� Ž��� ������ �Ǿ���..
*/

#include<iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char** argv)
{
	// �賶 ����, �ͱݼ� ����
	int w, n;
	cin >> w >> n;

	// pair<���Դ� ����, �ݼ��� ����>
	vector<pair<int, int>> metals;
	for (int i = 0; i < n; i++) {
		pair<int, int> p;
		cin >> p.second >> p.first;
		metals.push_back(p);
	}

	sort(metals.begin(), metals.end());

	// �賶�� ���� �� �ִ� ���� ��� ����
	int price = 0;
	while (w > 0 && n > 0) {
		pair<int, int> metal = metals.back();
		metals.pop_back();

		if (w < metal.second) {
			metal.second = w;
		}

		w -= metal.second;
		price += metal.second * metal.first;

		n--;

		// cout << price  << ' ' << metal.second() << ' ' << w << ' ' << n << endl;
	}

	cout << price << endl;

	return 0;
}