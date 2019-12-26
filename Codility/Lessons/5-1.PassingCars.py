def solution(A):
    e_car = 0
    answer = 0
    
    for num in A:
        if num == 0:
            e_car += 1
        else:
            answer += e_car

    return answer if answer <= 1000000000 else -1
