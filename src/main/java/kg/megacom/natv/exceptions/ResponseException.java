package kg.megacom.natv.exceptions;

import kg.megacom.natv.utils.ResourceBundle;
import kg.megacom.natv.utils.models.Language;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseException {
    private String message;
    private Object data;


    public static ResponseException getResponse(String message, Language language) {

        return ResponseException.builder()
                .message(message==null ? ResourceBundle.periodMessages(language,"success") :message)
                .build();
    }

    public static ResponseException getErrorResponse(String message) {
        return ResponseException.builder()
                .message(message==null?"Произошла неизвестная ошибка":message)
                .build();
    }

    public static ResponseException getResponseWithBody(String message, Object data) {
        return ResponseException.builder()
                .message(message)
                .data(data)
                .build();
    }
}
