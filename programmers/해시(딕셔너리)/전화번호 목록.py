##아니 이걸 왜 해시로 풀어.. 해시인거 까먹고 완전탐색해버렸는데 잘됨..
##게다가 전화번호 길이가 너무 작아서 진심 너무 빨리 풀린다. 

##def solution(phone_book):
##    for i in range(len(phone_book)):
##        for j in range(i+1,len(phone_book)):
##            if phone_book[j] in phone_book[i][0:len(phone_book[j])]: return False
##            if phone_book[i] in phone_book[j][0:len(phone_book[i])]: return False
##    
##    return True

##정확성  테스트
##테스트 1 〉	통과 (0.05ms, 10.7MB)
##테스트 2 〉	통과 (0.05ms, 10.7MB)
##테스트 3 〉	통과 (0.04ms, 10.7MB)
##테스트 4 〉	통과 (0.04ms, 10.7MB)
##테스트 5 〉	통과 (0.05ms, 10.7MB)
##테스트 6 〉	통과 (0.04ms, 10.6MB)
##테스트 7 〉	통과 (0.04ms, 10.7MB)
##테스트 8 〉	통과 (0.04ms, 10.7MB)
##테스트 9 〉	통과 (0.04ms, 10.6MB)
##테스트 10 〉	통과 (0.04ms, 10.6MB)
##테스트 11 〉	통과 (0.04ms, 10.7MB)
##효율성  테스트
##테스트 1 〉	통과 (0.16ms, 15.3MB)
##테스트 2 〉	통과 (0.15ms, 15.3MB)

##딕셔너리를 이용해서 푼 것, 위의 방법보다 느리다;;

##def solution(phone_book):
##    dic={}
##    for i in phone_book: dic[i] = 1
##        
##    for i in phone_book:
##        for j in range(1,len(i)): 
##            if dic.get(i[0:j]): return False
##    
##    return True

##정확성  테스트
##테스트 1 〉	통과 (0.04ms, 10.8MB)
##테스트 2 〉	통과 (0.04ms, 10.7MB)
##테스트 3 〉	통과 (0.04ms, 10.7MB)
##테스트 4 〉	통과 (0.06ms, 10.7MB)
##테스트 5 〉	통과 (0.04ms, 10.6MB)
##테스트 6 〉	통과 (0.04ms, 10.7MB)
##테스트 7 〉	통과 (0.04ms, 10.7MB)
##테스트 8 〉	통과 (0.04ms, 10.6MB)
##테스트 9 〉	통과 (0.04ms, 10.7MB)
##테스트 10 〉	통과 (0.04ms, 10.7MB)
##테스트 11 〉	통과 (0.04ms, 10.8MB)
##효율성  테스트
##테스트 1 〉	통과 (0.89ms, 15.3MB)
##테스트 2 〉	통과 (0.90ms, 15.4MB)
