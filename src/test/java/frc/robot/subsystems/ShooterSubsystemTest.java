package frc.robot.subsystems;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static frc.robot.Constants.*;
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
        assertEquals(true, shooter.isServoArmRetracted());
    }

    @Test
    public void testSetSpeed() {
        // Arrange
        SpeedController motor = mock(SpeedController.class);
        Servo servo = mock(Servo.class);
        ShooterSubsystem shooter = new ShooterSubsystem(motor, servo);
   
        when(motor.get()).thenReturn(0.5);

        // Act
        shooter.setSpeed(0.5);

        // Assert
        assertEquals(0.5, shooter.shooterMotor.get(), DELTA);
    }

    @Test
    public void testReset() {
        // Arrange
        SpeedController motor = mock(SpeedController.class);
        Servo servo = mock(Servo.class);
        ShooterSubsystem shooter = new ShooterSubsystem(motor, servo);

        // Act
        shooter.reset();

        // Assert
        assertEquals(true, shooter.isServoArmRetracted());
        verify(motor).set(0.0);
        verify(servo).set(SHOOTER_SERVO_MIN);
    }
}
