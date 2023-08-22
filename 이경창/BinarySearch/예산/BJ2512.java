package 예산;

import java.io.*;
import java.util.*;

public class BJ2512 {

    private static int N;
    private static long M;
    private static int[] arr;

    private static boolean Check(int mid){
        // mid가 있을 건데
        // mid보다 작은 것은 빼줌
        // mid값보다 큰 것은 mid로 처리
        long sum = 0;
        for(int i = 0; i < N; i++){
//            System.out.print("arr[i] : " + arr[i] + " ");
            if(mid >= arr[i]) sum += arr[i];
            else sum += mid;
        }
//        System.out.println();
//        System.out.println("sum : " + sum + " mid : " + mid + " M : " + M);

        // 총합이 M보다 크거나 같은 경우
        return sum <= M;
    }
    private static int binarySearch(){
        long sum = 0;
        for(int inArr : arr) sum += inArr;
        if(sum <= M) return arr[arr.length - 1];

        int low = 1;
        int high = arr[arr.length - 1];

        while(low + 1 < high){
            int mid = (low + high) / 2;

            if(Check(mid)) low = mid;
            else high = mid;
        }

        return low;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        M = Long.parseLong(reader.readLine());

        Arrays.sort(arr);
        System.out.println(binarySearch());

        reader.close();
    }
}
