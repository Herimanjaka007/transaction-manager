package com.finance;

import java.time.LocalDate;
import java.util.Map;

public class Transaction {
    private int id;
    private LocalDate date;
    private double montant;
    private String type;
    private String categorie;
    private String description;

    @Override
    public String toString() {
        return "" + this.id + "," + this.date.toString() + "," + this.montant + ","
                + this.type + "," + this.categorie + "," + this.description;
    }

    public Transaction() {
    }

    public Transaction(int id, LocalDate date, double montant, String type, String categorie, String description) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.type = type;
        this.categorie = categorie;
        this.description = description;
    }

    public static Transaction mapToTransaction(Map<String, String> transactionMap) {
        return new Transaction(
                Integer.parseInt(transactionMap.get("id")),
                LocalDate.parse(transactionMap.get("date")),
                Double.parseDouble(transactionMap.get("montant")),
                transactionMap.get("type"),
                transactionMap.get("categorie"),
                transactionMap.get("description"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
