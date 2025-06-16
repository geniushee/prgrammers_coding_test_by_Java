import java.io.*;
public class Main{
    private static int[] arr;
    private static int front;
    private static int end;
    private static String[] commands;
    private static boolean asc;
    private static boolean err;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i< count;i++){
            // 초기화
            err = false;
            for(int j = 0; j<3;j++){
                switch (j){
                    case 0 -> commands = br.readLine().split("");
                    case 1 ->  {
                        asc = true;
                        front = 0;
                        end = Integer.parseInt(br.readLine()) - 1;
                        if(end < 0){
                            break;
                        }
                    }
                    case 2 -> arr = stringToArray(br.readLine());
                }
            }

            // 명령어 실행
            int idx = 0;
            while(idx < commands.length){
                if(commands[idx++].equals("D")){
                    // 정순/역순
                    if(asc){
                        if(front <= end){
                            front++;
                        }else{
                            // 제거 에러
                            bw.write("error\n");
                            err = true;
                            break;
                        }
                    }else{
                        if(front >= end){
                            front--;
                        }else{
                            // 제거 에러
                            bw.write("error\n");
                            err = true;
                            break;
                        }
                    }
                }else{
                    // R은 정역 바꾸기
                    swap();
                }
            }

            // 에러 났으면 다음
            if(err){
                continue;
            }

            // 에러 안 났으니 배열 프린팅
            String answer = getStringOfArray().toString();
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
    
    
    private static StringBuilder getStringOfArray() {
        StringBuilder answer = new StringBuilder("[");

        if(asc){
            for(int j = front;j<=end;j++){
                answer.append(arr[j]);
                if(j < end){
                    answer.append(",");
                }
            }
        }else{
            for(int j = front;j>=end;j--){
                answer.append(arr[j]);
                if(j > end){
                    answer.append(",");
                }
            }
        }
        answer.append("]");
        return answer;
    }

    public static int[] stringToArray(String str){
        str = str.replace("[", "");
        str = str.replace("]", "");
        String[] strArr = str.split(",");
        int[] result = new int[strArr.length];
        if(!str.isBlank()){
            for(int i = 0; i < strArr.length;i++){
                result[i] = Integer.parseInt(strArr[i]);
            }
        }
        return result;
    }

    public static void swap(){
        int temp = front;
        front = end;
        end = temp;
        asc = !asc;
    }
}