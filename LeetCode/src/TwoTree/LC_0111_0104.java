package TwoTree;

import java.util.Collections;
import java.util.List;

public class LC_0111 {
    public static void main(String[] args) {
        List<TreeNode> nodeList = null;
        int[] nums = {1,2};
        CreateTree ct = new CreateTree();
        nodeList = ct.CreateTreeBin(nums);

        TreeNode nodes = nodeList.get(0);
        Colution co = new Colution();
        System.out.println(co.minDepth(nodes));
    }
}
/**
 * 最小深度
 */
class Colution {
    public int minDepth(TreeNode root) {
       if(root == null){
           return 0;
       }
       int depth = 0;
       if(root.leftChild == null){
           depth = minDepth(root.rightChild);
       }else if(root.rightChild == null){
           depth = minDepth(root.leftChild);
       }else {
           depth = Math.min(minDepth(root.leftChild), minDepth(root.rightChild));
       }
       return depth + 1;
    }
}
/**
 * 最大深度
 */

