import java.io.*;
import java.util.*;

public class BJ16401 {

    private static int N, M;
    private static int[] L;
    private static boolean Check(int mid){
        long cnt = 0;

        for (int i = 0; i < L.length; i++) {
            // 중앙값으로 과자의 길이를 나누어 나오는 갯수 파악
            cnt += L[i] / mid;
        }

        return cnt >= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 조카 수
        N = Integer.parseInt(st.nextToken()); // 과자 수
        L = new int[N]; // 과자의 길이를 담을 배열
        st = new StringTokenizer(br.readLine());
        int max = Integer.MAX_VALUE; // 길이 최대값
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        builder.append(binarySearch(0, max));
        System.out.println(builder);
    }

    public static int binarySearch(int left, int right) {
//        int result = 0;
//        System.out.println("left : " + left + " right : " + right);
        while (left + 1 < right) {
            int mid =  (left + right) / 2;
//            System.out.println("mid : " + mid);
            // 현재 값
            if (Check(mid)) {
                // 위에서 나눈 갯수가 조키수보다 같거나 많을 경우
                left = mid;
            } else {
                right = mid;
            }
//            System.out.println("result : " + result + 1);
        }
        return left;
    }
}