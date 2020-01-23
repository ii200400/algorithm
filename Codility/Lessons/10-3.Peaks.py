# 먼저 peak들의 위치를 리스트로 만든다. (O(n)의 시간복잡도 필요)
# 리스트 길이의 약수를 찾고
# 그런데 더 쉬운 방법을 찾아서 그것도 아래에 올렸다.
# 방법은 같은데 기준을 다르게 두어서 나보다 훨씬 짧고 속도도 조금 더 빠르다.

import math

def solution(A):
    l = len(A)
    
    def check(leng):
        temp = -1
        
        for peak in peak_list:
            if temp == peak//leng:
                continue
            elif temp+1 == peak//leng:
                temp += 1
            else:
                return False
        
        if temp == math.ceil(l/leng)-1:
            return True
        else:
            return False
        
    peak_list = [0 for i in range(l//2)]
    peak_index = 0
    isup = False
    
    for index in range(1,l):
        if A[index-1] == A[index]:
            isup = False
        elif  A[index-1] < A[index]:
            isup = True
        elif isup == True:
            peak_list[peak_index] = index - 1
            peak_index += 1
            isup = False
    
    if peak_index == 0:
        return 0
    
    peak_list = peak_list[:peak_index]
    start = int(math.sqrt(l))
    isup = None
    for num in range(start,0,-1):
        if l % num == 0:
            if check(num):
                isup = False
            else:
                isup = True
            
            start = num
            break
    
    answer = 0
    for num in range(start,0,-1):
        if l % num == 0:
            if isup == True and check(l//num):
                return num
            elif isup == False:
                if check(num):
                    answer = num
                else:
                    break
    
    return l//answer

# 다른 사람의 해결 방법이다. 배워야겠다..
def solution(A):
    peaks = []
 
    for idx in range(1, len(A)-1):
        if A[idx-1] < A[idx] > A[idx+1]:
            peaks.append(idx)
 
    if len(peaks) == 0:
        return 0
 
    for size in range(len(peaks), 0, -1):
        if len(A) % size == 0:
            block_size = len(A) // size
            found = [False] * size
            found_cnt = 0
            for peak in peaks:
                block_nr = peak//block_size
                if found[block_nr] == False:
                    found[block_nr] = True
                    found_cnt += 1
 
            if found_cnt == size:
                return size
 
    return 0
