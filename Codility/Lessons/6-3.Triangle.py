# 배열의 길이가 0일수도 있는데 고려를 안했다가 에러났다;
# heap을 활용해서 해결해보았다.
import heapq

def solution(A):
    if len(A) < 3:
        return 0
        
    heapq.heapify(A)

    save = heapq.heappop(A)
    s = save + heapq.heappop(A)
    while len(A) > 0:
        num = heapq.heappop(A)
        if num < s:
            return 1
        else:
            temp = s - save
            s += num - save
            save = temp
    
    return 0

# 입력으로 받은 리스트를 그대로 sort 함수로 정렬해서 가장 큰 숫자가 나머지의 합보다 작은지만 확인한다.
def solution(A):
    A.sort()

    for idx in range(len(A) - 2):
        if A[idx] + A[idx + 1] > A[idx + 2]:
            return 1

    return 0
