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

#배열의 길이가 0일수도 있는데 고려를 안했다가 에러났다;
