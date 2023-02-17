// ������ũ : https://softeer.ai/practice/info.do?idx=1&eid=625
// ���� ��ũ : 
// ����Ƽ�� �¼� ����

// cpp �� �����ϱ� ���ؼ� Ǯ�� �ִ� level 3 ����

/*
��.. �ùķ��̼��ΰ�? �����϶�� ������� �����غ��ڴ�.

ó���� ��� ������ �¼����� ���� �� �� �¼��� ��� ���ϳ� �ߴµ� cpp���� map�� �־���.
map�� ����ϴ� ���� ó���̱� �Ͽ�����, �ٸ� ������ ���� ����߾��� 
cpp�� �ٸ� ���̺귯���� ����ϰ� ����ϸ� �� �� ���Ƽ� �����Ͽ����� �������� �� ����.. �� �� ����!
�� ���� ����� �� ������ ������, ������~
(��� �� ����;)

1��
Ʋ�ȴ� ��������
�ð��ʰ��� ��Ÿ�ӿ����� ���� �ʾҰ� ������ ���� �ִ�.
��.. ���� ������ �߸����ų� ������..? �ʹ� �ڵ尡 �� �߰��� �� ������ �𸣰ڴ�.

������ �� ���������� Ȯ������ ������, 
������ �迭�� �¼��� ���� �� �ִ��� ���θ� ���̴� ������ �����ϰ�
�׳� map�� �¼��� ���� ��� ��� ������ ����ؼ� ��� �¼������� �Ÿ��� �Ǵ��� �� �ֵ��� �ڵ带 �����Ͽ���.

2, 3��
�˰����� ũ�� ������ �ʾƼ� ����� ������ ��ȭ�� ���� ���� �˰ڴµ�..
�ڵ尡 ������ ��ŭ �ڵ� ���ش� ��������.
������ ������ �� ������ �ߴ��� �˼��� ����;;

��� ���߿� �����÷ο찡 ����� �͵� �ƴϰ�
�ʱ�ȭ�� ���� �߸��� �� ������ �ʰ� (Ȥ�� ���� state �ʱ�ȭ �ڵ带 �����Ͽ���.)
����� �߸��� �͵� �ƴϰ�
���� ������ �߸��� �� ������ ������
������ ������ �� ������ �� ���� �����ϴ�.
if���� Ư�� ���Ƽ� ������ �̻����� õõ�� ���������, ��ã�ڴ�;

.. ���� �࿭ �ٲ�質..? �ƴѵ� �´µ�..?
��.. ���� ������ �� ã�ڴ�;;
*/

#include <iostream>
#include <string>
#include <map>
using namespace std;

int main() {
	// �� ��, �� ��, �۾� ��
	int n, m, q;
	cin >> n >> m >> q;

	// ������ ���� (0:���� �� ����, 1:�¼��� ����/��Դ� ��, 2:�̹� ��԰� ����)
	int state[10001];
	for (int i = 0; i < 10001; i++)
	{
		state[i] = 0;
	}
	// �¼��� �ɾ� �� �Դ� ���� ����
	map<int, int*> eating;
	
	string work;
	int id;
	for (int i = 0; i < q; i++)
	{
		cin >> work >> id;
		// ���¿� ���� �۾��� �����Ѵ�.
		if (work[0] == 'I')	// in
		{
			if (state[id] == 0) { // ���� ���� �� �Ծ��ٸ� 
				int farSeat[2] = {-1, -1}, distance = -1;
				if (eating.size() == 0) { // �ƹ��� �� ���� ���
					farSeat[0] = 0, farSeat[1] = 0;
				}
				else { // �¼��� �����ϱ� ���� Ž���� �Ѵ�.
					for (int i = 0; i < n; i++)
					{
						for (int j = 0; j < m; j++)
						{
							// �ش� �¼����� �ٸ� �¼����� ���� ����� �¼������� �Ÿ��� ã�µ�
							int shortestDis = 400;
							for (auto it = eating.begin(); it != eating.end(); it++)
							{
								int dx = i - it->second[0], dy = j - it->second[1];
								int tempDis = dx*dx + dy*dy;

								// �ٸ� ����� ���� �¼��� �Ÿ��� 1�̰ų� 0�̸� �����Ѵ�.
								if (tempDis <= 1) { 
									goto next;
								}

								if (tempDis < shortestDis)
								{
									shortestDis = tempDis;
								}
							}

							// �� �Ÿ��� ������ ã�� �Ÿ����� �ָ� �����Ѵ�.
							if (shortestDis > distance)
							{
								farSeat[0] = i, farSeat[1] = j;
								distance = shortestDis;
							}
							next:;
						}
					}
				}
				// ���� �¼��� ���ٸ�
				if (farSeat[0] == -1) {
					cout << "There are no more seats." << endl;
				}
				else { // ã�� �¼��� ������.
					state[id] = 1;
					eating[id] = new int[2] {farSeat[0], farSeat[1]};
					//eating.insert({ id, new int[2] {farSeat[0], farSeat[1]} });

					cout << id << " gets the seat (" << farSeat[0]+1 << ", " << farSeat[1]+1 << ")." << endl;
				}
				
			}
			else if (state[id] == 1) { // �̹� �¼��� �ɾҴٸ�
				cout << id << " already seated." << endl;
			}
			else{ // �̹� ���� �Ծ��ٸ�
				cout << id << " already ate lunch." << endl;
			}
		}
		else {	// out
			if (state[id] == 0) { // ���� ���� �� �Ծ��ٸ� 
				cout << id << " didn't eat lunch." << endl;
			}
			else if (state[id] == 1) { // �¼��� �ɾ��־��ٸ�
				// �¼����� �����ٴ� ���� ����ϰ� �����鿡�� ���� �� �����Ѵ�.
				auto it = eating.find(id);
				int x = it->second[0], y = it->second[1];
				cout << id << " leaves from the seat (" << x+1 << ", " << y+1 << ")." << endl;
				eating.erase(it);

				state[id] = 2;
			}
			else { // �̹� ���� �Ծ��ٸ�
				cout << id << " already left seat." << endl;
			}
		}
	}

	return 0;
}