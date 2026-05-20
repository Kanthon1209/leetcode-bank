import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
    }

    List<char[]> mapper;
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        this.mapper.add(new char[] { 'a', 'b', 'c' });//
        this.mapper.add(new char[] { 'd', 'e', 'f' });
        this.mapper.add(new char[] { 'g', 'h', 'i' });
        this.mapper.add(new char[] { 'j', 'k', 'l' });
        this.mapper.add(new char[] { 'm', 'n', 'o' });
        this.mapper.add(new char[] { 'p', 'q', 'r', 's' });
        this.mapper.add(new char[] { 't', 'u', 'v' });
        this.mapper.add(new char[] { 'w', 'x', 'y', 'z' });
        backtrack(digits, 0, new StringBuilder());
        return this.res;
    }

    public void backtrack(String digits, int start, StringBuilder path) {
        if (path.length() == digits.length()) {
            res.add(new String(path));
            return;
        }
        char digit = digits.charAt(start); // 当前的数字是哪一个
        char[] chars = this.mapper.get(digit - '2');// 当前数字对应的字符是哪些
        for (int i = 0; i < chars.length; i++) {
            path.append(chars[i]);
            backtrack(digits, start + 1, path);
            path.deleteCharAt(path.length() - 1);// 删除最后一个字符
        }
    }
}
