// 문제 링크 : https://www.acmicpc.net/problem/9996
// 제출 공유 링크 : http://boj.kr/3a0fbf93132e4ff4ab88570be24b5786

// re 참고 블로그 : https://m.blog.daum.net/chutedeau/202

import java.util.*

fun main9996(args: Array<String>) = with(Scanner(System.`in`)) {
    val n = nextInt()
    val re = next().replace("*", "\\w*").toRegex()
//    println(re.toString())
    for(i in 0 until n){
        println(if ((re.matchEntire(next())?.value) == null) "NE" else "DA")
    }
}