import heapq, itertools

def solution(A):
    m_heap = []
    re_m_heap = []
    heap = []
    
    for num in A:
        if num >= 0:
            heapq.heappush(heap, -num)
        else:
            heapq.heappush(m_heap, num)
            heapq.heappush(re_m_heap, -num)
    
    nums = []
    for _ in range(3):
        if len(heap) > 0:
            nums.append(-heapq.heappop(heap))
        else:
            break
        
    if len(nums) == 0:
        for _ in range(3):
            if len(re_m_heap) > 0:
                nums.append(-heapq.heappop(re_m_heap))
            else:
                break
    else:      
        for _ in range(3):
            if len(m_heap) > 0:
                nums.append(heapq.heappop(m_heap))
            else:
                break
    
    answer = -1000000001
    combin = list(itertools.combinations(nums, 3))
    for a,b,c in combin:
        mul = a*b*c
        if answer < mul:
            answer = mul
            
    return answer

# 효율성 보다는 정확성이 어려웠던 문제였다. 다음에 다시 풀어봐야겠다.
