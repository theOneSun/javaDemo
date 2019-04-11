package study.utils;

import org.junit.Test;

/**
 * @author sunjian.
 */
public class StringUtils {

    /**
     * 包含null的比较
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean equalsContainsNull(String s1, String s2) {
        if (s1 == null) {
            return s2 == null;
        } else {
            return s1.equals(s2);
        }
    }

    //生成sql
    @Test
    public void generateSql() {
        String[] indexes = new String[]{"电梯设施运行正常", "会员权益能够吸引普通顾客入会", "推广活动对客流/销售业绩的促进效果", "消防设施、安全通道指示标志清楚明了，杜绝安全隐患", "会员权益有助于激励顾客更多消费", "对进出项目的人员进行有效控制（如：无流浪、乞讨、散发小广告人员等）", "告知商场管理规范，并依照规范对店铺日常工作进行有效管理", "项目秩序良好（治安，人流等），有安全感", "商场推广/宣传活动吸引更多客流", "购物中心整体档次及氛围营造", "业态与品牌", "会员营销活动（如多倍积分、周年庆、满额赠礼等）对店铺业绩具有促进效果", "在该城市或商圈的品牌知名度对您的店铺经营起到积极作用", "供水、供电设施运行正常", "一点万象/掌上五彩城商户版实用性", "设施设备维护", "办理装修手续服务人员态度好", "服务积极主动，态度良好", "总体满意度", "会员活动丰富", "手机通信信号畅通，能够正常拨打电话（或上网）", "公众号及App简单易用，对经营有促进作用", "保安人员仪容仪表及沟通态度", "手续办理流程简便快捷（入场证照办理，工商税务质检协助）", "推广（主题/促销）活动宣传渠道的覆盖面", "商场推广/宣传活动与项目定位匹配度", "前场或后勤）公共区域垃圾处理清运及时，无卫生死角", "仓库面积、位置满足存货、补货要求", "店铺与商场各部门之间沟通协调、协商顺畅", "及时与租户沟通推广与促销活动", "商场推广/宣传活动影响力", "场内空调设施运行正常", "经营和后勤区域垃圾箱布局合理、便于使用", "商场了解目标消费者并能有效分享消费者信息", "零售、餐饮、娱乐等经营种类的设置与组合合理性", "能及时通知管理措施和重大事项", "卫生间干净整洁、保洁处理及时", "对于租户自发推广活动的支持程度", "商场推广活动形式丰富多样", "收银系统硬件的维护", "市场经营与推广", "购物中心公共区域整体卫生状况", "配合装修材料顺利进场", "商场推广/宣传活动频率及力度", "设备设施维护", "商场对于所在商圈竞品、商圈环境等信息了解，能对商户进行有效信息分享", "公共区域（不含商铺内区域）无线网络wifi顺畅", "货运通道，消防通道等区域卫生状况", "微博/微信公众号活动宣传的有效性", "Pos机使用方便快捷", "项目运营人员（运营、客关、推广、物业）的职业操守（如无吃拿卡要、无故意刁难、无收取个人利益等）", "目前店铺的销售业绩符合您当时的预期", "关注商铺的经营，并且进行经营情况沟通与信息分享，能对租户的日常工作进行有效指导", "设备设施故障维修效果显著，不造成经营困扰", "形象与定位", "定期组织消防灭火及疏散演练", "购物区域的整体装饰及氛围", "目前消费群体的档次与品牌定位相契合", "设备设施出现故障迅速回应 ，及时高效", "信息服务", "维修人员的仪容仪表与服务态度", "商场品牌丰富度", "会员服务有助于促进会员光顾本商场的频次", "安全秩序", "商场导视指引系统可以对于店铺进行有效指引与宣传", "装修施工期间可以正常用水、用电", "日常进出货管控合理，过程便捷高效", "整体营运能力", "会员运营", "（若有投诉）投诉处理公平公正，及时有效", "硬件设施及物业", "清洁卫生", "日常运营", "开业支持", "新入驻门店/商户新员工培训指导"};
        /*
        SELECT '电梯设施运行正常' as index_name ,avg((last_level_index_scores->>'电梯设施运行正常') :: numeric) :: numeric(5, 2) as score from project_data WHERE project_id = 'e0a8dd85-0d2f-4a1c-82d7-89aed69ccdab' AND batch = '2018年'
 UNION ALL
SELECT '电梯设施运行正常' as index_name ,avg((last_level_index_scores->>'电梯设施运行正常') :: numeric) :: numeric(5, 2) as score from project_data WHERE project_id = 'e0a8dd85-0d2f-4a1c-82d7-89aed69ccdab' AND batch = '2018年'

         */
        StringBuilder sql = new StringBuilder("");
        for (int i = 0; i < indexes.length; i++) {
            String index = indexes[i];
            StringBuilder tempSql = new StringBuilder();
            if (i != 0) {
                tempSql.append(" UNION ALL ");
            }
            tempSql.append("SELECT '")
                   .append(index)
                   .append("' AS index_name,  avg((last_level_index_scores->>'")
                   .append(index)
                   .append("') :: numeric ) :: numeric(5, 2) as score FROM project_data  WHERE project_id = 'e0a8dd85-0d2f-4a1c-82d7-89aed69ccdab' AND batch = '2018年'");
            sql.append(tempSql);
        }

        System.out.println(sql.toString());

    }

    //生成projectArea的插入语句
    @Test
    public void generateInsert() {
        String projectId = "bf242bc7-d99a-44a0-8cc1-87eafd9d2bb1";
        String[] areas = new String[]{"{上海市分行}", "{河南省分行}", "{吉林省分行}", "{湖南省分行}", "{辽宁省分行}", "{重庆市分行}", "{北京市分行}", "{贵州省分行}", "{江苏省分行}", "{黑龙江省分行}", "{甘肃省分行}", "{广西省分行}", "{四川省分行}", "{山东省分行}", "{江西省分行}", "{苏州市分行}", "{内蒙古分行}", "{宁波市分行}", "{河北省分行}", "{深圳市分行}", "{厦门市分行}", "{宁夏区分行}", "{广东省分行}", "{青岛市分行}", "{浙江省分行}", "{无锡市分行}", "{陕西省分行}", "{大连市分行}", "{山西省分行}", "{天津市分行}", "{云南省分行}", "{福建省分行}", "{青海省分行}", "{湖北省分行}", "{新疆区分行}", "{海南省分行}", "{安徽省分行}"};
        StringBuilder sql = new StringBuilder("INSERT INTO project_area VALUES (");
        for (int i = 0; i < areas.length; i++) {
            String area = areas[i];
            StringBuilder tempSql = new StringBuilder();
            if (i != 0) {
                tempSql.append(" , ");
            }
            tempSql.append("(uuid_generate_v4(), '")
                   .append(area)
                   .append("','")
                   .append(projectId)
                   .append("',")
                   .append(i).append(")");
            sql.append(tempSql);
        }
        sql.append(")");
        System.out.println(sql.toString());
    }
}
