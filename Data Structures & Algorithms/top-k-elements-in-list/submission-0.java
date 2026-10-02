class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],  map.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryListSortedDesc =  map.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .toList();
        return entryListSortedDesc.subList(0, k).stream().mapToInt(Map.Entry::getKey).toArray();
    }
}
