//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ConjuntosBonsOuRuins {
//    public static <StringTokenizer> void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        List<String> group = new ArrayList<>();
//        boolean isBadGroup = false;
//        String number = br.readLine();
//        String word = "";
//        while (!("0").equals(word)){
//            for(int i = 1; i <= Integer.parseInt(number); i ++){
//                String lambdaWord = br.readLine();
//                word = lambdaWord;
//                if(group.contains(word) || group.stream().anyMatch(currentWord -> currentWord.contains(lambdaWord)))isBadGroup=true;
//                group.add(word);
//            }
//            if (!isBadGroup) {
//                for (String wordGroup : group) {
//                    if (group.stream().anyMatch(currentWord -> (currentWord.contains(wordGroup) && !currentWord.equals(wordGroup)))){
//                        isBadGroup = true;
//                        break;
//                    }
//                }
//            if (isBadGroup){
//                System.out.println("Conjunto Ruim");
//            }
//            else {
//                System.out.println("Conjunto Bom");
//            }
//            if(word.matches("-?\\d+"))number = word;
//            group.clear();
//            isBadGroup = false;
//            }
//        }
//        br.close();
//    }
//}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConjuntosBonsOuRuins {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> group = new ArrayList<>();
        boolean isBadGroup = false;
        String word = br.readLine();
        while (!("0").equals(word)){
            word = br.readLine();
            if (!word.matches("-?\\d+")){
                String lambdaWord = word;
                if(group.contains(word) || group.stream().anyMatch(currentWord -> currentWord.contains(lambdaWord)))isBadGroup=true;
                group.add(word);
            }else{
                if (!isBadGroup) {
                    for (String wordGroup : group) {
                        if (group.stream().anyMatch(currentWord -> (currentWord.contains(wordGroup) && !currentWord.equals(wordGroup)))){
                            isBadGroup = true;
                            break;
                        }
                    }
                }
                if (isBadGroup) System.out.println("Conjunto Ruim");
                else System.out.println("Conjunto Bom");
                group.clear();
                isBadGroup = false;
            }
        }
    }
}

