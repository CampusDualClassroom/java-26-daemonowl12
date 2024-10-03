package com.campusdual.classroom;

import java.text.Normalizer;

public class Contact implements ICallActions {

    private String name;
    private String surnames;
    private String phone;
    private String code;

    public Contact(String name, String surnames, String phone) {
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.code = generateCode(name, surnames);

    }

    private String generateCode(String name, String surnames) {
        String normalizedSurname = Normalizer.normalize(surnames.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

        String normalizedName = Normalizer.normalize(name.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

        System.out.println("Normalized Name: " + normalizedName);
        System.out.println("Normalized Surname: " + normalizedSurname);

        String initialName = normalizedName.substring(0, 1);
        String[] surnameParts = normalizedSurname.split(" ");

        if (surnameParts.length == 1) {
            return initialName + surnameParts[0];

        }

        String firstSurnameInitial = surnameParts[0].substring(0, 1);
        StringBuilder code = new StringBuilder(initialName + firstSurnameInitial);

        for (int i = 1; i < surnameParts.length; i++) {
            code.append(surnameParts[i]);
        }

        return code.toString();

    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getPhone() {
        return phone;
    }

    public String getCode() {
        return code;
    }

    @Override
    public void callMyNumber() {
        System.out.println("Llamandome a mi mismo, " + name + " " + surnames + ", al teléfono " + phone);
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Llamando a " + name + " " + surnames + " desde " + number);
    }

    @Override
    public void showContactDetails() {

        System.out.println("Name: " + name);
        System.out.println("Surnames: " + surnames);
        System.out.println("Phone: " + phone);
        System.out.println("Code: " + code);

    }
}
