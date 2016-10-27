package com.mygroovy.demo.collection

/**
 * Created by Kevin on 27/10/2016.
 */
class MapTest {

     static main(args){
        countingWordFrequency();
    }

    def iteratingMap(){
        def myMap = [a:1, b:2, c:3];

        def store = '';
        myMap.each {entry ->
            store += entry.key;
            store += entry.value;
        }

        assert store.contains('a1');
        assert store.contains('b2');
        assert store.contains('c3');

        store = '';
        myMap.each {key, value ->
            store += key;
            store += value;
        }

        assert store.contains('a1');
        assert store.contains('b2');
        assert store.contains('c3');

        store = '';
        for(key in myMap.keySet()){
            store += key;
        }

        assert store.contains('a');
        assert store.contains('b');
        assert store.contains('c');

        store = '';
        for(value in myMap.values()){
            store += value;
        }

        assert store.contains('1');
        assert  store.contains('2');
        assert store.contains('3');
    }

    static mapProcess(){
        def myMap = [a:1, b:2, c:3];
        myMap.clear();
        assert myMap.isEmpty();

        myMap = [a:1, b:2, c:3];
        def abMap = myMap.subMap(['a','b']);
        assert abMap.size() == 2;

        abMap = myMap.findAll {entry -> entry.value < 3};

        assert abMap.size() == 2;
        assert abMap.a == 1;

        def found = myMap.find{entry -> entry.value < 2};
        assert found.key == 'a';
        assert found.value == 1;


        def doubled = myMap.collect {entry -> entry.value *= 2}
        assert doubled instanceof List;
        assert doubled.every{item -> item % 2 == 0};

        def addTo = [];

        myMap.collect (addTo){entry -> entry.value *= 2};
        assert doubled instanceof List;
        assert addTo.every{item -> item % 2 == 0};

    }

    def countingWordFrequency(){
        def textCorpus = """
        Look for the bare necessities
        The simple bare necessities
        Forget about your worries and you strife
        I mean the bare necessities
        Old Mother Nature's recipes
        That bring the bare necessities of life
        """;

        def words = textCorpus.tokenize();
        def wordFrequency = [:];
        words.each {word ->
            wordFrequency[word] = wordFrequency.get(word, 0) + 1;
        }

        def wordList = wordFrequency.keySet().toList();
        wordList.sort{wordFrequency[it]};

        def statistic = "\n";
        wordList[-1..-6].each {word ->
            statistic += word.padLeft(12) + ': ';
            statistic += wordFrequency[word] + "\n";
        }

        assert statistic ==
                """
                        bare:4
                 necessities:4
                         the:3
                        your:2
                         for:1
                     recipes:1
                """
    }

}
