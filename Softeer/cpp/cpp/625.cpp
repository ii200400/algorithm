// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=625
// 제출 링크 : 
// 소프티어 좌석 관리

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
어.. 시뮬레이션인가? 구현하라는 지문대로 구현해보겠다.

처음에 모든 차지된 좌석에서 가장 먼 빈 좌석을 어떻게 구하나 했는데 cpp에도 map이 있었다.
map을 사용하는 것이 처음이긴 하였으나, 다른 언어에서도 자주 사용했었고 
cpp의 다른 라이브러리와 비슷하게 사용하면 될 것 같아서 진행하였더니 문제없이 잘 구현.. 된 것 같다!
한 번에 통과할 것 같지는 않지만, 도저언~
(어우 눈 아파;)

1차
틀렸다 아하하하
시간초과나 런타임에러는 나지 않았고 오답이 많이 있다.
또.. 무언가 변수를 잘못쓰거나 했을까..? 너무 코드가 길어서 발견할 수 있을지 모르겠다.

연산이 더 많아지는지 확실하지 않으나, 
이차원 배열로 좌석에 앉을 수 있는지 여부를 보이는 변수를 제거하고
그냥 map에 좌석에 앉은 모든 사람 정보를 기록해서 모든 좌석까지의 거리로 판단할 수 있도록 코드를 수정하였다.

2, 3차
알고리즘은 크게 변하지 않아서 정답과 오답이 변화가 없는 것은 알겠는데..
코드가 쉬워진 만큼 코드 이해는 좋아졌다.
하지만 여전히 왜 오답이 뜨는지 알수가 없다;;

계산 도중에 오버플로우가 생기는 것도 아니고
초기화를 무언가 잘못한 것 같지도 않고 (혹시 몰라서 state 초기화 코드를 수정하였다.)
출력이 잘못된 것도 아니고
변수 조작을 잘못한 것 같지도 않은데
문제의 조건은 잘 이해한 거 같아 막막하다.
if문이 특히 많아서 조건이 이상한지 천천히 살펴봤지만, 못찾겠다;

.. 설마 행열 바꿔썼나..? 아닌디 맞는디..?
와.. 오답 원인을 못 찾겠다;;
*/

#include <iostream>
#include <string>
#include <map>
using namespace std;

int main() {
	// 행 수, 열 수, 작업 수
	int n, m, q;
	cin >> n >> m >> q;

	// 직원의 상태 (0:밥을 안 먹음, 1:좌석에 앉음/밥먹는 중, 2:이미 밥먹고 떠남)
	int state[10001];
	for (int i = 0; i < 10001; i++)
	{
		state[i] = 0;
	}
	// 좌석에 앉아 밥 먹는 직원 정보
	map<int, int*> eating;
	
	string work;
	int id;
	for (int i = 0; i < q; i++)
	{
		cin >> work >> id;
		// 상태에 따라서 작업을 진행한다.
		if (work[0] == 'I')	// in
		{
			if (state[id] == 0) { // 밥을 아직 안 먹었다면 
				int farSeat[2] = {-1, -1}, distance = -1;
				if (eating.size() == 0) { // 아무도 안 앉은 경우
					farSeat[0] = 0, farSeat[1] = 0;
				}
				else { // 좌석을 배정하기 위해 탐색을 한다.
					for (int i = 0; i < n; i++)
					{
						for (int j = 0; j < m; j++)
						{
							// 해당 좌석에서 다른 좌석까지 가장 가까운 좌석까지의 거리를 찾는데
							int shortestDis = 400;
							for (auto it = eating.begin(); it != eating.end(); it++)
							{
								int dx = i - it->second[0], dy = j - it->second[1];
								int tempDis = dx*dx + dy*dy;

								// 다른 사람이 앉은 좌석과 거리가 1이거나 0이면 생략한다.
								if (tempDis <= 1) { 
									goto next;
								}

								if (tempDis < shortestDis)
								{
									shortestDis = tempDis;
								}
							}

							// 그 거리가 이전에 찾은 거리보다 멀면 저장한다.
							if (shortestDis > distance)
							{
								farSeat[0] = i, farSeat[1] = j;
								distance = shortestDis;
							}
							next:;
						}
					}
				}
				// 남은 좌석이 없다면
				if (farSeat[0] == -1) {
					cout << "There are no more seats." << endl;
				}
				else { // 찾은 좌석에 앉힌다.
					state[id] = 1;
					eating[id] = new int[2] {farSeat[0], farSeat[1]};
					//eating.insert({ id, new int[2] {farSeat[0], farSeat[1]} });

					cout << id << " gets the seat (" << farSeat[0]+1 << ", " << farSeat[1]+1 << ")." << endl;
				}
				
			}
			else if (state[id] == 1) { // 이미 좌석에 앉았다면
				cout << id << " already seated." << endl;
			}
			else{ // 이미 밥을 먹었다면
				cout << id << " already ate lunch." << endl;
			}
		}
		else {	// out
			if (state[id] == 0) { // 밥을 아직 안 먹었다면 
				cout << id << " didn't eat lunch." << endl;
			}
			else if (state[id] == 1) { // 좌석에 앉아있었다면
				// 좌석에서 떠난다는 글을 출력하고 변수들에서 제거 및 수정한다.
				auto it = eating.find(id);
				int x = it->second[0], y = it->second[1];
				cout << id << " leaves from the seat (" << x+1 << ", " << y+1 << ")." << endl;
				eating.erase(it);

				state[id] = 2;
			}
			else { // 이미 밥을 먹었다면
				cout << id << " already left seat." << endl;
			}
		}
	}

	return 0;
}