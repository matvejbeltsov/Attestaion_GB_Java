import java.util.*;

class Attestation{
    public static void main(String[] args) {
        // Создаем HashMap для хранения имени и списка телефонов
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        // Пример заполнения телефонной книги
        addContact(phoneBook, "Иванов", "123456789");
        addContact(phoneBook, "Петров", "987654321");
        addContact(phoneBook, "Сидоров", "555666777");
        addContact(phoneBook, "Иванов", "111222333");
        addContact(phoneBook, "Петров", "444555666");
        addContact(phoneBook, "Сидоров", "999888777");
        addContact(phoneBook, "Иванов", "3183781973913931");

        // Выводим телефонную книгу
        List<Map.Entry<String, List<String>>> sortedEntries = sortByNumberOfPhones(phoneBook);
        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            String name = entry.getKey();
            List<String> phones = entry.getValue();
            System.out.println(name + ": " + phones);
        }
    }

    // Метод для добавления контакта в телефонную книгу
    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phone) {
        // Если контакт уже существует, добавляем телефон к списку телефонов
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phone);
        } else {
            // Если контакт новый, создаем новый список телефонов и добавляем его
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            phoneBook.put(name, phones);
        }
    }

    // Метод для сортировки записей по убыванию числа телефонов
    public static List<Map.Entry<String, List<String>>> sortByNumberOfPhones(HashMap<String, List<String>> phoneBook) {
        // Создаем список записей из HashMap
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем записи по убыванию числа телефонов
        Collections.sort(entries, new Comparator<Map.Entry<String, List<String>>>() {
            @Override
            public int compare(Map.Entry<String, List<String>> entry1, Map.Entry<String, List<String>> entry2) {
                return Integer.compare(entry2.getValue().size(), entry1.getValue().size());
            }
        });

        return entries;
    }
}