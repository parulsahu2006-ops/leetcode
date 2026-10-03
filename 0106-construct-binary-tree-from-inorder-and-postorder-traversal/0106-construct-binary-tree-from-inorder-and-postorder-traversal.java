class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length - 1,
                     0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder,
                           int inStart, int inEnd,
                           int postStart, int postEnd) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // Last element of postorder is the root
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int rootIndex = inStart;
        while (inorder[rootIndex] != rootValue) {
            rootIndex++;
        }

        // Number of nodes in left subtree
        int leftSize = rootIndex - inStart;

        // Build left subtree
        root.left = build(inorder, postorder,
                          inStart, rootIndex - 1,
                          postStart, postStart + leftSize - 1);

        // Build right subtree
        root.right = build(inorder, postorder,
                           rootIndex + 1, inEnd,
                           postStart + leftSize, postEnd - 1);

        return root;
    }
}