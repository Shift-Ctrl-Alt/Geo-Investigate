package com.oymn.geoinvestigate.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.oymn.geoinvestigate.dao.pojo.LandType;
import com.oymn.geoinvestigate.vo.LandTypeVo;
import org.junit.jupiter.api.Test;

import javax.xml.soap.Node;
import java.awt.font.NumericShaper;
import java.beans.Visibility;
import java.util.*;

public class ProjectTest {

    @Test
    public void test01() {
        LandTypeVo landTypeVo = new LandTypeVo(1L, "aa", "aa");
        List<LandType> landTypeList = new ArrayList<>();
        landTypeList.add(new LandType(1L, "aa", "bb", 10L, new Date(), new Date()));
        landTypeList.add(new LandType(2L, "aa", "bb", 10L, new Date(), new Date()));
        landTypeVo.setSubLandType(landTypeList);

        LandTypeVo landTypeVo2 = new LandTypeVo(2L, "aa", "aa");
        landTypeVo2.setSubLandType(landTypeList);

        List<LandTypeVo> landTypeVoList = new ArrayList<>();
        landTypeVoList.add(landTypeVo);
        landTypeVoList.add(landTypeVo2);

        String json = JSONObject.toJSONString(landTypeVoList);
        System.out.println(json);
        List<LandTypeVo> newLandTypeVoList = JSONObject.parseArray(json, LandTypeVo.class);
        System.out.println(newLandTypeVoList);
    }

