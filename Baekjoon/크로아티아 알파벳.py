s = input()
l = 0
cnt = 0
while True:
    if (l>=len(s)): break
    if ({'dz=':3}.get(s[l:l+3],1)==3):
        l+=3
        cnt+=1
        continue
    if ({'c=':2,'c-':2,'d-':2,'lj':2,'nj':2,'s=':2,'z=':2}.get(s[l:l+2],1)==2):
        l+=2
        cnt+=1
        continue
    l+=1
    cnt+=1
    
print(cnt)
