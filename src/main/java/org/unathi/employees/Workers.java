package org.unathi.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Workers {
    protected final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
    private final String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+\\s?\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
    protected final Pattern pat = Pattern.compile(regex);
    protected final Matcher mat;
    protected String firstName;
    protected String lastName;
    protected LocalDate dob;
    DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("d/M/y");

    public Workers(String personText) {
        mat = pat.matcher(personText);
        if(mat.find()) {
            this.lastName = mat.group("lastName");
            this.firstName = mat.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(mat.group("dob")));
        }
    }

    public int getSalary() {
        return 0;
    }

    public double getBonus(){
        return  getSalary() * 2.0;
    }
    @Override
    public String toString() {
        return String.format("%s, %s : %s",lastName, firstName, moneyFormat.format(getSalary()));
    }
}