    @Test
    public int findRepeatNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return 0;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }

        int[] result = new int[count];
        p = head;
        for (int i = count - 1; i >= 0; i--) {
            result[i] = p.val;
            p = p.next;
        }

        return result;
    }

    public ListNode reverseList(ListNode head) {

        return null;
    }

    @Test
    public void testLadderLength() {
        ArrayList<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        int res = ladderLength("hit", "cog", wordList);
        if (res == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(res);
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int size = wordList.size();
        int[][] wordGraph = new int[size + 1][size + 1];

        //绘制图
        for (int i = 0; i < size + 1; i++) {
            if (i == 0) wordGraph[0][0] = Integer.MAX_VALUE;
            else if (isDifferentOne(beginWord, wordList.get(i - 1))) {
                wordGraph[0][i] = 1;
                wordGraph[i][0] = 1;
            } else {
                wordGraph[0][i] = Integer.MAX_VALUE;
                wordGraph[i][0] = Integer.MAX_VALUE;
            }
            ;
        }


        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < size + 1; j++) {
                if (i == j) wordGraph[i][j] = Integer.MAX_VALUE;
                else {
                    if (isDifferentOne(wordList.get(i - 1), wordList.get(j - 1))) {
                        wordGraph[i][j] = 1;
                    } else {
                        wordGraph[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        Integer minCount = Integer.MAX_VALUE;
        int[] visited = new int[size + 1];
        visited[0] = 1;
        dfs(wordGraph, 0, size + 1, 0, minCount, visited, new HashMap<>());

        return minCount;
    }

    private int dfs(int[][] wordGraph, int vertex, int size, int count, Integer minCount, int[] visited, Map<Integer, Integer> map) {

        //已经存在更短的路径了
        if (count + 1 >= minCount) {
            return Integer.MAX_VALUE;
        }

        //已经到达终点
        if (vertex == size - 1) {
            if (count + 1 < minCount) minCount = count + 1;
            return count + 1;
        }

        //剪枝
        //if(map.get(vertex) != null){
        //    Integer len = map.get(vertex);
        //    if(count + len < minCount)minCount = count + len;
        //    return len;
        //}

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (visited[i] == 1 || wordGraph[vertex][i] != 1) {
                continue;
            }

            visited[i] = 1;
            min = Integer.min(min, dfs(wordGraph, i, size, count + 1, minCount, visited, map) - count + 1);
            visited[i] = 0;
        }

        //map.put(vertex, min);

        return min;
    }

    private boolean isDifferentOne(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }

    //剑指30
    class MinStack {

        class Node {
            int val;
            int min;
        }

        private LinkedList<Node> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList<>();
        }

        public void push(int x) {
            Node node = new Node();
            node.val = x;
            if (stack.isEmpty()) {
                node.min = x;
            } else {
                int min = stack.peek().min;
                node.min = x < min ? x : min;
            }
            stack.push(node);
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            Node peek = stack.peek();
            return peek.val;
        }

        public int min() {
            Node peek = stack.peek();
            return peek.min;
        }
    }

    //剑指24
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode p = head.next;
            head.next = null;
            while (p != null) {
                ListNode q = p.next;
                p.next = head;
                head = p;
                p = q;
            }

            return head;

        }
    }

    //剑指35
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution2 {
        public Node copyRandomList(Node head) {
            Node p = head;

            //复制新结点
            while (p != null) {
                Node newNode = new Node(p.val);
                newNode.next = p.next;
                p.next = newNode;
                p = p.next.next;
            }

            p = head;
            //赋值random
            while (p != null) {
                Node newNode = p.next;
                if (p.random == null) {
                    newNode.random = null;
                } else {
                    newNode.random = p.random.next;
                }
                p = p.next.next;
            }

            Node newHead = new Node(0);  //新链表的头
            Node q = newHead;
            //分离两个链表
            p = head;
            while(p != null){
                Node newNode = p.next;
                q.next = newNode;
                q = newNode;
                p.next = newNode.next;
                p = p.next;
            }

            return newHead.next;
        }
    }

    //剑指05
    class Solution3 {
        public String replaceSpace(String s) {
            return s.replaceAll(" ", "%20");
        }
    }

    //剑指58
    class Solution4 {
        public String reverseLeftWords(String s, int n) {
            String sub1 = s.substring(0, n);
            String sub2 = s.substring(n);

            StringBuilder sb = new StringBuilder();
            sb.append(sub2);
            sb.append(sub1);

            return sb.toString();
        }
    }

    @Test
    public void testSolution4() {
        String s = "abcdef";
        String sub1 = s.substring(0, 1);
        String sub2 = s.substring(2);

        System.out.println(sub1);
        System.out.println(sub2);
    }

    //剑指03
    class Solution5 {
        public int findRepeatNumber(int[] nums) {

            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)) {
                    return num;
                }
                set.add(num);
            }

            return 0;
        }
    }

    //剑指53
    class Solution6 {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            int count = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    for (int i = mid - 1; i >= left; i--) {
                        if (nums[i] == target) count++;
                        else break;
                    }
                    for (int i = mid; i <= right; i++) {
                        if (nums[i] == target) count++;
                        else break;
                    }
                    break;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return count;
        }
    }

    //剑指53-II
    class Solution7 {
        public int missingNumber(int[] nums) {
            int left = 0, right = nums.length - 1;

            if (nums.length == 1) {
                if (nums[0] == 0) return 1;
                else if (nums[0] == 1) return 0;
            }

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > mid) {
                    right = mid;
                } else if (nums[mid] == mid) {
                    left = mid + 1;
                }
            }

            return left;
        }
    }

    @Test
    public void testSolution8() {
        Solution8 solution8 = new Solution8();
        int[][] nums = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(solution8.findNumberIn2DArray(nums, 5));
    }

    //剑指04 
    class Solution8 {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int left = 0, right = matrix[0].length - 1;
            int top = 0, bottom = matrix.length - 1;

            return findNum(matrix, left, right, top, bottom, target);
        }

        public boolean findNum(int[][] matrix, int left, int right, int top, int bottom, int target) {

            if (left > right || top > bottom) return false;
            if (left == right - 1 && top == bottom) return matrix[left][top] == target || matrix[right][top] == target;
            if (top == bottom - 1 && left == right)
                return matrix[left][top] == target || matrix[left][bottom] == target;

            int hMid = left + (right - left) / 2;
            int vMid = top + (bottom - top) / 2;

            if (matrix[vMid][hMid] == target) {
                return true;
            } else if (matrix[vMid][hMid] < target) {
                return findNum(matrix, hMid + 1, right, top, bottom, target)
                        || findNum(matrix, left, right, vMid + 1, bottom, target);
            } else {
                return findNum(matrix, left, hMid, top, bottom, target);
            }
        }
    }

    //剑指11
    class Solution9 {
        public int minArray(int[] numbers) {
            int left = 0, right = numbers.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] > numbers[right]) {
                    left = mid + 1;
                } else if (numbers[mid] < numbers[left]) {
                    right = mid;
                }
            }

            return numbers[left];
        }
    }

    //剑指07
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution10 {
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int pBegin, int pEnd, int[] inorder, int iBegin, int iEnd) {
            if (pBegin > pEnd || iBegin > iEnd) return null;

            int rootVal = preorder[pBegin];

            int rootIndex = 0;
            for (int i = iBegin; i <= iEnd; i++) {
                if (inorder[i] == rootVal) {
                    rootIndex = i;
                    break;
                }
            }

            TreeNode root = new TreeNode(rootVal);
            root.left = buildTree(preorder, pBegin + 1, pBegin + (rootIndex - iBegin), inorder, iBegin + 1, rootIndex - 1);
            root.right = buildTree(preorder, pBegin + (rootIndex - iBegin) + 1, pEnd, inorder, rootIndex + 1, iEnd);
            return root;
        }
    }

    @Test
    public void testSolution10() {
        new Solution10().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

}
