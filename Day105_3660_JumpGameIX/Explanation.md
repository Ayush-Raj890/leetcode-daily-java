# 3660. Jump Game IX

## Approach
- Build a prefix maximum array `pre` where `pre[i]` is the maximum in `nums[0..i]`.
- Build a suffix minimum array `suf` where `suf[i]` is the minimum in `nums[i..n-1]`.
- Traverse from right to left and build `res`:
  - If `pre[i] > suf[i + 1]`, current index merges with the next segment, so `res[i] = res[i + 1]`.
  - Otherwise, start a new segment with `res[i] = pre[i]`.

## Complexity
- Time: O(n)
- Space: O(n)
