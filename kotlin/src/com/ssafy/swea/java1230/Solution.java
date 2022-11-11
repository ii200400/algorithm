// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14zIwqAHwCFAYD

package com.ssafy.swea.java1230;

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
                String command = sc.next();
                if (command.equals("I")){

                    int idx = sc.nextInt();
                    int count = sc.nextInt();

                    for (int j = 0; j<count; j++){
                        passwords.add(idx+j, sc.nextInt());
                    }

                }else if (command.equals("D")){

                    int idx = sc.nextInt();
                    int count = sc.nextInt();

                    for (int j = 0; j<count; j++){
                        passwords.remove(idx);
                    }

                }else if (command.equals("A")){

                    int count = sc.nextInt();

                    for (int j = 0; j<count; j++){
                        passwords.add(sc.nextInt());
                    }

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
