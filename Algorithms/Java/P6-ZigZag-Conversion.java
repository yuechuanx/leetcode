class Solution {
    public String convert(String s, int numRows) {
        /* 申请数组空间, 用来存储下标行的字符 */
        StringBuffer[] res = new StringBuffer[numRows];
        for (int i = 0; i < numRows; ++i) {
            res[i] = new StringBuffer();
        }
        
        /* 遍历字符串,更新每行字符 */
        int i = 0;
        while (i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); ++j) {   // 顺序res[0...N-1]
                res[j].append(s.charAt(i++));
            }
            for (int j = numRows - 2; j > 0 && i < s.length(); j--) {  // 逆序 res[N-2...1]
                res[j].append(s.charAt(i++));
            }
        }

        /* 将 res[1...N-1] 插入到 res[0] */
        for (int j = 1; j < numRows; ++j) {
            res[0].append(res[j]);
        }
        
        return new String(res[0]);
    }
}

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;  // 再次回到原下标的长度

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}