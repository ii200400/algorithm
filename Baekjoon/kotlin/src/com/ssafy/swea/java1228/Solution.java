// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD

package com.ssafy.swea.java1228;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int size = sc.nextInt();
            LinkedList<Integer> passwords = new LinkedList<>();
            for (int i = 0; i<size; i++) {
                passwords.add(sc.nextInt());
            }

            int commandSize = sc.nextInt();
            for (int i = 0; i<commandSize; i++){
                sc.next();
                int insert = sc.nextInt();
                int numCount = sc.nextInt();

                for (int j = 0; j<numCount; j++){
                    passwords.add(insert+j, sc.nextInt());
                }
            }

            System.out.printf("#%d ", test_case);
            for (int i = 0; i<10; i++){
                System.out.print(passwords.get(i) + " ");
            }
            System.out.println();
        }
    }
}

