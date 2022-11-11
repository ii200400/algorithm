// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWyNQrCahHcDFAVP
// swea 방향 전환

// 가장 왼쪽 위 시작점을 0, 0 도착점을 임의의 한 점(0 이상의 수)라고 할 때 최소 이동 회수는 아래와 같다.
// 0 1 4 5 8 ...
// 1 2 3 6 7 ...
// 4 3 4 5 8 ...
// 5 6 5 6 7 ...
// 8 7 8 7 8 ...
// ...

// 잘 보면 특정수가 반복되는 것을 볼 수 있다.
// 1 2 1 이나 4 3 4 3 4, 5 6 5 6 5 6 5 같은..;; 이것을 토대로 식을 만들어 해결하였다.
// 이게 시험만 아니었다면 이쁜 수열 만들었다고 출제자한테 박수쳤을 것이다.

// 미안하니까 bfs로도 한 번 풀어봐야겠다.

package com.ssafy.swea.java8382;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
//		solution1();
		solution2();
	}
	
	// 수식 계산으로 해결
	static void solution1(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 시작점과 끝점의 차이를 절대값으로 바꾸고
			int startR = sc.nextInt(), startC = sc.nextInt();
			int endR = sc.nextInt(), endC = sc.nextInt();
			int absR = Math.abs(startR-endR), absC = Math.abs(startC-endC);

			// 연산을 하여 최소 이동을 구한다.
			int num = Math.max(absR, absC);
			System.out.printf("#%d %d%n", test_case, (absR+absC)%2==0? num*2:num*2-1);
		}
	}

	static void solution2(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 시작점과 끝점의 차이를 절대값으로 바꾸고
			int startR = sc.nextInt(), startC = sc.nextInt();
			int endR = sc.nextInt(), endC = sc.nextInt();
			int absR = Math.abs(startR-endR), absC = Math.abs(startC-endC);

			if (absR == 0 && absC == 0){
				System.out.printf("#%d 0%n", test_case);
				continue;
			}

			// 해당 위치까지의 최소거리를 구한다.
			int n = Math.max(2, absR+1);	// 세로 크기
			int m = Math.max(2, absC+1);	// 가로 크기
			boolean[][][] visited = new boolean[n][m][2];	// 방문 체크
			visited[0][0][0] = true;
			visited[0][0][1] = true;

			Queue<int[]> q = new LinkedList<>();
			// [가로, 세로, 직전에 가로 이동이면 0, 세로 이동이면 1]
			q.offer(new int[] {0, 0, 0});
			q.offer(new int[] {0, 0, 1});
			
			// 위 오른쪽 아래 왼쪽
			int[] dr = new int[] {-1, 0, 1, 0};
			int[] dc = new int[] {0, 1, 0, -1};

			int move = 0;	// 이동 회수
			bfs: while (true){
				move++;

				int qSize = q.size();
				for (int i = 0; i<qSize; i++){
					int[] current = q.poll();
					int r = current[0];
					int c = current[1];
					int moveType = current[2]; // 직전에 가로 이동이면 0, 세로 이동이면 1

					// 가로이동이면 위와 아래를(j가 0, 2), 세로이동이면 오른쪽, 왼쪽을(j가 1, 3) 살펴본다.
					for (int j = moveType; j<4; j+=2){
						int nr = r+dr[j];
						int nc = c+dc[j];
						int nType = moveType==0? 1:0;

						// 도착점에 도달하면 bfs종료
						if (nr == absR && nc == absC){
							break bfs;
						}

						// 범위가 벗어나거나 이미 방문한 상태라면 생략
						if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc][nType])
							continue;

						// 방문 체크 및 큐에 저장
						visited[nr][nc][nType] = true;
						q.offer(new int[] {nr, nc, nType});
					}
				}
			}

			// 최소 이동 회수
			System.out.printf("#%d %d%n", test_case, move);
		}
	}
}
