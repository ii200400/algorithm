#에라테노스의 체였나 그것을 사용하면 더 빠를 것 같기는 한데 쓰지는 않고
#그냥 제곱근의 속도(O(sqrt(N)))로만 해결하도록 하였다.

import math

def solution(N):
    sqrt = int(math.sqrt(N))
    for num in range(sqrt, 0, -1):
        if N % num == 0:
            return 2 * (num + N//num)
