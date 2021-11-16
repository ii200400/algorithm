// 문제 링크 : https://www.acmicpc.net/problem/19942
// 제출 공유 링크 : http://boj.kr/ec74792adf384caca0058506397dd0df

import java.io.BufferedReader
import java.io.InputStreamReader

fun main19942() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val foodsNumber = readLine().toInt()
    val nutritionStandard = readLine().split(" ").map{ it.toInt() }
    val foods = Array(foodsNumber){ readLine().split(" ").map { it.toInt() }.toIntArray() }

    val searchFoods = BooleanArray(foods.size){ false }
    var selectedFoods = BooleanArray(foods.size){ false }
    var price = 8000
    fun getNutritionSum(selectedFoods: BooleanArray): IntArray {
        val nutritionSum = intArrayOf(0,0,0,0,0)
        for (idx in selectedFoods.indices){
            if (selectedFoods[idx]){
                nutritionSum[0] += foods[idx][0]
                nutritionSum[1] += foods[idx][1]
                nutritionSum[2] += foods[idx][2]
                nutritionSum[3] += foods[idx][3]
                nutritionSum[4] += foods[idx][4]
            }
        }

        return nutritionSum
    }
    fun compareOrder(): Boolean{
        var selectedFoodsMark = -1
        var searchFoodsMark = -1
        for (idx in selectedFoods.indices){
            if (selectedFoods[idx] == searchFoods[idx] && selectedFoodsMark == -1 && searchFoodsMark == -1) continue
            if (selectedFoods[idx] && selectedFoodsMark == -1) selectedFoodsMark = idx
            if (searchFoods[idx] && searchFoodsMark == -1) searchFoodsMark = idx
        }
//        println("$selectedFoodsMark and $searchFoodsMark")

        if (selectedFoodsMark > searchFoodsMark) return true
        return false
    }
    fun dfs(idx: Int){
        if (idx == foods.size){
            val compareTo = getNutritionSum(searchFoods)
//            println(searchFoods.contentToString())
            if (compareTo[0] >= nutritionStandard[0]
                && compareTo[1] >= nutritionStandard[1]
                && compareTo[2] >= nutritionStandard[2]
                && compareTo[3] >= nutritionStandard[3]){
                    if (compareTo[4] < price || (compareTo[4] == price && compareOrder())) {
                        price = compareTo[4]
                        selectedFoods = searchFoods.clone()
//                        println("change to: ${searchFoods.contentToString()}")
                    }
            }

            return
        }

        dfs(idx+1)
        searchFoods[idx] = true
        dfs(idx+1)
        searchFoods[idx] = false
    }

    dfs(0)

    if (price == 8000){
        println(-1)
        return
    }

    println(price)
    for (idx in selectedFoods.indices){
        if (selectedFoods[idx]) print("${idx+1} ")
    }
}