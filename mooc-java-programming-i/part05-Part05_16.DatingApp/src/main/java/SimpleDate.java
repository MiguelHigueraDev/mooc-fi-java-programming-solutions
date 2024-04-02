
public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean before(SimpleDate compared) {
        if (this.year < compared.year) {
            return true;
        }

        if (this.year == compared.year && this.month < compared.month) {
            return true;
        }

        if (this.year == compared.year && this.month == compared.month
                && this.day < compared.day) {
            return true;
        }

        return false;
    }

    public void advance() {
        if (this.day == 30) {
            this.day = 1;
            // Advance month and year as well
            if (this.month == 12) {
                this.month = 1;
                this.year++;
            } else {
                this.month++;
            }
        } else {
            this.day++;
        }
    }

    public void advance(int howManyDays) {
        if (this.day == 30) {
            this.day = howManyDays;
        } else {
            this.day += howManyDays;
        }

        if (this.month == 12) {
            this.month = 1;
            this.year++;
        } else {
            this.month++;
        }
    }
    
    public SimpleDate afterNumberOfDays(int days) {
        SimpleDate newDate = new SimpleDate(this.day, this.month, this.year);
        
        while (days > 0) {
            if (newDate.day < 30) {
                newDate.day++;
            } else {
                newDate.day = 1;
                if (newDate.month == 12) {
                    newDate.month = 1;
                    newDate.year++;
                } else {
                    newDate.month++;
                }
            }
            days--;
        }
        
        return newDate;
    }

}
