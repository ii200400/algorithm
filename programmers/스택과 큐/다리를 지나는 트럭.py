##리스트의 append와 pop을 이용해서 느리지만 간단한 코드
##빠른 속도를 보여주는 다른 사람의 코드에서는 클래스를 사용하기도 하였다.

def solution(length, weight, weights):
    time = 0
    li = [0 for i in range(length)]
    weight_s = 0
    
    while(True):
        weight_s -= li.pop(0)
        time += 1
        if weight_s+weights[0] <= weight:
            put = weights.pop(0)
            weight_s += put
            li.append(put)
        else: li.append(0)
        
        if len(weights) == 0:
            time += length
            break
    
    return time

##정확성: 100.0
##합계: 100.0 / 100.0
