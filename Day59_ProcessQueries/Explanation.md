# 🔧 Day 59 – Process Queries (DSU + Component Heaps)

## 🧩 Problem Summary

You have `c` cities (numbered 1..c) with initial connections (undirected). You must process queries of two types:
- Type 1: given a city u, return the smallest-index city in u's connected component that is currently online (not marked offline). If u itself is online return u. If none are online return -1.
- Type 2: mark a city u as offline (it remains offline for subsequent queries).

Connections are given before queries. City indices in inputs are 1-based.

This solution uses Disjoint Set Union (union-by-size) to build components, and for each component a min-heap (PriorityQueue) of its member city indices for retrieving the smallest online city. Offline cities are removed lazily from heaps during queries.

## 💡 Key Ideas

- Build DSU for `c` nodes and union all given connections.
- Maintain for each component a PriorityQueue of its member node indices (0-based in implementation).
- Maintain an `offline[]` boolean array.
- For a type-1 query on node u:
  - If u is currently online, return u.
  - Otherwise, find u's component parent, access its heap, pop offline nodes from the top until the top is online or heap is empty; return the top (or -1 if none).
- For a type-2 query mark the city offline. (Removal from heaps is lazy — done only when needed.)

## ⚙️ Implementation Notes

- Indices: input uses 1-based indices; implementation converts to 0-based.
- DSU:
  - `parent[]`, `size[]` arrays.
  - Union merges smaller into larger; when merging, transfer all elements from the smaller component's heap into the larger component's heap to keep PQs consistent.
- Heaps:
  - Each component keeps a `PriorityQueue<Integer>` with city indices so queries can obtain the minimum online index quickly.
  - Lazy deletion: offline cities remain in PQs until popped during a query.
- Complexity:
  - Building DSU: near O(c + connections · α(c)).
  - Each query: amortized O(log c) for heap operations; lazy removals cost overall proportional to number of offline marks.
  - Space: O(c) for DSU, heaps and offline array.

## ✅ Edge Cases

- Repeated offline marking of the same city — handled by boolean check.
- Queries asking about a city in a singleton component.
- If all cities in a component become offline, return -1 for type-1 queries to that component.

## 📌 Files

- See `Solution.java` in this folder for the implementation.

```// filepath: c:\Users\ayush\leetcode-daily-java\Day59_ProcessQueries\Explanation.md
# 🔧 Day 59 – Process Queries (DSU + Component Heaps)

## 🧩 Problem Summary

You have `c` cities (numbered 1..c) with initial connections (undirected). You must process queries of two types:
- Type 1: given a city u, return the smallest-index city in u's connected component that is currently online (not marked offline). If u itself is online return u. If none are online return -1.
- Type 2: mark a city u as offline (it remains offline for subsequent queries).

Connections are given before queries. City indices in inputs are 1-based.

This solution uses Disjoint Set Union (union-by-size) to build components, and for each component a min-heap (PriorityQueue) of its member city indices for retrieving the smallest online city. Offline cities are removed lazily from heaps during queries.

## 💡 Key Ideas

- Build DSU for `c` nodes and union all given connections.
- Maintain for each component a PriorityQueue of its member node indices (0-based in implementation).
- Maintain an `offline[]` boolean array.
- For a type-1 query on node u:
  - If u is currently online, return u.
  - Otherwise, find u's component parent, access its heap, pop offline nodes from the top until the top is online or heap is empty; return the top (or -1 if none).
- For a type-2 query mark the city offline. (Removal from heaps is lazy — done only when needed.)

## ⚙️ Implementation Notes

- Indices: input uses 1-based indices; implementation converts to 0-based.
- DSU:
  - `parent[]`, `size[]` arrays.
  - Union merges smaller into larger; when merging, transfer all elements from the smaller component's heap into the larger component's heap to keep PQs consistent.
- Heaps:
  - Each component keeps a `PriorityQueue<Integer>` with city indices so queries can obtain the minimum online index quickly.
  - Lazy deletion: offline cities remain in PQs until popped during a query.
- Complexity:
  - Building DSU: near O(c + connections · α(c)).
  - Each query: amortized O(log c) for heap operations; lazy removals cost overall proportional to number of offline marks.
  - Space: O(c) for DSU, heaps and offline array.

## ✅ Edge Cases

- Repeated offline marking of the same city — handled by boolean check.
- Queries asking about a city in a singleton component.
- If all cities in a component become offline, return -1 for type-1 queries to that component.

## 📌 Files

- See `Solution.java` in this folder for the implementation.
