# 🏦 Day 48 – Simple Bank System

## 🧩 Problem Statement

Design a **simple bank system** that supports the following operations:

1. **Transfer**: Transfer money from one account to another.
2. **Deposit**: Deposit money into an account.
3. **Withdraw**: Withdraw money from an account.

Each account is represented by its balance, and all operations must validate account numbers and sufficient funds.

**LeetCode Problem**: [2043. Simple Bank System](https://leetcode.com/problems/simple-bank-system/)

---

## 💡 Examples

### Example 1:

**Input:**
```
["Bank", "withdraw", "transfer", "deposit", "transfer", "withdraw"]
[[[10, 100, 20, 50, 30]], [3, 10], [5, 1, 20], [5, 20], [3, 4, 15], [10, 50]]
```

**Output:**
```
[null, true, true, true, false, false]
```

**Explanation:**
- `Bank(...)`: Initialize with balances [10, 100, 20, 50, 30]
- `withdraw(3, 10)`: Account 3 has 20, withdraw 10 → balance becomes 10 → **true**
- `transfer(5, 1, 20)`: Account 5 has 30, transfer 20 to account 1 → **true**
- `deposit(5, 20)`: Deposit 20 to account 5 → **true**
- `transfer(3, 4, 15)`: Account 3 has 10, cannot transfer 15 → **false**
- `withdraw(10, 50)`: Account 10 doesn't exist → **false**

---

## 🧠 Approach

This solution uses a **simple array-based implementation** with validation:

1. **Data Structure:**
   - Store account balances in a `long[]` array.
   - Keep track of the number of accounts `n`.

2. **Operations:**

   **Transfer:**
   - Validate both accounts exist.
   - Check if the source account has sufficient funds.
   - Deduct from source and add to destination.

   **Deposit:**
   - Validate the account exists.
   - Add the amount to the account balance.

   **Withdraw:**
   - Validate the account exists.
   - Check if the account has sufficient funds.
   - Deduct the amount from the account balance.

3. **Validation Helper:**
   - `valid(acc)`: Checks if account number is between 1 and n (inclusive).
   - Accounts are 1-indexed in the problem but stored 0-indexed in the array.

---

## 📊 Implementation Details

**Key Points:**
- All account numbers are 1-indexed (user-facing) but stored 0-indexed internally.
- Use `long` to handle large balances.
- Return `false` for any invalid operation (invalid account or insufficient funds).

---

## ⏱️ Complexity

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Transfer  | O(1)           | O(1)             |
| Deposit   | O(1)           | O(1)             |
| Withdraw  | O(1)           | O(1)             |
| Constructor | O(n)         | O(n)             |

---

## ✅ Code Reference

See `Solution.java` for the implementation.

---

## 🎯 Key Insights

- **Validation is crucial**: Always check account existence and sufficient funds before operations.
- **1-indexed to 0-indexed conversion**: Account numbers need to be adjusted (`acc - 1`).
- **Immutable `n`**: The number of accounts is fixed at initialization.
- **Clean design**: Each method has a single responsibility.

---

## 📝 Notes

- The system doesn't support creating new accounts after initialization.
- All balances are non-negative.
- Invalid operations return `false` without modifying state.
- The solution is straightforward and efficient with O(1) operations.

---

## 🔄 Method Summary

| Method | Parameters | Returns | Description |
|--------|-----------|---------|-------------|
| `Bank()` | `long[] balance` | - | Initialize bank with account balances |
| `transfer()` | `int account1, int account2, long money` | `boolean` | Transfer money between accounts |
| `deposit()` | `int account, long money` | `boolean` | Deposit money to account |
| `withdraw()` | `int account, long money` | `boolean` | Withdraw money from account |

---