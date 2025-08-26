import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> dictionary = new HashMap<>();
        try {
            try (BufferedReader dictionaryReader = Files.newBufferedReader(Path.of("dictionary.txt"), StandardCharsets.UTF_8)) {
                String line;
                Pattern pattern = Pattern.compile("^([a-zA-Z]+(?:[\\s-][a-zA-Z]+)*)\\s\\|\\s((?:[а-яА-Я]+[\\s-])*[а-яА-Я]+)$");
                while ((line = dictionaryReader.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        dictionary.put(matcher.group(1).toLowerCase(Locale.ROOT), matcher.group(2));
                    } else {
                        throw new InvalidFileFormatException("Incorrect dictionary format (allowed \"word or expression | translation\"):" + line);
                    }
                }
            } catch (FileNotFoundException e) {
                throw new FileReadException("The file does not exist, there is no access to the file, etc");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileReadException e) {
            e.printStackTrace();
        }
        try {
            try (BufferedReader untranslatedReader = Files.newBufferedReader(Path.of("untranslated.txt"))) {
                String line;
                while ((line = untranslatedReader.readLine()) != null) {
                    StringBuilder translatedPhrase = new StringBuilder();
                    String untranslatedPhrase = line;
                    int charsPassed = 0;
                    while (!untranslatedPhrase.isEmpty()) {
                        int lastSpaceIndex;
                        String testPhrase = dictionary.getOrDefault(untranslatedPhrase.toLowerCase(Locale.ROOT), "");
                        while (testPhrase.isEmpty()) {
                            lastSpaceIndex = untranslatedPhrase.lastIndexOf(' ');
                            if (lastSpaceIndex == -1 || lastSpaceIndex == 0) {
                                if (lastSpaceIndex == 0) {
                                    untranslatedPhrase = " ";
                                }
                                testPhrase = untranslatedPhrase;
                                break;
                            }
                            untranslatedPhrase = untranslatedPhrase.substring(0, lastSpaceIndex);
                            testPhrase = dictionary.getOrDefault(untranslatedPhrase.toLowerCase(Locale.ROOT), "");
                        }
                        translatedPhrase.append(testPhrase);
                        charsPassed += untranslatedPhrase.length();
                        untranslatedPhrase = line.substring(charsPassed);
                    }
                    System.out.println(translatedPhrase);
                }
            } catch (FileNotFoundException e) {
                throw new FileReadException("The file does not exist, there is no access to the file, etc");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileReadException e) {
            e.printStackTrace();
        }
    }
}