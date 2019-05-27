package frc.robot.commands;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;

import edu.wpi.first.wpilibj.experimental.command.CommandScheduler;
import frc.robot.subsystems.ShooterSubsystem;

public class AutoShootCommandTest {

    private CommandScheduler scheduler = null;

    @Before
    public void setup() {
        scheduler = new CommandScheduler() {
            @Override
            protected boolean isRobotDisabled() {
                return false;
            }
        };
    }

    @After
    public void cleanup() {
        scheduler.cancelAll();
    }

    @Test
    public void testShoot() {
        // Arrange
        ShooterSubsystem shooter = mock(ShooterSubsystem.class);
        AutoShootCommand command = new AutoShootCommand(shooter);

        // Act
        scheduler.schedule(command);
        while (scheduler.getScheduleSize() > 0) {
            scheduler.run();
        }

        // Assert
        verify(shooter, times(2)).retract();
        verify(shooter, times(1)).fire();
        verify(shooter).setSpeed(1.0);
        verify(shooter).setSpeed(0.0);
        assertEquals(0, scheduler.getScheduleSize());
    }
}
