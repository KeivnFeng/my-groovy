package com.mygroovy.demo.collection

/**
 * Created by Kevin on 27/10/2016.
 */
class ListTest {

    static main(args){
        //listProcess();

        //listsTakingPartInControlStr();

        manipulateListContent();
    }

    static listDefine(){
        def myList = [1,2,3,3,4,5,653,2];
        def longList = (0..1000).toList();

        /*def explicitList = new ArrayList();
        explicitList.addAll(myList);

        explicitList = new LinkedList(mylist);*/

        assert myList[0..1] == [1,2];

        assert myList[0,2] == [1, 3];

        assert myList[-1..-3] == [2,653,5];

        println myList[0..-2]
    }

    static listProcess(){
        def myList = [];
        myList += 'a';
        assert myList == ['a'];

        myList += ['b', 'c'];
        assert myList == ['a', 'b', 'c'];

        myList = [];
        myList << 'a' << 'b';
        assert myList == ['a', 'b'];

        myList - ['b'];
        print(myList);

        assert (myList = (myList - ['b'])) == ['a'];
        print(myList);
        assert myList * 2 == ['a',  'a', ];


    }

    static listsTakingPartInControlStr(){
        def myList = ['a','b','c'];
        assert myList.isCase('a');

        def candidate = 'a';

        switch (candidate){
            case myList:
                assert true;
                break;
            default:
                assert false
        }


        assert  ['x','a','z'].grep(myList) == ['a'];

        myList = [];

        if(myList) assert false;

        def log = '';
        for(i in [1, 'x', 5]){
            log += i;
        }

        assert log == '1x5';
    }

    static manipulateListContent(){
        assert [1, [2, 3]].flatten() == [1, 2, 3];

        assert [1,2,3].intersect([4,3,1]) == [3,1];
        assert [1,2,3].disjoint([4,5,6]);

        def list = [1,2,3];
        def popped = list.pop();
        assert popped == 3;
        assert list == [1,2];

        assert [1,2].reverse() == [2,1];
        assert [3,1,2].sort() == [1,2,3];

        list = [[1,0], [0,1,2]];
        list = list.sort{a,b ->a[0] <=> b[0]};
        assert list == [[0,1,2], [1,0]];

        list = ['a','b','c'];
        list.remove(2);
        assert list == ['a', 'b'];
        list.remove('b');
        assert  list == ['a'];

        def doubled = [1,2,3].collect{ item ->
            item*2;
        }
    }
}
