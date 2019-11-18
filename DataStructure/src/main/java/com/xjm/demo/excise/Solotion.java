package com.xjm.demo.excise;

import java.util.Arrays;

public class Solotion {
    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串
     * 为We%20Are%20Happy
     *
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        int spacenum = 0;
        int oldlen = str.length();
        for (int i = 0; i < oldlen; i++) {
            if (str.charAt(i) == ' ') {
                spacenum++;
            }
        }
        int newlength = oldlen + spacenum * 2;
        str.setLength(newlength);
        newlength--;
        oldlen--;
        System.out.println(str.length());
        for (int i = newlength; i >= 0 && oldlen >= 0; i--, oldlen--) {
            if (str.charAt(oldlen) != ' ') {
                str.setCharAt(newlength--, str.charAt(oldlen));
            } else {
                str.setCharAt(newlength--, '0');
                str.setCharAt(newlength--, '2');
                str.setCharAt(newlength--, '%');
            }
        }
        return new String(str);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return node;
    }

    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     *
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * <p>
     * 保证base和exponent不同时为0
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        double n = base;
        if (base == 0) {
            return 0;
        } else if (exponent >= 0) {
            if (exponent == 0) {
                return 1;
            }
            if (exponent == 1) {
                return n;
            }
            for (int i = 2; i <= exponent; i++) {
                n *= base;
            }
        } else {
            if (exponent == -1) {
                return 1 / n;
            }
            for (int i = exponent + 1; i < 0; i++) {
                n *= base;
            }
            n = 1 / n;
        }
        return n;
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     *
     * @param array
     */
    public static void reOrderArray(int[] array) {
        int len = array.length;

        for (int i = 0; i < len; i++) {
            int j = i;
            int tem = array[i];
            while (j > 0 && array[j] % 2 == 1) {
                if (array[j - 1] % 2 == 0) {
                    array[j] = array[j - 1];
                    array[j - 1] = tem;
                }
                j--;
            }

        }
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        ListNode node1 = head;
        int count = 0;
        for (; node != null; node = node.next) {
            count++;
        }
        if (count < k) {
            return null;
        }
        int x = count - k;
        for (int i = 0; i < x; i++) {
//          System.out.println(node1.val);
            node1 = node1.next;
        }
//      System.out.println(node1.val);
        return node1;

    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点
     * 递归写法
     *
     * @param head
     * @param k
     * @return
     */
    private static int count;

    public static ListNode FindKthToTail1(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode node = FindKthToTail1(head.next, k);
        count++;
        if (count == k) {
            return head;
        }
        return node;
    }

    /**
     * 输入一个链表，反转链表后，输出新链表的表头
     *
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，
     * 当然我们需要合成后的链表满足单调不减规则。
     */

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        ListNode next = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (head == null) {
                    head = next = list1;
                } else {
                    next.next = list1;
                    next = list1;
                }
                list1 = list1.next;
            } else {
                if (head == null) {
                    head = next = list2;
                } else {
                    next.next = list2;
                    next = list2;
                }
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            next.next = list2;
        } else {
            next.next = list1;
        }
        return head;
    }

    /**
     * 递归实现 输入两个单调递增的链表，输出两个链表合成后的链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = Merge1(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge1(list1, list2.next);
            return list2;
        }
    }

    public static int Fin(int n) {
        if (n < 1) {
            System.out.println("返回咯");
            return 1;
        }
        System.out.println("n=" + n + "     n-1:" + (n - 1));
        int z = n * Fin(n - 1);
        System.out.println("f" + n + "=" + z);
        return z;
    }

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
       if(root1==null||root2==null){
           return false;
       }

        boolean flag = false;
        if (root1.val == root2.val) {
            flag = isLike(root1, root2);
        }
       if(!flag){
           flag=HasSubtree(root1.left,root2);
       }
       if(!flag){
           flag=HasSubtree(root1.right,root2);
       }
       return flag;
    }
    public boolean isLike(TreeNode root1, TreeNode root2){
        if (root1==null&&root2!=null){
            return false;
        }
        if (root2==null){
            return true;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return isLike(root1.left,root2.left)&&isLike(root1.right,root2.right);
    }

    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     * @param root
     */
    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode treeNode=root.left;
        root.left=root.right;
        root.right=treeNode;
        Mirror(root.left);
        Mirror(root.right);

    }

    public static void main(String[] args) {



    }
}
