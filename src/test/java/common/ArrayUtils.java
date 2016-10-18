package common;

public class ArrayUtils {

    public static int [][] toIntArray(String str) {
        str = str.substring(2, str.length() - 2);
        String [] strs = str.split("\\],\\[");
        int [][] array = new int[strs.length][];
        for(int i = 0; i < strs.length; i++) {
            String s = strs[i];
            String [] ss = s.split(",");
            array[i] = new int[ss.length];
            for(int j = 0; j < ss.length; j++) {
                array[i][j] = Integer.valueOf(ss[j]);
            }
        }
        return array;
    }

    public static double [][] toDoubleArray(String str) {
        str = str.substring(2, str.length() - 2);
        String [] strs = str.split("\\],\\[");
        double [][] array = new double[strs.length][];
        for(int i = 0; i < strs.length; i++) {
            String s = strs[i];
            String [] ss = s.split(",");
            array[i] = new double[ss.length];
            for(int j = 0; j < ss.length; j++) {
                array[i][j] = Double.valueOf(ss[j]);
            }
        }
        return array;
    }
}
