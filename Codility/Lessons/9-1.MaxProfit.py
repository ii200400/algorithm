# 아주 비효율적인 O(n**2) 알고리즘
# maxinum slice problem으로 풀면 된다는데 잘 모르겠다.

def solution(A):
    answer = 0
    for index, num1 in enumerate(A):
        for num2 in A[index+1:]:
            if num2 - num1 > answer:
                answer = num2 - num1
    
    return answer

# 각 위치마다 사용가능한 최소값과 최대값을 리스트에 저장하고 답을 찾는 알고리즘

def solution(A):
    l = [[0,0] for _ in range(len(A))]
    leng = len(A)
    
    min_num = 400001
    max_num = -1
    for index,num in enumerate(A):
        if num < min_num:
            min_num = num
        l[index][0] = min_num
    for index, num in enumerate(A[::-1]):
        if num > max_num:
            max_num = num
        l[leng-index-1][1] = max_num

    answer = 0
    for num1, num2 in l:
        if answer < num2-num1:
            answer = num2-num1
            
    return answer

# 리스트를 하나씩 읽어오면서 가장 작은 값을 저장하는 동시에 현재 요소값과의 차이를 비교하여 가장 큰 차이값을 찾아내는 알고리즘
def solution(A):
    lowest, answer = 2000001, 0
    for price in A:
        if price < lowest:
            lowest = price
        if price - lowest > answer:
            answer = price - lowest

    return answer

# 다른 사람의 알고리즘을 참고하여 위의 알고리즘과 원리는 같지만 개행수를 줄인 것
def solution(A):
    lowest, answer = 2000001, 0
    for price in A:
        lowest = min(price, lowest)
        answer = max(price - lowest, answer)

    return answer