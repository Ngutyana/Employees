package org.unathi.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Workers
{
    private int organisationSize = 0;

    String managerRegex = "\\w+\\s?=\\s?(?<OrgSize>\\w+)";
    Pattern mngrPat = Pattern.compile(managerRegex);

    public Manager(String personText) {
        super(personText);
        Matcher mngrMat = mngrPat.matcher(mat.group("details"));
        if (mngrMat.find()) {
            this.organisationSize = Integer.parseInt(mngrMat.group("OrgSize"));
        }
    }

    public int getSalary(){
        return  5000 * organisationSize;
    }

}
