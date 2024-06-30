class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        int tempRed = red, tempBlue = blue;
        int blueFirstHeight = 0, i = 1;
        while (true) {
            if (red == 0 && blue == 0)
                break;
            if (i % 2 != 0 && blue >= i) {
                blue -= i;
                blueFirstHeight++;
            }
            else if (i % 2 == 0 && red >= i) {
                red -= i;
                blueFirstHeight++;
            }
            else
                break;
            i += 1;
        }
        int redFirstHeight = 0;
        i = 1;
        red = tempRed;
        blue = tempBlue;
        while (true) {
            if (red == 0 && blue == 0)
                break;
            if (i % 2 != 0 && red >= i) {
                red -= i;
                redFirstHeight++;
            }
            else if (i % 2 == 0 && blue >= i) {
                blue -= i;
                redFirstHeight++;
            }
            else
                break;
            i += 1;
        }
        return Math.max(blueFirstHeight, redFirstHeight);
    }
}