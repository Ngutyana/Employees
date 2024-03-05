package org.unathi.employees;

import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String people = """
            Sarah1, A, 17/2/2001, Programmer, {loc=2000,yoe=10,iq=140}
            Sarah2, B, 01/4/2002, Programmer, {loc=1500,yoe=12,iq=120}
            Sarah3, C, 04/9/2003, Programmer, {loc=2000,yoe=10,iq=112}
            Sarah4, D, 23/10/2004, Programmer, {loc=2000,yoe=10,iq=100}
            Steve, M, 02/2/1988, Manager, {OrgSize = 500}
            Steve, N, 14/7/1987, Manager, {OrgSize = 150}
            Steve, O, 23/9/1986, Manager, {OrgSize = 200}
            Steve, P, 21/12/1985, Manager, {OrgSize = 50}
            Unathi1, N, 05/3/2000, Solutions Architect, {Projects = 9}
            Unathi2, O, 25/12/1999, Solutions Architect, {Projects = 7}
            Unathi3, P, 30/7/1910, Solutions Architect, {Projects = 5}
            Unathi4, Q, 12/9/1998, Solutions Architect, {Projects = 10}
            """;

        String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+\\s?\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(people);

        int totalSalaries = 0;
        Workers employee = null;

        while (mat.find()) {
            employee = switch (mat.group("role")) {
                case "Programmer" -> new Programmer(mat.group());
                case "Manager" -> new Manager(mat.group());
                case "Solutions Architect" -> new SolutionsArchitect(mat.group());
                default -> new Workers(mat.group());
            };
            System.out.println(employee.toString());
            totalSalaries += employee.getSalary();

        }
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.printf("Total payout should be be %s%n",currency.format(totalSalaries));
    }
}