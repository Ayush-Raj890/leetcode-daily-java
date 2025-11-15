# 🔎 Day 68 – Number of Substrings (ones vs zeros threshold)

## 🧩 Problem (intent)
Count substrings of a binary string `s` that satisfy a relation between the number of `1`s and the number of `0`s. The implementation groups substrings by the number of zeros `z` and counts those where the number of ones in the substring is at least `z*z`.

## 💡 Key ideas
- Precompute prefix sums of `1`s for O(1) range-ones queries.
- Record positions of all `0`s in an array Z. This lets us enumerate substrings that contain exactly `z` zeros by choosing consecutive zero indices in Z and expanding left/right between adjacent zeros.
- Handle the special case `z = 0` (substrings of only `1`s) directly by summing lengths of consecutive `1` runs: len*(len+1)/2.
- For `z >= 1`, only need to consider z up to about sqrt(n): if z^2 > n no substring can have that many ones, so larger z are impossible.
- For each window of `z` consecutive zeros (indices a..b in Z) determine valid left starts and right ends, then for each left start find the minimal right position where ones >= z^2 using prefix sums; count all right extensions beyond that point.

## ⚙️ Algorithm outline
1. Build prefix sum array of `1`s.
2. Build list Z of zero indices.
3. Add contributions of all-ones substrings (runs of `1`s).
4. Let B = floor(sqrt(n)) + small constant. For each zero index a:
   - Determine allowed left-start range [Lmin..Lmax] (between previous zero+1 and Z[a]).
   - For z = 1..B, let b = a+z-1 (window of z zeros); determine right-end range [Rmin..Rmax].
   - For each left l in [Lmin..Lmax], binary/linear scan r in [Rmin..Rmax] to find first r with ones(l..r) >= z^2; add (Rmax - r + 1) to answer.
5. Return total count.

## ⏱ Complexity
- Time: O(n + m * B * (avg left-range work)), worst-case roughly O(n * sqrt(n)) but practically near O(n sqrt n).
- Space: O(n) for prefix sums and zero indices.

## ✅ Notes
- The sqrt-bound on z limits work: if z^2 > n no substring can meet the ones requirement.
- Using prefix sums and zero-index grouping avoids iterating all O(n^2) substrings.