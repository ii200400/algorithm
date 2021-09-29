// 문제 링크 : https://www.acmicpc.net/problem/2447
// 제출 공유 링크 : http://boj.kr/78b4370e92f645baaf84dc7ee75687b2

// 한참을 낙서장에서 패턴을 파악하고 풀었다;;
// k가 정수이면서 3^k가 n보다 작을 수일때
// 가로/세로 인덱스 모두 3^k로 나누었을 때 나머지가 3^(k-1)~3^(k-1)*2-1 사이이면
// 공백을 사용해야한다. (22번줄~34번째줄에 해당하는 내용)
// 출력이 빨라야하므로 BufferedWriter를 추가로 사용하였다.

// isBlank : 별을 찍어줄지 공백을 찍어줄지 정하는 변수
// divTo : 항상 k가 정수인 3^k 값을 가지는 변수, 가로/세로 인덱스가 조건에 부합하는지 확인한다.

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(BufferedWriter(OutputStreamWriter(System.out))) {
        val n = readLine().toInt()

        // n*n 크기의 별을 찍어준다.
        for (i in 0 until n) {
            for (j in 0 until n) {

                var isBlank = false
                var divTo = n
                // 가로와 세로 인덱스가 조건에 부합하는지 확인
                while (divTo > 1) {
                    val blankRange = divTo / 3
                    if (i % divTo in blankRange until blankRange * 2 &&
                        j % divTo in blankRange until blankRange * 2
                    ) {
                        // 조건에 충족하면 isBlank 을 true 로 바꾼다.
                        isBlank = true
                        break
                    }

                    divTo /= 3
                }
                // isBlank 의 변수에 맞게 별을 찍어준다.
                write(if (isBlank) " " else "*")
            }
            // 한 줄을 찍었으면 다음 줄로 넘어간다.
            write("\n")
        }
        // write 에 쌓인 버퍼 출력
        flush()
    }
}