package com.mygroovy.demo.string
/**
 * Created by Kevin on 27/10/2016.
 */
class GStringTest {

    static main(args){
//        def me = 'Tarzan';
//        def you = 'Jane';
//        def line = "me $me - you $you";
//
//        println line;
//
//        assert line == 'me Tarzan - you Jane';
//        assert line instanceof GString;
//        assert line.strings[0] == 'me ';
//        println(line);
//        assert line.strings[1] == ' - you ';
//        println(line);
//        assert line.values[0] == 'Tarzan';
//        assert line.values[1] == 'Jane'
//
//        def date = new Date(0);
//        def out = "Year $date.year Month $date.month Day $date.date";
//
//        assert out == 'Year 70 Month 0 Day 1';
//
//
//        out = "Date is ${date.toGMTString()} !";
//        assert out == 'Date is 1 Jan 1970 00:00:00 GMT !';
//        def sql = """
//            SELECT FROM MyTable
//                WHERE Year = $date.year
//        """;
//
//        assert sql == """
//            SELECT FROM MyTable
//                WHERE Year = 70
//        """;
//
//        out = "my 0.02\$";
//
//        assert out == 'my 0.02$';

        /*System.out.println('xxxxxxxx');
        System.out.println("ddddddd")*/

       /* def greeting = 'Hello Groovy';
        assert greeting.startsWith('Hello');

        assert greeting.getAt(0) == 'H';
        assert greeting[0] == 'H';

        assert greeting.indexOf('Groovy') >= 0;
        assert greeting.contains('Groovy');

        assert greeting[6..11] == 'Groovy';
        assert 'Hi' + greeting - 'Hello' == 'Hi Groovy';

        assert greeting.count('o') == 3;

        assert 'x'.padLeft(3) == '  x';
        assert 'x'.padRight(3, '--') == 'x--';
        assert 'x'.center(3) == ' x ';
        assert 'x' * 3 == 'xxx';
*/

        def greeting = 'Hello';
        greeting <<= ' Groovy';
        assert greeting instanceof  java.lang.StringBuffer;
        greeting << '!';
        assert greeting.toString() == 'Hello Groovy!';
        greeting[1..4] = 'i';
        assert greeting.toString() == 'Hi Groovy!';
//正则匹配


    }
}
