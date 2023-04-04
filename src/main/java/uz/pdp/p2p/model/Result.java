package uz.pdp.p2p.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class Result {

    private String message;
    private boolean success;

    private Object object;

    public Result(String message, boolean success, Object object) {
        this.message = message;
        this.success = success;
        this.object = object;
    }

    public Result(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
