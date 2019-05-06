package frc.robot.subsystems;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import edu.wpi.first.wpilibj.*;
import org.junit.*;


public class ShooterSubsystemTest {

    public static final double DELTA = 0.001;

    @Test
    public void testConstructor() {
        // Arrange
        SpeedController motor = mock(SpeedController.class);
        Servo servo = mock(Servo.class);

        // Act
        ShooterSubsystem shooter = new ShooterSubsystem(motor, servo);

        // Assert
        assertEquals(true, shooter.servoRetracted);
    }

    @Test
    public void testSetSpeed() {
        // Arrange
        SpeedController motor = mock(SpeedController.class);
        Servo servo = mock(Servo.class);
        when(motor.get()).thenReturn(0.5);

        ShooterSubsystem shooter = new ShooterSubsystem(motor, servo);

        // Act
        shooter.setSpeed(0.5);

        // Assert
        assertEquals(0.5, shooter.shooterMotor.get(), DELTA);
    }
}
