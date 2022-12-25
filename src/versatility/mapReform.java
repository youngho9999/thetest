package versatility;

import java.util.Arrays;

public class mapReform {

    public int[][] mapReform(int[][] map) {
        int[][] newMap = new int[map.length+2][map[0].length+2];
        for(int[] temp : newMap) {
            Arrays.fill(temp,0);
        }
        for(int i = 1; i < newMap.length-1; i++) {
            for(int j = 1; j < newMap[0].length-1; j++) {
                newMap[i][j] = map[i-1][j-1];
            }
        }
        return newMap;
    }
}
