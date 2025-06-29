import com.sun.source.tree.Tree;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;
class LinkedListNode {
    public int data;
    public LinkedListNode next;

    LinkedListNode(LinkedListNode next,int data)
    {
        this.next = next;
        this.data = data;
    }
    LinkedListNode(int head)
    {
        this.data = head;
        this.next= null;
    }
    public static void showAllLinkedListNodes(LinkedListNode LinkedListNode)
    {
        while(LinkedListNode != null)
        {
            System.out.println(LinkedListNode.data);
            LinkedListNode = LinkedListNode.next;
        }
    }
}

class TreeNode{
    int data;
    TreeNode left ;
    TreeNode right;
    TreeNode(int data)
    {
        this.data=data;
        this.left = null;
        this.right = null;
    }
}
public class Main {
    public static void two_sum()
    {
        int [] v= {2,4,5,8,11};
        int target = 15;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int n = v.length;
        for(int i=0 ;i<n;i++)
        {
            int num = v[i];
            int moreneeded = target - num;
            if (mpp.containsKey(moreneeded))
            {
                System.out.println("contains");
            }
            mpp.put(v[i],i);
        }
    }
    public static void stock()
    {
        int[] v  ={7,1,5,3,6,4};
        int cur = v[0];
        int profit = 0;
        for(int i=1 ;i<v.length ; i++)
        {
            if (cur < v[i])
            {
                profit = Math.max((v[i] - cur),profit);
            }
            else {
                cur = v[i];
            }
        }
        System.out.println(profit);

    }
    public static void product_except_itself()
    {
        int [] v = {1, 2, 3, 4,5};
        int [] ans = new int[v.length];
        int left = 1 ;
        ans[0] = 1;
        for(int i= 1 ;i < v.length ; i++)
        {
            left = left * v[i-1];
            ans[i]= left;
        }
        int right = 1;
        for(int i = v.length -2 ; i >=0 ; i--)
        {
            right = right * v[i+1];
            ans[i] = right * ans[i];
        }
        for(Integer a : ans)
        {
            System.out.println(a);
        }
    }
    public static void kadane_algo()
    {
        int [] v = {-2};
        int max_so_far = v[0];
        int curmax = v[0];

        for (int i = 1; i < v.length; i++) {
            curmax = Math.max(v[i], curmax + v[i]);
            max_so_far = Math.max(max_so_far, curmax);
        }
        System.out.println(max_so_far);
    }
    public static void max_product()
    {
        int [] v = {1,2,-3,0,-4,-5};
//        int result = v[0];
//        for(int i= 0 ;i<v.length-1;i++)
//        {
//            int p = v[i];
//            for(int j = i+1;j<v.length;j++)
//            {
//                result = Math.max(result,p);
//                p = p*v[j];
//            }
//            result = Math.max(result,p);
//        }
//        System.out.println(result);
        //2,3,-2,4
        int suffix =1 ;
        int prefix = 1;
        int ans = Integer.MIN_VALUE;
        for(int i= 0;i<v.length;i++)
        {
            if(suffix == 0)
                suffix = 1;
            if(prefix == 0)
                prefix =1;
            prefix = prefix * v[i];
            suffix = suffix * v[v.length - i -1];
            ans = Math.max(ans , Math.max(prefix,suffix));
        }
        System.out.println(ans);
    }
    public static void container_most_water()
    {
        int [] v = {1,8,6,2,5,4,8,3,7};
        int left = 0;
        int right = v.length -1;
        int total = 0;
        while (left < right)
        {
            int b = Math.min(v[left],v[right]);
            int l = right - left ;
            total = Math.max(l*b,total);
            if (v[left] > v[right])
            {
                right-=1;

            }
            else{
                left+=1;
            }
        }
        System.out.println(total);
    }
    public static void longest_sub_without_repeating2() {
        String s = "a2bc2d";
        int left = 0;
        int ans = 0;
        int right = 0;
        Set<Character> st = new HashSet<>();
        while(right<s.length())
        {
            if(st.contains(s.charAt(right)))
            {
                while(st.contains(s.charAt(right)))
                {
                    st.remove(s.charAt(left));
                    left+=1;
            }
            }
            else{
                st.add(s.charAt(right));
                right+=1;
                ans = Math.max(right-left,ans);
            }
        }
        System.out.println(ans);
    }
    public static void longest_sub_without_repeating()
    {
        String s = "abcabcbb";
        int left= 0;
        int ans = 0;
        int right =0;
        Set<Character> st = new HashSet<>();
        while(right<s.length())
        {
            if(st.contains(s.charAt(right)))
            {
                st.remove(s.charAt(left));
                left+=1;
            }
            else{
                st.add(s.charAt(right));
            ans = Math.max(right-left+1,ans);
            right+=1;
            }
        }
        System.out.println(ans);
    }
    static void check_ana()
    {

        String s = "anagram";
        String t = "anagram";
        int [] ch = new int[26];
        for(int i=0;i<s.length() ; i++)
        {
            ch[s.charAt(i) - 'a'] ++;
            ch[t.charAt(i) - 'a'] --;
        }
        for(Integer c : ch)
        {
            if(c != 0)
            {
                System.out.println("not anagrams");
                return;
            }
        }

        System.out.println("anagrams");
    }
    public static void group_anagrams()
    {
        String [] v = {"eat","tea","tan","ate","nat","bat"};
//        Collection<List<String>> gana = Arrays.stream(v).collect(Collectors.groupingBy(
//
//                w-> {
//                    char [] ch = w.toCharArray();
//                    Arrays.sort(ch);
//                    return new String(ch);
//                }
//        ))
//                .values();
//        gana.forEach(System.out::println);
        Map<String, List<String>> gana = Arrays.stream(v).collect(Collectors.groupingBy(
                p ->    {
                    char [] c = p.toCharArray();
                    Arrays.sort(c);
                    return new String(c);
                }
                ));
        System.out.println(gana.values());
    }
    public static void check_palindrome()
    {
        int x = 123;
        ArrayList<Integer> digits = new ArrayList<>();
        int temp = x;
        while(temp>0)
        {
            digits.add(temp%10);
            System.out.println(temp%10);
            temp/=10;
        }
        ArrayList<Integer> rdigits = digits;
        Collections.reverse(digits);
        if(digits.equals(rdigits))
        {
            System.out.println("Palindrome");
            return;
        }
        System.out.println("not palindrome");


//        List<Integer> digits = String.valueOf(x)
//                .chars() // IntStream of Unicode code points
//                .map(c -> c - '0') // Convert 'char' digits to actual digits
//                .boxed() // Convert IntStream to Stream<Integer>
//                .collect(Collectors.toList());
//        System.out.println(digits);

    }
    public static void balanced_parenthesis()
    {
        String s="()[{}(]";
        Stack<Character> st = new Stack<>();
        for(Character c : s.toCharArray())
        {
            if(c == '(' || c =='{' || c== '[')
            {
                st.add(c);
            }
            else{
                Character t = st.pop();
                if ((c == ')' && t == '(' ) || (c == '}' && t == '{' ) ||  (c == ']' && t == '[' ))
                {
                    continue;
                }
                else{
                    System.out.println("not balanced");
                    return;
                }
            }
        }
        System.out.println("balanaced");

    }
    public static void all_substrings()
    {
        String s = "kart";
        ArrayList<String> v = new ArrayList<>();
        int n = s.length();
        for(int i= 1;i<=n;i++)
        {
            for(int j =0;j<=n-i;j++)
            {
                System.out.println(s.substring(j,i+j));
            }
        }
    }
    public static void encode_decode()
    {
        List<String> s = new ArrayList<>(Arrays.asList("abc","def","d"));
        // encoded string is #4$neet4$code3$you
        String res = "13$abcabcabcabca3$def1$d";
//        for(int i= 0 ;i <s.size();i++)
//        {
//            String temp = s.get(i);
//            int temp_length = temp.length();
//            res = res + temp_length + "$" + temp ;
//        }
//        System.out.println(res);

        //encoded string 13$abc3$def1$d
        char[] nres = res.toCharArray();
        int n = res.length();
        int right = 0;
        ArrayList<String> resArray = new ArrayList<>();
        while (right < n)
        {
            StringBuilder number = new StringBuilder();
            while (Character.isDigit(nres[right])) {
                number.append(nres[right]);
                right++;
            }

            // Step 2: Skip the '$' character
            if (right < n && nres[right] == '$') {
                right++;
            }

            // Step 3: Read the substring of length = number
            int len_of_string = Integer.parseInt(number.toString());
            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < len_of_string; i++) {
                ans.append(nres[right]);
                right++;
            }

            resArray.add(ans.toString());
        }

