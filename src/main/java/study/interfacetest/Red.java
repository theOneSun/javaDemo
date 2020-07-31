package study.interfacetest;

import lombok.Data;

/**
 * @author sunjian.
 */
@Data
public class Red implements Color {
    @Override
    public String getColor() {
        return "red";
    }
}
