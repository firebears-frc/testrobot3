package frc.robot.commands;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;

import edu.wpi.first.wpilibj.experimental.command.CommandScheduler;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterSetSpeedCommandTest {

    
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
    public void testCommand() {
         // Arrange
         ShooterSetSpeedCommand command = new ShooterSetSpeedCommand(0.5, shooter) {
            @Override
            public boolean runsWhenDisabled() {
                return true;
            }
        };

        // Act
        scheduler.scheduleCommand(command, true);
        scheduler.run();

        // Assert
        verify(shooter).setSpeed(0.5);
    }
}