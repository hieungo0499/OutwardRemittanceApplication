package hpt.outwardRemittance;

import hpt.outwardRemittance.model.MailInfo;
import hpt.outwardRemittance.model.NameValuePair;
import hpt.outwardRemittance.service.SystemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class OutwardRemittanceApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Autowired
	private SystemServiceImpl systemService ;
	public static void main(String[] args) {
		SpringApplication.run(OutwardRemittanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Integer CIF =  10001 ;
//		String sql = "SELECT  cust_acc_num as code, acc_currency as name \n" +
//				"FROM bpm.cust_accounts where cust_id = ? " ;
//	String result =	jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(NameValuePair.class),CIF).toString();
//			System.out.println(systemService.getPurposeReferenceList("PER_01"));
		MailInfo mailInfo = new MailInfo();
		mailInfo.setToMail("hieungo0499@gmail.com");
		mailInfo.setContent("content");
		mailInfo.setSubject("subject");
//		systemService.sendMail(mailInfo) ;

	}
}
