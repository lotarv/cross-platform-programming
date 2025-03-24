import java.util.HashMap;
import java.util.Map;

public class UniqueChars {
    private String entry;

    public UniqueChars(String entry) {
        this.entry = entry;
    }
    @Override
    public String toString() {
        String result = "";
        Map<Character, Integer> charCount = new HashMap<>();
        // Подсчет символов в строке
        for (Character character : entry.toCharArray()) {
            charCount.put(character, charCount.getOrDefault(character, 0) + 1);
        }
        // Формирование строки результата
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            result += "char: " + entry.getKey() + ", count: " + entry.getValue() + "\n";
        }
        return result;
    }

    // Подзадача 1: Подсчет слов
    public int countWords() {
        if (entry == null || entry.trim().isEmpty()) {
            return 0;
        }
        // Разделяем строку на слова по пробелам
        String[] words = entry.trim().split("\\s+");
        return words.length;
    }

    // Подзадача 2: Подсчет цифр
    public Map<Character, Integer> countDigits() {
        Map<Character, Integer> digitCount = new HashMap<>();
        for (Character character : entry.toCharArray()) {
            if (Character.isDigit(character)) {
                digitCount.put(character, digitCount.getOrDefault(character, 0) + 1);
            }
        }
        return digitCount;
    }

    // Подзадача 3: Подсчет букв в указанном регистре
    public Map<Character, Integer> countLettersInCase(boolean upperCase) {
        Map<Character, Integer> letterCount = new HashMap<>();
        for (Character character : entry.toCharArray()) {
            if (Character.isLetter(character)) {
                if (upperCase && Character.isUpperCase(character)) {
                    letterCount.put(character, letterCount.getOrDefault(character, 0) + 1);
                } else if (!upperCase && Character.isLowerCase(character)) {
                    letterCount.put(character, letterCount.getOrDefault(character, 0) + 1);
                }
            }
        }
        return letterCount;
    }

    // Пример использования
    public static void main(String[] args) {
        UniqueChars uc = new UniqueChars("I LOVE programming 2025");
        
        // Подсчет всех символов (toString)
        System.out.println("Подсчет всех символов:");
        System.out.println(uc.toString());
        
        // Подзадача 1: Подсчет слов
        System.out.println("Количество слов: " + uc.countWords());
        
        // Подзадача 2: Подсчет цифр
        System.out.println("Цифры:");
        Map<Character, Integer> digits = uc.countDigits();
        for (Map.Entry<Character, Integer> entry : digits.entrySet()) {
            System.out.println("digit: " + entry.getKey() + ", count: " + entry.getValue());
        }
        
        // Подзадача 3: Подсчет букв в верхнем регистре
        System.out.println("Буквы в верхнем регистре:");
        Map<Character, Integer> upperCaseLetters = uc.countLettersInCase(true);
        for (Map.Entry<Character, Integer> entry : upperCaseLetters.entrySet()) {
            System.out.println("char: " + entry.getKey() + ", count: " + entry.getValue());
        }
        
        // Подзадача 3: Подсчет букв в нижнем регистре
        System.out.println("Буквы в нижнем регистре:");
        Map<Character, Integer> lowerCaseLetters = uc.countLettersInCase(false);
        for (Map.Entry<Character, Integer> entry : lowerCaseLetters.entrySet()) {
            System.out.println("char: " + entry.getKey() + ", count: " + entry.getValue());
        }
    }
}