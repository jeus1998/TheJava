package org.example;

public class Moim {
    int maxNumberOfAttendees; // 최대 참가자
    int numberOfEnrollment;   // 현재 신청자
    public boolean isEnrollmentFull(){
        if(maxNumberOfAttendees == 0) { // 참가 무한대로 가능
            return false;
        }
        if(numberOfEnrollment < maxNumberOfAttendees) {
            return false;
        }
        return true;
    }
}