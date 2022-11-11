// 문제 링크 : https://www.acmicpc.net/problem/17413
// 제출 공유 링크 : http://boj.kr/98b01a3aedc742f293eab1e59f701ae3

// 단어를 뒤집는 것은 그냥 할수도 잇지만..
// 스택을 사용하고 싶다, 어차피 메모리도 많고 괜찮을 것이다.

// 스택을 사용하는 곳이 생각보다 더 있어서 예외처리가 덜 되었다.
// 그래도 테스트 케이스가 많아서 편하게 풀었다.

package com.baekjoon.problem.java17413;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String str = br.readLine(); // 입력받은 문자열
        boolean isTag = false;  // 태그 여부
        Stack<Character> stack = new Stack<>(); // 단어를 뒤집기 위한 스택
        for (int i = 0; i<str.length(); i++){
            // 태그가 열린 상태라면
            if (isTag){
                // 글자를 그대로 추가한다.
                sb.append(str.charAt(i));

                // 태그가 닫히면 변수를 조정한다.
                if (str.charAt(i) == '>')
                    isTag = false;

                continue;
            }

            // 태그가 시작 되었을 때
            if (str.charAt(i) == '<') {
                while(!stack.isEmpty())
                    sb.append(stack.pop());

                isTag = true;
                sb.append('<');
            }else if (str.charAt(i) == ' '){
                // 공백일 때 스택이 빌 때까지 문자를 꺼내서 추가해준다.
                while(!stack.isEmpty())
                    sb.append(stack.pop());
                // 마지막으로 공백도 추가한다.
                sb.append(' ');
            }else{
                // 숫자이거나 문자일 때 스택에 넣어준다.
                stack.add(str.charAt(i));
            }
        }

        // 남아있는 단어가 있다면 마저 추가한다.
        while(!stack.isEmpty())
            sb.append(stack.pop());

        // 뒤집은 단어를 출력한다.
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
