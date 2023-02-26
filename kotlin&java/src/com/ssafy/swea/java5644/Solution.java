// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo

// 효율적으로 하는 방법은 모르겠고.. 그냥 해야겠다;;
// 두 사람이 이동하면서 최대로 충전할 수 있는 경우를 각가 살펴봐주었다.
// 각자 충전이 가능하면 각자 충전하고 겹치면 누구 한명 양보해줄 수 있는 사람이 양보하는 식으로 진행했는데
// 생각보다 코드가 길었다.

package com.ssafy.swea.java5644;

import java.util.*;

public class Solution
{

	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 초기화
			int m = sc.nextInt();	// 이동 시간
			int a = sc.nextInt();	// BC 개수
			int[] walking1 = new int[m+1];	// 사용자 A의 이동 정보 (초기 위치 계산을 위해 인덱스 0은 0으로 고정)
			int[] walking2 = new int[m+1];	// 사용자 B의 이동 정보 (초기 위치 계산을 위해 인덱스 0은 0으로 고정)
			int[][] stationInfo = new int[a][4];	// BC 정보
			int totalCharge = 0;	// 총 충전량

			for (int i = 1; i<=m; i++){
				walking1[i] = sc.nextInt();
			}
			for (int i = 1; i<=m; i++){
				walking2[i] = sc.nextInt();
			}
			for (int i = 0; i<a; i++){
				stationInfo[i] = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
			}
			// ??? 이런 메서드가 있다..
			Arrays.sort(stationInfo, Comparator.comparingInt(o -> -o[3]));
//			System.out.println(Arrays.deepToString(stationInfo));

			// 사용자 이동 시뮬레이션 시작
			int[] location1 = new int[]{1,1};	// 사용자 A의 위치
			int[] location2 = new int[]{10,10};	// 사용자 B의 위치
			ArrayList<int[]> chargeable1;	// 사용자 A 가 사용할 수 있는 BC
			ArrayList<int[]> chargeable2;	// 사용자 B 가 사용할 수 있는 BC
			for (int i = 0; i<=m; i++){
				walk(walking1[i], location1);
				walk(walking2[i], location2);

				chargeable1 = new ArrayList<>();
				chargeable2 = new ArrayList<>();
				for (int j = 0; j<a; j++){
					// 현재 위치가 BC의 영역이라면
					if (Math.abs(location1[0]-stationInfo[j][0]) + Math.abs(location1[1]-stationInfo[j][1])
							<= stationInfo[j][2]){
						// 추가한다.
						chargeable1.add(new int[]{j, stationInfo[j][3]});
					}

					// 아 몰라 복붙
					if (Math.abs(location2[0]-stationInfo[j][0]) + Math.abs(location2[1]-stationInfo[j][1])
							<= stationInfo[j][2]){
						chargeable2.add(new int[]{j, stationInfo[j][3]});
					}
				}

				int size1 = chargeable1.size();
				int size2 = chargeable2.size();
				if (size1 > 0 && size2 == 0){
					// 1. 사용자A만 충전하는 경우
					totalCharge += chargeable1.get(0)[1];

				}else if (size1 == 0 && size2 > 0){
					// 2. 사용자B만 충전하는 경우
					totalCharge += chargeable2.get(0)[1];

				}else if (size1 > 0 && size2 > 0){
					// 3-1. 둘 모두 충전 가능한데 둘이 사용할 수 있는 BC가 겹친다!
					if (chargeable1.get(0)[0] == chargeable2.get(0)[0]){
						if (size1 > 1 && size2 > 1){
							// 4. 둘 모두 더 고려할 BC가 있다면 더 크게 충전 되는 곳을 골라서 충전한다.
							totalCharge += chargeable1.get(0)[1] + Math.max(chargeable1.get(1)[1], chargeable2.get(1)[1]);

						}else if (size1 == 1 && size2 > 1){
							// 5. 사용자 B만 두곳이 가능하면 A첫번째 장소와 B의 두번째를 더한다.
							totalCharge += chargeable1.get(0)[1] + chargeable2.get(1)[1];

						}else if (size1 > 1 && size2 == 1){
							// 6. 사용자 A만 두곳이 가능하면 B첫번째 장소와 A의 두번째를 더한다.
							totalCharge += chargeable2.get(0)[1] + chargeable1.get(1)[1];
						}else{ // 7. 둘이 나눠 사용해야 하는 경우라면 그냥 하나만 더한다.
							totalCharge += chargeable1.get(0)[1];
						}

					}else{ // 3-2. 둘 모두 충전 가능한데 둘이 사용할 수 있는 BC가 안 겹치면 그냥 각자 더한다.
						totalCharge += chargeable1.get(0)[1] + chargeable2.get(0)[1];
					}
				}

			}

			// 총 충전량 출력
			System.out.printf("#%d %d\n", test_case, totalCharge);
		}
	}

	static void walk(int walkInfo, int[] location){
		switch (walkInfo) {
			case 1: // 상
				location[1]--;
				break;
			case 2:	// 우
				location[0]++;
				break;
			case 3:	// 하
				location[1]++;
				break;
			case 4:	// 좌
				location[0]--;
				break;
		}
	}
}
