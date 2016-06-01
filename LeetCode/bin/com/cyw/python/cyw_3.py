def lengthOfLongestSubstring(s):
    ans, start, end = 0, 0, 0
    countDict = {}
    for c in s:
        end += 1
        print(countDict)
        countDict[c] = countDict.get(c, 0) + 1
        print(countDict[c])
        print(countDict)
        while countDict[c] > 1:
            print(start)
            print('start:'+s[start])
            countDict[s[start]] -= 1
            start += 1
        ans = max(ans, end - start)
    return ans
    
a = lengthOfLongestSubstring('woowshicabeywwshicabe')
print(a)
