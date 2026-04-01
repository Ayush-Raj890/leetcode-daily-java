# 🗒️ Day 71 – Count Mentions

## Summary
Processes timestamped chat events and returns an array of mention counts per user. Events are strings with three tokens: an event type ("OFFLINE" or "MESSAGE"), a timestamp, and a payload (user id for OFFLINE, mention tokens for MESSAGE). Mentions can be:
- "ALL" — everyone
- "HERE" — users currently online
- "idX" — specific user X (0-based)

## Key behavior of the implementation
1. Group events by integer timestamp using a sorted map so timestamps are handled in increasing order.
2. Maintain:
   - int[] mentions — result counters per user.
   - boolean[] isOnline — current online status (initialized to true).
   - int[] offlineUntil — timestamp until which a user is offline (set to t+60 on OFFLINE).
3. At each timestamp t:
   - Revive users whose offlineUntil <= t by setting isOnline = true.
   - Apply OFFLINE events at t: set isOnline[id] = false and offlineUntil[id] = t + 60.
   - Process MESSAGE events at t: parse mention tokens and increment mentions accordingly:
     - "ALL": increment all users.
     - "HERE": increment only users with isOnline == true.
     - "idX": increment user X if 0 <= X < numberOfUsers.
4. Return mentions after processing all events.

## Complexity
- Let U = numberOfUsers, E = number of events, T = distinct timestamps.
- Time: O(E log T) to group events + O(T * U) worst-case for revivals / "ALL"/"HERE" processing. Worst-case can be heavy if U and T are large.
- Space: O(U + E).

## Edge cases and assumptions
- Users are assumed 0-based in [0, numberOfUsers-1]; id bounds are checked before increment.
- Users start as online (isOnline initialized true).
- OFFLINE keeps a user offline for exactly 60 units: offlineUntil = t + 60.
- Events are expected well-formed; parsing uses Integer.parseInt on tokens.

## Possible improvements
- Use a min-heap (priority queue) keyed by offlineUntil to revive only expired users instead of scanning all users each timestamp.
- Avoid O(U) work for "ALL" / "HERE" by maintaining counters or lazy increments if MESSAGE volume is high.
- Validate and sanitize event formats before parsing in untrusted-input contexts.

## Example (conceptual)
numberOfUsers = 3  
events = [
  ["OFFLINE","10","1"],
  ["MESSAGE","15","HERE id0 id2"],
  ["MESSAGE","70","ALL"]
]  
- At t=10 user1 goes offline until 70.  
- At t=15 "HERE id0 id2": "HERE" counts online users (0 and 2), id0 and id2 counted again if present.  
- At t=70 revive user1 then "ALL" increments all users.
```// filepath: c:\Users\ayush\leetcode-