/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author misfit
 */
public class LiteracyLevel {
    private String country;
    private int year;
    private String gender;
    private double percentage;
    
    public LiteracyLevel(String country, int year, String gender, double percent) {
        this.country = country;
        this.year = year;
        String gen = gender.replace("(%)", "");
        gen = gen.trim();
        this.gender = gen;
        this.percentage = percent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    
    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.percentage;
    }
    
}
