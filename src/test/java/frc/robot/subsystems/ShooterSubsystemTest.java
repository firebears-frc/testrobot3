package frc.robot.subsystems;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import edu.wpi.first.wpilibj.*;
import org.junit.*;


public class ShooterSubsystemTest {

    @Test
    public void testSetSpeed() {
        // Arrange
        SpeedController motor = mock(SpeedController.class);
        Servo servo = mock(Servo.class);
        ShooterSubsystem shooter = new ShooterSubsystem(motor, servo);

        // Act
        shooter.setSpeed(0.5);

        // Assert
        assertEquals(0.5, shooter.shooterMotor.get());
    }
}
