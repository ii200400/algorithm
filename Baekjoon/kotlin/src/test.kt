import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val a = arrayOf(intArrayOf(1,2), intArrayOf(3,4))
    for ((v,b) in a){
        println("$v,$b")
    }
}