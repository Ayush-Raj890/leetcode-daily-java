package Day24_MaximumBottlesDrunk;

class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int count = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            empty = empty - numExchange + 1;
            count++;
            numExchange++;
        }
        return count;
    }
}