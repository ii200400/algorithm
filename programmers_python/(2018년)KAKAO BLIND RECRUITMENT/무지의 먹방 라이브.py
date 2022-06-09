##아.. 예외가 조금 나와서 조금 실수가 많았다.
##이진탐색을 이용해서 풀었다.

def solution(food_times, k):
    up = 100000000
    down = 0
    count = 0

    #이진탐색으로 각 음식을 최대 몇 초 먹었는지 확인
    while down+1 != up:
        count = 0
        mid = (up+down)//2
        for i in food_times:
            if i <= mid: count += i
            else: count += mid
        
        if count > k: up = mid
        elif count < k: down = mid
        else:
            down = mid
            break

    #위에서 마지막을 탐색한 mid가 up이었을 경우 count를 다시알아야 해서..
    count = 0
    for i in food_times:
        if i <= down: count += i
        else: count += down

    #몇번째 음식부터 먹어야하는지 구하는 부분
    answer = k - count
    for i in range(len(food_times)):
        if food_times[i] > down: 
            if answer == 0: return i+1
            answer -= 1
    
    return -1

##정확성: 42.9
##효율성: 57.1
##합계: 100.0 / 100.0
