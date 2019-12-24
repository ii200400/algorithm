num=input().split(" ")
num=[int(i) for i in num]

th=[2,3]
bo=True

for i in range (4,10000):
    bo=True
    for j in th:
        if i%j==0:
            bo=False
            break
    if bo:
        th.append(i)

i=0
div=1
n1=num[0]
n2=num[1]
while i<len(th):
    if n1%th[i]==0 and n2%th[i]==0:
        div*=th[i]
        n1=int(n1/th[i])
        n2=int(n2/th[i])
        continue
    i+=1

print(div)
print(int(n1*n2*div))
