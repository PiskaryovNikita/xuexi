package com.xuexi.sonya;

public class StringImmutabilityDemo {

    public static void main(String[] args) {

        // equal
        String s = "immutableString";
        String s2 = "immutableString";
        System.out.println(s == s2);
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(s2));
        s += 4;
        System.out.println(System.identityHashCode(s));

        // not equal
        s = new String("immutableString");
        s2 = new String("immutableString");
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(s2));

        // equal
        s = new String("immutableString1");
        System.out.println(System.identityHashCode(s));
        // under the hood inter() uses equals
        s = s.intern();
        s2 = new String("immutableString1");
        s2 = s2.intern();
        System.out.println(s == s2);
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(s2));
    }
}
