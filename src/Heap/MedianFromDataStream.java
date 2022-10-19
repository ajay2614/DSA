package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStream {
    PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minH = new PriorityQueue<>();

    public void addNum(int num) {

        if(maxH.isEmpty() || maxH.peek() >= num)
            maxH.add(num);
        else
            minH.add(num);

        if(maxH.size() > minH.size() + 1)
            minH.add(maxH.poll());
        else if(minH.size() > maxH.size())
            maxH.add(minH.poll());
    }

    public double findMedian() {
        if(maxH.size() == minH.size()) {
            int l = maxH.peek();
            int r = minH.peek();

            return (l + r)/2.0;
        }

        return maxH.peek();
    }

    public static void main(String[] args) {
        /**
         *
         * IN THIS QUESTION WE ARE TO FIND MEDIAN AT ANY GIVEN STAGE AND ADD NUM AT ANY GIVEN STAGE
         *
         * TO IMPLEMENT THIS WE WILL USE MAX HEAP AND MIN HEAP
         *
         * WHY MAX AND MEAN HEAP, BECAUSE THEY WOULD ALLOW US TO STORE IN A SORTED MANNER AND WITH THESE TWO HEAPS
         * WE CAN EASILY GET MEDIAN WHICH WOULD BE TOP OF MAX HEAP(LEFT PARTITION) IF BOTH THE HEAP SIZE
         * ISN'T EQUAL AND IF IT IS THEN TOP OF MAX HEAP(LEFT PARTITION) AND TOP OF MIN HEAP(RIGHT PARTITION)
         *
         * HOW THIS WORKS?
         *
         * WE WILL START STORING ELEMENT IN MAX HEAP AS WE KNOW IT WOULD GIVE US LEFT PARTITION AND AS
         * FOR ANY SET OF NUMBERS IN INCREASING ORDER WE START LIKE 1 2 THEN UPTO N, SO MAX HEAP SHOULD BE FILLED FIRST
         *
         * THE CONDITION TO FILL IN MAX HEAP
         * IF IT IS EMPTY OR IF THE NUMBER IS SMALLER THAN THE TOPMOST ELEMENT, BECAUSE LETS SAY MAX HEAP HAS
         * 1 AND 3, AND THEN SUPPOSE 2 COMES, AS 2 COMES BEFORE 3, IT MEANS IT WOULD BELONG TO LEFT PART AND IT MAKES NO
         * SENSE TO STORE IT AT RIGHT WHICH IS MIN HEAP
         *
         * THE CONDITION TO STORE IN MIN HEAP, WHEN THE ELEMENT AT TOP OF MIN HEAP IS GREATER THAN TOP OF MIN HEAP,
         * SUGGESTING IT IS BIGGER THAN LEFT MOST PART OF RIGHT PARTITION AND BELONGS TO RIGHT PARTITION, SO WE STORE
         * IT IN RIGHT SIDE.
         *
         * ALONG WITH THE ABOVE TWO CONDITIONS, WE ALSO NEED TO MAKE SURE THAT SIZE OF MAX HEAP AND MIN HEAP
         * IS EQUAL OR SIZE OF MAX HEAP IS ONLY 1 GREATER THAN SIZE OF MIN HEAP, THIS IS BECAUSE
         * WE ARE STORING SUCH THAT WE CAN EASILY GET MEDIAN,
         *
         * SO WE CHECK WHETHER MAX HEAP SIZE > MIN HEAP SIZE + 1
         * IF SO STORE THE TOP MOST ELEMENT IN MIN HEAP
         *
         * SIMILARLY IF MIN HEAP SIZE IS BIGGER THAN MAX HEAP, WE NEED TO STORE IN SUCH WAY THAT MAX HEAP IS ALWAYS EQUAL
         * TO OR 1 GREATER THAN MIN HEAP SO WE POP FROM MIN HEAP TO MAX HEAP
         *
         *
         * NOW WHEN WE HAVE TO COMPUTE MEDIAN, WE CHECK IF SIZE OF BOTH MAX AND MIN HEAP IS SAME, THIS WOULD MEAN
         * THAT TOTAL NUMBERS ARE EVEN, SO GET LEFT MIDDLE AND RIGHT MIDDLE, WHICH IS JUST TOP OF MAX AND MIN HEAP AND
         * DIVIDE BY 2.0
         *
         * IN CASE OF ODD, JUST GET THE LEFT MIDDLE WHICH IS JUST THE TOP OF MAX HEAP AND RETURN.
         */
        MedianFromDataStream medianFromDataStream = new MedianFromDataStream();

        medianFromDataStream.addNum(1);
        medianFromDataStream.addNum(2);

        double data = medianFromDataStream.findMedian();

        System.out.println(data);

        medianFromDataStream.addNum(3);

        data = medianFromDataStream.findMedian();

        System.out.println(data);


    }
}
