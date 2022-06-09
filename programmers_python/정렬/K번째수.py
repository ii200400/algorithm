##파이썬 내장함수 사용

def solution(array, commands):
    answer = []
    
    for (i,j,k) in commands:
        temp = array[i-1:j]
        answer.append(sorted(temp)[k-1])
    
    return answer
