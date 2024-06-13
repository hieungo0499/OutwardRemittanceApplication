package hpt.outwardRemittance;

import hpt.outwardRemittance.model.*;
import hpt.outwardRemittance.service.DatabaseServiceImpl;
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

import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class OutwardRemittanceApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	DatabaseServiceImpl databaseService ;

	@Autowired
	private SystemServiceImpl systemService ;

	public static void main(String[] args) {
		SpringApplication.run(OutwardRemittanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// accounting result : done
//		AccountingResult accountingResult = new AccountingResult() ;
//		accountingResult.setDescription("123");
//		accountingResult.setProcessId("process1");
//		accountingResult.setReferenceId("123456");
//		databaseService.insertAccountingResult(accountingResult) ;
		// done
//		OutwardRemittanceProcess outwardRemittanceProcess = new OutwardRemittanceProcess();
//		outwardRemittanceProcess.setAmount(1000.0F);
//		outwardRemittanceProcess.setProcessId("123");
//		outwardRemittanceProcess.setDebtDate(new Date());
//		System.out.println(databaseService.createProcessCTQTRecord(outwardRemittanceProcess) );

		DocumentInfo documentInfo = new DocumentInfo();
		documentInfo.setDocumentGroup("123");
		documentInfo.setDocumentType("13");
		documentInfo.setCreatedDate(new Date());
		databaseService.updateDebInfo("ok",new Date(),"123") ;
	}
}
