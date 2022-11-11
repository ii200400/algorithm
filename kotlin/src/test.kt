import java.io.BufferedReader
import java.io.InputStreamReader
import java.sql.Wrapper
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

abstract class Create {
    abstract fun test()
    fun testNum(num: Int): Int {
        return num
    }
}

abstract class Create2 {
    fun test3(): Int { return 1}
}

interface Ability {
    abstract fun test2()
    fun testNum2(num: Int): Int {
        return num
    }
}

class Humen: Create(), Ability{
    override fun test() {
        TODO("Not yet implemented")
    }

    override fun test2() {
        TODO("Not yet implemented")
    }
}

//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val l = arrayOf(listOf(1,2,3))
//}