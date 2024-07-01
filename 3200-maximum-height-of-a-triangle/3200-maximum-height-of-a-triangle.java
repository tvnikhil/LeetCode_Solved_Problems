class Solution {
    public int maxHeight(int red, int blue, int currColor, int height) {
        if (red == 0 && blue == 0)
            return height - 1;
        if ((currColor == 0 && red < height) || (currColor == 1 && blue < height))
            return height - 1;
        if (currColor == 0 && red >= height)
            return maxHeight(red - height, blue, 1, height+1);
        if (currColor == 1 && blue >= height)
            return maxHeight(red, blue-height, 0, height+1);
        return height - 1;
    }
    public int maxHeightOfTriangle(int red, int blue) {
        int a = maxHeight(red, blue, 0, 0);
        int b = maxHeight(red, blue, 1, 0);
        return Math.max(a, b);
        // int tempRed = red, tempBlue = blue;
        // int blueFirstHeight = 0, i = 1;
        // while (true) {
        //     if (red == 0 && blue == 0)
        //         break;
        //     if (i % 2 != 0 && blue >= i) {
        //         blue -= i;
        //         blueFirstHeight++;
        //     }
        //     else if (i % 2 == 0 && red >= i) {
        //         red -= i;
        //         blueFirstHeight++;
        //     }
        //     else
        //         break;
        //     i += 1;
        // }
        // int redFirstHeight = 0;
        // i = 1;
        // red = tempRed;
        // blue = tempBlue;
        // while (true) {
        //     if (red == 0 && blue == 0)
        //         break;
        //     if (i % 2 != 0 && red >= i) {
        //         red -= i;
        //         redFirstHeight++;
        //     }
        //     else if (i % 2 == 0 && blue >= i) {
        //         blue -= i;
        //         redFirstHeight++;
        //     }
        //     else
        //         break;
        //     i += 1;
        // }
        // return Math.max(blueFirstHeight, redFirstHeight);
    }
}