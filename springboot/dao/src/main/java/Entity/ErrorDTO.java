package Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
  public class ErrorDTO{
    private Long errorCode;
    private String msg;

    public ErrorDTO(Long errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }
}


