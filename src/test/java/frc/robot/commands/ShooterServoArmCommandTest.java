package frc.robot.commands;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;

import edu.wpi.first.wpilibj.experimental.command.CommandScheduler;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterServoArmCommandTest {

    CommandScheduler scheduler = null;

    @Before
    public void setup() {
        scheduler = CommandScheduler.getInstance();
    }

    @After
    public void cleanup() {
        scheduler.cancelAll();
    }

    @Test
    public void testRetractArm() {
        // Arrange
        ShooterSubsystem shooter = mock(ShooterSubsystem.class);
        ShooterServoArmCommand retractCommand = new ShooterServoArmCommand(false, shooter) {
            @Override
            public boolean runsWhenDisabled() {
                return true;
            }
        };

        // Act
        scheduler.scheduleCommand(retractCommand, true);
        scheduler.run();

        // Assert
        verify(shooter).retract();
    }

    @Test
    public void testFireArm() {
        // Arrange
        ShooterSubsystem shooter = mock(ShooterSubsystem.class);
        ShooterServoArmCommand fireCommand = new ShooterServoArmCommand(true, shooter) {
            @Override
            public boolean runsWhenDisabled() {
                return true;
            }
        };

        // Act
        scheduler.scheduleCommand(fireCommand, true);
        scheduler.run();

        // Assert
        verify(shooter).fire();
    }
}
