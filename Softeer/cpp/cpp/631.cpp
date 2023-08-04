// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=631
// ���� ��ũ : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_236965&psProblemId=631
// ����Ƽ�� [21�� ������ ��ȸ ����] Ʈ��

// �ñ��ؼ� Ǯ��� ���� 4 ����

/*
��.. �ʹ� ����.. �ϴ� Ǯ�� ������� �ۼ��غ��ڴ�.

1. ��� �Һ����� ������ ũ�� ������������ �����Ѵ�. �ڷ����� vector<int[]<���� ũ��, ���� ����, �Һ��� �ѹ�>>
2. �ó����� ���⵵ ������������ �����Ѵ�.
3. �� �Һ����� ���� �� ���� ���� ������ �����ϴ� �迭�� ������ ���� ��, ũ�� ������ �����
	���� ���� ���� ���� �ó����� ������ ������ ������ �Һ����� ������ ������ ���� ���캻��.
4. ���� ���� �ó����� ���⿡ �����ߴٸ� �ش� ����� ũ�⸦ Ű:������ map �ڷ����� �����ϰ� 
	�̷� ������� ��� �ó����� ���⿡ ���ؼ��� �Ȱ��� �����Ѵ�.
5. ������ map�� ������� ���� ������ �°� ����� �Ѵ�.

-- 1�� �õ� -- 
��! ������ ����, ������ ��Ÿ�� �����̴�.
.. �׷��� ��� ����� ������..?

int* best �� ũ�⸦ ����� ���� n�� �ƴ϶� �ó����� ���� m�� �־���;
�̰͸� �����ִ� ����! ��δϰ� ����!
�ӵ��� ���� ���� ���̽��� 0.55�� ������ ���� �� ����!

*/

#include<iostream>
#include<vector>
#include<map>
#include <algorithm>

using namespace std;

int main(int argc, char** argv)
{
	// �Һ��� ���� �Һ����� ���ȵ�<���� ũ��, ���� ���, �Һ��� ��ȣ>
	int n;
	vector<vector<int>> consumers;
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		// �Һ����� ���� ��
		int a;
		cin >> a;

		for (; a > 0; a--) {
			vector<int> v;
			int temp;
			cin >> temp;
			v.push_back(temp);
			cin >> temp;
			v.push_back(temp);
			v.push_back(i);

			consumers.push_back(v);
		}
	}

	/*
	������
	for (auto i : consumers) {
		cout << i[0] << ' ' << i[1] << ' ' << i[2] << endl;
	}
	*/

	// �Һ����� ������ ũ������� �����Ѵ�.
	sort(consumers.begin(), consumers.end());

	// �ó����� ��
	int m;
	cin >> m;

	// �ó������� �� ���(���� �� �ȰͰ� �� ��)
	vector<int> scen;
	vector<int> scenSort;
	for (int i = 0; i < m; i++) {
		int temp;
		cin >> temp;

		scen.push_back(temp);
		scenSort.push_back(temp);
	}

	sort(scenSort.begin(), scenSort.end());

	// �Һ��ں� �ִ� ����
	int* best = new int[n] {0};
	// �ó����� �ڵ��� ũ��, �Һ��� �ִ� ���, �Һ��� ���� �ε���
	int carSize = 0, priceSum = 0, conIdx = 0;
	// �ó����� �� ������ �ּ��� ũ��
	map<int, int> scenMap;

	// �ó������� ����� �ϳ��� ����.
	for (int i = 0; i < m; i++) {
		// cout << priceSum << ' ' << carSize << ' ' << scenSort[i] << endl;

		// �̹� ����� �ó����� ��뺸�� ũ�ٸ� map�� �����Ѵ�.
		if (priceSum >= scenSort[i]) {
			scenMap[scenSort[i]] = carSize;
			continue;
		}

		// �� ����� �ѱ� ������, �Һ����� ������ ���� ���� ������ ���캻��.
		while (priceSum < scenSort[i] && conIdx < consumers.size()) {
			int size = consumers[conIdx][0], price = consumers[conIdx][1], conNum = consumers[conIdx][2];
			conIdx++;

			// �Һ����� ������ ���� ���Ⱥ��� ����� ���ٸ�, �װ����� ��ü�Ѵ�.
			if (price > best[conNum]) {
				priceSum += price - best[conNum];
				best[conNum] = price;
				carSize = size;

				// ���� �� ����� �ó����� ��뺸�� ũ�ٸ� map�� �����Ѵ�.
				if (priceSum >= scenSort[i]) {
					scenMap[scenSort[i]] = carSize;
					break;
				}
			}
		}
	}

	// map�� ����� ������ ������ �°� ����Ѵ�.
	for (int i = 0; i < m; i++) {
		if (scenMap.find(scen[i]) != scenMap.end()) {
			cout << scenMap[scen[i]] << ' ';
		}
		else {
			cout << -1 << ' ';
		}
	}

	return 0;
}
