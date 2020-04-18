# 리스트 길이의 제곱근의 +1 이내의 수에 답이 있다는 것을 알면 쉽게 만들 수 있다.
# 그러고보니 약수와는 관계가 없는 알고리즘인데 이게 왜 이곳으로 분류가 되었는지 잘 모르겠다.

import math

def solution(A):
    def is_set(k):
        count = 0
        save = -700

        for idx in range(len(peaks)):
            if peaks[idx] - save >= k:
                save = peaks[idx]
                count += 1
                if count == k:
                    return True

        return False

    peaks = [idx + 1 for idx in range(len(A) - 2) if A[idx] < A[idx + 1] and A[idx + 1] > A[idx + 2]]
    if len(peaks) < 1: return 0

    max_flags = int(math.sqrt(len(A)) + 1)
    for k in range(max_flags, 0, -1):
        if is_set(k):
            return k

    return 0