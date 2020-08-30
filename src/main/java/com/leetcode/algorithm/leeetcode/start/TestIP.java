package com.leetcode.algorithm.leeetcode.start;

import java.net.Inet6Address;
import java.net.InetAddress;

public class TestIP {
    public static void main(String[] args) {
       // System.out.println("001:");

    }

    ;

    /**
     *最直接的方法是使用内置函数和 try/catch 结构检查 IP 地址的正确性：
     * 在 Python 中使用 ipaddress，
     * 在 Java 中使用 InetAddress 。
     * @param ip
     * @return
     */
    public String isIp(String ip) {
        try {
            return (InetAddress.getByName(ip) instanceof Inet6Address) ? "IPv6" : "IPv4";
        } catch ( Exception e ) {
            return "Neither";
        }
    }


    public String validateIPv4(String IP){
        String[] nums = IP.split("\\.",-1);

        for (String x :nums){
            if (x.length() ==0 || x.length()>3 ) return "Neither";
            if (x.charAt(0) ==  '0' && x.length() != 1) return  "Neither";
            for (char ch :x.toCharArray()){
                if (! Character.isDigit(ch)) return "Neither";
            };
            if (Integer.parseInt(x) > 255) return "Neither";
        }
        return null;
    }


    public String validateIPv6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x : nums) {
            // Validate hexadecimal in range (0, 2**16):
            // 1. at least one and not more than 4 hexdigits in one chunk
            if (x.length() == 0 || x.length() > 4) return "Neither";
            // 2. only hexdigits are allowed: 0-9, a-f, A-F
            for (Character ch : x.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) return "Neither";
            }
        }
        return "IPv6";
    }


    public String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(IP);
        }
        else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(IP);
        }
        else return "Neither";
    }

}
