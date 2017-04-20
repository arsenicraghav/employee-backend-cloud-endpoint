package com.g4s.javelin.util;

import com.g4s.javelin.employee.model.JobType;
import com.g4s.javelin.employee.model.OverTimePeriod;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by sromares on 3/16/16.
 */
public class EmployeeFieldFaker extends Faker {

    public String id() {
        Random random = new Random();
        int n = random.nextInt(10000) + 1;
        return "1054287" + n;
    }

    public String title() {
        String[] titleArr = {"Mr", "Miss", "Mrs", "Dr", "Sir", ""};
        Random random = new Random();
        int n = random.nextInt(titleArr.length);
        return titleArr[n];
    }

    public OverTimePeriod overtimePeriod() {
        OverTimePeriod overTimePeriod = new OverTimePeriod();
        Random random = new Random();
        int n = random.nextInt(2) + 1;
        if (n == 1) {
            overTimePeriod.setId("FORTNIGHTLY");
            overTimePeriod.setType("Fortnightly");
        } else {
            overTimePeriod.setId("WEEKLY");
            overTimePeriod.setType("Weekly");
        }
        return overTimePeriod;
    }

    public String dateOfBirth() {
        Random random = new Random();

        int randomYear = random.nextInt(30) + 1980;
        int dayOfYear = random.nextInt(300) + 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, randomYear);
        calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
        Date randomDoB = calendar.getTime();
        String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(randomDoB);
        return formattedDate;
    }

    public String payGroup() {
        Random random = new Random();
        int n = random.nextInt(300) + 200;
        return "" + n;
    }

    public String basicHours() {
        Random random = new Random();
        int n = random.nextInt(80) + 40;
        return "" + n;
    }

    public String rank() {
        String[] titleArr = {"Security Officer 1", "Security Officer 2", "HR Officer 1", "HR Officer 2", "Site Manager 1", "Site Manager 2"};
        Random random = new Random();
        int n = random.nextInt(titleArr.length);
        return titleArr[n];
    }

    public JobType jobType() {
        JobType jobType = new JobType();
        Random random = new Random();
        int n = random.nextInt(3) + 1;
        if (n == 1) {
            jobType.setId("PART_TIME");
            jobType.setType("Part Time");
        } else if (n == 2) {
            jobType.setId("FULL_TIME");
            jobType.setType("Full Time");
        } else {
            jobType.setId("CASUAL");
            jobType.setType("Casual");
        }
        return jobType;
    }

    public String regulationOption() {
        String regOption;
        Random random = new Random();
        int n = random.nextInt(3) + 1;
        if (n == 1) {
            regOption = "MORE_THAN_AVERAGE";
        } else if (n == 2) {
            regOption = "LESS_THAN_AVERAGE";
        } else {
            regOption = "AVERAGE";
        }
        return regOption;
    }

    public List<String> roles() {
        String[] roleArr = {"role0", "role1", "role2", "role3"};
        List<String> roleList = new ArrayList<>();

        Random randomRoleCount = new Random();
        int count = randomRoleCount.nextInt(roleArr.length);

        roleList.add(roleArr[0]);
        if (count > 1) {
            roleList.add(roleArr[1]);
        }
        if (count > 2) {
            roleList.add(roleArr[2]);
        }
        if (count > 3) {
            roleList.add(roleArr[3]);
        }
        return roleList;
    }

}