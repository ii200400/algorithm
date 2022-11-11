// 문제 링크 : https://www.acmicpc.net/problem/5397
// 제출 공유 링크 : http://boj.kr/54806a3c732e40419c5cb215a128037b

// 링크드 리스트를 사용하려고 했더니 시간초과가 났다.
// 그럼 뭐.. 직접 구현해야한다.

// Buffer 쓰는줄 알고 Scanner 계속 사용하다가 시간초과 2번 받았다..
// 일단 버퍼 쓰고나니 속도가 빨라서 마음에 들긴한다.

package com.baekjoon.problem.java5397;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

class Node{
    static Node head;   // 삭제되지 않는 가장 앞의 노드
    static Node pointer;// 노드를 가리키는 포인터 역할의 노드

    char c;
    Node fLink = null, bLink = null;

    Node(char c){
        this.c = c;
    }

    void add(){
        this.fLink = pointer.fLink;
        this.bLink = pointer;

        if (pointer.fLink != null)
            pointer.fLink.bLink = this;
        pointer.fLink = this;
        pointer = this;
    }

    static void remove(){
        if (pointer.c == ' ') // head를 가리키고 있을 때 (커서가 맨 앞일 때)
            return;

        if (pointer.fLink != null){
            pointer.fLink.bLink = pointer.bLink;
        }
        pointer.bLink.fLink = pointer.fLink;
        pointer = pointer.bLink;
    }

    static void back(){
        if (pointer.c == ' ')
            return;

        pointer = pointer.bLink;
    }

    static void go(){
        if (pointer.fLink == null)
            return;

        pointer = pointer.fLink;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t<testCase; t++){
            Node.head = new Node(' ');
            Node.pointer = Node.head;
            String str = br.readLine(); // 로거

            // 문자마다 작업 진행
            for (int i = 0; i<str.length(); i++){
                char c = str.charAt(i);

                if (c == '<'){ // 왼쪽으로 한 칸
                    Node.back();
                }else if (c == '>'){ // 오른쪽으로 한 칸
                    Node.go();
                }else if (c == '-'){ // 백 스페이스
                    Node.remove();
                }else{ // 문자 입력
                    Node n = new Node(c);
                    n.add();
                }
            }

            // 출력
            Node n = Node.head;
            while (n.fLink != null){
                n = n.fLink;
                wr.write(n.c);
            }
            wr.newLine();
        }

        wr.flush();
        wr.close();
        br.close();
    }

    // 시간 초과
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int testCase = sc.nextInt();
//
//        for (int t = 0; t<testCase; t++){
//            String str = sc.next(); // 로거
//            LinkedList<Character> characters = new LinkedList<>(); // 비밀번호 리스트
//            int idx = 0; // 커서 위치
//
//            for (char c : characters){
//                System.out.print(c);
//            }
//
//            // 문자마다 작업 진행
//            for (int i = 0; i<str.length(); i++){
//                char c = str.charAt(i);
//
//                if (c == '<'){ // 왼쪽으로 한 칸
//                    idx--;
//                    if (idx < 0) idx = 0;
//                }else if (c == '>'){ // 오른쪽으로 한 칸
//                    idx++;
//                    if (idx > characters.size()) idx = characters.size();
//                }else if (c == '-'){ // 백 스페이스
//                    idx--;
//                    if (idx < 0) idx = 0;
//                    if (characters.size() > 0 && idx != 0) characters.remove(idx);
//                }else{ // 문자 입력
//                    characters.add(idx++, c);
//                }
//            }
//
//            // 출력
//            for (char c : characters){
//                System.out.print(c);
//            }
//            System.out.println();
//        }
//    }
}
