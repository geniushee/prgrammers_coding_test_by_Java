import java.util.*;import java.util.stream.*;


class Solution {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        answer = Arrays.stream(str_list).filter(str -> !str.contains(ex)).collect(Collectors.joining());
        return answer;
    }
}