// 문제 링크 : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=488&sca=99&sfl=wr_hit&stx=1205
// 제출 링크 (공유 링크 아님) : http://jungol.co.kr/theme/jungol/result.php?sid=5526870

// 음.. 정렬하고 하나하나보면 시간초과 나려나..?
// 시간초과 안났다. 오히려 예외처리를 잘못해서 오답;

// 구현 도중 투포인터 생각났는데.. 어.. 일단 지나간다;;
// 투포인터 방식이.. 더..? 좋다, 한칸씩 계산하는 것보다 한꺼번에 계산하는게 더 빠르니까? 아마?

package com.jungol.java1205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());    // 카드의 수
        HashSet<Integer> cards = new HashSet<>();  // 카드 배열 (중복제거를 위함)
        int jokerNum = 0;   // 조커의 수

        // 카드 배열과 조커 수 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if (num == 0)
                jokerNum++;
            else
                cards.add(num);
        }

        // 카드 정렬 (좀 느린 코드)
        int[] cardsArray = cards.stream().mapToInt(i -> i).toArray();
        Arrays.sort(cardsArray);

        // 카드가 한장이라도 있다면 jokerNum+1 아니라면 jokerNum을 저장한다.
        int straight = cardsArray.length == 0? jokerNum: jokerNum+1;
        // 작은 수 부터 다음 수들을 탐색해 나간다.
        for (int i = 0; i<cards.size(); i++){
            // 연산을 위해 임시 변수를 사용한다.
            int tempJoker = jokerNum;
            int tempStraight = 1;

            // i의 다음 숫자들을 보는데
            for (int j = i+1; j<cards.size(); j++){
                // 사이의 공간을
                int term = cardsArray[j] - cardsArray[j-1] - 1;
//                System.out.println(term + " " +tempJoker);

                // 조커로 매울 수 없다면
                if (term > tempJoker){
                    tempStraight += tempJoker;
                    tempJoker = 0;
                    break;
                }else{
                    // 조커로 매울 수 있고 조커가 남거나 딱 맞는다면
                    tempJoker -= term;
                    tempStraight += term + 1;
                }
            }

            // 위의 작업을 마치고
            // 이전 스트레이트 수와 혹시 남아있는 조커까지 합쳐서 나온 현재의 스트레이트 중 더 큰 수를 저장한다.
            straight = Math.max(straight, tempStraight+tempJoker);
        }

        // 스트레이트 최대 길이를 출력한다.
        System.out.println(straight);
    }
}
