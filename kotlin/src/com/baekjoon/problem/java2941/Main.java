// 문제 링크 : https://www.acmicpc.net/problem/2941
// 제출 공유 링크 : http://boj.kr/971fcdc95183410da6b6de27c324169b

// 예전에.. 어떻게.. 풀었더라..? ㅍ,.ㅍ
// 일단 역순 탐색이 더 쉬워보인다.

package com.baekjoon.problem.java2941;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String alpha = " " + sc.nextLine(); // 알파벳 배열 (공백은 예외처리를 하지 않기 위함)
        int cnt = 1; // 크로아티아 알파벳으로 변경하면서 줄어드는 알파벳 수 (1부터 시작하는 것은 앞의 공백도 같이 지워주기 위함)
        
        // 역순으로 알파벳을 살펴본다.
        for (int i = alpha.length()-1; i>1; i--){
            if (alpha.charAt(i) == '='){
                if (alpha.charAt(i-1) == 'z' && alpha.charAt(i-2) == 'd') {
                    // dz= 인 경우 (알파벳이 다른 것과는 다르게 3개를 1개 취급한다.)
                    i -= 2;
                    cnt+=2;

                } else if (alpha.charAt(i-1) == 'c' || alpha.charAt(i-1) == 's' || alpha.charAt(i-1) == 'z'){
                    // c=, s=, z= 인 경우
                    i--;
                    cnt++;
                }
            }else if (alpha.charAt(i) == '-'){
                // c-, d- 인 경우
                i--;
                cnt++;

            }else if (alpha.charAt(i) == 'j'){
                if (alpha.charAt(i-1) == 'l' || alpha.charAt(i-1) == 'n'){
                    // lj, nj 인 경우
                    i--;
                    cnt++;
                }
            }
        }

        System.out.println(alpha.length() - cnt);
    }
}
