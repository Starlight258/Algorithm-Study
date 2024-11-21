import java.util.*;
import java.util.regex.*;

class Solution {
    private String URL_REGEX = "<meta property=\"og:url\" content=\"(.*?)\"/>";
    private String BODY_REGEX = "<body>([\\s\\S]*?)<\\/body>";
    private String LINK_REGEX = "<a href=\"([\\w\\W]*?)\">[\\s\\S]*?<\\/a>";
    public int solution(String word, String[] pages) {
        int answer = 0;
        List<String> urls = new ArrayList<>();
        Map<String, Double> defaultScores = new HashMap<>();
        List<Double> linkScores = new ArrayList<>();
        List<List<String>> outSources = new ArrayList<>();

        String wordRegex = "(?<=[^a-zA-Z]|^)"+word+"(?=[^a-zA-Z]|$)";
        Pattern urlPattern = Pattern.compile(URL_REGEX);
        Pattern bodyPattern = Pattern.compile(BODY_REGEX);
        Pattern linkPattern = Pattern.compile(LINK_REGEX);
        Pattern wordPattern = Pattern.compile(wordRegex, Pattern.CASE_INSENSITIVE);

        for (int i=0;i<pages.length;i++){
            String page = pages[i];
            // url 저장
            String url = "";
            Matcher urlMatcher = urlPattern.matcher(page);   
            while (urlMatcher.find()){
                url = urlMatcher.group(1);
                urls.add(url);
            }
            
            Matcher bodyMatcher = bodyPattern.matcher(page);   
            String body = "";
            while (bodyMatcher.find()){
                body = bodyMatcher.group(1);
            }
            // 외부 연결된 링크 저장하기
            List<String> outSource = new ArrayList<>();
            Matcher linkMatcher = linkPattern.matcher(body);
            while (linkMatcher.find()){
                outSource.add(linkMatcher.group(1));
            }
            outSources.add(outSource);
            body = body.replaceAll(LINK_REGEX, "").trim(); 
            
            // 기본 점수 구하기
            double defaultScore = 0;
            Matcher wordMatcher = wordPattern.matcher(body);
            while (wordMatcher.find()){
                defaultScore++;
            }
            defaultScores.put(url, defaultScore);
            double linkScore = outSource.size()==0?0.0:defaultScore / outSource.size();
            linkScores.add(linkScore);
        }
        
        // 링크 점수 더하기
        for (int i=0;i<pages.length;i++){
            List<String> outSource = outSources.get(i);
            double linkScore = linkScores.get(i);
            for (String each:outSource){
                // 외부 링크의 인덱스 구하기
                Double score = defaultScores.getOrDefault(each, -1.0);
                if (score==-1.0) continue;
                defaultScores.put(each, defaultScores.getOrDefault(each, 0.0)+ linkScore);
            }
        }
        // 가장 높은 점수 구하기
        List<Double> scores = new ArrayList<>(defaultScores.values());
        Double maxScore = 0.0;
        // 가장 높은 점수를 가진 index 가장 적은 점수 구하기
        for (int index=0;index<urls.size();index++){
            String url = urls.get(index);
            Double score = defaultScores.get(url);
            if (maxScore<score){
                maxScore = score;
                answer = index;
            }
        }
        
        return answer;
    }
}