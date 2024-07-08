import java.util.*;
import java.util.stream.*;
class Solution {
    // 작업 소요시간이 짧은 것을 우선으로 정렬
    class Work extends Object{
        private Integer startTime;
        private Integer workTime;
        
        public Work(int start, int work){
            this.startTime = start;
            this.workTime = work;
        }
        
        public Integer getStartTime(){
            return this.startTime;
        }
        
        public Integer getWorkTime(){
            return this.workTime;
        }
        
        @Override
        public String toString(){
            return "시작시간 : " + startTime + ", 소요시간 : " + workTime;
        }
    }
    
    public int solution(int[][] jobs) {
        int res = 0;
        int len = jobs.length;
        
        List<Work> works = Arrays.stream(jobs).map(job -> new Work(job[0], job[1])).collect(Collectors.toList());
        Collections.sort(works, new Comparator<Work>(){
            @Override
            public int compare(Work work1, Work work2){
                return work1.getStartTime() - work2.getStartTime();
            }
        });
        // System.out.println(works.toString());
        
        PriorityQueue<Work> waits = new PriorityQueue<>(new Comparator<Work>(){
            @Override
            public int compare(Work work1, Work work2){
                return work1.getWorkTime() - work2.getWorkTime();
            }
        });
        
        int clock = 0;
        int working = 0;
        int complete= 0;
        
        while(true){
            // System.out.println("1. 시간 : " + clock +", 작업중 : "+working+ ", 완료 : "+complete+ ", 대기 : " + waits.toString());
            if(works.size() > 0 && waits.size() == 0){
                Work a = works.get(0);
                works.remove(0);
                waits.add(a);
                if(a.getStartTime() > clock){
                    clock += (a.getStartTime() - clock);
                }
                // System.out.println("waits 크기 : " + waits.size() + ", " + a.toString());
            }

            while(works.size() > 0 && works.get(0).getStartTime() <= clock){
                waits.add(works.get(0));
                works.remove(0);
                // System.out.println("waits 크기 : " + waits.size());
            }
            
            if(waits.size() > 0){
                Work b = waits.poll();
                // System.out.println("제거 : " + b.toString());
                clock += b.getWorkTime();
                complete++;
                res += (clock - b.getStartTime());
                // System.out.println("res : " + res);
            }          
            
            // System.out.println("2. 시간 : " + clock +", 작업중 : "+working+ ", 완료 : "+complete+ ", 대기 : " + waits.toString());
            
            if(complete == len){
                // System.out.println("완료");
                break;
            }

        }
        
        return res / len;
    }
}