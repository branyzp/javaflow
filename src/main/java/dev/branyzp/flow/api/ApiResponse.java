package dev.branyzp.flow.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ApiResponse<T> {

    private int status;
    private String message;
    private Object result;


}
