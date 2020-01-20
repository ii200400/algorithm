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
