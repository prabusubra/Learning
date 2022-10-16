1. Remove Duplicates from Sorted Array

  Input: nums = [0,0,1,1,1,2,2,3,3,4]
  Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
  Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
  It does not matter what you leave beyond the returned k (hence they are underscores).

  ```
  class Solution {
    public int removeDuplicates(int[] nums) {
       int s = 0;
       for (int f = 1; f < nums.length; f++){
           if (nums[f] != nums[s]){
               s+=1;
               if (s!=f){
                   nums[s] = nums[f];
               }
           }
       }
        return s+1;
    }
}
```
2. Move Zeroes

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

```
class Solution {
    public void moveZeroes(int[] nums) {
        for (int i=0, j=0; i < nums.length; i+=1){
            if (nums[i] != 0){
                if (i != j){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++;
            } 
        }
    }
}
```

3. Longest Substring Without Repeating Characters

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> slide = new HashMap();
        int max = 0;

        //String[] data = s.split("");
        for (int left = 0, right =0; right < s.length(); right++ ){
            char currentChar = s.charAt(right);
            if (slide.containsKey(currentChar) && slide.get(currentChar) >= left){
                left = slide.get(currentChar) + 1;
            }
            max = Math.max(max, right-left+1);
            slide.put(currentChar, right);
        }
        return max;
    }
}
```
