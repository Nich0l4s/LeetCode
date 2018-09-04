package com.xxp.leetcode.Medium;
public class MultiplyStrings {
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int l1 = num1.length();
        int l2 = num2.length();
        int l = l1 + l2;

        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        char[] result = new char[l];

        for (int i = l1 - 1; i >= 0; i--) {
            int a = c1[i] - '0';
            for (int j = l2 - 1; j >= 0; j--) {
                result[i + j + 1] += a * (c2[j] - '0');
            }
        }
        for (int i = l - 1; i > 0; --i) {
            if (result[i] > 9) {
                result[i - 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (;; ++i)
            if (result[i] != 0)
                break;
        for (; i < result.length; ++i)
            sb.append((char) (result[i] + '0'));
        return sb.toString();
    }

    public String multiply(String num1, String num2) {
        if (num1.length() > num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int[][] times = new int[10][];
        times[0] = new int[] { 0 };
        times[1] = new int[num2.length()];
        for (int i = 0; i < num2.length(); i++) {
            times[1][i] = num2.charAt(num2.length() - 1 - i) - '0';
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int factor1 = num1.charAt(num1.length() - 1 - i) - '0';
            if (times[factor1] == null) {
                times[factor1] = new int[num2.length() + 1];
                int carry = 0;
                for (int j = 0; j < num2.length(); j++) {
                    int product = factor1 * times[1][j] + carry;
                    times[factor1][j] = product % 10;
                    carry = product / 10;
                }
                times[factor1][num2.length()] = carry;
            }
            int carry = 0, j = 0;
            while (j < times[factor1].length) {
                int sum = times[factor1][j] + res[i + j] + carry;
                res[i + j] = sum % 10;
                carry = sum / 10;
                j++;
            }
            while (carry != 0) {
                int sum = res[i + j] + carry;
                res[i + j] = sum % 10;
                carry = sum / 10;
                j++;
            }
        }
        int i = res.length - 1;
        while (i > 0 && res[i] == 0) {
            i--;
        }
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            sb.append(res[i--]);
        }
        return sb.toString();
    }
}