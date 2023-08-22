package 입국심사;

import java.io.*;
import java.util.*;

public class BJ3079 {

    private static long[] arr;
    private static int N, M;

    private static boolean Check(long mid){
        long people = 0;
        for(int i = 0 ; i < arr.length; i++){
            people += mid / arr[i];

            if(people >= M) return false;
        }
//        System.out.println("people : " + people);
        return true;
    }
    private static long binarySearch(){
        long low = 0L;
        long high = arr[arr.length - 1] * M;
        while(low + 1 < high){
            long mid = (low + high) / 2;
//            System.out.println("mid : " + mid);
            if(Check(mid)) low = mid;
            else high = mid;
        }
//        System.out.println("low : " + low + " high : " + high);
        return high;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        arr = new long[N];
        for(int i = 0 ; i < N; i++){
            long num = Long.parseLong(reader.readLine());
            arr[i] = num;
        }
        Arrays.sort(arr);
        System.out.println(binarySearch());

        reader.close();
    }
}
