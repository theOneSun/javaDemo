package schoolcup;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author sunjian.
 */
@Data
@Accessors(chain = true)
class Team {
    private String code;
    private String name;
}
