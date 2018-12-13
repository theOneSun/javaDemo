package study.designModel.bridge.vo;

import lombok.Data;

import java.util.UUID;

/**
 * 项目数据查询的参数
 *
 * @author sunjian.
 */
@Data
public class ProjectDataParam {
    private String batch;
    private String[] areas;
    private UUID projectId;
}
