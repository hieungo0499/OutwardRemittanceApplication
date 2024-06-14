package hpt.outwardRemittance.model;

import lombok.*;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentInfo {
    private String processInstance ;
    private String fileName ;
    private String fileType ;
    private String documentGroup ;
    private String documentType ;
    private String createdBy ;
    private Date createdDate ;




}
