package hpt.outwardRemittance.controller;

import hpt.outwardRemittance.model.MailInfo;
import hpt.outwardRemittance.service.SystemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("outwardRemittance/")
public class SystemController {
    @Autowired
    SystemServiceImpl systemService;

    @GetMapping(path = "/complexLevel",
            produces = "application/json")
    public Map<String, Object> getComplexLevel() {
        return systemService.getComplexLevel();
    }

    @GetMapping(path = "/priorityLevel",
            produces = "application/json")
    public Map<String, Object> getPriorityLevel() {
        return systemService.getPriorityLevel();
    }
    //
    @GetMapping(path = "/countryList",
            produces = "application/json")
    public Map<String, Object> getCountryList() {
        return systemService.getCountryList();
    }
    //
    @GetMapping(path = "/purposeList",
            produces = "application/json")
    public Map<String, Object> getPurposeList() {
        return systemService.getPurposeList();
    }

    //
    @GetMapping(path = "/purposeReferenceList",
            produces = "application/json")
    public Map<String, Object> getPurposeReferenceList(@RequestParam String parentCode) {
        return systemService.getPurposeReferenceList(parentCode);
    }

    @PostMapping(path = "/purposeReferenceList1",
            produces = "application/json")
    public Map<String, Object> getPurposeReferenceList1(@RequestBody String parentCode) {
        return systemService.getPurposeReferenceList(parentCode);
    }

    //
    @GetMapping(path = "/feeTypeList",
            produces = "application/json")
    public Map<String, Object> getFeeTypeList() {
        return systemService.getFeeTypeList();
    }


    @GetMapping(path = "/bankAccount",
            produces = "application/json")
    public Map<String, Object> getTransferAccounts(@RequestParam Integer CIF) {
        return systemService.getBankAccounts(CIF);

    }


    //

    @GetMapping(path = "/approvalType",
            produces = "application/json")
    public Map<String, Object> getApprovalType() {
        return systemService.getApprovalType();
    }

    //

    @PostMapping(path = "/sendMail")

    public String sendMail(@RequestParam String caseId, @RequestParam String toMail ){
       try {
           MailInfo mailInfo = new MailInfo() ;
           System.out.println(toMail);
           mailInfo.setToMail(toMail);
           String subject = "Thông báo giao dịch "+ caseId+ " đã được duyệt ";
           String content = "Kính gửi anh/chị,\n" ;
           content += "Hệ thống xin thông báo giao dịch số "+caseId+" đã được phê duyệt. Vui lòng truy cập …<link xử lý>… để kiểm tra và xử lý các công việc tiếp theo.\n" ;
           content += "Trân trọng!\nP/S: Đây là email thông báo tự động, vui lòng không reply!" ;
           mailInfo.setSubject(subject);
           mailInfo.setContent(content);
           systemService.sendMail(mailInfo) ;
           return "Send mail completed" ;
       }
       catch (Exception e) {
           return "Send mail failed" ;
       }
    }

    @GetMapping(path = "/test",
            produces = "application/json")
    public void sayHello() {
        systemService.testAPI();
    }



}

