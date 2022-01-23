// 문제 링크 : https://www.acmicpc.net/problem/19942
// 제출 공유 링크 : http://boj.kr/ec74792adf384caca0058506397dd0df

// 완전탐색을 이용해서 음식을 선택하는 모든 경우를 살펴보기 위해 재귀 함수(searchAllFoods)를 사용한다.
// 사전순으로 더 빠른 것을 선택해야 하므로 compareOrder라는 함수를 만들어 선택한 음식들의 순서를 비교하였다.

// foodsNumber : 음식 수
// nutritionStandard : 최소 영양소 리스트
// foods : 각 음식들의 영양소 배열
// searchFoods : 탐색중인 음식 세트
// selectedFoods : 현재까지 탐색한 음식 세트 중 가장 가격이 싸고 사전순으로 빠른 것

import java.io.BufferedReader
import java.io.InputStreamReader

fun main19942() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 입력값
    val foodsNumber = readLine().toInt()
    val nutritionStandard = readLine().split(" ").map{ it.toInt() }
    val foods = Array(foodsNumber){ readLine().split(" ").map { it.toInt() }.toIntArray() }

    val searchFoods = BooleanArray(foods.size){ false }
    var selectedFoods = BooleanArray(foods.size){ false }
    var price = 8000

    // 선택한 음식들의 영양분과 가격의 총합 반환
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
    // 현재 탐색중인 음식들이 사전순으로 더 빠르다면 true, 그렇지 않다면 false를 반환한다.
    fun compareOrder(): Boolean{
//        첫번째 방법 (사전순으로 더 빠른지 두 음식 세트를 하나하나 비교하여 확인한다.)
//        var selectedFoodsMark = -1
//        var searchFoodsMark = -1
//        for (idx in selectedFoods.indices){
//            if (selectedFoods[idx] == searchFoods[idx] && selectedFoodsMark == -1 && searchFoodsMark == -1) continue
//            if (selectedFoods[idx] && selectedFoodsMark == -1) selectedFoodsMark = idx
//            if (searchFoods[idx] && searchFoodsMark == -1) searchFoodsMark = idx
//        }
////        println("$selectedFoodsMark and $searchFoodsMark")
//
//        if (selectedFoodsMark > searchFoodsMark) return true
//        return false

//        두번째 방법 (string 대소비교는 사전순인 것을 활용하여, 음식들을 string형으로 변환하여 바로 대소 비교를 해준다.)
        var selectedFoodsString = ""
        var searchFoodsString = ""
        for (idx in selectedFoods.indices){
            if (selectedFoods[idx]) selectedFoodsString += (idx+1).toString()
            if (searchFoods[idx]) searchFoodsString += (idx+1).toString()
        }
        if (selectedFoodsString > searchFoodsString) return true
        return false
    }
    // 완전탐색
    fun searchAllFoods(idx: Int){
        if (idx == foods.size){
            val compareTo = getNutritionSum(searchFoods)
//            println(searchFoods.contentToString())
            // 최소 영양소 기준을 넘으면서 가격이 더 싸거나, 가격은 같으면서 사전순으로 더 빠르면 음식 세트를 기억한다.
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

        searchAllFoods(idx+1)
        searchFoods[idx] = true
        searchAllFoods(idx+1)
        searchFoods[idx] = false
    }

    // 완전 탐색 시작
    searchAllFoods(0)

    // 조건에 맞는 답이 없는 경우
    if (price == 8000){
        println(-1)
        return
    }

    println(price)
    for (idx in selectedFoods.indices){
        if (selectedFoods[idx]) print("${idx+1} ")
    }
}