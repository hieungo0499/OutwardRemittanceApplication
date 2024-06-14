package hpt.outwardRemittance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OutwardRemittanceProcess {
    private String processId ;
    private String customerId;
    private Float amount ;
    private String currencyId ;
    private String accountingStatus ;
    private String debtStatus ;
    private Date debtDate ;



}
