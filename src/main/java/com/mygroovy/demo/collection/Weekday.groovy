package com.mygroovy.demo.collection

/**
 * Created by Kevin on 27/10/2016.
 */
class Weekday implements Comparable{

    static final DAYS = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];

    private int index = 0;

    Weekday(String day){
        index = DAYS.indexOf(day);
    }

    Weekday next(){
        return new Weekday(DAYS[(index+1) % DAYS.size()]);
    }

    Weekday previous(){
        return new Weekday(DAYS[index - 1]);
    }


    int compareTo(Object other) {
        return this.index <=> other.index;
    }

    static main(args){
        def mon = new Weekday('Mon');

        println(mon.index);
        def fri = new Weekday('Fri');
        println(fri.index);

        def worklog = '';
        for (day in mon .. fri){
            worklog += day.DAYS[day.index].toString() + ' ';
        }

        println(worklog);
        assert worklog == 'Mon Tue Wed Thu Fri ';

    }
}
