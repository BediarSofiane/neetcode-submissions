class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> indicesStack = new Stack();
        for (int i = 0; i < n; i++) {
            while (indicesStack.size() > 0 && temperatures[i] > temperatures[indicesStack.peek()]) {
                int head = indicesStack.pop();
                result[head] = i - head;
            }
            indicesStack.add(i);
        }
        return result;
    }
}
