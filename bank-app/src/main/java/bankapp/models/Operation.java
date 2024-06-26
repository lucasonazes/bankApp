package bankapp.models;

import java.sql.Timestamp;

public class Operation {
    private int id;
    private int accountNumber;
    private String type;
    private double value;
    private Timestamp timestamp;

    public Operation(int id, int accountNumber, String type, double value, Timestamp timestamp) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.type = type;
        this.value = value;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getValue() {
        return value;
    }
    
    public Timestamp getTimestamp() {
        return timestamp;
    }
}
