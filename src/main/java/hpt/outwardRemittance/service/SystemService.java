package hpt.outwardRemittance.service;

import hpt.outwardRemittance.model.BankAccount;
import hpt.outwardRemittance.model.MailInfo;
import hpt.outwardRemittance.model.NameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SystemService {
    Map<String, Object> getPriorityLevel();
    Map<String, Object> getComplexLevel();
    Map<String, Object> getApprovalType();
    //tai khoan thanh toan / phi by cif
    Map<String, Object> getBankAccounts(Integer CIF);
    Map<String, Object> getCountryList();
    Map<String, Object> getPurposeList();
    Map<String, Object> getPurposeReferenceList(String parentCode);
    Map<String, Object> getFeeTypeList();
    Map<String, Object> getBankCodeList() ;
    Map<String, Object> getGoodsList();
    String sendMail(MailInfo mailInfo) ;
    void testAPI();




}
