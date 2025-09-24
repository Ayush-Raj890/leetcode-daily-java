package Day16_FractionToRecurringDecimal;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        // handle sign
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }

        // use long to avoid overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // integer part
        sb.append(num / den);
        long remainder = num % den;
        if (remainder == 0) return sb.toString();

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>(); // remainder -> index

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());

            remainder *= 10;
            sb.append(remainder / den);
            remainder %= den;
        }

        return sb.toString();
    }
}

