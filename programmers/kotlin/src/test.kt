class Solution1 {
    fun solution(numbers: IntArray): Int {
        val check = Array(10) {false}
        var answer = 0

        for (number in numbers)
            check[number] = true

        for (idx in check.indices)
            if (!check[idx]) answer += idx

        return answer
    }
}