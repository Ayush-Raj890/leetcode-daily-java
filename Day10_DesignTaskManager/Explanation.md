# Day 10 – LeetCode 3408: Design Task Manager

---

## Problem Statement

You need to design a Task Manager that supports the following operations efficiently:

1. **Initialization**: Given a list of tasks, each represented as `(userId, taskId, priority)`.
2. **add(userId, taskId, priority)**: Add a new task if it doesn’t already exist.
3. **edit(taskId, newPriority)**: Update the priority of an existing task.
4. **rmv(taskId)**: Remove a task by marking it as deleted.
5. **execTop()**: Execute the task with the highest priority and return its userId.  
   - If multiple tasks share the same priority, the one with the smallest taskId should be executed first.  
   - If no tasks remain, return `-1`.

---

## Example

**Input**
tasks = [[1, 101, 5], [2, 102, 7], [3, 103, 5]]
TaskManager manager = new TaskManager(tasks);

manager.add(4, 104, 10); // adds new task
manager.edit(101, 8); // updates priority of task 101
manager.rmv(102); // removes task 102
manager.execTop(); // executes the highest priority task


**Output**
4 // userId of executed task

---

## Approach

We need efficient **insert**, **update**, **remove**, and **get-max** operations.  
A **PriorityQueue (Max-Heap)** is a natural fit here, but since Java’s `PriorityQueue` is min-heap by default, we invert the comparator.

### Data Structures Used
1. **`int[] priorities`** → stores the current priority of each `taskId`.
2. **`int[] userIds`** → maps each `taskId` to its corresponding `userId`.
3. **`PriorityQueue<Long> PQ`** → stores tasks encoded as `(priority * 100001 + taskId)` for easy sorting:
   - Higher priority first.
   - If equal priority, smaller taskId first.

### Key Operations
1. **Initialization**  
   Add all initial tasks into both arrays and the priority queue.

2. **Add a Task**  
   - Only insert if taskId is not already present (`priority == 0`).
   - Store `(priority, userId)` and push to PQ.

3. **Edit a Task**  
   - Update the task’s priority.
   - Push the new priority-task pair into PQ.

   > Note: We allow duplicates in PQ and filter them out during `execTop`.

4. **Remove a Task**  
   - Simply mark its priority as `-1`.
   - Lazy deletion: The task stays in PQ but will be skipped during execution.

5. **Execute Top Task**  
   - Poll the PQ until you find a valid entry (priority matches the current one in the `priorities` array).
   - Mark it as removed (`priority = -1`).
   - Return the associated `userId`.

---

## Complexity Analysis

- **Add/Edit**: `O(log n)` due to heap insertion.  
- **Remove**: `O(1)` (lazy deletion).  
- **ExecTop**: Amortized `O(log n)` since invalid tasks may be skipped.  
- **Space Complexity**: `O(n)` for arrays and priority queue.

---

## Why This Approach?

- **Lazy Deletion** avoids the costly operation of removing arbitrary elements from the heap.  
- Encoding `(priority, taskId)` into a single `long` ensures correct ordering with a custom comparator.  
- Arrays (`priorities`, `userIds`) give **O(1)** access for updates and lookups.  
- This design balances efficiency across all operations.

---
