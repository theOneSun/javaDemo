package schoolcup;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sunjian.
 */
public class GroupLoop {

    private Integer[] indexPool = {0,1,2,3,4,5,6,7,8};

    private List<Match> matchList = new ArrayList<>();
//    private final static List<Team> teams;
    private final static List<Team> teamsB;


    static {
//        teams = initTeams();
        teamsB = initTeamsB();
    }

    //初始化球队
    private static List<Team> initTeams(){
        String[] teamNames = new String[]{"浙江大学","兰州大学","中南财经政法大学","北京理工大学MBA","南京航空航天大学","国防科技大学","南昌大学","湖南大学","沈阳工业大学"} ;
        List<Team> teams = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            teams.add(new Team().setCode("A"+i).setName(teamNames[i-1]));
        }
        return teams;
    }

    @Test
    public void single(){

//        initMatch();
        initMatchB();

        game();
//        matchList.forEach(System.out::println);
        System.out.println("结束");
    }

    /*private void initMatch(){
        matchList.clear();
        //手动添加第一轮和第二轮
        final Team 浙江大学 = teams.get(0);
        final Team 兰州大学 = teams.get(1);
        final Team 中南财经政法大学 = teams.get(2);
        final Team 北京理工大学MBA = teams.get(3);
        final Team 南京航空航天大学 = teams.get(4);
        final Team 国防科技大学 = teams.get(5);
        final Team 南昌大学 = teams.get(6);
        final Team 湖南大学 = teams.get(7);
        final Team 沈阳工业大学 = teams.get(8);
        //第一轮
        matchList.add(new Match(1, 南昌大学, 湖南大学, 沈阳工业大学));
        matchList.add(new Match(2, 中南财经政法大学, 北京理工大学MBA, 沈阳工业大学));
        matchList.add(new Match(3, 南京航空航天大学, 国防科技大学, 沈阳工业大学));
        matchList.add(new Match(4, 浙江大学, 兰州大学, 沈阳工业大学));

        matchList.add(new Match(5, 沈阳工业大学, 浙江大学, 湖南大学));
        matchList.add(new Match(6, 兰州大学, 中南财经政法大学, 湖南大学));
        matchList.add(new Match(7, 北京理工大学MBA, 南京航空航天大学, 湖南大学));
        matchList.add(new Match(8, 国防科技大学, 南昌大学, 湖南大学));
    }*/

    //初始化球队
    private static List<Team> initTeamsB(){
        String[] teamNames = new String[]{"北京邮电大学","中国科技大学","四川大学","天津大学","江西财经大学","西安交通大学","中央财经大学","中国人民公安大学","南京大学"} ;
        List<Team> teams = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            teams.add(new Team().setCode("B"+i).setName(teamNames[i-1]));
        }
        return teams;
    }

    private void initMatchB(){
        matchList.clear();
        //手动添加第一轮和第二轮
        final Team 北京邮电大学 = teamsB.get(0);
        final Team 中国科技大学 = teamsB.get(1);
        final Team 四川大学 = teamsB.get(2);
        final Team 天津大学 = teamsB.get(3);
        final Team 江西财经大学 = teamsB.get(4);
        final Team 西安交通大学 = teamsB.get(5);
        final Team 中央财经大学 = teamsB.get(6);
        final Team 中国人民公安大学 = teamsB.get(7);
        final Team 南京大学 = teamsB.get(8);
        //第一轮
        matchList.add(new Match(1, 北京邮电大学, 中国科技大学, 南京大学));
        matchList.add(new Match(2, 四川大学, 天津大学, 南京大学));
        matchList.add(new Match(3, 江西财经大学, 西安交通大学, 南京大学));
        matchList.add(new Match(4, 中央财经大学, 中国人民公安大学, 南京大学));

        matchList.add(new Match(5, 南京大学, 北京邮电大学, 中国人民公安大学));
        matchList.add(new Match(6, 中国科技大学, 四川大学, 中国人民公安大学));
        matchList.add(new Match(7, 天津大学, 江西财经大学, 中国人民公安大学));
        matchList.add(new Match(8, 西安交通大学, 中央财经大学, 中国人民公安大学));
    }
    private void game() {
        try {
            //轮空球队下标
            int byeIndex = 6;
            for (int i = 3; i <= 9; i++) {
                System.out.println("=======第" + i + "轮开始======");

                final List<Match> roundMatchList;

                roundMatchList = round(byeIndex, i);

                matchList.addAll(roundMatchList);
                byeIndex--;
                System.out.println("=======第" + i + "轮结束======");
            }
        } catch (OverException e) {
            initMatchB();
            game();
        }
    }

    private List<Match> round(int byeIndex, int roundIndex) throws OverException {
        List<Integer> currentIndexPool = new LinkedList<>(Arrays.asList(indexPool));
        currentIndexPool.remove(byeIndex);
        List<Match> currentMatchList = new LinkedList<>();
        int number = roundIndex * 4 - 3;
//        try {
            for (int j = 0; j < 4; j++) {
                final Match match = new Match();
                match.setBye(teamsB.get(byeIndex));
                match.setNumber(number);
                number++;
                randomHomeGuest(match, currentIndexPool);
                currentMatchList.add(match);
                System.out.println(match);
            }
//        } catch (OverException e) {
//            round(byeIndex, roundIndex);
//        }
        return currentMatchList;
    }

    //随机出两个比赛的球队
    private void randomHomeGuest(Match match, List<Integer> currentIndexPool) throws OverException {
        Collections.shuffle(currentIndexPool);
        final Integer homeIndex = currentIndexPool.remove(0);
        Collections.shuffle(currentIndexPool);
        final Integer guestIndex = currentIndexPool.remove(0);

        final boolean exist = matchExist(teamsB.get(homeIndex), teamsB.get(guestIndex));
        if (exist) {
            currentIndexPool.add(homeIndex);
            currentIndexPool.add(guestIndex);
            Collections.shuffle(currentIndexPool);
            if (currentIndexPool.size() == 2) {
                throw new OverException();
            } else {
                randomHomeGuest(match, currentIndexPool);
            }
        } else {
            match.setHome(teamsB.get(homeIndex));
            match.setGuest(teamsB.get(guestIndex));
        }
    }



    //获取主队下标
    private int getHomeIndex(int index){
        if (index > 8) {
            return 0;
        } else {
            return index+1;
        }
    }

    //获取客队的下标
    /*private int getguestIndex(int homeIndex,int interval){
        final int i = homeIndex + interval;
    }*/

    //校验比赛是否存在
    public boolean matchExist(Team t1, Team t2) {
        for (Match match : matchList) {
            if ((t1.getName().equals(match.getHome().getName()) && t2.getName()
                    .equals(match.getGuest().getName())) || (t2.getName()
                    .equals(match.getHome().getName()) && t1.getName().equals(match.getGuest().getName()))) {
                //已经有这场比赛
                return true;
            }
        }
        //没有比赛
        return false;
    }

    /**
     * 排列组合(字符不重复排列)<br>
     * 内存占用：需注意结果集大小对内存的占用（list:10位，length:8，结果集:[10! / (10-8)! = 1814400]）
     * @param list 待排列组合字符集合(忽略重复字符)
     * @param length 排列组合生成长度
     * @return 指定长度的排列组合后的字符串集合
     * @author www@yiynx.cn
     */
    private List<String> permutationNoRepeat(List<String> list, int length) {
        Stream<String> stream = list.stream().distinct();
        for (int n = 1; n < length; n++) {
            stream = stream.flatMap(str -> list.stream()
                    .filter(temp -> !str.contains(temp))
                    .map(str::concat));
        }
        return stream.collect(Collectors.toList());
    }

    @Test
    public void combination() {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println(permutationNoRepeat(list,2));
    }
}
