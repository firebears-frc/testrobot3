package frc.robot.commands;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;

import edu.wpi.first.wpilibj.experimental.command.CommandScheduler;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterServoArmCommandTest {

    CommandScheduler scheduler = null;
    ShooterSubsystem shooter = null;

    @Before
    public void setup() {
        shooter = mock(ShooterSubsystem.class);
        scheduler = CommandScheduler.getInstance();
        scheduler.registerSubsystem(shooter);
    }

    @After
    public void cleanup() {
        scheduler.cancelAll();
        scheduler.unregisterSubsystem(shooter);
    }

    @Test
    public void testRetractArm() {
        // Arrange
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
