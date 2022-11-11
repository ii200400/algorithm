n=int(input())
nums=[int(i) for i in input().split(" ")]
nums.sort()

sum=0
for i in range(n):
    sum+=nums[i]*(n-i)

print(sum)
