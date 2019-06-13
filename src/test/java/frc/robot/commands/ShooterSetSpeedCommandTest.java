package frc.robot.commands;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import edu.wpi.first.hal.sim.DriverStationSim;
import org.junit.*;

//import edu.wpi.first.wpilibj.experimental.RobotState;
import edu.wpi.first.wpilibj.experimental.command.CommandScheduler;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterSetSpeedCommandTest {

    CommandScheduler scheduler = null;
    ShooterSubsystem shooter = null;

    @Before
    public void setup() {
        shooter = mock(ShooterSubsystem.class);
        DriverStationSim sim = new DriverStationSim();
        sim.setDsAttached(true);
        scheduler = CommandScheduler.getInstance();
        sim.setEnabled(false);
        sim.notifyNewData();
    }

    @After
    public void cleanup() {
        scheduler.cancelAll();
        scheduler.unregisterSubsystem(shooter);
    }

    @Test
    public void testCommand() {
         // Arrange
         ShooterSetSpeedCommand command = new ShooterSetSpeedCommand(0.5, shooter);

        // Act
        scheduler.schedule(command);
        scheduler.run();

        // Assert
        verify(shooter).setSpeed(0.5);
    }
}
