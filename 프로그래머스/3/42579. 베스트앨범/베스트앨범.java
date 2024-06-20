import java.util.*;
import java.util.stream.Collectors;

class Genres{
    private String name;
    private List<Integer[]> songs = new ArrayList<>();
    private int total = 0;
    
    public Genres(String name){
        this.name = name;
    }
    
    public String getName(){return this.name;}
    public int getTotal(){return this.total;}
    public List<Integer[]> getSongs(){return this.songs;}
    public void setSongs(int song, int count){
        this.total += count;
        Integer[] arr = {song, count};
        songs.add(arr);
        Collections.sort(songs, new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] a, Integer[] b){
                return b[1] - a[1];
            }
        });
        if(songs.size() > 2){
            songs.remove(2);
        }
    }
    
    @Override
    public String toString(){
        String s = "";
        for(Integer[] song : songs){
            s += Arrays.toString(song);
        }
        return "장르 : " + this.name + "\n총 플레이 수 : "+ this.total + "\n노래 순서 : " + s;
    }
    
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genres> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            String g = genres[i];
            if(!map.containsKey(g)){
                map.put(g, new Genres(g));
            }
            map.get(g).setSongs(i, plays[i]);
        }
        
        List<Genres> zip = map.values().stream().collect(Collectors.toList());
        
        Collections.sort(zip, new Comparator<Genres>(){
            @Override
            public int compare(Genres a, Genres b){
                return b.getTotal() - a.getTotal();
            }
        });
        List<Integer> last = new ArrayList<>();
        for(Genres g : zip){
            for(Integer[] arr : g.getSongs()){
                last.add(arr[0]);
            }
        }
        int[] answer = last.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}