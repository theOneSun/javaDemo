package study.designModel.bridge;

import lombok.AllArgsConstructor;
import lombok.Data;
import study.designModel.bridge.vo.ProjectDataParam;

import java.util.UUID;

/**
 * 属性容器,每添加一个可变属性就加一个字段
 *
 * @author sunjian.
 */
@Data
@AllArgsConstructor
public class AttributeContainer {

    private UUID projectId;
    /**
     * 标签页
     */
    private Table tab;

    /**
     * 查询展示数据的属性
     */
    private DataDisplay dataDisplay;

    public AttributeContainer(UUID projectId) {
        this.projectId = projectId;
    }

    //返回数据库参数查询对象
    public ProjectDataParam getSelectParam() {
        final ProjectDataParam selectParam = new ProjectDataParam();
        selectParam.setProjectId(projectId);
        //        selectParam.setBatch();
        //        selectParam.setAreas();
        return null;
    }

}
