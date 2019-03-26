package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null) return null;
        List<List<Integer>> paths = new ArrayList<>();
        walk(root, paths, sum);
        return paths;
    }


    /**
     * @param root
     * @param paths 保存所有加和为sum的path
     * @param sum
     */
    public void walk(TreeNode root, List<List<Integer>> paths, int sum) {

        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> path = new ArrayList<>();
                path.add(root.val);
                paths.add(path);
            }
        } else {
            int remain = sum - root.val;
            if (root.left != null) walk(root.left, paths, remain);
            if (root.right != null) walk(root.right, paths, remain);

            for (List<Integer> path : paths) {
                path.add(0, root.val);
            }

        }
    }

}
