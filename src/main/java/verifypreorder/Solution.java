package verifypreorder;


public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return verify(preorder, 0, preorder.length - 1);
    }

    boolean verify(int [] preorder, int start, int end) {
        if(start >= end)
            return true;

        int root = preorder[start];
        int rightIndex = start + 1;
        while(rightIndex <= end && preorder[rightIndex] < root)
            rightIndex++;

        // no right branch, check left only
        if(rightIndex > end)
            return verify(preorder, start + 1, rightIndex - 1);

        if(!verify(preorder, start + 1, rightIndex - 1))
            return false;

        for(int i = rightIndex; i <= end; i++)
            if(preorder[i] < root)
                return false;

        return verify(preorder, rightIndex, end);
    }
}