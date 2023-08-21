package 나무_자르기;

import java.io.*;
import java.util.*;

public class BJ2805 {

    private static int N;
    private static long M;
    private static long[] arr;


    private static boolean Check(int mid){
        long sum = 0;

        // mid 절단기
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > mid) sum += arr[i] - mid;
        }

//        System.out.println("sum : " + sum);

        return sum >= M;
    }
    private static long binarySearch(){
        int low = 0;
        int high = Integer.MAX_VALUE;

        while(low + 1 < high){
            int mid = (low + high) / 2;
            if(Check(mid)) low = mid;
            else high = mid;
        }

//        System.out.println("low : " + low + " high : " + high);
        return low;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Long.parseLong(tokenizer.nextToken());

        arr = new long[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++){
            long input = Long.parseLong(tokenizer.nextToken());
            arr[i] = input;
        }
        Arrays.sort(arr);

        System.out.println(binarySearch());

        reader.close();
    }
}
