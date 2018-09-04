package com.xxp.leetcode.Easy;

public class AddBinary {
	public String addBinary(String a, String b) {
        char[] cha;
        char[] chb;
        if(a.length() >= b.length()){
             cha = a.toCharArray();
             chb = b.toCharArray();
        }
        else{
            cha = b.toCharArray();
            chb = a.toCharArray();
        }
        char carry = '0';
        int i = 1;
        while(i<=cha.length){
            char ca = cha[cha.length-i];
            char cb = chb.length-i >= 0 ? chb[chb.length-i] : '0';
            cha[cha.length-i] = (char)(ca ^ cb ^ carry);
            carry = (char)((ca&cb)|((ca^cb)&carry));
            i++;
        }
        if(carry == '1'){
            return new StringBuilder("1").append(cha).toString();
        }
        return new String(cha);
    }

	public String addBinary2(String a, String b) {
		StringBuilder sb = new StringBuilder();
		char sum = '0';
		for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0;) {
			if (i >= 0)
				sum += a.charAt(i--);
			if (j >= 0)
				sum += b.charAt(j--);
			sb.append((char) ((sum & 1) + '0'));
			sum = (char) (((sum & 2) >> 1) + '0');
		}
		if (sum != '0') {
			sb.append(sum);
		}
		return sb.reverse().toString();
	}
}
