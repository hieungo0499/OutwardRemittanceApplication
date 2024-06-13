package hpt.outwardRemittance.service;

import hpt.outwardRemittance.model.BankAccount;
import hpt.outwardRemittance.model.MailInfo;
import hpt.outwardRemittance.model.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    JdbcTemplate jdbcTemplate ;
    // ok

    @Autowired
    private JavaMailSender mailSender;

    public static ArrayList<NameValuePair>  rowMapper(List<Map<String, Object>> rows){
        ArrayList<NameValuePair> list = new ArrayList<>();
        for (Map row : rows) {
            NameValuePair nameValuePair = new NameValuePair();
            nameValuePair.setCode(row.get("code").toString());
            nameValuePair.setName(row.get("name").toString());
            list.add(nameValuePair) ;
        }

        return list;
    }
    @Override
    public Map<String, Object> getPriorityLevel() {
        String sql = "select code, name  FROM bpm.adm_masterdata am where group_code = 'PRIORITY_LEVEL' " ;
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        Map<String,Object> map = new HashMap<>();
        map.put("priorityLevel",rowMapper(rows));
        return map ;
    }

    @Override
    public Map<String, Object> getComplexLevel() {
        String sql = " select code, name  FROM bpm.adm_masterdata am where group_code = 'COMPLEX_LEVEL' " ;
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        Map<String,Object> map = new HashMap<>();
        map.put("complexLevel",rowMapper(rows));
        return map ;
    }

    @Override
    public Map<String, Object> getApprovalType() {
        String sql = " select code, name  FROM bpm.adm_masterdata am where group_code = 'APPROVAL_TYPE' " ;
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        Map<String,Object> map = new HashMap<>();
        map.put("approvalType",rowMapper(rows));
        return map ;
    }

    @Override
    public Map<String, Object> getBankAccounts(Integer CIF) {
        String sql = "SELECT  cust_acc_num as accountNumber, acc_currency as currency, acc_balance as balance \n" +
                "FROM bpm.cust_accounts where cust_id = ? " ;

      List<BankAccount> list =   jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(BankAccount.class),CIF) ;
      ArrayList<NameValuePair> bankAccountList = new ArrayList<>();
      for(BankAccount bank : list){
          NameValuePair bankInfo = new NameValuePair();
          bankInfo.setName(bank.getAccountNumber()+"-"+bank.getCurrency()+"-"+bank.getBalance().toString());
          bankInfo.setCode(bank.getAccountNumber());
          bankAccountList.add(bankInfo) ;
      }
      Map<String, Object> result = new HashMap<>();
      result.put("bankAccountList", bankAccountList);
        return result ;
    }



    @Override
    public Map<String, Object> getCountryList() {
        String sql = " select code, name  FROM bpm.adm_masterdata am where group_code = 'COUNTRY' " ;
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        Map<String,Object> map = new HashMap<>();
        map.put("countryList",rowMapper(rows));
        return map ;
    }

    @Override
    public Map<String, Object> getPurposeList() {
        String sql = " select code, name FROM bpm.adm_masterdata am where group_code = 'PERPOSEID' " ;
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        Map<String,Object> map = new HashMap<>();
        map.put("purpose",rowMapper(rows));
        return map ;
    }

    @Override
    public Map<String, Object> getPurposeReferenceList(String parentCode) {
        String sql = "select code,name FROM bpm.adm_masterdata am where parent_code  =  '" + parentCode + "' " ;
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        Map<String,Object> map = new HashMap<>();
        map.put("perposeRefer",rowMapper(rows));
        System.out.println(sql);
        return map ;

    }

    @Override
    public Map<String, Object> getFeeTypeList() {
        String sql = " select code, name FROM bpm.adm_masterdata am where group_code = 'FEE_TYPE' " ;
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        Map<String,Object> map = new HashMap<>();
        map.put("purpose",rowMapper(rows));
        return map ;
    }

    @Override
    public Map<String, Object> getBankCodeList() {
        String sql = "select * FROM bpm.adm_masterdata am where group_code = 'BANKCODE' " ;
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        Map<String,Object> map = new HashMap<>();
        map.put("purpose",rowMapper(rows));
        return map ;
    }

    @Override
    public Map<String, Object> getGoodsList() {
        String sql = "select * FROM bpm.adm_masterdata am where group_code = 'MATERIAL'" ;
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        Map<String,Object> map = new HashMap<>();
        map.put("purpose",rowMapper(rows));
        return map ;
    }

    @Override
    public String sendMail(MailInfo mailInfo) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hieungo049900@gmail.com");
        message.setTo(mailInfo.getToMail());
        message.setText(mailInfo.getContent());
        message.setSubject(mailInfo.getSubject());
        mailSender.send(message);
        System.out.println("Mail Send...");
        return "";
    }

    @Override
    public void testAPI() {
        String date = new Date().toString();
        String sql = "insert into camunda.bpm.nmhieu (CONTENT) values ('"+date+"'"+" )" ;
        jdbcTemplate.update(sql) ;
    }


}
