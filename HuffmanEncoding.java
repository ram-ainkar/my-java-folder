
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node {

    char ch;
    int freq;
    Node left, right;

    Node(char c, int f) {
        ch = c;
        freq = f;
    }
}

public class HuffmanEncoding {

    static void print(Node root, String code) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
        }
        print(root.left, code + "0");
        print(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of characters: ");
        int n = sc.nextInt();
        char[] ch = new char[n];
        int[] f = new int[n];

        System.out.println("Enter character and frequency:");
        for (int i = 0; i < n; i++) {
            ch[i] = sc.next().charAt(0);
            f[i] = sc.nextInt();
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        for (int i = 0; i < n; i++) {
            pq.add(new Node(ch[i], f[i]));
        }

        while (pq.size() > 1) {
            Node l = pq.poll(), r = pq.poll();
            Node p = new Node('-', l.freq + r.freq);
            p.left = l;
            p.right = r;
            pq.add(p);
        }

        System.out.println("\nHuffman Codes:");
        print(pq.peek(), "");
    }
}
