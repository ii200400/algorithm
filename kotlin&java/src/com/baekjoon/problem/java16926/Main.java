// 문제 링크 : https://www.acmicpc.net/problem/16926
// 제출 공유 링크 : http://boj.kr/5d5d8bef578d4316b7251824eabfd21b

// 오랫만에 그림을 그렸다.
// 메모지에 y=x와 y=n-x를 그리고 어느 범위가 y<x인지, x<n-x인지 표시만한 다음에 그것을 참고해서 돌렸다.
// 졸려서 그런지 더 귀찮다, 빨리 풀고 자야지..

package com.baekjoon.problem.java16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        String[] input = br.readLine().split(" ");
        int yLen = Integer.parseInt(input[0]), xLen = Integer.parseInt(input[1]), n = Integer.parseInt(input[2]);
        String[][] arr = new String[yLen][xLen];

        // 배열에 값을 입력한다.
        for (int y = 0; y<yLen; y++){
            input = br.readLine().split(" ");
            for (int x = 0; x<xLen; x++){
                arr[y][x] = input[x];
            }
        }

        // n번 만큼 회전을 진행한다.
        for (int i = 0; i<n; i++) {

            // arr배열에서 숫자들을 적절히 움직여 tempArr로 옮긴다.
            String[][] tempArr = new String[yLen][xLen];
            int xLen_ = xLen-1;
            int yLen_ = yLen-1;
            for (int y = 0; y < yLen; y++) {
                for (int x = 0; x < xLen; x++) {
                    // 각 위치마다 적절한 위치로 저장한다.
                    if (yLen_/2 >= y && xLen_/2 >= x){

                        if (y>=x) tempArr[y+1][x] = arr[y][x];
                        else tempArr[y][x-1] = arr[y][x];

                    }else if (yLen_/2 >= y && xLen_/2 < x){

                        if (y <= xLen_ - x) tempArr[y][x-1] = arr[y][x];
                        else tempArr[y-1][x] = arr[y][x];

                    }else if (yLen_/2 < y && xLen_/2 < x){

                        if (y <= x + yLen_-xLen_) tempArr[y-1][x] = arr[y][x];
                        else tempArr[y][x+1] = arr[y][x];

                    }else{

                        if (y >= yLen_ - x) tempArr[y][x+1] = arr[y][x];
                        else tempArr[y+1][x] = arr[y][x];

                    }
                }
            }
            // 회전 끝
            arr = tempArr;
        }

        for (int y = 0; y<yLen; y++){
            System.out.println(String.join(" ", arr[y]));
        }
    }
}
