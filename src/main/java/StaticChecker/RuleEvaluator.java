package StaticChecker;

import java.util.ArrayList;

public class RuleEvaluator<T> {

    private ArrayList<Rule<T>> ruleList = new ArrayList<>();

    public void addRule(Rule<T> rule){

        ruleList.add(rule);

    }

    public void evaluateRules(T item, String fileName){

        for(Rule<T> rule : ruleList){

            rule.apply(item, fileName);
        }
    }
}
