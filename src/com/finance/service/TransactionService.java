package com.finance.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.finance.Transaction;
import com.finance.utils.CSVReader;

public class TransactionService {
    private String fileName = "transactions.csv";
    private List<Transaction> transactions = CSVReader.getDataFromCSV(fileName).stream()
            .map(transaction -> Transaction.mapToTransaction(transaction))
            .collect(Collectors.toList());

    public TransactionService() {
    }

    public TransactionService(String fileName) {
        this.fileName = fileName;
        this.transactions = CSVReader.getDataFromCSV(fileName).stream()
                .map(Transaction::mapToTransaction)
                .collect(Collectors.toList());
    }

    public Optional<Transaction> getTransaction(int id) {
        return this.transactions.stream()
                .filter(transaction -> transaction.getId() == id)
                .findAny();
    }

    public Optional<Transaction> getLastTransaction() {
        return this.transactions.stream()
                .sorted(Comparator.comparing(Transaction::getDate).reversed())
                .findFirst();
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

}
