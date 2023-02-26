// 문제 링크 : https://www.acmicpc.net/problem/16935
// 제출 공유 링크 : http://boj.kr/395333e6c0f84b55b809653dcee495a4

// 90도 돌리는 부분에서 어떻게 구현할지 막혔으나,
// '대각선이나 세로로 뒤집는건 쉬운데..' 라는 생각하다가 90도 돌리는 방법을 깨닿고 구현하였다.

// 비슷한 코드가 많아서 복붙을 했더니 엄청난 길이가 되었다;;

package com.baekjoon.problem.java16935;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 초기화
        arr = new int[sc.nextInt()][sc.nextInt()];
        int n = sc.nextInt();

        // 배열 초기화
        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        // 작업 시작
        for(int i = 0; i<n; i++){
            switch (sc.nextInt()) {
                case 1:
                    arr = work1();
                    break;
                case 2:
                    arr = work2();
                    break;
                case 3:
                    arr = work3();
                    break;
                case 4:
                    arr = work4();
                    break;
                case 5:
                    arr = work5();
                    break;
                case 6:
                    arr = work6();
                    break;
            }
        }

        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int[][] arr;

    // 배열 상하 반전
    static int[][] work1(){
        int[][] temp = new int[arr.length][arr[0].length];
        int iLen = arr.length - 1;
        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr[0].length; j++){
                temp[iLen-i][j] = arr[i][j];
            }
        }

        return temp;
    }

    // 배열 좌우 반전
    static int[][] work2(){
        int[][] temp = new int[arr.length][arr[0].length];
        int jLen = arr[0].length - 1;
        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr[0].length; j++){
                temp[i][jLen-j] = arr[i][j];
            }
        }

        return temp;
    }

    // 대각선 반전 (work3과 4에서 사용)
    static int[][] preWork(){
        int[][] temp = new int[arr[0].length][arr.length];
        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr[0].length; j++){
                temp[j][i] = arr[i][j];
            }
        }

        return temp;
    }

    // 오른쪽 90도 회전 (대각선 대칭 1번에 좌우 대칭 1번)
    static int[][] work3(){
        arr = preWork();
        return work2();
    }

    // 왼쪽 90도 회전 (대각선 대칭 1번에 상하 대칭 1번)
    static int[][] work4(){
        arr = preWork();
        return work1();
    }

    // 부분 배열 왼쪽 회전
    static int[][] work5(){
        int[][] temp = new int[arr.length][arr[0].length];
        int i, j; // 탐색을 위한 인덱스들, 단순히 밖에 선언해야했기에 여기에 작성
        int iHalf = arr.length/2, jHalf = arr[0].length/2; // 세로 길이 절반, 가로 길이 절반

        for (i = 0; i<iHalf; i++){
            // 왼쪽 위 부분 배열 이동
            for (j = 0; j<jHalf; j++){
                temp[i][j+jHalf] = arr[i][j];
            }

            // 오른쪽 위 부분 배열 이동
            for ( ; j<arr[0].length; j++){
                temp[i+iHalf][j] = arr[i][j];
            }
        }

        for (; i<arr.length; i++){
            // 왼쪽 아래 부분 배열 이동
            for (j = 0; j<jHalf; j++){
                temp[i-iHalf][j] = arr[i][j];
            }

            // 오른쪽 아래 부분 배열 이동
            for ( ; j< arr[0].length; j++){
                temp[i][j-jHalf] = arr[i][j];
            }
        }

        return temp;
    }

    // 부분 배열 오른쪽 회전
    static int[][] work6(){
        int[][] temp = new int[arr.length][arr[0].length];
        int i, j;
        int iHalf = arr.length/2, jHalf = arr[0].length/2; // 세로 길이 절반, 가로 길이 절반

        for (i = 0; i<iHalf; i++){
            // 왼쪽 위 부분 배열 이동
            for (j = 0; j<jHalf; j++){
                temp[i+iHalf][j] = arr[i][j];
            }

            // 오른쪽 위 부분 배열 이동
            for ( ; j<arr[0].length; j++){
                temp[i][j-jHalf] = arr[i][j];
            }
        }

        for (; i<arr.length; i++){
            // 왼쪽 아래 부분 배열 이동
            for (j = 0; j<jHalf; j++){
                temp[i][j+jHalf] = arr[i][j];
            }

            // 오른쪽 아래 부분 배열 이동
            for ( ; j< arr[0].length; j++){
                temp[i-iHalf][j] = arr[i][j];
            }
        }

        return temp;
    }
}
