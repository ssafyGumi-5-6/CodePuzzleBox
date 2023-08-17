package n진수_게임;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder builder = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < (t * m); i++){
            String s = Integer.toString(i, n);
            builder.append(s);
        }

        for(int i = 0; i < t; i++){
            answer.append(builder.toString().charAt(p - 1 + (i * m)));
        }

        return answer.toString().toUpperCase();
    }
}
