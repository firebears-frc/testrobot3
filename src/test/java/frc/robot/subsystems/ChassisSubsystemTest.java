package frc.robot.subsystems;

import static org.junit.Assert.*;
import org.junit.*;

public class ChassisSubsystemTest {

    @Test
    public void testSimplifyAngle() {
        ChassisSubsystem chassis = new ChassisSubsystem(null, null, null, null, null);
        assertEquals(-90, chassis.simplifyAngle(270));
        assertEquals(-45, chassis.simplifyAngle(315));
        assertEquals(-60, chassis.simplifyAngle(-60));
        assertEquals(30, chassis.simplifyAngle(30));
        assertEquals(0, chassis.simplifyAngle(0));
        assertEquals(180, chassis.simplifyAngle(180));
        assertEquals(-180, chassis.simplifyAngle(-180));
        assertEquals(97, chassis.simplifyAngle(1537));
        assertEquals(99, chassis.simplifyAngle(-2781));
    }
}
