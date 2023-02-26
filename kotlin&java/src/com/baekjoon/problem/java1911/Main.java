// 문제 링크 : https://www.acmicpc.net/problem/1911
// 제출 공유 링크 : http://boj.kr/1471da5adc284a5895269468e3f11f41

// 그냥 1000000001 boolean배열 넣고 사용했는데 생각하고보니 1천 mb가 넘는닼ㅋㅋㅋ
// 그냥 정렬 사용해야겠다. 첫번째 두번째 숫자를 모두 신경 써서 정렬해야한다.

// 음.. 어.. 특별한 알고리즘 없이 단순히
// 사용한 널판지 위치와 물웅덩이 길이를 고려해서 널판지를 추가한 개수를 센것 뿐이 없다.

package com.baekjoon.problem.java1911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 물 웅덩이 수
        int l = Integer.parseInt(st.nextToken());   // 널판지 길이
        int[][] pools = new int[n][2];  // 물 웅덩이 위치

        // 물웅덩이 위치 초기화
        for (int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            pools[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        // 물웅덩이 위치들 정렬 (시작점 기준으로 오름차순, 끝점 기준으로 내림차순)
        Arrays.sort(pools, (o1, o2) -> {
            if (o1[0] == o2[0]){
                return o2[1] - o1[1];
            }else{
                return o1[0] - o2[0];
            }
        });

//        System.out.println(Arrays.deepToString(pools));

        int boardCnt = 0;   // 사용한 판자 수
        int lastLoc = 0;   // 널판지 마지막 위치 +1
        for (int i = 0; i<n; i++){
//            System.out.println(boardCnt + " " + lastLoc);

            // 널판지가 커버하지 못한 지역이 있다면
            if (lastLoc < pools[i][1]) {

                // 거리를 계산해서 널판지를 추가한다.
                int from = Math.max(lastLoc, pools[i][0]);  // 물이 시작되는 위치
                int len = pools[i][1] - from;   // 물 웅덩이 길이
                int needNum = len / l + ((len % l) == 0? 0:1);  // 필요한 판자 수, Math.ceil써도 된다.

                // 정보 갱신
                boardCnt += needNum;
                lastLoc = from + needNum * l;
            }
        }

        // 사용한 판자 수 출력
        System.out.println(boardCnt);
    }

    // 메모리 초과
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());   // 물 웅덩이 수
//        int l = Integer.parseInt(st.nextToken());   // 널판지 길이
//        boolean[] road = new boolean[1000000001];   // 0부터 1000000000까지 길의 상태 (true가 물웅덩이)
//
//        // 비포장 도로 길의 상태 초기화
//        for (int i = 0; i<n; i++){
//            st = new StringTokenizer(br.readLine());
//            int j = Integer.parseInt(st.nextToken());
//            int to = Integer.parseInt(st.nextToken());
//            for (; j<to; j++){
//                road[j] = true;
//            }
//        }
//
//        int boardCnt = 0;   // 사용한 판자의 수
//        int boardLeft = 0;  // 사용 중인 판자의 길이
//        // 0 부터 1000000001 까지 살펴보면서 판자를 둔다.
//        for (int i = 0; i<1000000001; i++){
//            // 물 웅덩이가 아니라면 패스
//            if (!road[i]){
//                // 앞에서 사용한 판자가 있다면
//                if (boardLeft > 0){
//                    boardLeft--;
//                }else{
//                    boardCnt++;
//                    boardLeft = l-1;
//                }
//            }
//        }
//
//        // 사용한 판자의 수 출력
//        System.out.println(boardCnt);
//    }
}
