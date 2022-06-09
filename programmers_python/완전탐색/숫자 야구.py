##말 그대로 모든 경우의 수를 모두 채크하는 방법이다.
##대부분 비슷하게 하였다.

from itertools import permutations

def solution(baseball):
    answer = 0
    #([i for i in ['1','2','3','4','5','6','7','8','9']], 3)를 왜 쎴는지..
    #(['1','2','3','4','5','6','7','8','9'], 3)로 쓰자..
    all_num = list(permutations([i for i in ['1','2','3','4','5','6','7','8','9']], 3))
    
    for number in all_num:
        answer += 1
        for predict, strike, ball in baseball:
            predict = str(predict)
            s_cnt = 0
            b_cnt = 0
            for i in range(3):
                if predict[i] == number[i]: s_cnt += 1
                elif predict[i] in number: b_cnt += 1
            
            if not (s_cnt == strike and b_cnt == ball): 
                answer -= 1
                break
    
    return answer

##정확성: 100.0
##합계: 100.0 / 100.0
