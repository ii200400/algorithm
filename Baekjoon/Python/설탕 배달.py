s = int(input())

if s in [1,2,4,7]: print(-1)
else: print({0:1,1:2,2:1,3:2,4:3}.get((s-3)%5)+(s-3)//5)
