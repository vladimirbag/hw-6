package cc.robotdreams;


import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"мама", "папа", "їж їжак желе"};
        char[] uniqueLetters = findUniqueLetters(strings);
        System.out.println(uniqueLetters);
    }

    public static char[] findUniqueLetters(String[] strings) {
        HashSet<Character> uniqueLettersSet = new HashSet<>();

        int count = 0; // Лічильник знайдених слів
        int index = 0; // Індекс поточного рядка

        // Перший цикл while перебирає рядки доти, поки не знайдено два слова з парною кількістю символів або не перебрані всі рядки
        while (count < 2 && index < strings.length) {
            String string = strings[index];

            // Перевіряємо, чи має рядок парну кількість кожного символу
            boolean allCharactersEven = true; // Прапорець, що всі символи мають парну кількість входжень
            for (char c : string.toCharArray()) {
                int frequency = countCharacterFrequency(string, c);
                if (frequency % 2 != 0) {
                    allCharactersEven = false;
                    break;
                }
            }

            if (allCharactersEven) {
                // Додаємо унікальні символи зі слова до множини
                for (char c : string.toCharArray()) {
                    if (Character.isLetter(c)) {
                        uniqueLettersSet.add(Character.toLowerCase(c));
                    }
                }
                count++; // Збільшуємо лічильник знайдених слів
            }

            index++; // Переходимо до наступного рядка
        }

        // Перетворюємо множину у масив символів
        char[] uniqueLettersArray = new char[uniqueLettersSet.size()];
        int i = 0;
        for (char c : uniqueLettersSet) {
            uniqueLettersArray[i++] = c;
        }

        return uniqueLettersArray;
    }

    public static int countCharacterFrequency(String string, char targetChar) {
        int frequency = 0;

        // Рахуємо кількість входжень символу у рядок
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == targetChar) {
                frequency++;
            }
        }

        return frequency;
    }
}