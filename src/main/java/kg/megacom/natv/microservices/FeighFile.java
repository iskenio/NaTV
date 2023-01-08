package kg.megacom.natv.microservices;

import lombok.*;

@Getter
@Setter
public class FeighFile {
    private String fileName;
    private String downloadUri;
    private String fileType;
    private long size;

}
