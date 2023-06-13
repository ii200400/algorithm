import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 격자 크기
        int width = sc.nextInt(), height = sc.nextInt();
        int x = sc.nextInt(), y = sc.nextInt(); // 개미 위치

        int t = sc.nextInt();   // 이동 시간
        // 음.. 너비에 따른 x 계산, 높이에 따른 y계산
        int temp = t % (width*2);
        x = x+temp > width? Math.abs(width - (x+temp - width)) : x+temp;
        temp = t % (height*2);
        y = y+temp > height? Math.abs(height - (y+temp - height)) : y+temp;

        // 개미의 위치 출력
        System.out.println(x + " " + y);
    }
}