# 1914. Cyclically Rotating a Grid

Approach summary:

- Extract each ring (layer) of the grid in counterclockwise order starting at the top-left of the layer.
- Collect positions and values for the layer into lists.
- Compute the effective rotation `kk = k % total` and write values back shifted by `kk`.

This matches the repository convention: `Solution.java` contains the implementation and `Explanation.md` contains the notes.
