import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class EntrevistaEmbaracosa {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.lines().forEach( word -> {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                String substring = word.substring(i, length);
                if(word.replaceFirst(substring, "").contains(substring)){
                    word = word.replaceFirst(substring,"");
                    break;
                }
            }
            System.out.println(word);
        });
        br.close();
    }
}
