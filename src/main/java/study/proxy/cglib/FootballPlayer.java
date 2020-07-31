package study.proxy.cglib;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunjian.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FootballPlayer {
    private String name;

    public void goal() {
        System.out.println(" goal!!!!!  " + name + "  进球了 !!!");
    }
}
