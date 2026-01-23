
public class GFG {

// Binary tree node consists of data, a
// pointer to the left child and a
// pointer to the right child
    static class node {

        int data;
        node left;
        node right;
    };

// Function to create new Binary Tree node
    static node newNode(int data) {
        node temp = new node();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    ;

// Function to return the sum of all
// the nodes at Kth level using
// level order traversal
static int sumOfNodesAtNthLevel(node root,
            int k) {

        // If the current node is null
        if (root == null) {
            return 0;
        }

        // Create Queue
        Queue<node> queue = new LinkedList<>();

        // Enqueue the root node
        que.add(root);

        // Level is used to track
        // the current level
        int level = 0;

        // To store the sum of nodes
        // at the Kth level
        int sum = 0;

        // flag is used to break out of
        // the loop after the sum of all
        // the nodes at Nth level is found
        int flag = 0;

        // Iterate the queue till its not empty
        while (!que.isEmpty()) {

            // Calculate the number of nodes
            // in the current level
            int size = que.size();

            // Process each node of the current
            // level and enqueue their left
            // and right child to the queue
            while (size-- > 0) {
                node ptr = que.peek();
                que.remove();

                // If the current level matches the
                // required level then calculate the
                // sum of all the nodes at that level
                if (level == k) {

                    // Flag initialized to 1
                    // indicates that sum of the
                    // required level is calculated
                    flag = 1;

                    // Calculating the sum of the nodes
                    sum += ptr.data;
                } else {

                    // Traverse to the left child
                    if (ptr.left != null) {
                        que.add(ptr.left);
                    }

                    // Traverse to the right child
                    if (ptr.right != null) {
                        que.add(ptr.right);
                    }
                }
            }

            // Increment the variable level
            // by 1 for each level
            level++;

            // Break out from the loop after the sum
            // of nodes at K level is found
            if (flag == 1) {
                break;
            }
        }
        return sum;
    }

// Driver code
    public static void main(String[] args) {
        node root = new node();

        // Tree Construction
        root = newNode(50);
        root.left = newNode(30);
        root.right = newNode(70);
        root.left.left = newNode(20);
        root.left.right = newNode(40);
        root.right.left = newNode(60);
        int level = 2;
        int result = sumOfNodesAtNthLevel(root, level);

        // Printing the result
        System.out.print(result);
    }
}

// This code is contributed by 29AjayKumar
