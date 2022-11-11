// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRQm6qfL0DFAUo
// swea 벽돌깨기

// 중복조합인 줄 알았는데 중복 순열 생각해보니 중복 순열인 것 같다.
// 구슬을 날릴 때 빈 세로줄이면 그냥 넘어가는 것이 좋겠다 싶어서 구현을 하였다.

package com.ssafy.swea.java5656;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution
{
	static int n, w, h, answer;

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 던질 수 있는 구슬 수, 벽돌판의 가로길이, 세로길이
			n = sc.nextInt(); w = sc.nextInt(); h = sc.nextInt();
			int[][] blocks = new int[h][w];	// 벽돌판 배열 (벽돌이 없으면 0 있으면 탐색 길이)

			// 벽돌판 배열 초기화
			int cnt = 0;	// 벽돌판의 벽돌 개수
			for (int i = 0; i<h; i++){
				for (int j = 0; j<w; j++){
					int num = sc.nextInt();
					if (num != 0){
						cnt++;
						blocks[i][j] = num;
					}
				}
			}
			
			answer = Integer.MAX_VALUE;	// 정답 저장 변수
			// 구슬로 벽돌 깨기 시작
			dfs(0, cnt, blocks);

			System.out.printf("#%d %d%n", test_case, answer);
		}
	}

	// 중복순열로 구슬을 어디에 쏠지 정하면서 구슬을 날려본다.
	// 사용한 구슬 수, 남은 블록 수, 블록판 배열
	static void dfs(int cnt, int blockCnt, int[][] blocks){
		// 모든 구슬을 사용했다면 정답을 적절히 저장
		if (cnt == n){
			answer = Math.min(answer, blockCnt);
			return;
		}

		// 구슬을 날릴 곳을 정하고
		for (int i = 0; i<w; i++){
			// 블록판 복사
			int[][] tempBlocks = cloneBlocks(blocks);
			// 구슬을 날려보고 부셔진 블록판을 반환받는다.
			int broken = playGame(i, tempBlocks);

			// 부셔진 것이 없다면 해당 줄에 더 이상 남은 블록이 없다는 의미이므로
			// 정답을 적절히 저장하고 방금 사용한 구슬을 다른 줄에서 날려보는 시뮬레이션을 해본다.
			if (broken == 0) {	// 해당 빈 줄에 구슬을 다 날리면 현재 블록 수만 남으므로 답이 될 수 있다.
				answer = Math.min(answer, blockCnt);
				continue;
			}

			// 다음 구슬을 사용해본다.
			dfs(cnt+1, blockCnt - broken, tempBlocks);
		}

	}

	// c줄에 구슬을 날려 블록을 없애고 부셔진 블록을 반환하는 함수
	// 구슬을 날릴 줄, 블록 배열
	static int playGame(int c, int[][] blocks){
		// 구슬이 한칸씩 떨어지면서
		for (int i = 0; i<h; i++){
			if (blocks[i][c] != 0){	// 블록에 닿으면
				// 블록으로 인해 연쇄적으로 블록을 터뜨리는 연산을 하고
				int broken = bfs(blocks, i, c);

				// 터진 것이 없다면 정리할 블록이 없으므로 바로 break
				if (broken == 0) return 0;

				// 깨진 블록이 있다면 블록을 정리(중력에 따라 아래로 빈칸이 없도록 옮겨준)한다.
				gravity(blocks);
				return broken;
			}
		}

		return 0;
	}

	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};

	// 4방위 탐색을 하면서 블록을 연쇄적으로 깨뜨리는 함수
	// 블록 배열, 처음 깨지는 블록 가로 위치 r, c
	static int bfs(int[][] blocks, int r, int c){
		int broken = 0;	// 깨지는 블록을 저장

		// bfs를 사용하기 위한 큐
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{r, c, blocks[r][c]});
		blocks[r][c] = 0;	// 블록 초기화

		// 큐가 빌 때까지
		while (!q.isEmpty()){
			int[] current = q.poll();	// 현재 터지는 블록 위치
			broken++;	// 블록이 하나 더 깨지므로

			// 1칸 너비라면 다른 블록에 영향이 가지 않으므로
			if (current[2] == 1)
				continue;

			// 4방위 탐색으로 다른 블록에 영향을 끼치는지 확인한다.
			for (int i = 0; i<4; i++) {
				// 한칸씩 진행하면서 범위가 넘어가면 패스
				for (int nr = current[0]+dr[i], nc = current[1]+dc[i], limit = current[2] - 1;
					 0 <= nr && nr < h && 0 <= nc && nc < w && limit > 0;
					 nr+=dr[i], nc+= dc[i], limit--) {

					// 블록이 존재 하지 않아도 패스
					if (blocks[nr][nc] == 0)
						continue;

					// 그렇지 않다면 블록 위치와 숫자를 큐에 저장하고 방문처리를 해준다.
					q.add(new int[] {nr, nc, blocks[nr][nc]});
					blocks[nr][nc] = 0;
				}
			}
		}

		// 연쇄 폭발이 끝나면 터진 블록 반환
		return broken;
	}

	// 블록을 아래방향으로 빈 칸이 없도록 차곡차곡 쌓는 함수
	// 블록판 배열
	static void gravity(int[][] blocks){
		// 각 세로줄 마다
		for (int j = 0; j < w; j++) {
			// 아래쪽부터 탐색하는데
			for (int i = h-1; i > 0; i--) {
				// 블록이 없는 곳이 발견되면
				if (blocks[i][j] == 0){

					// 해당위치 위쪽으로 블록을 찾는데
					int tempR = i-1;
					while (tempR >= 0 && blocks[tempR][j] == 0)
						tempR--;

					// 남은 블록이 없다면 다음 줄을 진행
					if (tempR == -1)
						break;

					// 남은 블록이 있다면 해당 블록을 i 위치로 옮긴다.
					blocks[i][j] = blocks[tempR][j];
					blocks[tempR][j] = 0;
				}
			}
		}
	}

	// 블록판 복사
	static int[][] cloneBlocks(int[][] blocks){
		int[][] tempBlocks = new int[h][w];
		for (int i = 0; i<h; i++){
			tempBlocks[i] = blocks[i].clone();
		}
		return tempBlocks;
	}
}
