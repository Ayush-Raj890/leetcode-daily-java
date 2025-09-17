# Day 09 – Design a Food Rating System

**Problem Link:** [LeetCode #2353: Design a Food Rating System](https://leetcode.com/problems/design-a-food-rating-system/)

---

## Problem Statement
You are tasked with designing a system that can track **foods, cuisines, and ratings**.  

You need to implement a class `FoodRatings`:

- **Constructor:**  
  `FoodRatings(String[] foods, String[] cuisines, int[] ratings)`  
  - `foods[i]`, `cuisines[i]`, and `ratings[i]` represent the name, cuisine, and rating of the i-th food.  

- **Methods:**  
  - `void changeRating(String food, int newRating)` → Update the rating of the given food.  
  - `String highestRated(String cuisine)` → Return the food with the **highest rating** in the given cuisine.  
    - If multiple foods have the same rating, return the lexicographically smallest food name.  

---

## Approach
1. **Data Structures Used:**  
   - `Map<String, Food>` → Maps food name to its `Food` object (quick access).  
   - `Map<String, TreeSet<Food>>` → Maps each cuisine to a **sorted set of foods**, ordered by:
     - Highest rating first.  
     - If ratings are equal, lexicographically smaller food name first.  

2. **Adding Foods (Constructor):**  
   - For each food, store it in `foodToFood`.  
   - Insert it into the corresponding cuisine’s `TreeSet`.  

3. **Updating Ratings (`changeRating`):**  
   - Find the food object from `foodToFood`.  
   - Remove it from the cuisine’s `TreeSet`.  
   - Update the rating.  
   - Reinsert it into the `TreeSet` to maintain order.  

4. **Getting Highest Rated (`highestRated`):**  
   - Return the first element in the cuisine’s `TreeSet` (since it’s always sorted).  

---

## Dry Run
**Input:**  
```text
foods = ["kimchi","miso","sushi","moussaka","ramen","bulgogi"]  
cuisines = ["korean","japanese","japanese","greek","japanese","korean"]  
ratings = [9,12,8,15,14,7]
Build initial mappings:

"japanese" → { ramen(14), miso(12), sushi(8) }

"korean" → { kimchi(9), bulgogi(7) }

"greek" → { moussaka(15) }

highestRated("korean") → "kimchi" (rating 9).

changeRating("sushi", 16)

Remove sushi(8), reinsert sushi(16).

Now "japanese" → { sushi(16), ramen(14), miso(12) }.

highestRated("japanese") → "sushi".

Time & Space Complexity

Insertion/Removal in TreeSet: O(log N)

Highest Rated Query: O(1) (fetching first element).

Space Complexity: O(N) to store foods and cuisines.

Significance

Demonstrates the use of custom comparators with TreeSet.

Covers data structure design: multiple maps + ordering requirements.

Strengthens understanding of balancing fast updates and efficient queries.



