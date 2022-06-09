def solution(food_times, k):
    up = 100000000
    down = 0
    count = 0

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

    count = 0
    for i in food_times:
        if i <= down: count += i
        else: count += down

    answer = k - count
    for i in range(len(food_times)):
        if food_times[i] > down: 
            if answer == 0: return i+1
            answer -= 1
    
    return -1