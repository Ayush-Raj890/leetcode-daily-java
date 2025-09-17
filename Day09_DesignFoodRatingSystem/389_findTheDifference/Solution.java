import java.util.HashMap;
import java.util.Map;
class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer>map=new HashMap<>();

        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        // traverse t and check
        for(char c: t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);

                if(map.get(c)==0){
                    map.remove(c);
                }
            }
            else{
                return c;
            }
        }
        return ' ';
    }
}

