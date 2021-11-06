package com.practice.problems.medium;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int[][] product = new int[nums.length][2];
        int maxProduct = product[0][0] = product[0][1] = nums[0];
        for (int index = 1; index < nums.length; index ++ ) {
            // 该位置为正数
            product[index][0] = Math.max(product[index - 1][0] * nums[index], Math.max(product[index -1][1] * nums[index], nums[index]));
            System.out.println("0 " + product[index][0]);
            product[index][1] = Math.min(product[index - 1][0] * nums[index], Math.min(product[index -1][1] * nums[index], nums[index]));
            System.out.println("1 " + product[index][1]);

            if (product[index][0] > maxProduct) {
                maxProduct = product[index][0];
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,-5,-2,-4,3};
        MaximumProductSubarray a = new MaximumProductSubarray();
        int b = a.maxProduct(nums);
        System.out.println(b);
    }

}
