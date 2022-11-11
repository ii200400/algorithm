# 입력 처리
_, m = map(int, input().split())
numbers = list(map(int, input().split()))
l = len(numbers)

ishead, count, answer, head, tail = True, 0, 0, 0, 0

while True:
    if ishead: 
        if (head >= l): break
    
        count += numbers[head]
        if count == m: 
            answer += 1
            ishead = False
        elif count > m: ishead = False
        
        head += 1
            
    else: 
        count -= numbers[tail]
        if count == m:
            answer += 1
            ishead = True
        elif count < m: ishead = True
        
        tail += 1

print(answer)