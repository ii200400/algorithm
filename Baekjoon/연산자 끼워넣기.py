# 문제 https://www.acmicpc.net/problem/14888
# 결과 페이지 http://boj.kr/af000b03e3b343668c7da733ea3474b5
import math

input()
nums = list(map(int, input().split()))
ops = list(map(int, input().split()))

# [지금까지 계산한 값, 지금까지 사용한 (_, -, *, %) 개수], 총 연산자 수
stack, op_sum = [[nums[0], [0,0,0,0]]], sum(ops)
# 식의 결과가 최대, 최소인 것을 저장하는 변수
result_min, result_max = 1000000000, -1000000000

# 깊이우선방식 사용
while len(stack)>0:
    val, stack_ops = stack.pop()
    stack_op_sum = sum(stack_ops)

    for i in range(4):
        # 연산 가능 여부 확인
        if stack_ops[i]+1 <= ops[i]:
            new_val = 0

            if i==0: new_val = val + nums[stack_op_sum+1]
            elif i==1: new_val = val - nums[stack_op_sum+1]
            elif i==2: new_val = val * nums[stack_op_sum+1]
            # "음수를 양수로 나눌 때는 C++14의 기준을 따른다."
            # "즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다."
            elif i==3: new_val = val // nums[stack_op_sum+1] if val>0 else math.ceil(val / nums[stack_op_sum+1])

            # 연산자를 모두 사용했는지
            if stack_op_sum+1 == op_sum:
                result_min = min(result_min, new_val)
                result_max = max(result_max, new_val)
            else: # 모두 사용하지 않았으면 스택에 상태 저장
                new_ops = stack_ops[:]
                new_ops[i] += 1
                stack.append([new_val, new_ops])

print(result_max)
print(result_min)