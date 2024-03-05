package org.unathi.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionsArchitect extends Workers {
    private int projects = 0;
    String archtctRegex = "\\w+\\s?=\\s?(?<prjct>\\w+)";
    Pattern arhctctPat = Pattern.compile(archtctRegex);


    public SolutionsArchitect(String personText) {
        super(personText);
        Matcher archtctMat = arhctctPat.matcher(mat.group("details"));
        if (archtctMat.find()) {
            this.projects = Integer.parseInt(archtctMat.group("prjct"));
        }
    }
    public int getSalary(){
        return  4500 * projects;
    }


}
