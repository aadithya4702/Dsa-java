package JavaTest;

public class Ip {

    public static void main(String[] args) {
        String s = "2001:0db8:85a3:0000:0000:8a2e:0370:zzzz";
        switch (ipType(s)) {
            case "IPv4":
                System.out.println("IPV4 type");
            case "IPv6":
                System.out.println("IPV6 type");
            default:
                System.out.println("Neither of those type");
        }
    }

    private static String ipType(String s) {
        if (isV4(s))
            return "IPV4";
        if (isV6(s))
            return "IPv6";

        return "No";
    }

    private static boolean isV6(String s) {
        if (s.endsWith(":")) {
            return false;
        }
        String[] sp = s.split(":");
        if (sp.length < 8 || sp.length > 8) {
            return false;
        }

        for (String c : sp) {

            if (c.length() < 1 || c.length() > 4) {
                return false;
            }
            for (char ch : s.toCharArray()) {
                if (!Character.isDigit(ch) && "0123456789abcdefABCDEF".contains(String.valueOf(ch))) {
                    return false;
                }
            }

        }
        return true;
    }

    private static boolean isV4(String s) {
        if (s.endsWith(".")) {
            return false;
        }

        String[] sp = s.split("\\.");

        if (sp.length < 4 || sp.length > 4) {
            return false;
        }

        for (String c : sp) {

            if (c.length() < 1 || c.startsWith("0")) {
                return false;
            }
            if (!isNotValidNumber(c)) {
                return false;
            }

        }

        return true;
    }

    private static boolean isNotValidNumber(String c) {
        int x = 0;
        for (char ch : c.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
            x = x * 10 + (ch - '0');
        }
        return x >= 0 && x < 255 ? true : false;
    }
}
