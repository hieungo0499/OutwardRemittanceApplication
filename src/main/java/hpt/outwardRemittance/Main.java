package hpt.outwardRemittance;

import hpt.outwardRemittance.model.BankAccount;
import hpt.outwardRemittance.model.NameValuePair;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount() ;
        bankAccount.setAccountNumber("123");
        NameValuePair  nameValuePair = new NameValuePair();
        nameValuePair.setCode("123");
        System.out.println(nameValuePair.getCode());
        System.out.println(bankAccount.getAccountNumber());


    }
}
