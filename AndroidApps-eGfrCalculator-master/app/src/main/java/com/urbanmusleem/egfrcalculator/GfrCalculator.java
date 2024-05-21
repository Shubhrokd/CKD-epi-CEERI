package com.urbanmusleem.egfrcalculator;

public class GfrCalculator {

    private double age, creatinine;
    private double genderConstant, raceConstant;
    private double result;
    private int ckdResult;

    public GfrCalculator(double age, double creatinine, double genderConstant, double raceConstant) {
        this.age = age;
        this.creatinine = creatinine;
        this.genderConstant = genderConstant;
        this.raceConstant = raceConstant;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setCreatinine(double creatinine) {
        this.creatinine = creatinine;
    }

    public void setGenderConstant(double genderConstant) {
        this.genderConstant = genderConstant;
    }

    public void setRaceConstant(double raceConstant) {
        this.raceConstant = raceConstant;
    }

    public void setCkdResult(int ckdResult) {
        this.ckdResult = ckdResult;
    }

    public double getGfrResult() {
        result = 175 * Math.pow((creatinine / 88.4), -1.154) * Math.pow(age, -0.203) * genderConstant * raceConstant;
        return result;

         /*

             MDRD eGFR formula =                175
                                                 x
                                     (SCr/88.4)powerOf-1.154
                                                 x
                                        (Age)powerOf-0.203
                                                 x
                                          (0.742 if female)
                                                 x
                                    (1.212 if African-American)

          */



    }

}
