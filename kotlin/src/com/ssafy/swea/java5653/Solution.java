// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRJ8EKe48DFAUo
// [모의 SW 역량테스트] 줄기세포배양

//JAVA
//언어
//120,968 kb
//메모리
//443 ms
//실행시간
//2,020
//코드길이
//Pass
//결과

// bfs 로 풀려고 하는데 시간내로 풀 수 있는지.. 확신이 안 선다;;

// 아.. 활성화하고 확산되면 계산에서 빼버려서 계속 생각보다 작은 값이 나오는 것이었다;
// 아이고난..!
// 3초 의식하면서 풀었는데 시간 아주 넉넉해서 슬프다..

package com.ssafy.swea.java5653;

import java.util.*;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 가로 크기, 세로 크기,
			int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
			int[][] map = new int[n+2*k][m+2*k];	// 맵 배열(최대 가로 세로 크기가 [n+2*k][m+2*k]이므로)
			ArrayList<int[]> arr = new ArrayList<>();	// 줄기세포 정렬하기 위함
			Queue<int[]> q = new LinkedList<>();	// 줄기세포 bfs 진행을 위한 큐
			PriorityQueue<Integer> pq = new PriorityQueue<>();	// 활성상태가 된 줄기세포가 비활성이 되는 시간

			// 맵 초기화 및 줄기세포 입력 받기
			for (int i = 0; i<n; i++){
				for (int j = 0; j<m; j++){
					int num = sc.nextInt();
					map[i+k][j+k] = num;
					if (num != 0)
						arr.add(new int[] {i+k,j+k, num});
				}
			}
			// 줄기세포 크기 우선 정렬
			arr.sort(Comparator.comparingInt(i -> -i[2]));
			q.addAll(arr);

			int[] dr = new int[] {1, -1, 0, 0};
			int[] dc = new int[] {0, 0, 1, -1};

			// k번 만큼
			int time = 0;
			while(++time != k){
				// 레벨우선탐색
				int size = q.size();
				for (int i = 0; i<size; i++){
					int[] current = q.poll();
					int hp = map[current[0]][current[1]]; // 세포줄기의 생명력 수치

					// 줄기세포가 아직 활성화가 되지 않았다면 패스
					if (--current[2] != 0) {
						q.offer(current);
						continue;
					}else{
						// 활성화가 되었다면 우선순위 큐에 추가
						pq.offer(time+hp);
					}

					// 4방위 탐색
					for (int j = 0; j<4; j++) {
						int nr = current[0]+dr[j];
						int nc = current[1]+dc[j];

						// 줄기세포가 없는 위치라면 출기세포가 확장한다.
						if (map[nr][nc] == 0){
							map[nr][nc] = hp;
							// 줄기세포가 생기는 시간 때문에 +1
							q.add(new int[] {nr, nc, map[nr][nc]+1});
						}
					}
				}

				while (!pq.isEmpty() && pq.peek() <= time+1)
					pq.poll();
			}

			System.out.printf("#%d %d%n", test_case, q.size()+pq.size());
		}
	}
}
