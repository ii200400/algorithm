// 문제 링크 : https://www.acmicpc.net/problem/1920
// 제출 공유 링크 (ArrayList 사용) : http://boj.kr/402deb9eedcc4fbbb514e511793fadc5
// 제출 공유 링크 (Array 사용) : http://boj.kr/0bf571c6b6bd4290ae31ef9b2a1e2371
// 제출 공유 링크 (Stack 사용) : http://boj.kr/759ae85bdcb148949b2bd670f10e44f7

// 너무 쉬운 문제라서 ArrayList와 intArray와 Stack을 썼을 때
// 시간차이가 얼마나 나는지 확인하는 용도로 활용하였다.

// intArray가 가장 빨랐고 나머지 두개는 거의 같은 시간이 소모되었는데,

package com.baekjoon.problem.java10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    static int n;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        // 초기화
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        useArrayList();
        useArray();
        useStack();
    }

    // ArrayList를 사용하는 경우
    static void useArrayList() throws IOException {
        List<Integer> stack = new ArrayList<>(n);
        int num;
        for (int i = 0; i<n; i++){
            switch (num = Integer.parseInt(br.readLine())){
                case 0:
                    stack.remove(stack.size()-1);
                    break;
                default:
                    stack.add(num);
            }
        }

        int sum = 0;
        for (int i : stack){
            sum += i;
        }

        System.out.println(sum);
    }

    // int[]를 사용하는 경우
    static void useArray() throws IOException {
        int[] stack = new int[n];
        int num, size = 0;
        for (int i = 0; i<n; i++){
            switch (num = Integer.parseInt(br.readLine())){
                case 0:
                    size--;
                    break;
                default:
                    stack[size++] = num;
            }
        }

        int sum = 0;
        for (int i = 0; i<size; i++){
            sum += stack[i];
        }

        System.out.println(sum);
    }

    // Stack을 사용하는 경우
    static void useStack() throws IOException {
        Stack<Integer> stack = new Stack<>();
        int num;
        for (int i = 0; i<n; i++){
            switch (num = Integer.parseInt(br.readLine())){
                case 0:
                    stack.pop();
                    break;
                default:
                    stack.add(num);
            }
        }

        int sum = 0;
        for (int i : stack){
            sum += i;
        }

        System.out.println(sum);
    }
}
