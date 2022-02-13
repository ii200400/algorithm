// 문제 링크 : https://www.acmicpc.net/problem/1941
// 제출 공유 링크 : http://boj.kr/2e7324feb69449219b6384fe9e11ab0b

// 1. 각 칸을 0~24로 두고, 0~24 중 7개를 선택하는 조합을 구한다.
// 2. 조합에서 S가 4명 이상인지 확인한다
// 3. 조합이 모두 인접해있는지 확인한다.

// 대부분은 위와 같은 형식으로 한다. 본인은 인접한지 확인할 때 hashmap을 활용해보려고 했을 뿐인데..
// 위에서 말한대로 새로운 객체는 다른 키 취급을 할 줄 몰라 아예 클래스를 만들어서 진행했다..
// 좋은 점은 클래스의 equals 사용법을 잘 알게 되었다는 점이고
// 나쁜 점은 코드가 너무 길고 효율성도 크지 않으면서 메모리는 엄청나게 잡아먹는다는 것..

// 다른 사람들은 이차원(5*5) 탐색으로 하지 않고 일차원(1*25)으로 취급하고 탐색을 진행하였고
// 모두 인접한지 확인할 때, 큐와 visited 이차원 배열을 사용했는데
// 더 빠르긴 했지만 언어가 같지 않아서 빠른 방법인지 느린방법인지 잘 모르겠다. (당연히 나보다는 빠르겠지만)
// 다음에 다시 풀어봐야지..

package com.baekjoon.problem.again.java1941;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // 크기가 5*5로 고정되어있으므로
    static char[][] seats = new char[5][5];
    static HashMap<CustomIntArr, Boolean> selectedSeats = new HashMap<>();
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 초기화
        for (int i = 0; i<5; i++){
            String line = sc.nextLine();
            for (int j = 0; j<5; j++){
                seats[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 0, 0);

        System.out.println(result);
    }

    static void dfs(int r, int c, int cnt, int cntY){
        if (cntY > 3) // Y 학생이 4명 이상이면 돌아간다.
            return;

        if (cnt == 7 && isAllNear()){ // 모든 학생을 정했는데 모두 근접하다면
            // 결과값 +1
            result++;
            return;
        }

        // 계속해서 자리를 살펴보는데
        for (int i = r; i<5; i++){
            for (int j = c; j<5; j++){
                CustomIntArr seat = new CustomIntArr(i, j);
                selectedSeats.put(seat, true);

                if (seats[i][j] == 'S'){ // 'S' 학생이 있다면
                    dfs(i, j+1, cnt+1, cntY);
                }else{ // 'Y' 학생이 있다면
                    dfs(i, j+1, cnt+1, cntY+1);
                }

                selectedSeats.remove(seat); // new int[]{i,j} 하면 다른 객체라 그런지 없는 키라고 삭제를 안한다.
                //checkSeats.put(seat, false); //이것도 가능한데 뭐가 더 빠른지 모르겠다.
            }
            c = 0;
        }
    }

    static int[][] ds = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static HashMap<CustomIntArr, Boolean> tempSeats;
    static boolean isAllNear(){
        tempSeats = (HashMap<CustomIntArr, Boolean>) selectedSeats.clone();

        CustomIntArr arr = (CustomIntArr)tempSeats.keySet().toArray()[0];
        tempSeats.put(arr, false);

        return dfs(arr) == 7;
    }

    static int dfs(CustomIntArr seat){
        int result = 0;

        // 네 방향을 보면서 결성자의 수를 센다.
        for (int[] d : ds) {
            CustomIntArr searchSeat = new CustomIntArr(seat.x + d[0], seat.y + d[1]);
            if (tempSeats.getOrDefault(searchSeat, false)) {
                tempSeats.put(searchSeat, false);
                result += dfs(searchSeat);
            }
        }

        return result+1;
    }


    static class CustomIntArr{
        int x, y;

        public CustomIntArr(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return (x+""+y).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof CustomIntArr) {
                CustomIntArr arr = (CustomIntArr) obj;
                return (this.x+""+ this.y).equals(arr.x+""+arr.y);
            }
            return false;
        }
    }
}
