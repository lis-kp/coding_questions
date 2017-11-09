import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {
	public String replaceWords(List<String> dict, String sentence) {
        Set<String> set = new HashSet<String>();
        
        set.addAll(dict);
        
        String words[] = sentence.split(" ");
        
        String result = "";
        
        for (int i = 0; i< words.length;i++){
            for(int j = 0;j<words[i].length(); j++){
                if (set.contains(words[i].substring(0, j+1))){
                    words[i] = words[i].substring(0, j+1);
                }
            }
        }
        
        for (int i =0; i< words.length;i++){
            result += words[i] +" ";
        }
        
        return result.trim();
    }
}