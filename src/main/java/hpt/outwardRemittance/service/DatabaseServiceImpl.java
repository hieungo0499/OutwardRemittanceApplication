package hpt.outwardRemittance.service;

import hpt.outwardRemittance.model.AccountingResult;
import hpt.outwardRemittance.model.DocumentInfo;
import hpt.outwardRemittance.model.OutwardRemittanceProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DatabaseServiceImpl implements  DatabaseService{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public String createProcessCTQTRecord(OutwardRemittanceProcess outwardRemittanceProcess) {
       try {
        String sql = "insert into bpm.bpm_process_ctqt (process_id,cus_id,amount,curr_id,acc_status,debt_status,debt_date) VALUES(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, outwardRemittanceProcess.getProcessId(), outwardRemittanceProcess.getCustomerId(), outwardRemittanceProcess.getAmount(), outwardRemittanceProcess.getCurrencyId(), outwardRemittanceProcess.getAccountingStatus(), outwardRemittanceProcess.getDebtStatus(), outwardRemittanceProcess.getDebtDate());
       return "Success!" ;
       }
       catch (Exception e) {

           return "Failed";
       }

    }

    @Override
    public String updateDebInfo(String debtStatus, Date debtDate,String processId) {
        try {
            String sql = "update bpm.bpm_process_ctqt set debt_status  = ? ,debt_date  = ? where process_id  = ? " ;
            jdbcTemplate.update(sql, debtStatus, debtDate, processId);
            return "Success !" ;
        }
        catch (Exception e) {
            return "Failed";
        }

    }
// ok
    @Override
    public String insertDocument(DocumentInfo documentInfo) {
        try {
            String sql = "insert into bpm.bpm_process_documents(process_instance_id,file_name,file_type,document_group,document_type,created_by,created_at) Values(?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql, documentInfo.getProcessInstance(), documentInfo.getFileName(), documentInfo.getFileType(), documentInfo.getDocumentGroup(), documentInfo.getDocumentType(), documentInfo.getCreatedBy(), documentInfo.getCreatedDate());
            return "Success !" ;
        }
        catch (Exception e) {
            return "Failed";
        }
    }

    @Override
    public String insertAccountingResult(AccountingResult accountingResult) {
        try {
            String sql = "insert into bpm.accounting_result(reference_id,process_id,description) values(?,?,?) ";
            jdbcTemplate.update(sql, accountingResult.getReferenceId(), accountingResult.getProcessId(), accountingResult.getDescription());
            return "Success !";
        }
        catch (Exception e) {
            return "Failed";
        }
    }
}
