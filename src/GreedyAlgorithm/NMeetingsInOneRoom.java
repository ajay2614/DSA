package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Meeting {
    int start;
    int end;
    int index;
    Meeting() {}

    Meeting( int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}
class MeetingSort implements Comparator<Meeting> {


    @Override
    public int compare(Meeting m1, Meeting m2) {
        if(m1.end > m2.end)
            return 1;
        else if (m1.end < m2.end)
            return 0;
        else if (m1.end == m2.end) {
         if(m1.index > m2.index)
             return 1;
         else if (m1.index < m2.index)
             return -1;
        }
        return 0;
    }
}
public class NMeetingsInOneRoom {
    public static int maxMeetings(int start[], int end[], int n) {
        List<Meeting> meetings = new ArrayList<>();

        for(int i=0;i<n;i++) {
            meetings.add(new Meeting(start[i], end[i], i+1));
        }
        MeetingSort meetingSort = new MeetingSort();
        Collections.sort(meetings, meetingSort);

        int res = 1;

        int limit = meetings.get(0).end;
        for (int i = 1; i< meetings.size();i++) {
            if(meetings.get(i).start > limit) {
                limit = meetings.get(i).end;
                res+=1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * THE QUESTION HAS GIVEN US TWO ARRAYS, WHICH HAVE A CERTAIN MEETING ENDING TIME AND STARTING TIME
         *
         * WE WOULD NEED TO FIND THE TOTAL NUMBER OF MEETINGS THAT CAN BE HELD
         *
         * APPROACH
         *
         * IF WE CAN SORT A CERTAIN MEETING VIA ITS FINISHING TIME, AND THEN COMPARE STARTING TIME OF NEXT MEETING WITH
         * IT WE WILL BE ABLE TO SOLVE THIS QUESTION
         *
         * DECLARING A MEETING CLASS AND STORING EVERY MEETING IN LIST, AFTER THIS WE SORT USING COMPARATOR BASED ON FINISH
         * TIME, NOW WE WILL STORE THE FIRST FINISH TIME AND START FROM 1 TO N-1 INDEX AND COMPARE THAT FINISH TIME VARIABLE
         * WITH STARTING TIME, IF FINISH TIME IS SMALLER THEN UPDATE FINISH TIME OF THE INDEX MEETING AND ADD TO ANS.
         */
        int start[] = {1,3,0,5,8,5, 8};
        int end[] =  {2,4,6,7,9,9, 9};
        int N = 7;

        maxMeetings(start, end,N);
    }
}
