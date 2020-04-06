# 어떤 알고리즘을 써야할지 모르겠어서 생각이 나는대로 시간복잡도가 O(N**2)이 걸리는 알고리즘을 만들었다.
def solution(A):
    answer, s = 0, 20001
    
    start = 0
    while start < len(A)-1:
        s_part = A[start]
        
        end = start+1
        while end < len(A):
            s_part += A[end]
            ave = s_part / (end-start+1)
            if ave < s:
                s = ave
                answer = start
                
            end += 1
        start += 1
        
    return answer

# https://github.com/daotranminh/playground/blob/master/src/codibility/MinAvgTwoSlice/proof.pdf
# 위의 수학적 증명을 보고 시간복잡도가 O(N)이 걸리는 알고리즘이다.
# 특별히 prefix sum이거나 다른 알고리즘을 사용하지 않는다;
def solution(A):
    answer = -1
    avg = 10001

    for idx in range(len(A) - 1):
        if (A[idx] + A[idx + 1]) / 2 < avg:
            avg = (A[idx] + A[idx + 1]) / 2
            answer = idx
        elif idx != len(A) - 2 and (A[idx] + A[idx + 1] + A[idx + 2]) / 3 < avg:
            avg = (A[idx] + A[idx + 1] + A[idx + 2]) / 3
            answer = idx

    return answer