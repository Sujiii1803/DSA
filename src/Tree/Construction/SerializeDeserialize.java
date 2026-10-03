package Tree.Construction;

import java.util.*;

class CodecSolution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        serializeHelper(root, sb);

        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");

        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");

        Queue<String> queue = new LinkedList<>();

        for (String value : values) {
            queue.offer(value);
        }

        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {

        String value = queue.poll();

        if (value.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(value));

        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);

        return root;
    }
}

public class SerializeDeserialize {

    public static void main(String[] args) {

        /*
                  1
                 / \
                2   3
                   / \
                  4   5

            Serialize:
            1,2,null,null,3,4,null,null,5,null,null,

            Deserialize:
            Reconstructs the same tree.
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        CodecSolution codec = new CodecSolution();

        // Serialize
        String data = codec.serialize(root);

        System.out.println("Serialized Tree: " + data);

        // Deserialize
        TreeNode newRoot = codec.deserialize(data);

        System.out.println(
                "Deserialized Root: " + newRoot.val
        );
    }
}