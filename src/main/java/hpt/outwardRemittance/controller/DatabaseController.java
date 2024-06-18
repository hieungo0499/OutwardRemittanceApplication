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
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("outwardRemittance/")
public class DatabaseController {
    @Autowired
    private DatabaseServiceImpl databaseService;

    // ok
    @PostMapping(path = "/insertAccountingResult",
            produces = "application/json")
    public Map<String, Object> insertAccountingResult (@RequestBody AccountingResult accountingResult) {
        System.out.println(accountingResult.getReferenceId());

        String resp = databaseService.insertAccountingResult(accountingResult);
         Map<String,Object> map = new HashMap<>();
            map.put("status",resp);
            return map ;
    }
    //
    @PostMapping(path = "/insertDocument",
            produces = "application/json")
    public Map<String, Object> insertDocument (@RequestBody DocumentInfo documentInfo) {
        System.out.println(documentInfo.getProcessInstance());
        Map<String,Object> map = new HashMap<>();
        String resp =  databaseService.insertDocument(documentInfo);
        map.put("status",resp);
         return map ;
    }
    //
    @PostMapping(path = "/updateDebInfo",
            produces = "application/json")
    public Map<String, Object> updateDebInfo (@RequestParam String debtStatus, @RequestParam Date debtDate, @RequestParam String procesId) {
        Map<String,Object> map = new HashMap<>();
        String resp =  databaseService.updateDebInfo(debtStatus,debtDate,procesId);
        map.put("status",resp);
        return map ;
    }

    @PostMapping(path = "/createProcessRecord",
            produces = "application/json")
    public Map<String, Object> createProcessRecord (@RequestBody OutwardRemittanceProcess outwardRemittanceProcess) {
        Map<String,Object> map = new HashMap<>();
        String resp =  databaseService.createProcessCTQTRecord(outwardRemittanceProcess);
        map.put("status",resp);
        return map ;
    }




}
