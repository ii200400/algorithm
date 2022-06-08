// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRF8s6ezEDFAUo
// [모의 SW 역량테스트] 핀볼 게임

// 처음에는 단순히 간단한 시뮬레이션인줄 알았는데;;;
// 정말 귀찮은 시뮬레이션인것 같다..
// 메모이제이션을 조금 활용.. 하려고 했는데 안 사용하는 것이 정신에 이로울 것 같다. 정직하게 하자.

// 시간초과 이야기가 많아서 시간초과 될 줄 알았는데 의외로 바로 되어서.. 는 아니고 디버깅하고 바로 패스 받아서 놀랐다.

//JAVA
//언어
//102,860 kb
//메모리
//389 ms
//실행시간
//3,359
//코드길이

package com.ssafy.swea.java5650;

import java.util.Scanner;

public class Solution
{
	static int n, answer;
	static int map[][];

	// 4방위 (오른, 아래, 왼, 위)
	static int[] dr = new int[] {0, 1, 0, -1};
	static int[] dc = new int[] {1, 0, -1, 0};

	// 오른, 아래, 왼, 위 방향의 구슬이 부딫힌 경우 (-1은 되돌아가는 것을 의미)
	static int[][] block = new int[][] { {}, { -1, 0, 3, -1 }, { -1, -1, 1, 0 }, { 1, -1, -1, 2 }, { 3, 2, -1, -1 }, { -1, -1, -1, -1 } };
	// 웜홀 정보
	static int[][][] hole;

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();	// 게임판 크기
			map = new int[n][n];	// 게임판 배열 정보
			answer = 0;	// 점수의 최대값
			hole = new int[6][2][2];
			boolean[] holeCheck = new boolean[6];

			// 게임판 배열, 웜홀 초기화
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n; j++){
					int num = sc.nextInt();
					map[i][j] = num;

					if (num >= 6){
						num -= 6;
						if (holeCheck[num])
							hole[num][1] = new int[] {i, j};
						else{
							holeCheck[num] = true;
							hole[num][0] = new int[] {i, j};
						}
					}
				}
			}

			// 각 위치에서 각 방향의 위치별 점수 확인
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n; j++){
					for (int k = 0; k<4; k++){
						if (map[i][j] == 0)
							rollBall(i, j, k);
					}
				}
			}

			System.out.printf("#%d %d%n", test_case, answer);
		}
	}

	// 핀볼 게임 시작
	// 가로, 세로, 방향을 입력값으로 받는다.
	static void rollBall(int r, int c, int dir){
		int point = 0;
		int originR = r;
		int originC = c;
		int originDir = dir;

		while(true){
			// 한 칸 이동
			r += dr[dir];
			c += dc[dir];

			// 외벽에 부딮힌 경우
			if (r < 0 || r >= n || c < 0 || c >= n){
				if (answer < point*2+1){
					answer = point*2+1;
//					System.out.println(originR + " " + originC + " " + originDir + " " + answer);
				}
//				answer = Math.max(point*2+1, answer);
				return;
			}

			// 원점으로 돌아온 경우
			if (r == originR && c == originC){
				if (answer < point){
					answer = point;
//					System.out.println(originR + " " + originC + " " + originDir + " " + answer);
				}
//				answer = Math.max(point, answer);
				return;
			}

			int thing = map[r][c];	// 갈 위치에 있는 모형
			if (thing == -1){	// 블렉홀을 만난 경우
				if (answer < point){
					answer = point;
//					System.out.println(originR + " " + originC + " " + originDir + " " + answer);
				}
//				answer = Math.max(point, answer);
				return;
			}else if(thing == 0){
				// 아무 일도 일어나지 않는다.
			}else if (thing <= 5){	// 	블록을 만난 경우
				// 이동 방향에 따라서
				dir = block[thing][dir];

				// 튕겨 나가거나
				if (dir == -1){
					if (answer < point*2+1){
						answer = point*2+1;
//						System.out.println(originR + " " + originC + " " + originDir + " " + answer);
					}
//					answer = Math.max(point*2+1, answer);
					return;
				}

				// 방향만 바뀌어서 계속 진행하거나
				point++;
			}else if (thing <= 10){	// 웜홀을 만난 경우
				thing -= 6;	// 웜홀 배열에 쉽게 접근하기 위해 -6

				// 웜홀을 통해 이동
				int[][] holeLoc = hole[thing];
				if (holeLoc[0][0] == r && holeLoc[0][1] == c){
					r = holeLoc[1][0];
					c = holeLoc[1][1];
				}else{
					r = holeLoc[0][0];
					c = holeLoc[0][1];
				}
			}
		}
	}
}
