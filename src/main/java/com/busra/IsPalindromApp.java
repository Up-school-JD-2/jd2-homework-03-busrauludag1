package com.busra;

import java.util.Scanner;

class IsPalindromApp {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String s = kb.nextLine();

        System.out.println(reverseWord(s));
        System.out.println(isPalindrome(s) ? "Palindrome" : "Is Not Palindrome");

    }

    public static boolean isPalindrome(String s){
        if (reverseWord(s).equals(s))
            return true;
        else
            return false;
    }

    public static String reverseWord(String s){
        char[] c = s.toCharArray();
        int halfLen = c.length / 2;

        for (int i = 0; i < halfLen; ++i){
            swap(c, i, c.length - 1 - i);
        }

        return String.valueOf(c);
    }

    public static void swap(char[] chars, int index1, int index2){
        char c = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = c;
    }
}




