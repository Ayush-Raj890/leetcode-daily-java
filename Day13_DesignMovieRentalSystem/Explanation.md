# Day 13: LeetCode 1912 – Design Movie Rental System

## Problem Statement
We are asked to design a **Movie Renting System** where multiple shops rent out movies at different prices.  
The system should support these operations:

1. **search(movie)** → Return up to 5 shops offering this movie, sorted by price → shop ID.  
2. **rent(shop, movie)** → Rent the given movie from the given shop.  
3. **drop(shop, movie)** → Return the rented movie to the shop.  
4. **report()** → Return up to 5 rented movies, sorted by price → shop ID → movie ID.  

We need efficient lookups, insertions, and deletions.

---

## Approach ##

We design a data structure with the following components:

- **Node class** → Represents a `(shop, movie, price)` triple.
- **Comparator (CMP)** → Defines sorting order by price → shop → movie.
- **availableByMovie (Map<movie, TreeSet<Node>>)**  
  - Stores all currently available copies of a movie.  
  - Allows `search()` in `O(log n)`.
- **rentedSet (TreeSet<Node>)**  
  - Stores all currently rented movies.  
  - Used in `report()`.
- **byPair (Map<(shop,movie), Node>)**  
  - Provides quick access to a specific `(shop, movie)` combination.

### Operations
1. **Constructor**  
   - Initialize structures with given `entries`.  
   - Populate `availableByMovie` and `byPair`.

2. **search(movie)**  
   - Look into `availableByMovie[movie]`.  
   - Take first 5 entries (TreeSet keeps them sorted).  
   - Return shop IDs.

3. **rent(shop, movie)**  
   - Remove node from `availableByMovie[movie]`.  
   - Insert into `rentedSet`.

4. **drop(shop, movie)**  
   - Remove node from `rentedSet`.  
   - Add back into `availableByMovie[movie]`.

5. **report()**  
   - Take first 5 entries from `rentedSet`.  
   - Return list of `[shop, movie]`.

---

## Dry Run Example
### Input:
n = 3
entries = [[0,1,5],[0,2,6],[0,3,7],[1,1,4],[2,1,5]]


### Steps:
- `search(1)` → returns `[1,0,2]` (shops with movie 1 sorted by price then shop).
- `rent(0,1)` → shop 0 rents movie 1.
- `report()` → `[[0,1]]`.
- `drop(0,1)` → movie returned to shop 0.
- `report()` → `[]`.

---

## Complexity Analysis
- **search** → `O(log n + k)` (fetch first 5 nodes from TreeSet).  
- **rent / drop** → `O(log n)` (remove/insert in TreeSet).  
- **report** → `O(k)` where `k ≤ 5`.  
- **Space** → `O(n)` for storing all movie copies.

---

## Significance
This problem is a **system design + data structure** combination.  
It tests ability to:
- Use **TreeSet/priority-based structures** for ordering.  
- Manage **multiple indices** (`availableByMovie`, `rentedSet`, `byPair`).  
- Efficiently support **updates + queries** in logarithmic time.  

day: 13
leetcode_problem:
  number: 1912
  title: "Design Movie Rental System"

problem_statement: |
  Design a Movie Renting System where multiple shops rent out movies at different prices.
  The system should support:
    1. search(movie): Return up to 5 shops offering this movie, sorted by price → shop ID.
    2. rent(shop, movie): Rent the given movie.
    3. drop(shop, movie): Return the rented movie to the shop.
    4. report(): Return up to 5 rented movies, sorted by price → shop ID → movie ID.

approach:
  - Use Node class for (shop, movie, price).
  - Comparator (CMP) defines order: price → shop → movie.
  - Data Structures:
      availableByMovie: Map<movie, TreeSet<Node>>
      rentedSet: TreeSet<Node>
      byPair: Map<(shop,movie), Node>
  - Operations:
      constructor: initialize from entries
      search: get top 5 shops from availableByMovie[movie]
      rent: move node from availableByMovie to rentedSet
      drop: move node from rentedSet to availableByMovie
      report: return top 5 rented entries

dry_run_example:
  input:
    n: 3
    entries: [[0,1,5],[0,2,6],[0,3,7],[1,1,4],[2,1,5]]
  steps:
    - search(1): [1,0,2]
    - rent(0,1)
    - report(): [[0,1]]
    - drop(0,1)
    - report(): []

complexity:
  time:
    search: "O(log n + k)"
    rent: "O(log n)"
    drop: "O(log n)"
    report: "O(k), k ≤ 5"
  space: "O(n)"

significance: |
  This problem combines system design and data structures.
  It tests:
    - Efficient ordering with TreeSet/priority queues.
    - Managing multiple indices for fast queries.
    - Supporting dynamic updates with logarithmic complexity.
