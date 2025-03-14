class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        //Jan 1 1971 - Friday
        int days = 0;
        for(int i=1971; i<year; i++){
            if(i % 400 == 0 || (i % 4 && i % 100 != 0)){
                days += 366;
            }else{
                days += 365;
            }
        }

        for(int i=1; i<month; i++){
            if(i==1 || i==3 || i==5 || i==7 || i == 8 || i==10 || i==12){
                days += 31;
            }else if(i==4 || i == 6 || i==9 || i == 11){
                days += 30;
            }else if(i == 2){
                boolean isLeapYear = year % 400 || (year % 4 == 0 && year % 100 != 0);
                if(isLeapYear) days += 29;
                else days += 28;
            }
        }

        days += day;

        int remain = days % 7;

        String[] days = new String{"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};

        return days[remain];
    }
}