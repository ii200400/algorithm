// 문제 링크 : https://www.acmicpc.net/problem/11053
// 제출 공유 링크 : http://boj.kr/427e13b63f0b49b385c0431ff3be0301
// 백준 가장 긴 증가하는 부분 수열

// 최장 증가 부분 수열의 길이를 구하는 O(NlogN) 방식을 사용하려고 한다.
// 이전에는 이분탐색 라이브러리를 사용했으니 이번에는 직접 구현해보려고 한다.


package com.baekjoon.problem.java11053;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 수열 숫자 수
        int[] seq = new int[n]; // 수열
        int[] lis = new int[n]; // 가장 긴 증가하는 부분 수열
        

        // 수열 초기화
        for (int i = 0; i<n; i++){
            seq[i] = sc.nextInt();
        }

        // lis 초기화
        int end = 1; // end는 배열의 길이 및 끝나는 인덱스(미포함)
        lis[0] = seq[0];

        // lis 구현
        for (int i = 1; i<n; i++) {
            // lis에 저장된 수들 보다 더 큰 수가 들어왔을때는
            if (lis[end-1] < seq[i]){
                // 가장 뒤에 값을 넣고 길이를 증가시킨다.
                lis[end] = seq[i];
                end++;
            }else { // 중간에 끼워넣어야 할 때는 이진 탐색을 사용하여 값을 넣을 곳을 적절하게 선택한다.
                int insert = binarySearch(-1, end, lis, seq[i]);
                lis[insert] = seq[i];
            }
        }

        // lis 길이 출력
        System.out.println(end);
    }

    /**
     * end 인덱스에 저장된 값이 lis에 key를 추가하는 적절한 위치가 되도록 연산하고 그 값을 반환하는 함수
     * @param from  시작 인덱스
     * @param to    끝 인덱스(key 삽입 위치)
     * @param arr   lis
     * @param key   추가하고자 하는 값
     * @return  key 삽입 위치
     */
    static int binarySearch(int from, int to, int[] arr, int key){
        int mid;
        // 두 값의 차이가 1이 될 때까지만 반복
        while(from+1!=to){
            mid = (from+to)/2;
            if (arr[mid] == key){   // 값이 key와 같을 때
                to = mid;
                break;
            }else if (arr[mid] < key){  // 값이 key보다 작을 때(삽입 위치가 아님)
                from = mid;
            }else{  // 값이 key보다 작을 때(삽입 위치가 될 수도 있음)
                to = mid;
            }
        }

        // 삽입위치 반환
        return to;
    }
}
