num=int(input())

nums=input().split(" ")
nums=[int(i) for i in nums]
nums.sort()

print(nums[0]*nums[len(nums)-1])
