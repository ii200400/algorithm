import heapq, itertools

def solution(A):
    m_heap = []
    heap = []
    
    for num in A:
        if num > 0:
            heapq.heappush(heap, -num)
        else:
            heapq.heappush(m_heap, num)
    
    nums = []
    for _ in range(3):
        if len(heap) > 0:
            nums.append(-heapq.heappop(heap))
        else:
            break
        
    for _ in range(2):
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
