// 문제 링크 : https://www.acmicpc.net/problem/2477
// 제출 공유 링크 : http://boj.kr/b9738b96de504e4c88a0d171346b96df

// 육각형인 조건 못 봤다가 황천의 참외밭만들뻔..
// 이런거..
/*
 ------------|
 |           |
 |    |------|
 |--| |--|
    |----|
*/

// ㄷ자 모양이 나오지 않는 부분을 찾고 전체 넓이에서 빼는 방식으로 진행할 것이다.
// 전체 넓이는 받은 수 중 가장 큰 수 2개를 찾아서 곱해서 찾을 것이다.

// 풀다보니 다른 방법이 생각나서 아래와 같이 풀었다.
// 가장 긴 변을 구하고 해당 변의 양 옆변 중 더 긴 변을 한번 더 선택한다.
// 그러면 무조건 잘리지 않은 가로, 세로 값이 나오는데 그 값을 토대로 반대편의 잘린 참외밭 넓이를 빼준다.

package com.baekjoon.problem.java2477;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int k = sc.nextInt();   // 넓이당 자랄 수 있는 참외 수
        int[][] areaInfo = new int[6][2];   // 참외밭 변의 방향과 길이 정보 배열

        // 생각하고 보니.. 가장 긴 변이 잘리는 곳의 항상 반대편이다?
        int max = 0, maxIdx = 0;
        for (int i = 0; i<6; i++){
            areaInfo[i] = new int[]{sc.nextInt(), sc.nextInt()};
            if (max < areaInfo[i][1]){
                max = areaInfo[i][1];
                maxIdx = i;
            }
        }

        int secondIdx, goTo;
        // 가장 긴 변의 양 옆 변을 조사해서 더 긴 변의 인덱스를 저장한다.
        if (areaInfo[(maxIdx+1)%6][1] > areaInfo[(maxIdx+5)%6][1]){
            secondIdx = (maxIdx+1)%6;
            goTo = 1;
        }else{
            secondIdx = (maxIdx+5)%6;
            goTo = -1;
        }


        // 두 변을 이용해서 넓이를 구하고
        int area = areaInfo[maxIdx][1] * areaInfo[secondIdx][1];
        // 반대편의 오목한 곳을 빼준다.
        area -= areaInfo[(maxIdx+goTo*3+6)%6][1] * areaInfo[(maxIdx+goTo*4+6)%6][1];

        // 키야.. 내가 최근에 짠 것들 중에서 가장 복잡하다~
        // 정말 마음에 안든다~
        System.out.println(area*k);
    }
}
