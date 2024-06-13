package hpt.outwardRemittance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountingResult {
    private String referenceId ;
    private String processId ;
    private String description ;
}
