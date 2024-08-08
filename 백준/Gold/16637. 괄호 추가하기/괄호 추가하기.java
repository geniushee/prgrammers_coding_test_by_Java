import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        System.out.println("""
//                문제풀이 시작
//                -------------------""");
//
//        String[] arr = new String[]{"3+8*7-9*2","8*3+5","8*3+5+2","1*2+3*4*5-6*7*8*9*0","1*2+3*4*5-6*7*8*9*9","1-9-1-9-1-9-1-9-1-9"};
//        int[] answers = new int[]{136,64,66,0,426384,24};

        // 연산할 함수 호출
//        for(int i = 0; i < arr.length; i++){
            // 시작 시간 기록
//            long startTime = System.nanoTime();
//            int answer = SamsungA.addBracket(arr[i]);
//
//            // 종료 시간 기록
//            long endTime = System.nanoTime();
//
//            // 연산 시간 계산 (나노초 단위)
//            long duration = endTime - startTime;
//
//            // 나노초 단위를 밀리초 단위로 변환
//            double milliseconds = duration / 1_000_000.0;
//
//            System.out.println("연산 시간: " + duration + " 나노초");
//            System.out.println("연산 시간: " + milliseconds + " 밀리초");
//
//            System.out.println("문제 :" + arr[i]);
//            System.out.println("답안 :" + answer);
//
//            System.out.println("정답? " + (answer == answers[i]));
//        }

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String arg = sc.next();
        int answer = SamsungA.addBracket(a, arg);
        System.out.println(answer);

    }


    public static class SamsungA {

        public static int addBracket(int length, String formula) {
            if(length == 1){
                return Integer.parseInt(formula);
            }
            
            String[] elements = formula.split("");

            res.clear();
            pointer.clear();

            per(elements.length);
//            System.out.println(res.size());
//            System.out.println(res);

            List<Integer> answer = new ArrayList<>();

            for (List<Integer> order : res) {
                String[] temp = Arrays.copyOf(elements, elements.length);
                while (order.size() > 0) {
                    Integer start = order.remove(0);
                    temp = calOneSet(temp, start - 1);
                    order = order.stream()
                            .map(integer -> {
                                if (integer > start) {
                                    return integer - 2;
                                }
                                return integer;
                            })
                            .collect(Collectors.toList());
//                System.out.println(order);
                }
                answer.add(Integer.parseInt(temp[0]));
            }
//        System.out.println("답 후보" + answer);
            return Collections.max(answer);
        }

        private static int cal(String e1, String e2, String e3) {
            int res = 0;
            switch (e2) {
                case "+" -> res = Integer.parseInt(e1) + Integer.parseInt(e3);
                case "-" -> res = Integer.parseInt(e1) - Integer.parseInt(e3);
                case "*" -> res = Integer.parseInt(e1) * Integer.parseInt(e3);
            }
            return res;
        }

        private static String[] calOneSet(String[] arr, int startIdx) {
            if (startIdx + 2 >= arr.length) {
                return arr;
            }

            int res = cal(arr[startIdx], arr[startIdx + 1], arr[startIdx + 2]);

            arr[startIdx] = String.valueOf(res);

            String[] newOne = new String[arr.length - 2];

            int i = 0;
            int j = 0;
            while (j < newOne.length) {
                newOne[j++] = arr[i++];
                if (i == startIdx + 1) {
                    i += 2;
                }
            }

            return newOne;
        }

        static List<Integer> pointer = new ArrayList<>();

        static List<List<Integer>> res = new ArrayList<>();

        public static void per(int num) {
            // 초기 nums 배열 설정
            Integer[] nums = new Integer[num / 2];

            for (int i = 0; i < nums.length; i++) {
                nums[i] = 1 + i * 2;
            }
//        System.out.println("nums : " + Arrays.toString(nums));

            List<Integer> current = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                current.add(nums[i]);
                pointer.add(i);
                boolean left = false;
                boolean right = false;
                if(i - 1 >= 0){
                    pointer.add(i-1);
                    left = true;
                }
                if(i + 1 < nums.length){
                    pointer.add(i+1);
                    right = true;
                }
                newCurrent(nums.length, i, nums, current);
                current.remove(nums[i]);
                pointer.remove(Integer.valueOf(i));
                if(i - 1 > 0 && left){
                    pointer.remove(Integer.valueOf(i-1));
                }
                if(i + 1 < nums.length && right){
                    pointer.remove(Integer.valueOf(i+1));
                }
            }
        }

        private static void newCurrent(int max, Integer cur, Integer[] nums, List<Integer> current) {
            List<Integer> temp = new ArrayList<>(current);
            if(temp.size() != max){
                Arrays.stream(nums).filter(num -> !current.contains(num)).forEach(temp::add);
            }
            res.add(new ArrayList<>(temp));

            if (pointer.size() == max) {
                return;
            }

            for (int i = 0; i < max; i++) {
                if (pointer.contains(Integer.valueOf(i))) {
                    continue;
                }
                current.add(nums[i]);
                pointer.add(i);
                boolean left = false;
                boolean right = false;
                if(i -1 > 0 && !pointer.contains(Integer.valueOf(i-1))){
                    pointer.add(i-1);
                    left = true;
                }
                if(i + 1 < nums.length && !pointer.contains(Integer.valueOf(i+1))){
                    pointer.add(i+1);
                    right = true;
                }
                newCurrent(max, i, nums, current);

                current.remove(nums[i]);
                pointer.remove(Integer.valueOf(i));
                if(i -1 > 0 && left){
                    pointer.remove(Integer.valueOf(i-1));
                }
                if(i + 1 < nums.length && right){
                    pointer.remove(Integer.valueOf(i+1));
                }
            }
        }
    }

}

