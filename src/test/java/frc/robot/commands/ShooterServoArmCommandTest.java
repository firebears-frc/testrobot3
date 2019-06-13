package frc.robot.commands;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;

import edu.wpi.first.wpilibj.experimental.command.CommandScheduler;
//import edu.wpi.first.wpilibj.experimental.RobotState;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.hal.sim.DriverStationSim;

public class ShooterServoArmCommandTest {

    private CommandScheduler scheduler = null;

    @Before
    public void setup() {
//        RobotState robotState = mock(RobotState.class);
//        when(robotState.isDisabled()).thenReturn(false);
        DriverStationSim sim = new DriverStationSim();
        sim.setDsAttached(true);
        scheduler = CommandScheduler.getInstance();
        sim.setEnabled(false);
        sim.notifyNewData();
    }

    @After
    public void cleanup() {
        scheduler.cancelAll();
    }

    @Test
    public void testRetractArm() {
        // Arrange
        ShooterSubsystem shooter = mock(ShooterSubsystem.class);
        ShooterServoArmCommand retractCommand = new ShooterServoArmCommand(false, shooter);

        // Act
        scheduler.schedule(retractCommand);
        scheduler.run();

        // Assert
        verify(shooter).retract();
//        assertEquals(0, scheduler.getScheduleSize());
    }

    @Test
    public void testFireArm() {
        // Arrange
        ShooterSubsystem shooter = mock(ShooterSubsystem.class);
        ShooterServoArmCommand fireCommand = new ShooterServoArmCommand(true, shooter);

        // Act
        scheduler.schedule(fireCommand);
        scheduler.run();

        // Assert
        verify(shooter).fire();
//        assertEquals(0, scheduler.getScheduleSize());
    }
}
