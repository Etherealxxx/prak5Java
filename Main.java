package org.example;

abstract class PrisonManagementSystem {
    public static int getPrisonerCount(String prisonId) {
        return 100;
    }

    public static int calculateSentenceLength(String startDate, String endDate) {
        return 365;
    }

    public static void recordVisitorEntry(String visitorName, String visitDate, String purpose) {
        System.out.println("Посетитель " + visitorName + " осуществил вход с целью " + purpose + " " + visitDate);
    }

    public static void getPrisonStatistics() {
        System.out.println("Статистика:");
        System.out.println("Всего заключенных: 100");
        System.out.println("Средний срок заключения: 3 года");
    }

    public static void updateVisitorRecord(String visitorName, String newVisitDate, String newPurpose) {
        System.out.println("Обновлена запись для посетителя: " + visitorName + " с новой датой посещения: " + newVisitDate);
    }

    public abstract void addPrisoner(String name, int age, String crime);

    public abstract void releasePrisoner(int prisonerId);

    public abstract String searchPrisoner(String searchTerm);
}

class ExtendedPrisonManagementSystem extends PrisonManagementSystem {
    @Override
    public void addPrisoner(String name, int age, String crime) {
        System.out.println("Добавленный заключенный:  " + name + " преступление: " + crime);
    }

    @Override
    public void releasePrisoner(int prisonerId) {
        System.out.println("ID освобожденного заключенного: " + prisonerId);
    }

    @Override
    public String searchPrisoner(String searchTerm) {
        return "Заключенный не найден";
    }
}

public class Main extends PrisonManagementSystem {
    public static void main(String[] args) {
        System.out.println("Количество заключенных: " + getPrisonerCount("123"));
        System.out.println("Продолжительность приговора: " + calculateSentenceLength("01-01-2024", "01-01-2005"));
        recordVisitorEntry("Андрей", "04-06-2026", "посещение");

        PrisonManagementSystem main = new ExtendedPrisonManagementSystem(); // Полиморфное присваивание

        main.addPrisoner("Владислав", 30, "кража");
        main.releasePrisoner(456);
        System.out.println(main.searchPrisoner("Владислав"));

        getPrisonStatistics();
        updateVisitorRecord("Андрей", "04-04-2027", "визит");
    }

    @Override
    public void addPrisoner(String name, int age, String crime) {
    }

    @Override
    public void releasePrisoner(int prisonerId) {
    }

    @Override
    public String searchPrisoner(String searchTerm) {
        return null;
    }
}
