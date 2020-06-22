package com.qw.springcloud;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //输入源字符串用来被查找，如果不以$结尾，保持输入
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        while (!str.endsWith("$")) {
            str += scanner.nextLine();
        }
        System.out.println("源字符串：" + str);
        //输入特定单词用来查找
        String targetStr = scanner.nextLine();
        System.out.println("特定单词：" + targetStr);
        //输出特定单词出现次数
        count(str, targetStr);
        //输出各字符出现次数
        count(str);
    }
    public static void count(String str, String targetStr) {
        int count = 0;
        //如果输入的特定单词为""，不进行查找，直接输出次数为0
        if ("".equals(targetStr)) {
            System.out.println(targetStr + "出现次数：" + count);
            return;
        }
        //查询特定单词从头开始第一次出现位置
        int index = str.indexOf(targetStr);
        //-1说明没有查找，如果查到统计一次，并且该位置已经查询过了，从该位置后续开始重新查，直到-1没有查到为止位置
        while (index != -1) {
            count++;
            index = index + targetStr.length();
            index = str.indexOf(targetStr, index);
        }
        System.out.println(targetStr + "出现次数：" + count);
    }
    public static void count(String str) {
        int numberCount = 0;
        int letterCount = 0;
        int otherCount = 0;
        for (int i = 0; i < str.length(); i++) {
            //判断3种字符，符合就统计一次，就目前的题目，末尾的$也会被统计
            if (Character.isLetter(str.charAt(i))) {
                letterCount++;
            }else if(Character.isDigit(str.charAt(i))){
                numberCount++;
            }else{
                otherCount++;
            }
        }
        System.out.println("数字出现次数：" + numberCount);
        System.out.println("字母出现次数：" + letterCount);
        System.out.println("其他出现次数：" + otherCount);
    }
}
