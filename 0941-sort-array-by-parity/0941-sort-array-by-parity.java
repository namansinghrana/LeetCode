class Solution {
    public int[] sortArrayByParity(int[] nums) {
        Integer[] res = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(res, (x, y) -> Integer.compare(x%2, y%2));
        return Arrays.stream(res).mapToInt(Integer::intValue).toArray();
    }
}