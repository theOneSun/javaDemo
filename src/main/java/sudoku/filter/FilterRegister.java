package sudoku.filter;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjian.
 */
@Slf4j
public class FilterRegister {
    public static List<CandidateRemove> register() {
        List<CandidateRemove> result =  new ArrayList<>();
        result.add(new ModuleDistinct());
        result.add(new SingleCandidate());

        result.add(new UniqueInGrid());
        result.add(new UniqueInRow());
        result.add(new UniqueInColumn());


        return result;
    }
}
