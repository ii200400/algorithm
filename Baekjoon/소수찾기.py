n=int(input())
nums=input().split(" ")
nums=[int(i) for i in nums]

l=[2,3]
count=0

for i in range(4,30000):
    l.append(i)
    for j in l:
        if i%j==0 and i!=j:
            l.pop()
            break

for i in nums:
    if l.count(i)!=0:
        count+=1
print(l)
print(count)
