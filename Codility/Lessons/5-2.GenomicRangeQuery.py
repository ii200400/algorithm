#prefix sum을 전혀 사용하지 않고 장렬하게 timeout이 나온 코드
def solution(S, P, Q):
    length = len(P)
    array = [0 for _ in range(length)]
    
    for num in range(length):
        s = S[P[num]:Q[num]+1]
        
        mini = 5
        for char in s:
            if char == 'T' and mini > 4:
                mini = 4
            elif char == 'G' and mini > 3:
                mini = 3
            elif char == 'C' and mini > 2:
                mini = 2
            elif char == 'A' and mini > 1:
                mini = 1
                break
        
        array[num] = mini
        
    return array

#prefix sum을 사용하였다. ACGT를 각각 세어서 2차원배열로 사용하였다.
def solution(S, P, Q):
    answer = [0 for _ in range(len(P))]
    p_sum = [[0,0,0,0] for _ in range(len(S)+1)]
    
    for index, char in enumerate(S):
        if char == 'A':
            p_sum[index+1] = [p_sum[index][0]+1,p_sum[index][1]
            ,p_sum[index][2],p_sum[index][3]]
        elif char == 'C':
            p_sum[index+1] = [p_sum[index][0],p_sum[index][1]+1
            ,p_sum[index][2],p_sum[index][3]]
        elif char == 'G':
            p_sum[index+1] = [p_sum[index][0],p_sum[index][1]
            ,p_sum[index][2]+1,p_sum[index][3]]
        elif char == 'T':
            p_sum[index+1] =[p_sum[index][0],p_sum[index][1]
            ,p_sum[index][2],p_sum[index][3]+1]
            
    for num in range(len(P)):
        slice_p = p_sum[P[num]]
        slice_q = p_sum[Q[num]+1]
        
        if slice_q[0] > slice_p[0]:
            answer[num] = 1
        elif slice_q[1] > slice_p[1]:
            answer[num] = 2
        elif slice_q[2] > slice_p[2]:
            answer[num] = 3
        elif slice_q[3] > slice_p[3]:
            answer[num] = 4
        
    return answer
