package org.kainos.ea.cli;

public class Contractor implements IPayable
{
    private String name;
    private double dailyRate;
    private int monthlyDaysWorked;

    public Contractor(String name, double DailyRate, int monthlyDaysWorked){
        setName(name);
        setDailyRate(DailyRate);
        setMonthlyDaysWorked(monthlyDaysWorked);
    }

    public int getMonthlyDaysWorked() {
        return monthlyDaysWorked;
    }

    public void setMonthlyDaysWorked(int monthlyDaysWorked) {
        this.monthlyDaysWorked = monthlyDaysWorked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public double calcPay() {
        return getDailyRate() * getMonthlyDaysWorked();
    }

    @Override
    public double calcBonus() {
        return calcPay() * 0.01;
    }
}
