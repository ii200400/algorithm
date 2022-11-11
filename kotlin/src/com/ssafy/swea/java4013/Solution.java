// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH
// swea [모의 SW 역량테스트] 특이한 자석

// 예전에 백준의 톱니바퀴로 푼 경험이 있는 문제...
// 그런데 문제만 기억나고 어떻게 풀었는지 기억 하나도 안난다;;

// 문제 풀면서 어떻게 풀었는지 기억나서 그대로 적용했다.
// 문제는 톱니의 12시 방향의 극성을 기준으로 점수를 계산해서 출력하는 것이므로
// 12시 방향의 톱니를 가리키는 인덱스 배열(gearIdx)을 만들고 실재로 톱니를 돌려주는 것이 아니라 인덱스만 바꾸는 방향으로 한다.
// 3시와 6시 쪽의 맞물리는 톱니를 구하는 것은 +2 -2로 구하는 것 보다는 +2 +6으로 구하는 것이 더 편해서 (그.. 나머지 공식 어쩌구 활용)
// 중간에 톱니가 돌아가면 연산이 어려워지므로 우선 모든 톱니가 어떻게 돌지 배열(gearTurn)에 저장을 했다가 한꺼번에 바꾼다.
// 모든 연산을 마치고 12시 인덱스 배열을 확인하면서 점수를 계산하고 출력하기만 하면 된다.

package com.ssafy.swea.java4013;

import java.util.Scanner;

// 서로 붙어 있는 날의 자성이 다를 경우에만 반대 방향으로 1 칸 회전
// 자석을 회전시키는 방향은 시계방향이 1 로, 반시계 방향이 -1
// N 극이 0 으로, S 극이 1

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int k = sc.nextInt();	// 회전 회수
			int[] gearIdx = new int[] {0, 0, 0, 0};	// 각 톱니의 12시 위치를 가리키는 인덱스
			boolean[][] gears = new boolean[4][8];	// 톱니 정보 (n극이 true, s극이 false)

			// 톱니 정보 초기화
			for (int i = 0; i<4; i++){
				for (int j = 0; j<8; j++){
					gears[i][j] = sc.nextInt()==0;
				}
			}

			// 톱니 돌리기 시작
			for (int i = 0; i<k; i++){
				int num = sc.nextInt()-1;	// 현재 돌릴 기어 인덱스
				int turnGear = sc.nextInt();	// 시계방향이면 1, 반시계이면 -1
				int[] gearTurn = new int[4];		// 각 기어가 도는 정보, 시계방향이면 1, 반시계이면 -1, 안돌면 0
				gearTurn[num] = turnGear;

				// 왼쪽 회전 확인
				for (int j = num+1; j<4; j++){
					// 왼쪽의 톱니와 현재 톱니가 맞물린 곳이 서로 다른 극이라면
					if (gears[j-1][(gearIdx[j-1]+2)%8] != gears[j][(gearIdx[j]+6)%8]){
						gearTurn[j] = -gearTurn[j-1];	// 왼쪽 톱니와 다른 방향으로 돈다.
					}else{	// 같은 극이면 왼쪽 톱니들도 돌지 않으므로 break;
						break;
					}
				}

				// 오른쪽 회전 확인인
			for (int j = num-1; j>=0; j--){
					// 오른쪽 톱니와 현재 톱니가 맞물린 곳이 서로 다른 극이라면
					if (gears[j+1][(gearIdx[j+1]+6)%8] != gears[j][(gearIdx[j]+2)%8]){
						gearTurn[j] = -gearTurn[j+1];	// 왼쪽 톱니와 다른 방향으로 돈다.
					}else{	// 같은 극이면 오른쪽 톱니들도 돌지 않으므로 break;
						break;
					}
				}

				// gearTurn에 저장된 값을 보고 기어 돌리기 (12시 톱니를 가리키는 인덱스만 바꾼다.)
				for (int j = 0; j < 4; j++){
					// 돌아가는 방향과 반대로 인덱스가 움직여야 한다.
					// 시계반향으로 1칸 가면 12시의 톱니는 (대충) 이전 값의 -1이 된다.
					gearIdx[j] = (gearIdx[j] - gearTurn[j] + 8) % 8;
				}

//				for (int j = 0; j<4; j++){
//					System.out.print(gearIdx[j]);
//				}
//				System.out.println();
			}

			// 점수를 계산하고
			int point = 1;
			int sum = 0;
			for (int i = 0; i<4; i++){
				if (!gears[i][gearIdx[i]])
					sum += point;

				point *= 2;
			}

			// 점수를 출력한다.
			System.out.printf("#%d %d%n", test_case, sum);
		}
	}
}
