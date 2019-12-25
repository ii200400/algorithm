# 시간복잡도가 크게 나와서 큰 수에서 좋지 않은 결과를 보였다.
def solution(N, A):
    m = 0
    array = [0 for _ in range(N)]
    
    for num in A:
        if num <= N:
            array[num-1] += 1
        else:    
            m = max(array)
            array = [m for _ in range(N)]
            
    return array

# 위의 문제를 해결하기 위해서 사용한 코드 대략 30배 정도 빨라졌다.
def solution(N, A):
    dic = {}
    ma = 0
    mi = 0
    
    for num in A:
        if num == N+1:
            mi += ma
            ma = 0
            dic.clear()
        else:
            dic[num] = dic.get(num, 0) + 1
            if dic[num] > ma:
                ma = dic[num]
            
    array = [mi for _ in range(N)]
    for key, val in dic.items():
        array[key-1] += val
    
    return array
