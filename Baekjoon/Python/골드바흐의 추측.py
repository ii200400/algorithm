i=int(input())
li=[]
while i!=0:
    li.append(i)
    i=int(input())

d=[2,3]
for i in range(4,1000):
    boo=True
    for j in d:
        if i%j==0:
            boo=False
            break
    if boo:
        d.append(i)

for num in li:
    for x in d:
        boo=True
        for y in d:
            if y>=num-x:
                break
            if (num-x)%y==0:
                boo=False
                break
        if boo:
            print(str(num)+" = "+str(x)+" + "+str(num-x))
            break
