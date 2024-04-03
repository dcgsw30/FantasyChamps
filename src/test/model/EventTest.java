package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Class adapted from Alarm System file provided in CPSC 210 https://github.students.cs.ubc.ca/CPSC210/AlarmSystem
public class EventTest {
    private Event e;
    private Date d;
    private long dSeconds;
    private long eSeconds;

    //NOTE: these tests might fail if time at which line (2) below is executed
    //is different from time that line (1) is executed.  Lines (1) and (2) must
    //run in same millisecond for this test to make sense and pass.

    @BeforeEach
    public void runBefore() {
        e = new Event("Sensor open at door");   // (1)
        d = Calendar.getInstance().getTime();   // (2)
        dSeconds = d.getTime() / 1000;
        eSeconds = e.getDate().getTime() / 1000;
    }

    @Test
    public void testEvent() {
        assertEquals("Sensor open at door", e.getDescription());
        assertEquals(dSeconds, eSeconds);
    }

    @Test
    public void testToString() {
        assertEquals(d.toString() + "\n" + "Sensor open at door", e.toString());
    }
}