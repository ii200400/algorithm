// 문제 링크 : https://www.acmicpc.net/problem/17478
// 제출 공유 링크 : http://boj.kr/de062579029a4dd5b912f72181664e16

package com.baekjoon.problem.java17478;

import java.util.Scanner;

public class Main {
    static int n;
    static String question = "\"재귀함수가 뭔가요?\"";
    static String[] say = {
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""
    };
    static String end = "라고 답변하였지.";

    static void recursive(int time) {
        String underBar = "____";

        System.out.print(underBar.repeat(time));
        System.out.println(question);

        if (n==time){
            System.out.print(underBar.repeat(time));
            System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        }else{
            for (String ment : say) {
                System.out.print(underBar.repeat(time));
                System.out.println(ment);
            }
            recursive(time+1);
        }

        System.out.print(underBar.repeat(time));
        System.out.println(end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");

        recursive(0);
    }
}
