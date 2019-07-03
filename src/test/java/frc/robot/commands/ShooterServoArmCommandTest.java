package frc.robot.commands;

import edu.wpi.first.wpilibj.experimental.command.*;
import frc.robot.subsystems.*;
import org.junit.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ShooterServoArmCommandTest {

    private CommandScheduler scheduler = null;

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
        ShooterServoArmCommand retractCommand = new ShooterServoArmCommand(false, shooter);

        // Act
        scheduler.schedule(retractCommand);
        scheduler.run();

        // Assert
        verify(shooter).retract();
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
    }
}
