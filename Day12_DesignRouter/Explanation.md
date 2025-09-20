# Day 12 – Design Router

**Problem Link:** [LeetCode 3412: Design Router](https://leetcode.com/problems/design-router/)  

---

## Problem Statement
You need to design a **Router** that stores network packets with the following constraints:

1. **Initialization:** `Router(int memoryLimit)` – max number of packets that can be stored.
2. **addPacket(source, destination, timestamp)`** – adds a new packet if not already present.  
   - Returns `true` if added successfully, `false` if duplicate.
   - If memory limit exceeded, the **oldest packet** is forwarded (removed).
3. **forwardPacket()`** – forwards the oldest packet and returns it.  
   - Returns empty array if no packets.
4. **getCount(destination, startTime, endTime)`** – returns number of packets sent to the given `destination` in the given time interval `[startTime, endTime]`.

---

## Approach

### Data Structures
1. `Map<Long, int[]> packets` → Stores packet info keyed by encoded `(source, destination, timestamp)`.
2. `Queue<Long> queue` → Maintains order of packets for forwarding (FIFO).
3. `Map<Integer, List<Integer>> counts` → Maps destination to list of timestamps for counting packets.
4. `int size` → Memory limit of the router.

### Key Ideas
- Encode each packet into a single `long` key for unique identification:  
  `key = (source << 40) | (destination << 20) | timestamp`
- **Adding a packet:**  
  - If duplicate → ignore.  
  - If memory full → forward oldest packet.  
  - Store packet and update timestamp list for the destination.
- **Forwarding packet:**  
  - Poll the queue → remove from `packets` map → remove timestamp from `counts`.
- **Count query:**  
  - Binary search (`lowerBound` and `upperBound`) on the timestamp list to efficiently get the number of packets in `[startTime, endTime]`.

---

## Dry Run

**Input:**  
Router router = new Router(2);
router.addPacket(1, 100, 5); // true
router.addPacket(2, 100, 6); // true
router.addPacket(3, 101, 7); // memory full → forward oldest packet (1,100,5)
router.getCount(100, 0, 10); // returns 1 (only packet 2,100,6 remains)

**Output:**  
addPacket → true, true, true (oldest forwarded)
getCount → 1

---

## Time & Space Complexity

- **Add/Edit/Forward:** O(1) average for hash map and queue operations.  
- **getCount:** O(log N) using binary search on timestamp list.  
- **Space Complexity:** O(N) where N is max number of packets stored.

---

## Significance

- Demonstrates **FIFO queue handling** with memory constraints.  
- Uses **hash map + queue + binary search** combination for efficient query and update.  
- Teaches **packet encoding** for uniqueness and ordering in networking problems.
