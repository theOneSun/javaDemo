package schoolcup;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author sunjian.
 */
@Data
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true)
class Team {
    private String code;
    @ToString.Include
    private String name;
}
