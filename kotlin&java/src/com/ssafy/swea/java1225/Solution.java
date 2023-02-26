// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD

package com.ssafy.swea.java1225;

import java.util.Scanner;

public class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()) {
            int T = sc.nextInt();
            int[] passward = new int[8];
            for (int i = 0; i<8; i++){
                passward[i] = sc.nextInt();
            }

            int i = -1;
            int minus = 0;
            while(true){
//                i = (++i > 8)? 0:i; // 가독성이 좀.. 아닌것 같다..
                i++;
                if (i > 7) i = 0;

                minus++;
                if (minus > 5) minus = 1;

                passward[i] = Math.max(0, passward[i]-minus);
                if (passward[i] == 0) break;
            }

            System.out.printf("#%d ", T);
            i++;
            for (int j = 0; j<8; j++){
                System.out.print(passward[(i+j)%8]+" ");
            }
            System.out.println();
        }
    }
}
