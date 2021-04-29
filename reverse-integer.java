class Solution {
    public int reverse(int x) {
        boolean signed = false;
        if (x < 0) {
            signed = true;
            x = x * -1;
        }
        
        int result = 0;
        while (x >= 1) {
            int digit = x % 10;
            System.out.println(digit);
            x /= 10;
            System.out.println(x);
            if (result < Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit <= 7)) { 
                /*
                Clever trick to avoid overflow! 
                Instead of comparing result * 10 directly to Integer.MAX_VALUE, 
                you compare result to Integer.MAX_VALUE divided by 10! 
                Also if result == Integer.MAX_VALUE but the digit you popped off is less than 7, 
                which is the 1th place number in Integer.MAX_VALUE, 
                you can still add the digit to the growing number.
                */
                result *= 10;
                System.out.println(result);
                result += digit;
                System.out.println(result);
            }
            else {
                /*
                Otherwise, an overflow occured, and you just return 0
                */
                return 0;
            }
        }

        return signed ? (result * -1) : result;
    }
}
