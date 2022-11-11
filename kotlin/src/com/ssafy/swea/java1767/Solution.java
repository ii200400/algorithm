// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf
// swea 프로세서 연결하기

// 각 프로세서들을 4방위 탐색+전선 연결 안함 을 시도하면서 가장 전선을 적게쓰는 경우의 전선수를 저장하는 문제
// 처음에 전선 연결을 무조건 적게 연결하는 것으로 기준을 들어서 틀렸는데
// 지문을 보니 프로세스를 가장 많이 연결하는 것 중 전선을 가장 적게 쓰는 것, 이라는 내용이 있었다 ^ㅠ^
// 문제 잘 읽자..

package com.ssafy.swea.java1767;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
	static int n, answer, connectCnt;	// 프로세서 크기, 정답 변수, 연결된 코어의 수
	static ArrayList<int[]> cores;	// 코어들의 위치 배열
	static boolean[][] map;	// 전선+코어 방문 배열

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();	// 프로세서 크기
			map = new boolean[n][n];	// 전선+코어 방문 배열
			cores = new ArrayList<>();	// 코어들의 위치 배열

			// 프로세서와 코어들의 위치 초기화
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n; j++){
					map[i][j] = sc.nextInt()==1;
					if (map[i][j]){
						cores.add(new int[]{i, j});
					}
				}
			}

			connectCnt = 0;	// 연결한 코어의 수
			answer = Integer.MAX_VALUE;	// 사용한 전선 수
			
			// 첫번째 코어의 방향 선택 (오ㅐ 이렇게 했을까..?)
			for (int i = 0; i<5; i++){
				dfs(1, cores.get(0)[0], cores.get(0)[1], i, 0, cloneMap(map), i==4? 0:1);
			}

			System.out.printf("#%d %d%n", test_case, answer);
		}
	}

	static int[] dr = new int[]{0, 0, 1, -1};
	static int[] dc = new int[]{1, -1, 0, 0};

	// 순열, 조합, 부분집합은 아닌데, 이름 뭐라 붙여야 할지 몰라서;;
	// 연결한 코어 수, 위치 r, c, 전선을 연결할 방향, 사용한 전선 총 수, 방문배열, 현재까지 연결한 코어 수
	static void dfs(int cnt, int r, int c, int dir, int wires, boolean[][] map, int connected){
		// 남은 코어들과 현재 연결된 코어를 보았을 때 절대 저장된 값을 못 넘을 것 같다면 돌아간다 (가지치기)
		// 가장자리에 있는 코어는 제외하는 코드가 더 괜찮아 보이는데 생각 못했다.
		if (cores.size() - cnt + connected < connectCnt){
			return;
		}

		// 코어에 전선을 연결하지 않는 경우(dir=4)가 아니라면 전선을 연결하는데
		if (dir != 4){
			for (int i = r + dr[dir], j = c + dc[dir]; 0 <= i && i < n && 0 <= j && j < n; i += dr[dir], j += dc[dir]) {
				// 연결하지 못하는 상황이면 되돌아간다.
				if (map[i][j]) {
					return;
				}

				// 전선 개수를 세고 방문처리를 진행한다.
				wires++;
				map[i][j] = true;
			}
		}

		// 모든 코어를 처리했다면
		if (cnt == cores.size()){
			// 연결한 코어들과 사용한 전선 수를 적절히  저장한다.
			if (connectCnt < connected) {
				connectCnt = connected;
				answer = wires;
			}else if (connectCnt == connected && answer > wires)
				answer = wires;
			return;
		}

		// 다음 코어를 어떻게 처리할지 정한다.
		for (int i = 0; i<5; i++){
			dfs(cnt+1, cores.get(cnt)[0], cores.get(cnt)[1], i, wires, cloneMap(map), connected + (i==4? 0:1));
		}
	}

	// 프로세스의 방문 배열 복사
	static boolean[][] cloneMap(boolean[][] map){
		boolean[][] clone = new boolean[n][];
		for (int i = 0; i<n; i++){
			clone[i] = map[i].clone();
		}
		return clone;
	}
}
