package 할인_행사;

import java.util.*;

class Solution {

    private boolean checkMapDiscount(String[] want, int[] number, Map<String, Integer> map){

        for(int i = 0; i < want.length; i++){
            if(map.getOrDefault(want[i], -1) == number[i]) continue;
            else return false;
        }

        return true;
    }

    private void printMap(Map<String, Integer> map){
        for(String s : map.keySet()){
            System.out.print("[" + s + ": " + map.get(s) + "]");
        }
        System.out.println();
    }

    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> mapDiscount = new HashMap<>();
        int answer = 0;

        for(int i = 0; i < discount.length; i++){
            if(i < 10){
                mapDiscount.putIfAbsent(discount[i], 0);
                mapDiscount.put(discount[i], mapDiscount.get(discount[i]) + 1);

                // 10번째 들어갔을 때 확인하는 곳
                if(i == 9 && checkMapDiscount(want, number, mapDiscount)){
                    answer += 1;
                }
            }
            else{
                // 11개차례가 되었을 때부터 확인한다.
                // System.out.println("현재 인덱스 : " + i + "새로 들어온 데이터 : " + discount[i - 10]);

                // i를 넣어주고, i - 10을 빼주면 될듯
                mapDiscount.putIfAbsent(discount[i], 0);
                mapDiscount.put(discount[i], mapDiscount.get(discount[i]) + 1);

                // i - 10인 것 무조건 들어가 있는 상황
                mapDiscount.put(discount[i - 10], mapDiscount.get(discount[i - 10]) - 1);

                // 확인하는 곳
                if(checkMapDiscount(want, number, mapDiscount)){
                    answer += 1;
                }

            }
        }

        return answer;
    }
}