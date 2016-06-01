import operator

def convert(s, numRows):
    if numRows == 1 or numRows >= len(s):
        return s
    zigzag = [[] for x in range(numRows)]
    print(zigzag)
    row, step = 0, 1
    for c in s:
        zigzag[row] += c,
        print(zigzag)
        if row == 0:
            step = 1
        elif row == numRows - 1:
            step = -1
        row += step
    print(reduce(operator.add, zigzag))
    #¼ä¸ô
    return ''.join(reduce(operator.add, zigzag))

def convert2(self, s, numRows):
    if numRows == 1 or numRows >= len(s): 
        return s
    final = [[] for row in xrange(numRows)]
    for i in range(len(s)): 
        final[numRows -1 - abs(numRows - 1 - i % (2 * numRows - 2))].append(s[i])
    return "".join(["".join(final[i]) for i in xrange(numRows)])

a = convert('PAYPALISHIRING',3)
print(a)
