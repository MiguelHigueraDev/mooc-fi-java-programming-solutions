

public class Checker {

    public boolean isDayOfWeek(String string) {
        String regex = "(mon|tue|wed|thu|fri|sat|sun)";
        return string.matches(regex);
    }
    
    public boolean allVowels(String string) {
        String vowelsRegex = "[aeiou]+";
        return string.matches(vowelsRegex);
    }
    
    public boolean timeOfDay(String string) {
        String timeOfDayRegex = "([01][01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
        return string.matches(timeOfDayRegex);
    }
}
