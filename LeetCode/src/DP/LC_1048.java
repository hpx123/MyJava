package DP;

public class LC_1048 {
    public static void main(String[] args) {
//        Question qu = new Question();
//        String[] words = {"a","b","ba","bca","bda","bdca"};
//        System.out.println(qu.longestStrChain(words));
        String a = "abc";
        String b = "ab";
        System.out.println(a.contains(b));
    }
}

//class Question {
//    public int longestStrChain(String[] words) {
//        int len = words.length;
//        int[] dp = new int[1000];
//        int i = 0, j = 0, max = -1;
//        for(i = 0; i < len; i++){
//            dp[i] = 1;
//            for(j = 0; j < i; j++){
//                if(words[i].contains(words[j]) && dp[j] + 1 > dp[i]){
//                    dp[i] = dp[j] + 1;
//                    if(dp[i] > max){
//                        max = dp[i];
//                    }
//                }
//            }
//            System.out.println(dp[i]);
//        }
//        return max;
//    }
//}
