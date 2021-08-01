import java.util.Arrays;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        int length = s.length();
        String newS = "";

        String[][] mat = new String[numRows][length];
        int nextString = 0;

        if (numRows == 1) {
            return s;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < numRows; j++) {
                if (nextString < length) {
                    String c = "" + s.charAt(nextString);
                    if (i % (numRows - 1) == 0) {
                        mat[j][i] = c;
                        nextString += 1;
                    } else if ((numRows - 1 - j) == (i % (numRows - 1))) {
                        mat[j][i] = c;
                        nextString += 1;
                    } else {
                        mat[j][i] = null;
                    }
                }
            }
        }

        nextString = 0;
        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i < length; i++) {
                if (nextString < length) {
                    if (mat[j][i] != null) {
                        newS = newS.concat(mat[j][i]);
                        nextString += 1;
                    }
                }
            }
        }
        return newS;
    }

    public static void printArray(String[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
