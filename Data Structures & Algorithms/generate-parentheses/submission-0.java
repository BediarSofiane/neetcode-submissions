class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        compute(result, 0, 0, n, "");
        return result;
    }

    private void compute(List<String> combinations, int open, int closed, int n, String current) {
        if (open + closed == 2 * n) {
            combinations.add(current);
            return;
        }
        if (open < n) {
            compute(combinations, open + 1, closed, n, current + "(");
        }
        if (closed < open) {
            compute(combinations, open, closed + 1, n, current + ")");
        }
    }
}
