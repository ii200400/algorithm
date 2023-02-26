// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc

package com.ssafy.swea.java1973;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    static int tr = 0, tc = 0; // 탱크의 위치
    // 움직이려는 위치가 이동 가능하면 이동하고 그렇지 않으면 생략하고 탱크의 방향을 변경한다.
    static void move(char[][] map, int nr, int nc, char headTo) {
        if (map[tr+nr][tc+nc] == '.') {
            map[tr][tc] = '.';

            tr += nr; tc += nc;
            map[tr][tc] = headTo;
        }else {
            map[tr][tc] = headTo;
        }
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 초기화

            // 방향 커맨드 별 이동 정보 방향 해시에 저장
            HashMap<Character, Object[]> headToHash = new HashMap<>();
            headToHash.put('L', new Object[] {0, -1, '<'});
            headToHash.put('U', new Object[] {-1, 0, '^'});
            headToHash.put('D', new Object[] {1, 0, 'v'});
            headToHash.put('R', new Object[] {0, 1, '>'});
            headToHash.put('<', new Object[] {0, -1});
            headToHash.put('^', new Object[] {-1, 0});
            headToHash.put('v', new Object[] {1, 0});
            headToHash.put('>', new Object[] {0, 1});

            int rSize = sc.nextInt(), cSize = sc.nextInt(); // 맵 크기

            char map[][] = new char[rSize+2][cSize+2]; // 게임 맵 2를 더 크게 만들어 ' '로 둘러싸준다.
            // 게임 필드 입력 및 탱크 검색
            for (int i = 0; i<rSize+2; i++) {
                Arrays.fill(map[i], '@'); // '@'으로 초기화.. 맵 밖이라는 의미
            }
            for(int i = 1; i<rSize+1; i++) {
                String line = sc.next();
                for(int j = 1; j<cSize+1; j++) {
                    map[i][j] = line.charAt(j-1);
                    if (map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>') {
                        tr = i;
                        tc = j;
                    }
                }
            }
//			System.out.println(Arrays.deepToString(map));

            int l = sc.nextInt();
            String commands = sc.next();
            // 커맨드 길이만큼 반복
            for(int i = 0; i<l; i++) {
                char command = commands.charAt(i);

                // 내가봐도 참.. 너무 줄였다.. 설마 나빼고 보는 사람 없겠지?
                if (command == 'S') { // 포탄 발사인 경우
                    // 탱크의 현재 방향을 확인하고
                    Object[] data = headToHash.get(map[tr][tc]);
                    int nr = (int)data[0], nc = (int)data[1];

                    // 포탄을 발사한다. Canon
                    for(int cr = tr+nr, cc = tc+nc; ; cr += nr, cc += nc) {
                        if (map[cr][cc] == '#' || map[cr][cc] == '@') { // 강철벽이나 맵 밖으로 나가면 작업 종료
                            break;
                        }

                        if (map[cr][cc] == '*') { // 벽돌과 만나면
                            map[cr][cc] = '.'; // 평지를 만든다.
                            break;
                        }
                    }

                }else { // 이동의 경우
                    Object[] data = headToHash.get(command);
                    move(map, (int)data[0], (int)data[1], (char)data[2]);
                }
            }

            System.out.printf("#%d ", test_case);
            for (int i = 1; i<rSize+1; i++) {
                for (int j = 1; j<cSize+1; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}

