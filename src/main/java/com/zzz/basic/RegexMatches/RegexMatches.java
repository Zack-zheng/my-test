package com.zzz.basic.RegexMatches;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jack_ on 2017/1/15.
 */

public class RegexMatches {
    /**
     * 捕获组
     * 捕获组是把多个字符当一个单独单元进行处理的方法，它通过对括号内的字符分组来创建。
     * 例如，正则表达式 (dog) 创建了单一分组，组里包含"d"，"o"，和"g"。
     * 捕获组是通过从左至右计算其开括号来编号。例如，在表达式（（A）（B（C））），有四个这样的组：
     * ((A)(B(C)))
     * (A)
     * (B(C))
     * (C)
     * 可以通过调用 matcher 对象的 groupCount 方法来查看表达式有多少个分组。groupCount 方法返回一个 int 值，表示matcher对象当前有多个捕获组。
     * 还有一个特殊的组（group(0)），它总是代表整个表达式。该组不包括在 groupCount 的返回值中。
     */
    public static void main(String args[]) {

        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        System.out.println("groupCount:" + m.groupCount());
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));//打印本身
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));

        } else {
            System.out.println("NO MATCH");
        }
    }
}

class RegexMatches1 {
    private static final String REGEX = "\\bcat\\b";//符串字面值 "\b" 与单个退格字符匹配，而 "\\b" 与单词边界匹配
    private static final String INPUT =
            "cat cat cat cattie cat";

    public static void main(String args[]) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0;

        while (m.find()) {
            count++;
            System.out.println("Match number " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());
        }
    }
}

class RegexMatches2 {
    private static final String REGEX = "foo";
    private static final String INPUT = "fooooooooooooooooo";
    private static Pattern pattern;
    private static Matcher matcher;

    public static void main(String args[]) {
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(INPUT);

        System.out.println("Current REGEX is: " + REGEX);
        System.out.println("Current INPUT is: " + INPUT);

        System.out.println("lookingAt(): " + matcher.lookingAt());
        System.out.println("matches(): " + matcher.matches());
    }
}

class RegexMatches3 {
    private static String REGEX = "dog";
    private static String INPUT = "The dog says meow. " +
            "All dogs say meow.";
    private static String REPLACE = "cat";

    //replaceFirst 替换首次匹配，replaceAll 替换所有匹配。
    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        // get a matcher object
        Matcher m = p.matcher(INPUT);
        INPUT = m.replaceFirst(REPLACE);
        System.out.println("replaceFirst 替换首次匹配:" + INPUT);
        INPUT = m.replaceAll(REPLACE);
        System.out.println("replaceAll 替换所有匹配:" + INPUT);
    }
}

class RegexMatches4 {
    private static String REGEX = "a*b";
    private static String INPUT = "aabfooaabfooabfoob";
    private static String REPLACE = "-";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        // 获取 matcher 对象
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, REPLACE);
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}