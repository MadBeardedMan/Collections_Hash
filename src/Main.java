import java.util.HashMap;
import java.util.Map;

class Main {
    static String text = ("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
            "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
            "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit " +
            "in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat" +
            " non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

    public static void main(String[] args) {
        Map<Character, Integer> txtMap = new HashMap<>();
        int max = -1;
        int min = Integer.MAX_VALUE;
        char mn = '@';
        char mx = '@';
        for (int i = 0; i < text.length(); i++) {
            char symbol = Character.toLowerCase(text.charAt(i));
            if (txtMap.containsKey(symbol)) {
                txtMap.put(symbol, (txtMap.get(symbol) + 1));
            } else {
                txtMap.put(symbol, 1);
            }
        }
        // Реализация через EntrySet
        for (Map.Entry<Character, Integer> entry : txtMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (key != ' ') {
                if (value > max) {
                    max = value;
                    mx = key;
                }
                if (value < min) {
                    min = value;
                    mn = key;
                }
            }
        }
        System.out.println("Символ " + mx + " встречался больше всего в тексте. Итого: " + max + " раз.");
        System.out.println("Символ " + mn + " встречался меньше всего в тексте. Итого: " + min + " раз.");
    }
}