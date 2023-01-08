package kg.megacom.natv.models.responces;

import kg.megacom.natv.utils.ResourceBundle;
import kg.megacom.natv.utils.models.Language;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private String message;
    private String data;

    public static Response getResponse(String message, Language language){
        return Response.builder().message(message==null? ResourceBundle.periodMessages(language, "success") :message)
                .build();
    }

}
