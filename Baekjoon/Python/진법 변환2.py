n,b=[int(i) for i in input().split(" ")]

li=[]
while n>=b:
    li.append(n%b)
    n=int(n/b)
li.append(n)

string=""
i=len(li)-1
while i!=-1:
    if li[i]>9:
        string+=chr(li[i]+55)
    else:
        string+=chr(li[i]+48)
    i-=1

print(string)
