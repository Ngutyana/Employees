package org.unathi.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer extends Workers
{
    private int linesOfCode = 0;
    private int yearsOfExp = 0;
    private int iq = 0;

    private final String progRegex = "\\w+=(?<loc>\\w),\\w+=(?<yoe>\\w),\\w+=(?<iq>\\w)";
    private final Pattern coderPat = Pattern.compile(progRegex);

    public Programmer(String personText) {
    super(personText);
        Matcher coderMat =  coderPat.matcher(mat.group("details"));
        if (coderMat.find()) {
            this.linesOfCode = Integer.parseInt(coderMat.group("loc"));
            this.yearsOfExp = Integer.parseInt(coderMat.group("yoe"));
            this.iq = Integer.parseInt(coderMat.group("iq"));
        }
    }
    public int getSalary(){
        return  3000 + linesOfCode * yearsOfExp * iq;
    }

}
