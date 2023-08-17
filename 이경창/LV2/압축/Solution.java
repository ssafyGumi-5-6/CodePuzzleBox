package 압축;

import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {

        char[] cArr = msg.toCharArray();

        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < 26; i ++){
            char c = (char)('A' + i);
            map.put(String.valueOf(c), (i + 1));
        }

        int nextNumber = 27;
        int printNumber = 0;
        for(int i = 0; i < cArr.length;){

            StringBuilder builder = new StringBuilder(String.valueOf(cArr[i]));
            int index = i + 1;
            printNumber = map.get(builder.toString());

            while(index < cArr.length){
                builder.append(String.valueOf(cArr[index]));
                // System.out.println(builder + " " + map.getOrDefault(builder.toString(), 0));
                if(map.getOrDefault(builder.toString(), 0) == 0){
                    map.put(builder.toString(), nextNumber++);
                    break;
                }else{
                    index += 1;
                    printNumber = map.get(builder.toString());
                }
            }
            i = index;

            answer.add(printNumber);
        }

        return answer;
    }
}
