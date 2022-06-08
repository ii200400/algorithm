// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRFInKex8DFAUo
// [모의 SW 역량테스트] 원자 소멸 시뮬레이션

// 이런 저런 생각 아무리 해도 시간초과 뜨는 미래가 보여서 댓글에서 아래의 방법을 보고 생각나는 방법으로 진행하였다..

//  날밤 2022-06-06 16:28 댓글
//1. 입력받는 사이즈 2배 늘려서 저장
//2. 충돌좌표가 같은 원자들이 있으면 map[1000][1000]에 저장하면서 거리값(|x1-x2| + |y1-y2|)/2 순으로 우선순위 큐에 저장
//3. 작은값부터 큐에서 꺼내서 충돌좌표가 같을 때 에너지 더하고, dead flag = 1, 충돌된 원자들은 충돌 위치의 좌표값으로 새로 업데이트
//4. 이미 dead flag가 올라간 건 다시 위치값을 업데이트 하지 않음

// 본인의 경우 우선순위 큐에 바로 [두 원소의 idx와 거리값 (|x1-x2| + |y1-y2|), 충돌시간(동시충돌을 고려하기 위해)]을 넣고
// 두 점이 충돌이 일어날 시간 (|x1-x2| + |y1-y2|)/2 을 유추할 수 있으므로 해당 시간에 원소가 충돌하는지 확인하여 진행하였다.

// 0.5에서 충돌하는 원소의 경우 아래의 조건에 만족하는지 확인하였다.
// 1. 충돌 예상 시간에 거리 차이가 1인지
// 2. 충돌 예상 시간 +1 에도 거리 차이가 1인지
// 3. 두 원소의 방향이 서로 반대되는지 (본인의 경우 두 원소의 방향 값의 합이 1(상하)이거나 5(좌우)인지로 판단)

// 또한 원소가 동시에 충돌하는 경우도 있으므로

package com.ssafy.swea.java5648;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();	// 원자 수
			// 각 원소 정보 [r위치, c위치, 이동방향, 보유 에너지, 충돌시간], 충돌시간이 -1이면 아직 충돌하지 않은 원소
			int[][] atoms = new int[n][4];	
			int answer = 0;	// 방출한 총 에너지

			// 각 원소 정보 초기화
			for (int i = 0; i<n; i++){
				int c = sc.nextInt();
				int r = sc.nextInt();
				atoms[i] = new int[] {r, c, sc.nextInt(), sc.nextInt(), -1};
			}

			// 좌표기준 상하좌우(원래 평소에는 하상좌우라고 작성..) 4방향
			int[] dr = new int[] {1, -1, 0, 0};
			int[] dc = new int[] {0, 0, -1, 1};

			// 우선순위 큐, 거리 차이를 기준으로 오름차순 정렬
			// [원소1 idx, 원소2 idx, 두 원소의 거리 차이, 충돌 시간]이 입력으로 들어간다.
			PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
			boolean[] used = new boolean[n];

			// 각 정점의 거리 차이를 pq에 추가
			for (int i = 0; i<n; i++){
				for (int j = i+1; j<n; j++){
					pq.offer(new int[] {i, j, Math.abs(atoms[i][0]-atoms[j][0]) + Math.abs(atoms[i][1]-atoms[j][1])});
				}
			}
			
			// 차이 순으로 살펴보면서 충돌하는지 확인
			while(!pq.isEmpty()){
				int[] current = pq.poll();
				int a1 = current[0];	// 첫번째 원소 idx
				int a2 = current[1];	// 두번째 원소 idx
				int size = current[2];	// 두 원소의 거리
				int[] atom1 = atoms[a1];	// 첫번째 원소 정보
				int[] atom2 = atoms[a2];	// 두번째 원소 정보

				int mul = (size/2);	// 충돌 예상 시간
				// 충돌 예상 시간의 두 원소의 r, c 위치들
				int nr1 = atom1[0] + dr[atom1[2]] * mul;
				int nc1 = atom1[1] + dc[atom1[2]] * mul;
				int nr2 = atom2[0] + dr[atom2[2]] * mul;
				int nc2 = atom2[1] + dc[atom2[2]] * mul;

				// 충돌 예상 시간의 두 원소의 거리 (0이나 1이여야 충돌 가능성이 있다 그렇지 않으면 충돌하는 원소들이 아니다.)
				int diff = Math.abs(nr1 - nr2) + Math.abs(nc1 - nc2);
				
				// 중간 지점에서 충돌하는지 확인(0.5 부분에서)
				if (size % 2 == 1){
					// 둘 중 한 원소라도 이미 충돌했다면 패스
					if (used[a1] || used[a2])
						continue;

					// 충돌한다면 (아래 조건에 충족한다면)
					// 1. 충돌 예상 시간에 거리 차이가 1인지
					// 2. 충돌 예상 시간 +1 에도 거리 차이가 1인지
					// 3. 두 원소의 방향이 서로 반대되는지 (본인의 경우 두 원소의 방향 값의 합이 1(상하)이거나 5(좌우)인지로 판단)
					if(diff == 1 &&
							Math.abs(nr1+dr[atom1[2]]-nr2-dr[atom2[2]]) + Math.abs(nc1+dc[atom1[2]]-nc2-dc[atom2[2]]) == 1 &&
							(atom1[2]+atom2[2] == 1 || atom1[2]+atom2[2] == 5) ){
						// 에너지 저장 및 충돌 체크
						answer += atom1[3] + atom2[3];
						atoms[a1][4] = mul;
						atoms[a2][4] = mul;
						used[a1] = true;
						used[a2] = true;
					}
				}else{	// 충돌하는지 확인2
					// 두 원소 이미 충돌했다면 패스
					if (used[a1] && used[a2])
						continue;

					// 충돌 예상 시간에 두 원소의 거리가 0인데
					if (diff == 0) {
						// 원소 1이 이미 충돌했었다면
						if (used[a1]) {
							// 원소 2도 같은 시간에 동시에 충돌하는지 확인하고
							if (atoms[a1][4] == mul) {
								// 에너지 저장 및 충돌 체크
								answer += atoms[a2][3];
								atoms[a2][4] = mul;
								used[a2] = true;
							}
						} else if (used[a2]) {	// 원소 2가 이미 충돌했었다면
							// 원소 1도 같은 시간에 동시에 충돌하는지 확인하고
							if (atoms[a1][4] == mul) {
								// 에너지 저장 및 충돌 체크
								answer += atoms[a1][3];
								atoms[a1][4] = mul;
								used[a1] = true;
							}
						} else { // 2개의 원소가 충돌한다면
							// 에너지 저장 및 충돌 체크
							answer += atoms[a1][3] + atoms[a2][3];
							atoms[a1][4] = mul;
							atoms[a2][4] = mul;
							used[a1] = true;
							used[a2] = true;
						}
					}
				}
			}

			// 방출된 에너지 출력..
			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
}
