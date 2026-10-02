class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        while (i < k) {
            pq.add(nums[i]);
            i++;
        }
        while (i < nums.length) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
            i++;
        }
        return pq.peek();

    }
}
