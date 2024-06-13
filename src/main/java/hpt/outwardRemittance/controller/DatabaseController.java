package hpt.outwardRemittance.controller;

import hpt.outwardRemittance.model.AccountingResult;
import hpt.outwardRemittance.model.DocumentInfo;
import hpt.outwardRemittance.model.OutwardRemittanceProcess;
import hpt.outwardRemittance.service.DatabaseService;
import hpt.outwardRemittance.service.DatabaseServiceImpl;
import hpt.outwardRemittance.service.SystemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("outwardRemittance/")
public class DatabaseController {
    @Autowired
    private DatabaseServiceImpl databaseService;


    @PostMapping(path = "/insertAccountingResult",
            produces = "application/json")
    public String insertAccountingResult (@RequestBody AccountingResult accountingResult) {

        return databaseService.insertAccountingResult(accountingResult);
    }
    //
    @PostMapping(path = "/insertDocument",
            produces = "application/json")
    public String insertDocument (@RequestBody DocumentInfo documentInfo) {

        return databaseService.insertDocument(documentInfo);
    }
    //
    @PostMapping(path = "/updateDebInfo",
            produces = "application/json")
    public String insertOutwardRemittanceRecord (@RequestParam String debtStatus, @RequestParam Date debtDate, @RequestParam String procesId) {

        return databaseService.updateDebInfo(debtStatus,debtDate,procesId);
    }
}
