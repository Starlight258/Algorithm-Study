import java.util.*;
class Solution {
    class Pair implements Comparable<Pair>{
        int idx;
        String songName;
        int songTime;
        Pair(int idx, String songName, int songTime){
            this.idx = idx;
            this.songName = songName;
            this.songTime = songTime;
        }
        
        public int compareTo(Pair p){
            if (this.songTime == p.songTime) {
                return this.idx - p.idx;
            }
            return p.songTime - this.songTime;
        }
        
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        ArrayList<Pair> answerList = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();
        hm.put("C", "0"); hm.put("C#", "1"); hm.put("D", "2"); hm.put("D#", "3");
        hm.put("E", "4"); hm.put("F", "5"); hm.put("F#", "6"); hm.put("G", "7");
        hm.put("G#", "8"); hm.put("A", "9"); hm.put("A#", "!"); hm.put("B", "?");
        hm.put("B#", "$");
        StringBuilder mm = new StringBuilder("");
        for (int j=0;j<m.length();j++){
            if (j!= m.length()-1 && m.charAt(j+1) == '#'){
                mm.append(hm.get(m.substring(j, j+2) + ""));
                j++;
            }
            else mm.append(hm.get(m.charAt(j) + ""));
        }
        
        for (int i=0;i<musicinfos.length;i++){
            String musicInfo = musicinfos[i];
            String[] info = musicInfo.split(",");
            int startHour = Integer.parseInt(info[0].substring(0,2));
            int startMinute = Integer.parseInt(info[0].substring(3,5));
            int endHour = Integer.parseInt(info[1].substring(0,2));
            int endMinute = Integer.parseInt(info[1].substring(3,5));
            int time = (endHour - startHour) * 60 + (endMinute - startMinute);
            String songName = info[2];
            String melodyInput = info[3];
            StringBuilder melody = new StringBuilder("");
            for (int j=0;j<melodyInput.length();j++){
                if (j!= melodyInput.length()-1 && melodyInput.charAt(j+1) == '#'){
                    melody.append(hm.get(melodyInput.substring(j, j+2) + ""));
                    j++;
                }
                else melody.append(hm.get(melodyInput.charAt(j) + ""));
            }
            StringBuilder music = new StringBuilder("");
            for (int j=0;j<time/melody.length();j++){
                music.append(melody);
            }
            if (time % melody.length() != 0){
                music.append(melody.substring(0, time%melody.length()+1));
            }
            if (music.toString().contains(mm)){
                answerList.add(new Pair(i, songName, time));
            }
        }
        Collections.sort(answerList);
        if (answerList.isEmpty()) return "(None)";
        return answerList.get(0).songName;
    }
}