        System.out.println(resArray);
    }
    public static void climbing_stairs()
    {
        int n = 3;
        int [] dp = new int[n+1];
        dp[0]= 1;
        dp[1] = 1;
        for(int i =2;i<=n;i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        for(Integer w : dp)
        {
            System.out.println(dp[n]);
        }
    }
    public static void coin_change()
    {
        int [] v = {1,2,5};
        int target = 11 ;
        int [] dp = new int [target+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1 ;i<target+1;i++)
        {
            for(int j = 0;j<v.length;j++)
            {
                if(i >= v[j] && dp[i - v[j]] != Integer.MAX_VALUE)
                {
                    dp[i] = Math.min(1 + dp[i-v[j]],dp[i]);
                }
            }
        }
        for(Integer s : dp)
        {
            System.out.println(s);
        }

    }
    public static void lis()
    {
        int v[] = {10, 9, 2, 5, 3, 7, 101, 18};
        int  dp [] = new int [v.length];
        Arrays.fill(dp,1);

        for(int i = 1; i<v.length;i++)
        {
            for(int j = 0; j <i ; j++)
            {
                if(v[i] > v[j])
                {
                    dp[i] = Math.max(1 + dp[j],dp[i]);
                }
            }
        }
        for(Integer i : dp)
        {
            System.out.println(i);
        }
    }
    public static int lcs_helper(String s,String t,int m,int n,int [][] dp)
    {
        if(m<0 || n<0 )
        {
            return 0;
        }
        if(dp[m][n] != -1)
        {
            return dp[m][n];
        }
        if(s.charAt(m) == t.charAt(n))
        {
            return dp[m][n] = 1 + lcs_helper(s,t,m-1,n-1,dp);
        }
        return dp[m][n] = Math.max(lcs_helper(s,t,m-1,n,dp),lcs_helper(s,t,m,n-1,dp));
    }
    public static void lcs()
    {
        String s1 = "acd";
        String s2 = "ced";
        int m = s1.length();
        int n = s2.length();
        int dp [][] = new int [m+1][n+1];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
//        System.out.println(lcs_helper(s1,s2,m-1,n-1,dp));
        for(int i = 0;i<=n;i++)
        {
            dp[i][0] = 0;
        }
        for(int i = 0;i<=n;i++)
        {
            dp[0][i] = 0;
        }
        for(int i= 1; i<=m;i++)
        {
            for(int j =1 ; j<=n;j++)
            {
                if(s1.charAt(i) == s2.charAt(j))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
    }
    public static int house_robber(int [] v ,int start,int end)
    {

        int [] dp = new int [v.length];
        int max_amount = 0;
        dp[start] = v[start];
        dp[start+1] = v[start+1];
        for(int i = start+2 ; i<end;i++)
        {
            dp[i] = Math.max(v[i] + dp[i-2] , v[i-1]);
            max_amount = Math.max(dp[i],max_amount);
        }
        return max_amount;
    }
    public static void house_robber2()
    {
        int [] v = {2,3,2};
        System.out.println(Math.max(house_robber(v,0,v.length-1),house_robber(v,1,v.length)));
    }
    public static void unique_paths()
    {
        int m =3 ;
        int n =7;
        int dp [][] = new int[3][7];
        Arrays.fill(dp[0],1);
        for (int rows[] : dp)
            Arrays.fill(rows, 1);
        for(int i =1;i<m;i++)
        {
            for(int j= 1;j<n;j++)
            {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        for(int i =0 ;i<m;i++)
        {
            for(int j =0;j<n;j++)
            {
                System.out.println(dp[i][j]);
            }
            System.out.println("/n");
        }
    }
    public static void combination_sum_helper(int v[] ,int target , int m ,ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> path)
    {
        if(m < 0)
        {
             if(target == 0)
             {
                 ans.add(new ArrayList<>(path));
             }
             return;
        }
        if(v[m] <= target)
        {
            path.add(v[m]);
            combination_sum_helper(v,target-v[m],m,ans,path);
            path.remove(path.size() - 1);
        }
        combination_sum_helper(v,target,m-1,ans,path);
    }
    public static void combination_sum()
    {
        int [] v = {2,3,6,7};
        int target = 7;
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        combination_sum_helper(v,target,v.length-1, ls,path);
        ls.add(new ArrayList<>(Arrays.asList(3,2,2)));
        Set<ArrayList<Integer>> s = new HashSet<>(ls);
        s.forEach(f -> System.out.println(f));
    }
    public static void set_matrix_zero()
    {
        int [][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}};
        int m = matrix[0].length;
        int n= matrix.length;
        int [] l = new int [matrix[0].length];
        int [] b = new int[matrix.length];
        for(int i =0;i<m ; i++)
        {
            for(int j =0 ;j <n;j++)
            {
                if(matrix[i][j] == 0)
                {
                    l[i] = -1;
                    b[j] = -1;
                }
            }
        }
        for(int i =0;i<m ; i++) {
            for (int j = 0; j < n; j++) {
                if (l[i] == -1 || b[j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
            for(int i =0;i<m ; i++)
            {
                for(int j =0 ;j <n;j++) {
                    System.out.println(matrix[i][j]);
                }}

    }
    public static void spiral_order()
    {
        int [][] v= { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        int marker = 0;
        int m = v[0].length;
        int n = v.length;
        int left= 0 ;
        int right = v[0].length;
        int top =0;
        int bottom = v.length;
        while ((left < right) && (top<bottom))
        {
            if((marker % 4) == 0)
            {
                for(int i = left;i<right;i++)
                {
                    System.out.println(v[top][i]);
                }
                top+=1;
            } else if ((marker % 4) == 1) {
                for(int i = top ; i<bottom ; i++)
                {
                    System.out.println(v[i][right]);
                }
                right-=1;

            }
        }
    }
    public static void reverse_array(int [] v)
    {
        int left =0 ;
        int right = v.length-1;
        while(left<(right/2))
        {
            int temp = v[left];
            v[left] = v[right];
            v[right] = temp;
            left ++ ;
            right --;
        }
    }
    public static void rotate_by_90()
    {
        int v[][] =
                {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        // 1,4,7
        // 2,5,8
        //3,6,9
        for(int i = 0 ;i<v[0].length;i++)
        {
            for(int j = i ; j<v.length;j++ )
            {
                int temp = v[i][j];
                v[i][j] = v[j][i];
                v[j][i] = temp ;
            }
        }
        for(int i = 0 ;i<v[0].length;i++)
        {
            reverse_array(v[i]);
        }
            for(int [] r : v)
        {
            System.out.println(Arrays.toString(r));
        }
    }
    public static boolean word_search_helper(char[][] board,int i,int j ,int cur_index,String word)
    {
        if(cur_index == word.length())
        {
            return true;
        }
        if(i<0 || j<0 || j == board[0].length || i == board.length || board[i][j] != word.charAt(cur_index))
        {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '@';
        boolean a = word_search_helper(board,i+1,j,cur_index+1,word);
        boolean b = word_search_helper(board,i,j+1,cur_index+1,word);
        boolean c = word_search_helper(board,i,j-1,cur_index+1,word);
        boolean d = word_search_helper(board,i-1,j,cur_index+1,word);

        board[i][j] = temp;
        if(a || b || c || d)
        {
            return true;
        }
        return false;

    }
    public static void word_search()
    {
        char[][] board = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};

        String word = "FCSEnm";
        for(int i = 0 ;i<board.length;i++)
        {
            for(int j =0 ;j<board[0].length;j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(word_search_helper(board,i,j,0,word))
                        System.out.println("Word is found");

                }
            }
        }
    }
    public static int edit_distance_helper(String s,String t,int m,int n,int [][] dp)
    {
        if(m<0)
        {
            return n;
        }
        if(n<0)
        {
            return m;
        }
        if(dp[m][n] != -1)
        {
            return dp[m][n];
        }
        if(s.charAt(m) == t.charAt(n))
        {
            return dp[m][n] = edit_distance_helper(s,t,m-1,n-1,dp);
        }
        return dp[m][n] = 1 + Math.min(edit_distance_helper(s,t,m-1,n,dp),Math.min(edit_distance_helper(s,t,m-1,n-1,dp),edit_distance_helper(s,t,m,n-1,dp)));
    }

    public static void edit_distance()
    {
        String s = "horse";
        String t = "ros";
        int m = s.length();
        int n = t.length();
        int [][] dp = new int [m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = edit_distance_helper(s,t,m-1,n-1,dp);
        System.out.println(ans);
    }
    public static void reverseLinkedList(LinkedListNode head)
    {
        LinkedListNode prev = null;
        LinkedListNode temp = head;
        while (temp!=null)
        {
            LinkedListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
//        LinkedListNode.showAllLinkedListNodes(prev);

    }
    public static void cycle_detection(LinkedListNode head)
    {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast != null)
        {
            slow = slow.next;
            fast= fast.next.next;
            if(slow == fast)
            {
                System.out.println("There is a cycle");
                return;
            }
        }
    }
    public static void linked_cycle_2(LinkedListNode head)
    {
        LinkedListNode temp = head;
        LinkedListNode slow = head;
        LinkedListNode fast = head ;
        Boolean hascycle = false;
        while(fast != null && fast.next != null)
        {
            slow= slow.next;
            fast= fast.next.next;
            if(slow == fast)
            {
                hascycle = true;
                break;
            }
        }
        int pos = 0;
        if(hascycle)
        {


            while(head != slow)
            {
                pos += 1;
                head= head.next;
                slow =slow.next;
            }
        }

        System.out.println(pos);
    }
    public static void merge_2_lists(LinkedListNode l1,LinkedListNode l2 )
    {
        if(l2 == null)
        {
            return;
        }
        LinkedListNode temp = new LinkedListNode(0);
        LinkedListNode curr = temp ;
        while(l1 != null && l2 != null)
        {
            if(l1.data > l2.data)
            {
                temp.next = l2;
                l2 = l2.next ;
            }
            else{
                temp.next = l1;
                l1 = l1.next ;
            }
            temp = temp.next;
        }
        if(l1 != null)
        {
            while(l1 != null)
            {
                temp.next = l1;
                l1 = l1.next;
            }
        }
        else{
            while(l2 != null)
            {
                temp.next = l2;
                l2 = l2.next;
            }
        }
        LinkedListNode.showAllLinkedListNodes(curr.next);

    }
    public static void delete_nth_from_end(LinkedListNode head)
    {
        int n =3;
        int total = 0 ;
        LinkedListNode curr= head;
        while (curr != null)
        {
            total +=1;
            curr= curr.next;
        }
        curr = head;
        if (total == n)
        {
            LinkedListNode newhead=  head.next;
            head= null;
            LinkedListNode.showAllLinkedListNodes(newhead);
        }
        int back = total - n -1;
        LinkedListNode back_pointer = head;
        while(back != 0)
        {
            back-=1;
            back_pointer = back_pointer.next;
        }
        while((n-1)!=0)
        {
            n-=1;
            curr= curr.next;
        }
        LinkedListNode temp = null;
        temp = curr.next;
        back_pointer.next= temp;
        LinkedListNode.showAllLinkedListNodes(head);
    }
    public static void add_2_numbers(LinkedListNode l1,LinkedListNode l2)
    {
        LinkedListNode temp = new LinkedListNode(0);
        LinkedListNode cur = temp;
        int carry =0 ;
        Stack<Integer> stack = new Stack<>();

        while (l1 != null || l2 != null)
        {
            int sum =carry;
            if(l1 != null)
            {
                sum += l1.data ;
                l1=l1.next;
            }
            if(l2 != null)
            {
                sum += l2.data ;
                l2=l2.next;
            }

//            System.out.println(sum);
            temp.next = new LinkedListNode(sum%10);
            carry = sum/10;
            temp = temp.next;
        }
        if (carry > 0)
        temp.next = new LinkedListNode(carry);
        LinkedListNode curr=cur.next;
        while(curr != null)
        {
            System.out.println(curr.data);
            curr=curr.next;
        }
    }
    public static void LinkedlistChecking() {

        LinkedListNode head = new LinkedListNode(2);
        head.next = new LinkedListNode(4);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(1);
        LinkedListNode head2 = new LinkedListNode(5);
        head2.next = new LinkedListNode(6);
        head2.next.next = new LinkedListNode(4);
        add_2_numbers(head,head2);
    }
    public static void jump_game()
    {
        int [] v={2,3,1,0,4};
        int maxjump = 0;
        int n = v.length;
        for(int i = 0 ;i<v.length;i++)
        {

            if(maxjump<i)
            {
                System.out.println("no");
                return;
            }
            maxjump = Math.max(maxjump,i+v[i]);
        }
        System.out.println("yes");
    }
    public static void jump_game2()
    {
        int [] v={2,2,1,2,0,4};
        int curmax = 0;
        int curreach=0;
        int n = v.length;
        int jump=0;
        for(int i = 0 ;i<v.length-1;i++)
        {
            curmax = Math.max(curmax,i+v[i]);
            if(curreach==i)
            {
                jump++;
                curreach=curmax;
            }

        }
        System.out.println(jump);
    }
    public static void generate_parenthesis_helper(int n,int open,int closed,ArrayList<String> ans,ArrayList<String> path)
    {
        if(open == n && closed == n)
        {
            ans.add(String.join("",path));
            return;
        }
        if(open<n)
        {
            path.add("(");
            generate_parenthesis_helper(n,open+1,closed,ans,path);
            path.remove(path.size()-1);
        }
        if (closed < open) {
            path.add(")");
            generate_parenthesis_helper(n,open,closed+1,ans,path);
            path.remove(path.size()-1);
        }
    }
public static void generate_parenthesis()
{
    int n = 3;
    ArrayList<String> ans = new ArrayList<>();
    ArrayList<String> path =new ArrayList<>();
    generate_parenthesis_helper(n,0,0,ans,path);
    for(String s : ans)
        System.out.println(s);
}
public static void stack_checking()
{
    Stack<Integer> stack = new Stack<>();
    stack.add(1);
    stack.add(2);

    stack.push(3);
    stack.push(4);

    while (!stack.isEmpty())
    {
        System.out.println(stack.pop());
    }
}

public static void subsets_helper(int [] v ,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> ans,int ind)
{
    if(ind == v.length)
    {
        ans.add(new ArrayList<>(path));
        return;
    }

    path.add(v[ind]);
    subsets_helper(v,path,ans,ind+1);
    path.remove(path.size()-1);

    subsets_helper(v,path,ans,ind+1);
}
public static void subsets()
{
    int [] v= {1,2,3};
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    subsets_helper(v,path,ans,0);
    for(ArrayList<Integer> s : ans)
        System.out.println(s);
}
static void addEdge(ArrayList<ArrayList<Integer>>ans,int u,int v)
{
    ans.get(u).add(v);
//    ans.get(v).add(u);
}
static void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
    visited[node]= true;
    System.out.println(node);
    for(int n : graph.get(node))
    {
        if(!visited[n])
        {
            dfs(n,graph,visited);
        }
    }
    }
    static void bfs(int node, ArrayList<ArrayList<Integer>> graph,int n)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[n];
        q.add(node);
        visited[node] = true;
        while(!q.isEmpty())
        {
            int current_node = q.poll();
            System.out.println(current_node);
            for(int neigh : graph.get(current_node))
            {
                if(!visited[neigh])
                {
                    visited[neigh] = true;
                    q.add(neigh);
            }
            }
        }
        }
        public static boolean has_a_cycle_(boolean [] vis, boolean [] recStack, ArrayList<ArrayList<Integer>> pre , int node)
        {
            vis[node] = true;
            recStack[node] = true;
            for(int i  : pre.get(node))
            {
                if(!vis[i])
                {
                    if(has_a_cycle_(vis,recStack,pre,i))
                    {
                        return true;
                    }


                }
                else if(recStack[i]){
                    return true;
                }
            }
            recStack[node] = false;
            return false;
        }
        public static boolean courseSchedule_cycle_detection(ArrayList<ArrayList<Integer>> pre,int n,int current_course)
        {
            boolean [] visited = new boolean[n];
            boolean [] recStack = new boolean[n];

            visited [current_course]  = true;
            for(int a : pre.get(current_course))
            {
                if(!visited[a])
                {
                    if(has_a_cycle_(visited,recStack,pre,a))
                    {
                        return false;
                    }
                }
            }
            return true;

        }
public static void courseSchedule()
{
//    int n = 4;
//    int p =4 ;
//        int [][] pre = {{1,2},{4,3},{2,4},{4,1}};
//    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//        addEdge(ans,1,2);
//        addEdge(ans,4,3);
//        addEdge(ans,2,4);
//        addEdge(ans,4,1);
//        courseSchedule_cycle_detection(ans,n,1);
    int n = 4;
    ArrayList<ArrayList<Integer>> pre = new ArrayList<>();
    for (int i = 0; i < n; i++) pre.add(new ArrayList<>());

    pre.get(0).add(1);
    pre.get(1).add(2);
    pre.get(2).add(3);
//    pre.get(3).add(4);

    if (courseSchedule_cycle_detection(pre, n, 0)) {
        System.out.println("No cycle. All courses can be completed.");
    } else {
        System.out.println("Cycle detected. Cannot complete all courses.");
    }


}
    public static void dfs_for_connected_components(ArrayList<ArrayList<Integer>> pre,boolean [] b,int i , int m , int n)
    {
        b[i] = true;
        System.out.println(i);
        for(int neighbour : pre.get(i))
        {
            if(!b[neighbour])
            {
                dfs_for_connected_components(pre,b,neighbour,m,n);
            }
        }
    }
public static void connected_components_of_a_graph(ArrayList<ArrayList<Integer>> pre,int v)
{
    boolean [] b = new boolean[v];
    int m = pre.size();
    int n = pre.get(0).size();
    int current_size = 0;
    for(int i = 0 ;i< v; i++)
    {
        if(!b[i])
        {
            dfs_for_connected_components(pre,b,i,m,n);
            current_size+=1;
        }
    }
    System.out.println("Current size" + current_size);


}
public static boolean cycle_check_bfs_undirected_graph(ArrayList<ArrayList<Integer>> pre, boolean [] visited, int node)
{
    visited[node] = true;
    Queue<int []> q =  new LinkedList<>(); //BFS
    q.add(new int[]{node,-1});
    while(!q.isEmpty())
    {
        int [] polled = q.poll();
        int current_node = polled[0];
        int parent = polled[1];

        for(int i : pre.get(current_node))
        {
            if(!visited[i])
            {
                q.add(new int[]{i,current_node});
                visited[i] = true;

            }
            else if(parent != i)
            {
                return true;
            }
        }
    }
    return false;

}

    public static void bfs_undirected_graph(ArrayList<ArrayList<Integer>> adjList, int v) {
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (cycle_check_bfs_undirected_graph(adjList, visited, i)) {
                    System.out.println("Cycle is there");
                    return;
                }
            }
        }

        System.out.println("No cycle found");
    }
    public static void Dijkstra(ArrayList<ArrayList<int[]>> adj,int n,int source) {
    int [] dist = new int[n];
    Arrays.fill(dist,Integer.MAX_VALUE);
    dist[source] = 0;
    PriorityQueue<int []> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    q.add(new int []{source,0});
    while(!q.isEmpty())
    {
        int [] current_element = q.poll();
        int u = current_element[0];
        int current_weight= current_element[1];
        if(current_weight > dist[u]) continue;
        for(int [] neigh : adj.get(u))
        {
            int v = neigh[0];
            int wt_of_neighbor = neigh[1];
            if(wt_of_neighbor + dist[u] < dist[v])
            {
                dist[v] = wt_of_neighbor + dist[u];
                q.add(new int[] {v,wt_of_neighbor});
            }
        }
    }
    for(int i = 1;i<n;i++)
    {
        System.out.println("From "+"source " + source +" to "+ i + " : "+ dist[i]);
    }
    }

        public static void graphsChecking()
{
    int[][] edges = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {1, 3, 2}};
    ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
    int n = 5;
    for(int i = 0; i<n;i++)
    {
        adj.add(new ArrayList<>());
    }
    for(int [] row : edges)
    {
        int u = row[0];
        int v = row[1];
        int weight = row[2];
        adj.get(u).add(new int[] {v,weight});
    }
   Dijkstra(adj,n,1);
//    ArrayList<ArrayList<Integer>> pre = new ArrayList<>();
//    int[][] edges = {
//            {0, 1},
//            {1, 2},
//            {3, 4}
//    };
//    for(int i = 0;i<V ; i++) pre.add(new ArrayList<>());
//
//    for(int i = 0 ;i < edges.length;i++)
//    {
//        int u = edges[i][0];
//        int v = edges[i][1];
//        pre.get(u).add(v);
//    }
//    connected_components_of_a_graph(pre,V);
//    courseSchedule();
//    ArrayList<ArrayList<Integer>> pre = new ArrayList<>();
//    for(int i= 0 ;i<n;i++)
//    {
//        pre.add(i,new ArrayList<>());
//    }
//    addEdge(pre, 0, 1);
//    addEdge(pre, 0, 2);
//    addEdge(pre, 1, 2);
//    addEdge(pre, 2, 0);
//    boolean [] vis = new boolean[n];
//    for(int i =0 ;i<n;i++)
//    {
//        if(!vis[i])
//        {
//            dfs(i,pre,vis);
//        }
//    }

//    bfs(0,pre,n);
}
    static void dfs_number_of_islands(int[][] v, int i, int j) {
        if (i < 0 || j < 0 || i >= v.length || j >= v[0].length || v[i][j] != 1) {
            return;
        }

        v[i][j] = 3; // mark as visited

        // 4-directional movement
        dfs_number_of_islands(v, i + 1, j);
        dfs_number_of_islands(v, i - 1, j);
        dfs_number_of_islands(v, i, j + 1);
        dfs_number_of_islands(v, i, j - 1);
    }

    static void number_of_islands() {
        int[][] v = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };

        int count = 0;

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                if (v[i][j] == 1) {
                    dfs_number_of_islands(v, i, j);
                    count++;
                }
            }
        }

        System.out.println("Number of islands: " + count);
    }
    public static void longestSuccessiveElements()
    {
        int [] v = {1,0,0,0};
        int cnt = 1 ;
        Arrays.sort(v);
        //1,2,3,4,100,200
        int longest = 1;
        int right = 0;

        for(int i = 1; true; i++) {
            if (v[i] == v[i - 1]) {
                continue;
            } else if (v[i] == v[i - 1] + 1) {
                cnt++;
            } else {
                cnt = 1; // reset if sequence breaks
            }
            longest= Math.max(longest,cnt);
        }

    }
    static void next_greater_element()
    {
        int [] v = {1,3,4,2};
        Stack<Integer> stack = new Stack<>();
        int [] ans = new int[v.length];
        int n = v.length;
        for(int i= 2* (v.length)-1;i>=0;i--) {
            while (!stack.isEmpty() && v[stack.peek()] <= v[i%n]) {
                stack.pop();
            }
            if (i < n) {
            if (stack.isEmpty()) {
                ans[i%n] = -1;
            } else {
                ans[i%n] = v[stack.peek()];
            }}
            stack.push(i%n);
        }

        for(int s:ans)
        {
            System.out.println(s);
        }
    }
    public static boolean find_koko_can_eat(int current_speed, int[] piles, int h) {
        int total_hours = 0 ;
        for(int bananas : piles)
        {
            total_hours = total_hours + (bananas + current_speed -1)/current_speed;
//            total_hours = (int) (total_hours + Math.ceil((double)bananas/current_speed));
        }
        System.out.println(total_hours);
        return total_hours<=h;
    }
    public static void koko_eating_bananas() {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        int low = 1; // Minimum speed = 1 banana/hour
        int high = Arrays.stream(piles).max().getAsInt(); // Max speed = max pile size
        int ans = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("mid is " + mid);
            if (find_koko_can_eat(mid, piles, h)) {
                ans = mid;
                high = mid - 1; // Try to find a smaller valid speed
            } else {
                low = mid + 1; // Need to eat faster
            }
        }

        System.out.println("Minimum speed Koko can eat all bananas: " + ans);
    }
    public static boolean can_be_shipped(int size_container , int [] v, int days_required )
    {
        int total_container = 0 ;
        int days_taken = 0;
        for(int container : v)
        {
            if(total_container + container > size_container )
            {
                days_taken+=1;
                total_container = 0;
            }
            total_container = total_container + container;
        }
        if(total_container > 0)
        {
            days_taken +=1;
        }
        return days_taken<=days_required;
    }
public static void ship_within_days()
{
    int [] v ={1,2,3,1,1};
    int days = 4;
    int left = Arrays.stream(v).max().getAsInt();
    int right = Arrays.stream(v).sum();
    //10   .... .55
    int ans = 0;
    while(left<= right)
    {
        int mid = (left+right) /2 ;
        if(can_be_shipped(mid,v,days))
        {
            ans = mid;
            right = mid-1;
        }
        else{
            left =mid+1;
        }
    }
    System.out.println(ans);

}
public static boolean isSafeRottenOranges(int i , int j, int m ,int n)
{
    return !(i<0 || j<0 || i>=m || j>=n);
}
public static void rotten_oranges()
{
    int[][] mat = {{2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
    Queue<int[]> q =new LinkedList<>();
    int n = mat.length;
    int m = mat[0].length;


    int[][] directions
            = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    for(int i = 0 ;i<n;i++)
    {
        for(int j = 0;j<m;j++)
        {
            if(mat[i][j] == 2)
            {
                q.add(new int[]{i, j});
            }
        }
    }
    int elapsed_time = 0;
    while(!q.isEmpty())
    {
        elapsed_time +=1;
        int size = q.size();
        while(size-- > 0)
        {
         int [] pp = q.poll();
         int jx = pp[1];
         int ix = pp[0];
         for(int i = 0 ; i<directions.length;i++)
         {
             int ii = ix + directions[i][0];
             int jj = jx + directions[i][1];
             if(isSafeRottenOranges(ii,jj,n,m) && mat[ii][jj] == 1)
             {
                 q.add(new int [] {ii,jj});
                 mat[ii][jj] = 2;
             }
         }
        }

    }
    System.out.println(elapsed_time);
}
public static void increasing_sum()
{
    int [] v = {1,101,2,3,100};
    int [] dp = new int[v.length];
    dp[0] = v[0];
    int max_overall = Integer.MIN_VALUE;
    for(int i = 1; i<v.length;i++)
    {
        for(int j = 0 ; j<i ; j++)
        {
            if(v[i] > v[j])
            {
                dp[i] = Math.max(v[i] + v[j],dp[i]);
            }
        }
        max_overall = Math.max(max_overall,dp[i]);
    }
    System.out.println(max_overall);

}

static int knapsack_helper(int [] wt,int [] val , int w,int ind,int [][] dp)
{
    if(ind == 0 )
    {
        if(wt[ind] <= w)
        {
            return val[0];
        }
        else{
            return 0;
        }
    }
    if(dp[ind][w] != -1)
        return dp[ind][w];
    int take = Integer.MIN_VALUE;
    if(wt[ind] <= w )
    {
        take = val[ind] + knapsack_helper(wt,val,w-wt[ind],ind-1,dp);
    }

    int not_take = knapsack_helper(wt,val,w,ind-1,dp);
    return dp[ind][w] = Math.max(take,not_take);


}
static void zero_one_knapsack()
{
    int [] wt = {1,2,4,5};
    int [] val ={5,4,8,6};
    int W = 5;
    int n = wt.length;
    int [][] dp = new int[n][W+1];
    for(int i =0 ;i <n;i++)
        Arrays.fill(dp[i],-1);
    System.out.println(knapsack_helper(wt,val,W,wt.length-1,dp));
    for(int [] r : dp)
    {
        System.out.println(Arrays.toString(r));
    }
    System.out.println(dp[n-1][W]);
}

    static void fractional_knapsack() {
        int[] val = {100, 60, 120};
        int[] wt = {20, 10, 30};
        int max_wt = 50;

        List<Pair_knapsack> nodes = new ArrayList<>();
        for (int i = 0; i < wt.length; i++) {
            nodes.add(new Pair_knapsack(val[i], wt[i]));
        }


        // Sort items by value-to-weight ratio (descending)
        nodes.sort((a, b) -> Double.compare(b.ratio, a.ratio));

        double total_val = 0;

        for (Pair_knapsack p : nodes) {
            if (max_wt == 0) break;

            if (p.wt <= max_wt) {
                // Take full item
                total_val += p.val;
                max_wt -= p.wt;
                System.out.println("Took full item with value = " + p.val + " and weight = " + p.wt);
            } else {
                // Take fractional part
                double fraction = (double) max_wt / p.wt;
                double taken_val = p.val * fraction;
                total_val += taken_val;
                System.out.println("Took " + (fraction * 100) + "% of item with value = " + p.val + " and weight = " + p.wt);
                max_wt = 0;
            }
        }

        System.out.println("Maximum value we can obtain = " + total_val);
    }

static void platform_required_checking()
{
    int[] arr ={900,945,955,1100,1500,1800};
    int[] dep={920,1200,1130,1150,1900,2000};
    //  i= 0 , j =1   900 >= 945   900 <= 920
    //  i = 0  j = 1  945>= 900    945 <= 920
//    int ans=1; //final value
//    for(int i=0;i<=n-1;i++)
//    {
//        int count=1; // count of overlapping interval of only this   iteration
//        for(int j=i+1;j<=n-1;j++)
    int n=arr.length;
    Arrays.sort(dep);
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(dep));
    int total_platforms_required = 0 ;
    int i = 0;
    int j  = 0 ;
    int max_plat = 0;
    while(i < n && j < n)
    {
        if(arr[i] < dep[j])
        {
            total_platforms_required += 1;
            i+=1;
            max_plat= Math.max(total_platforms_required,max_plat);
        }
     else {
            total_platforms_required-=1;
            j+=1;
        }
    }
    System.out.println(max_plat);

}
static void find_minimum_number_of_coins()
{
    int [] v ={ 1, 2, 5, 10, 20, 50, 100, 500};
    int target =220;
    int total_coins_required = 0;
    for(int i = v.length-1;i>=0;i--)
    {
        while(v[i] <= target)
        {
            total_coins_required = total_coins_required + 1;
            target -= v[i];
            System.out.println(v[i]);
        }
    }
    System.out.println(total_coins_required);
}

static void job_sequencing_problem()
{
    Job[] arr = new Job[4];
    arr[0] = new Job(1, 4, 20);
    arr[1] = new Job(2, 1, 10);
    arr[2] = new Job(3, 1, 40);
    arr[3] = new Job(4, 1, 30);
//    Job[] newarr = Arrays.copyOf(arr, arr.length);
    Arrays.sort(arr, Comparator.comparingInt((Job a) -> a.profit).reversed());
    boolean [] visited = new boolean[arr.length+1];
    int total = 0;
    for(Job p : arr)
    {
        System.out.println("id" + p.id + " deadline "+ p.deadline + " profit " + p.profit);
    }
    for(Job p : arr)
    {
        if(!visited[p.deadline])
        {
            total = total + p.profit;
            visited[p.deadline] = true;
        }

    }
    System.out.println(total);
//    Arrays.sort(arr, (a,b) -> (b.profit - a.profit));


}


static void n_meeting_rooms()
    {
        int n = 6;
        int [] start = {1, 2, 3, 4, 5};
        int [] end   = {3, 3, 3, 3, 3};

        List<int []> pairs = new ArrayList<>();
        for(int i = 0;i<start.length;i++)
        {
            pairs.add(new int [] {start[i],end[i]});
        }
        pairs.sort(Comparator.comparingInt(a -> a[1]));
        for (int[] pair : pairs) {
            System.out.println("Start: " + pair[0] + ", End: " + pair[1]);
        }
        int total_meetings = 1 ;
        int lastEnd = pairs.get(0)[1];
        for(int i = 1;i<=pairs.size()-1;i++)
        {
            if(pairs.get(i)[0] >= lastEnd)
            {
                total_meetings+=1;
                lastEnd = pairs.get(i)[1];

            }
        }

        System.out.println(total_meetings);
    }
    static void assign_cookies()
    {
        int [] g = {2,5,3};

        int [] s = {1,5,3};
        //2,3,5   1,3,5
        Arrays.sort(g);
        Arrays.sort(s);
        int total_required = 0;
        int i =0 , j = 0;
        while(i<g.length && j < s.length)
        {

            if (s[j] >= g[i]) {
                i+=1;
                total_required+=1;
            }
            j+=1;
        }
        System.out.println(total_required);
    }
    static void majority_element()
    {
        int [] v ={4,4,2,4,3,4,4,3,2,4};
        int candidate = v[0];
        int size = 1 ;
        for(int i = 1;i<v.length;i++)
        {
            if(size < 0)
            {
                candidate = v[i];
                size= 0;
            }
            if(v[i] == candidate)
            {
                size+=1;
            }
            else if(v[i] != candidate){
                size-=1;
            }
        }
        System.out.println(candidate);
    }
    static void pow()
    {
        // 6  --  2*2 * 2*2 * 2*2
     int nn = -5;
     int integer = 5;
     int ans = 1;
     int n = 0;
     if(nn < 0 )
     {
         n = nn * -1;
     }
     while(n>0)
     {
         if(n%2 == 1)
         {
             ans = ans * integer;
             n-=1;
         }
         else{
             integer *=  integer;
             n/=2;
         }
     }
     if(nn<0)
         ans = -1 * ans;
        System.out.println(ans);
    }
    public static void celebrity_problem()
    {
        int[][] mat =
                { { 0, 1, 0 },
                { 0, 0, 0 },
                { 0, 1, 0 } };
        int ii = 0 , j = mat.length-1;
        while(ii<j)
        {
            if(mat[j][ii] == 1)
            {
                j--;
            }
            else{
                ii++;
            }
        }
        int candidate = ii;
                for(int i =0 ;i<mat.length;i++)
        {
            if (i == candidate) continue; // skip self-check

            if(mat[i][candidate] == 0 || mat[candidate][i] != 0)
            {
                System.out.println("No candidate");
                return;
            }
        }
        System.out.println(candidate);

//        Stack<Integer> s = new Stack<>();
//        for(int i = 0 ;i<mat.length;i++)
//        {
//            s.add(i);
//        }
//        while(s.size()>1)
//        {
//            int first_element= s.pop();
//            int second_element = s.pop();
//            if(mat[first_element][second_element] == 1)
//            {
//                s.add(second_element);
//            }
//            else{
//                s.add(first_element);
//            }
//        }
//        int candidate = s.peek();
//        for(int i =0 ;i<mat.length;i++)
//        {
//            if (i == candidate) continue; // skip self-check
//
//            if(mat[i][candidate] == 0 || mat[candidate][i] != 0)
//            {
//                System.out.println("No candidate");
//                return;
//            }
//        }
//        System.out.println(candidate);
    }
    static void all_traversals(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        all_traversals(root.left);
        System.out.println(root.data);
        all_traversals(root.right);
    }
    static class Queue_pair{
        TreeNode t;
        int level ;
        Queue_pair(TreeNode t,int level)
        {
            this.t = t;
            this.level = level;
        }
    }
    static void right_left(TreeNode root)
    {
        if(root == null)
        {
            return ;
        }
//        HashMap<Integer,Integer> hmap = new HashMap<>();
       int [] ans ;
        Map<Integer, Integer> levelMap = new HashMap<>();

        Queue<Queue_pair> q = new LinkedList<>();
        q.add(new Queue_pair(root,0));
        while(!q.isEmpty())
        {
             Queue_pair p = q.poll();
            TreeNode node = p.t;
            int level = p.level;
            levelMap.put(level,node.data);
            if(node.left != null)
            {
                q.add(new Queue_pair(node.left,level+1));
            }
            if(node.right != null)
            {
                q.add(new Queue_pair(node.right,level+1));
            }

        }
        for(Map.Entry<Integer, Integer> t : levelMap.entrySet())
        {
            System.out.println(t.toString());
        }
        for (int level = 0; level < levelMap.size(); level++) {
            System.out.print(levelMap.get(level) + " ");
        }
    }
    static void right_left_recursion_help(TreeNode head,ArrayList<Integer>res,int level)
    {
        if(head == null)
        {
            return;
        }
        if(res.size() == level)
        {
            res.add(head.data);
        }

        right_left_recursion_help(head.right,res,level+1);
        right_left_recursion_help(head.left,res,level+1);

    }
    static void right_left_recursion(TreeNode head)
    {
        ArrayList<Integer>res = new ArrayList<>();
        right_left_recursion_help(head,res,0);
    }
    static void bottom_view(TreeNode root)
    {
        Map<Integer,Integer> m = new TreeMap<>();
        Queue<Queue_pair> q = new LinkedList<>();
        q.add(new Queue_pair(root,0));

        while(!q.isEmpty())
        {
            Queue_pair el = q.poll();
            TreeNode node = el.t;
            int level = el.level;
            m.put(level,node.data);
            if(node.left != null)
            {
                q.add(new Queue_pair(node.left,level-1));
            }
            if(node.right != null)
            {
                q.add(new Queue_pair(node.right,level+1));
            }
        }
        System.out.println(m);
    }
    static void vertical_order(TreeNode root)
    {
        Map<Integer,ArrayList<Integer>> m = new TreeMap<>();
        Queue<Queue_pair> q = new LinkedList<>();
        q.add(new Queue_pair(root,0));

        while(!q.isEmpty())
        {
            Queue_pair el = q.poll();
            TreeNode node = el.t;
            int level = el.level;

            m.putIfAbsent(level, new ArrayList<>());
            m.get(level).add(node.data);

            if(node.left != null)
            {
                q.add(new Queue_pair(node.left,level-1));
            }
            if(node.right != null)
            {
                q.add(new Queue_pair(node.right,level+1));
            }
        }
        System.out.println(m);
    }
    static int res = 0;

    static int height_of_a_tree(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        return 1 + Math.max(height_of_a_tree(root.left),height_of_a_tree(root.right));

    }
    static int diameter_of_tree(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int left = diameter_of_tree(root.left);
        int right =diameter_of_tree(root.right);
        res = Math.max(left+right,res);
        return 1 + Math.max(left,right);
    }
    static boolean node_to_value_path(TreeNode root,ArrayList<Integer>res,int target)
    {
        if(root == null)
        {
            return false;
        }
        if (root.data == target) {
            return true;
        }

        if(node_to_value_path(root.left,res,target) || node_to_value_path(root.right,res,target))
        {
            return true;
        }
        res.remove(root.data);
        return false;
    }
    static void tree_checking()
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        ArrayList<Integer>res = new ArrayList<>();


    }
    static void roman_to_integer()
    {
        Map<Character, Integer> m = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        String s = "XLVIII";
        int ans = 0;
        for(int i = 0;i<s.length()-1;i++)
        {
            int current = m.get(s.charAt(i));
            int next = 0;
            if(i+1 < s.length())
            {
                next = m.get(s.charAt(i+1));
            }
            if(next>current)
            {
                ans += next - current;
                i = i+1;
            }
            else{
                ans += current;
            }
        }
        System.out.println(ans);
    }
    static void integer_to_roman() {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {
                "M", "CM", "D", "CD", "C", "XC",
                "L", "XL", "X", "IX", "V", "IV", "I"
        };
        String res = "";
        int n = 1994;

        for (int i = 0; i < values.length && n > 0; i++) {
            {
                while (n>=values[i])
                {
                    res+=symbols[i];
                    n-= values[i];
                }
            }
            System.out.println(res);

        }
    }
    static void all_permutations_helper(int [] a ,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer>path,int index)
    {
        ans.add(new ArrayList<>(path));
        for(int i = index; i<a.length;i++)
        {
            if(i>index && a[i] == a[i-1]) continue;
            path.add(a[i]);
            all_permutations_helper(a,ans,path,i+1);
            path.remove(path.size()-1);
        }
//        all_permutations_helper(a,ans,path,index+1);
    }
    static void all_permutations_of_array()
    {
        int a [] = {1,2,3};
        String s = "abc";
        int n = a.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer>path = new ArrayList<>();
        all_permutations_helper(a,ans,path,0);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
//        for(int i = 1 ;i < n ;i ++)
//        {
//            for(int j = 0;j<=n-i;j++) {
//                System.out.println(s.substring(j, i + j));
//            }
//        }
    }
    static void next_permutation()
    {
        int [] v = {1,4,5,8,7};
        //6,9,8
        int n = v.length;
        int index_of_first = -1;
        int index_of_last = -1;
        for(int i = n-2;i>=0;i--)
        {
            if(v[i] < v[i+1])
            {
                index_of_first = i;
                break;
            }
        }
        if(index_of_first == -1)
        {
            reverse_array(v);
            return;
        }
        int last_index = 0;
        for(int i = n-1 ; i>=index_of_first;i++)
        {
            if(v[i] > v[index_of_first])
            {
                int temp = v[i] ;
                v[i] = v[index_of_first];
                v[index_of_first] = temp;
                break;
            }
        }
        int [] v1 = {1,2,3};
        ArrayList<Integer> test = new ArrayList<>();
        for(int a:v)
        {
            test.add(a);
        }

        List<Integer> sublist= test.subList(index_of_first+1,n);
        System.out.println(sublist);
        Collections.reverse(sublist);
        System.out.println(test.toString());
    }
static void longest_subarray_with_zero_sum()
{
    int [] v = {6, -2, 2, -8, 1, 7, 4, -10};
        //
    int n = v.length;
    int cursum  =0 ;
    int max_subarray_length = Integer.MIN_VALUE;
    Map<Integer,Integer> m = new HashMap<>();
    for(int i = 0 ; i<n;i++)
    {
        cursum += v[i];

        if(cursum == 0) {
            max_subarray_length = i + 1;
        }
        else{
            if(m.get(cursum) != null)
            {
                max_subarray_length = Math.max(max_subarray_length,i - m.get(i));
            }
            else{
                m.put(i,cursum);
            }

        }
    }
    System.out.println(m.entrySet());
    System.out.println(max_subarray_length);

}
public static void max_consecutive_one()
{
    int [] v= {0, 1, 1, 1, 0, 1};
    int maxi = 0;
    int count = 0;
    for(int i =1 ;i<v.length;i++)
    {
        if(v[i] == 1 )
        {
            count+=1;
            maxi = Math.max(maxi,count);
        }
        else{
            count = 0;
        }

    }
    System.out.println(maxi);
//    int ans = Arrays.stream(v).max().getAsInt();
//    System.out.println(Arrays.toString(v));
}
public static void swap(int [] v ,int i, int j )
{
    int temp = v[i];
    v[i] = v[j];
    v[j] =temp;
    return;
}
static void sort_an_array_of_ones_zeros_two()
{
    int  [] v ={2,1,2,0,1,0};
    int low = 0,mid = 0 , high =v.length-1;
    //
    //0,1,1,0,2,2
    //0,1mid,1low,0high,2,2

    while(mid<=high)
    {
        if(v[mid] == 2)
        {
           swap(v,mid,high);
           high-=1;
        }
        else if(v[mid] == 0)
        {
            swap(v,low,mid);
            low+=1;
            mid+=1;
        }
        else if(v[mid] == 1){
            mid+=1;
        }
    }
    System.out.println(Arrays.toString(v));
}
public static void word_break()
{
    String s = "catcaaats";
    int n = s.length();
    List<String> wordDict = new ArrayList<>(Arrays.asList("cat","cats"));
    boolean [] dp = new boolean[s.length()+1];
    dp[s.length()] = true;
    for(int i = n-1;i>=0;i--)
    {
        for(String w : wordDict)
        {
            int length_of_word = w.length();
            if(i+ length_of_word <= s.length() && (s.substring(i,i+length_of_word).equals(w)))
            {
                dp[i] = dp[i+w.length()];
            }
            if (dp[i])
                break;
        }
    }
    System.out.println(Arrays.toString(dp));



}
public static void largest_area_in_histogram()
{
    int [] v ={2,1,5,6,2,3};


//    int max_ans = Integer.MIN_VALUE;
//    for(int i = 0; i<v.length;i++)
//    {
//        int mini = Integer.MAX_VALUE;
//        for(int j = i;j<v.length;j++)
//        {
//            mini = Math.min(mini,v[j]);
//            max_ans = Math.max(max_ans,(j-i+1) * mini);
//        }
//    }
//    System.out.println(max_ans);


}
static void sliding_window_maximum()
{
    int [] v = {1,4,0,-1,3,5,3,6,8};
    PriorityQueue<Integer> q =new PriorityQueue<>(Collections.reverseOrder());
    for(Integer a : v)
    {
        q.add(a);
    }
    int k = 3;
    ArrayList<Integer>ans = new ArrayList<>();
    int first_element = v[0];
    q.add(first_element);
    int index_of_last_element = 0;
    for(int i =1 ;i<v.length;i++)
    {
        if(q.size() == k)
        {
            int element_to_be_added = q.peek();
           ans.add(element_to_be_added);
           index_of_last_element+=1;
           first_element = v[index_of_last_element];
           q.remove(first_element);
        }
        q.add(v[i]);

    }
    System.out.println(ans.toString());
}
public static void zigzag_traversal()
{
    TreeNode head = new TreeNode(3);
    head.left = new TreeNode(9);
    head.right = new TreeNode(20);
    head.right.left = new TreeNode(15);
    head.right.right = new TreeNode(7);
    boolean flag= false;
    ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
    Queue<Queue_pair> q = new LinkedList<>();
    q.add(new Queue_pair(head,0));
    Map<Integer,ArrayList<Integer>>m = new HashMap<>();
    while(!q.isEmpty())
    {
        Queue_pair p = q.poll();
        TreeNode headnode=  p.t;
        int level = p.level;
        m.putIfAbsent(level, new ArrayList<>());

        // Determine zigzag direction based on level parity
        if (level % 2 == 0) {
            m.get(level).add(headnode.data); // Left to Right
        } else {
            System.out.println(m.entrySet());
            m.get(level).add(0, headnode.data); // Right to Left (insert at front)
        }

        if (headnode.left != null)
            q.add(new Queue_pair(headnode.left, level + 1));
        if (headnode.right != null)
            q.add(new Queue_pair(headnode.right, level + 1));
    }
    System.out.println(m.entrySet());

}
public static boolean search_in_bst(TreeNode head)
{
    int m = Integer.MIN_VALUE
}
    public static void main(String[] args) {

//        int max = Arrays.stream(v).max().getAsInt();
//
            //        graphsChecking();
//        ArrayList<int[]> list = new ArrayList<>(List.of(v));
//        Integer[] arr = list.toArray(new Integer[0]);


    }
}
