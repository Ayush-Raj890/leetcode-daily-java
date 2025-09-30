package Day11_Design_Spreadsheet;

import java.util.*;

class Spreadsheet {
    private Map<String, Integer> cells;

    public Spreadsheet(int rows) {
        // rows are not really needed except for constraints
        cells = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }

    public void resetCell(String cell) {
        cells.remove(cell); // treat reset as deleting entry
    }

    public int getValue(String formula) {
        // formula looks like "=X+Y"
        formula = formula.substring(1); // remove '='
        String[] parts = formula.split("\\+");
        int sum = 0;
        for (String part : parts) {
            sum += getPartValue(part);
        }
        return sum;
    }

    private int getPartValue(String part) {
        // if it's a number
        if (Character.isDigit(part.charAt(0))) {
            return Integer.parseInt(part);
        }
        // else it's a cell reference
        return cells.getOrDefault(part, 0);
    }
}
