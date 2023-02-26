// 문제 링크 : https://www.acmicpc.net/problem/10815
// 제출 공유 링크(기수정렬) : http://boj.kr/df6b606fa0ef443cb6dd57d7a59819ea
// 제출 공유 링크(이분탐색 라이브러리) : http://boj.kr/099aad1e69af44d1b822f728cdcf3463
// 제출 공유 링크(이분탐색 직접 구현) : http://boj.kr/d940e3b68b32465aac5bfb0f0b9d4325

// 시간도 너무 넉넉하고 메모리도 너무 넉넉하길래 기수정렬로 끝냈다.
// 보통 이진탐색이라고 하면 특정 수나 상황에 맞는 수 하나를 구하는 것인데
// 이것은 많은 숫자를 구하라고 하니.. 정말 이진탐색을 사용하는 것이 맞는지 모르겠다.

package com.baekjoon.problem.java10815;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Main() throws IOException {
//        method1();
        method2();
    }

    // 1 기수 정렬을 사용한 방법
    void method1() throws IOException {
        int n = Integer.parseInt(br.readLine());    // 숫자 카드 수
        boolean[] arr = new boolean[20000001];      // 기수 정렬을 위한 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++){  // 기수 정렬 초기화
            arr[Integer.parseInt(st.nextToken())+10000000] = true;
        }

        int m = Integer.parseInt(br.readLine());    // 숫자 보유 여부 질문 수
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 숫자 보유에 대한 질문을 하는데
        for (int i = 0; i<m; i++){
            if (arr[Integer.parseInt(st.nextToken())+10000000])
                // 해당 숫자를 가지고 있다면 1을
                sb.append(1 + " ");
            else
                // 가지고 있지 않다면 0을 출력한다.
                sb.append(0 + " ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    // 2. 라이브러리의 정렬을 1번에 이진탐색 라이브러리 사용
    void method2() throws IOException {
        int n = Integer.parseInt(br.readLine());    // 숫자 카드 수
        int[] arr = new int[n];         // 숫자 카드 배열

        // 숫자 카드 배열을 초기화 후 정렬한다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());    // 숫자 보유 여부 질문 수
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 숫자 보유에 대한 질문을 하는데
        for (int i = 0; i<m; i++){
            int key = Integer.parseInt(st.nextToken());
//            if (Arrays.binarySearch(arr, key) >= 0)
            if (binarySearch(arr, key))
                // 해당 숫자를 가지고 있다면 1을
                sb.append(1 + " ");
            else
                // 가지고 있지 않다면 0을 출력한다.
                sb.append(0 + " ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    /**
     *  이진탐색을 활용하여 오름차순인 배열에서 key 값이 있는지 탐색한다.
     *  해당 키가 있다면 true를 없다면 false를 반환한다.
    */
    boolean binarySearch(int[] arr, int key){
        // 탐색 범위 초기화
        int start = 0, end = arr.length-1;
        int mid;
        
        // 이진탐색 시작
        while(start<=end){
            // 중간 위치에서
            mid = (start+end) >> 1;

            // 중간 값을 보았을 때
            if (arr[mid] < key){
                // 값이 키보다 작으면 start 탐색범위를 올려주고 탐색을 계속하고
                start = mid+1;
            }else if (key < arr[mid]){
                // 값이 키보다 크면 end 탐색범위를 내려주고 탐색을 계속하고
                end = mid-1;
            }else{
                // 키를 찾았다면 true를 반환해준다.
                return true;
            }
        }

        // 값을 모두 탐색했는데도 없다면 키에 해당하는 값이 없다는 의미이므로 false를 반환한다.
        return false;
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }
}
