class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonalSquare = 0;
        int maxArea = 0;

        for (int[] dim : dimensions) {
            int length = dim[0];
            int width = dim[1];
            
            int currentDiagonalSquare = length * length + width * width;
            int currentArea = length * width;

            if (currentDiagonalSquare > maxDiagonalSquare) {
                maxDiagonalSquare = currentDiagonalSquare;
                maxArea = currentArea;
            } else if (currentDiagonalSquare == maxDiagonalSquare) {
                if (currentArea > maxArea) {
                    maxArea = currentArea;
                }
            }
        }

        return maxArea;
    }
}