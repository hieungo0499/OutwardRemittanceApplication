package hpt.outwardRemittance.service;

import hpt.outwardRemittance.model.AccountingResult;
import hpt.outwardRemittance.model.DocumentInfo;
import hpt.outwardRemittance.model.OutwardRemittanceProcess;

import java.util.Date;

public interface DatabaseService {
    String createProcessCTQTRecord (OutwardRemittanceProcess outwardRemittanceProcess);
    String updateDebInfo (String debtStatus, Date debtDate,String processId);
    String insertDocument(DocumentInfo documentInfo) ;
    String insertAccountingResult(AccountingResult accountingResult) ;
}
