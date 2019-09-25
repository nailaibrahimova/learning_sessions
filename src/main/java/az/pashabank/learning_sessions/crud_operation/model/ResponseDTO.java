package az.pashabank.learning_sessions.crud_operation.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {
    private Integer code;
    private String msg;
}
