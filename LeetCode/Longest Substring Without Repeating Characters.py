# LeetCode
# https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        dic = {}
        head, tail, ishead = -1, -1, True
        answer = 0
        
        while True:
            if ishead:
                head += 1
                if head == len(s): break
                char = s[head]
            
                if dic.get(char, 0) == 0:
                    dic[char] = 1
                    if answer < len(dic): 
                        answer = len(dic)
                else: 
                    dic[char] = 2
                    ishead = False
                
            else:
                tail += 1
                char = s[tail]
                
                if dic[char] == 2: 
                    dic[char] = 1
                    ishead = True
                else: del dic[char]
                
        return answer
            
sol = Solution()
print(sol.lengthOfLongestSubstring("abcabcbb"))
print(sol.lengthOfLongestSubstring("bbbbb"))
print(sol.lengthOfLongestSubstring("pwwkew"))
