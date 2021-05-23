import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
O sistema de abreviações é simples e funciona da seguinte forma:
para cada letra, é possível escolher uma palavra que inicia com tal letra e que aparece no post.
Uma vez escolhida a palavra, sempre que ela aparecer no post, ela será substituída por sua letra inicial e um ponto, diminuindo assim o número de caracteres impressos na tela.

Por exemplo, na frase: “hoje eu programei em Python”, podemos escolher a palavra “programei” para representar a letra ‘p',
e a frase ficará assim: “hoje eu p. em Python”, economizando assim sete caracteres. Uma mesma palavra pode aparecer mais de uma vez no texto,
e será abreviada todas as vezes. Note que, se após uma abreviação o número de caracteres não diminuir, ela não deve ser usada, tal como no caso da palavra “eu” acima.

Para cada letra, escolha uma palavra, de modo que ao serem aplicadas todas as abreviações, o texto contenha o menor número de caracteres possíveis.

Saída
Para cada caso de teste, imprima uma linha contendo a frase já com as abreviações escolhidas e aplicadas.

Em seguida, imprima um inteiro N, indicando o número de palavras em que foram escolhidas uma letra para a abreviação no texto.
Nas próximas N linhas, imprima o seguinte padrão “C. = P”, onde C é a letra inicial e P é a palavra escolhida para tal letra. As linhas devem ser impressas em ordem crescente da letra inicial.
 */
public class AbreviandoPostsDoBlog {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String phrase = br.readLine();
        while(!(".").equals(phrase)) {
            List<String> listOfWords = Arrays.asList(phrase.split(" "));
            Map<Character, String> abbreviatedWords = new HashMap<>();
            for (String word : listOfWords) {
                if (word.isEmpty()) continue;
                char firstLetter = word.charAt(0);
                if (word.length() > 2) {
                    if (abbreviatedWords.isEmpty() || !abbreviatedWords.containsKey(firstLetter)) {
                        abbreviatedWords.put(firstLetter, word);
                    } else if (abbreviatedWords.containsKey(firstLetter) && (!abbreviatedWords.get(firstLetter).equals(word))) {
                        String wordsOnTheMap = abbreviatedWords.get(firstLetter);
                        if (digitsAdvantages(word, listOfWords) > digitsAdvantages(wordsOnTheMap, listOfWords)) {
                            abbreviatedWords.replace(firstLetter, word);
                        }
                    }
                }
            }

            for (int i = 0; i < listOfWords.size(); i++) {
                String word = listOfWords.get(i);
                if(word.isEmpty()) continue;
                char firstLetter = word.charAt(0);
                if ((word).equals(abbreviatedWords.get(firstLetter)))listOfWords.set(i, firstLetter + ".");

            }

            System.out.println(listOfWords.toString().replaceAll("[^a-zA-Z0-9. ]", ""));
            System.out.println(abbreviatedWords.size());
            abbreviatedWords.keySet().stream().sorted().forEach(
                    abbreviation -> System.out.println(abbreviation + ". = " + abbreviatedWords.get(abbreviation)));
            phrase = br.readLine();
        }
    }

    public static long digitsAdvantages (String word, List<String> stringList){
        long appearances = 0;
        for (String str: stringList) {
            if(str.equals(word))appearances++;
        }
        return (word.length() - 2) * appearances ;
    }
}
