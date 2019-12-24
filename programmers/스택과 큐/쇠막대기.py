##나오는 문자에 따라서 변수에 덧셈 뺄셈정도만 하는 문제
##다들 비슷하게 풀어서 참고할 것도 없다. 단지 나처럼 슬라이싱을 사용한 사람은 적다.

def solution(arr):
    answer = 0
    count = 0
    loc = 0
    while(True):
        if arr[loc:loc+2] == '()': 
            answer += count
            loc += 1
        elif arr[loc] == ')': 
            count -= 1
        elif arr[loc] == '(':
            count += 1
            answer += 1
        loc += 1
        
        if loc == len(arr): break
    
    return answer
