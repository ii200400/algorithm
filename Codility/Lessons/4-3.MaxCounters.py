# 시간복잡도가 크게 나와서 큰 수에서 좋지 않은 결과를 보였다.
def solution(N, A):
    m = 0
    array = [0 for _ in range(N)]
    
    for num in A:
        if num == N+1:
            m = max(array)
            array = [m for _ in range(N)]
        else:
            array[num - 1] += 1
            
    return array

# 위의 문제를 해결하기 위해서 사용한 코드 대략 30배 정도 빨라졌다.
def solution(N, A):
    dic = dict()
    max_counter = 0
    count = 0

    for num in A:
        if num == N + 1:
            max_counter += count
            dic.clear()
            count = 0

        else:
            dic[num - 1] = dic.get(num - 1, 0) + 1

            if dic[num - 1] > count:
                count = dic[num - 1]

    return [dic.get(idx, 0) + max_counter for idx in range(N)]
