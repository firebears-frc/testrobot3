package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.experimental.command.SendableSubsystemBase;

/**
 * Shoots balls.
 */
public class ShooterSubsystem extends SendableSubsystemBase {

  private final Preferences config = Preferences.getInstance();
  private final double SERVO_MIN = config.getDouble("shooter.servo_min", 0.0);
  private final double SERVO_MAX = config.getDouble("shooter.servo_max", 90.0);

  private final SpeedController shooterMotor;
  private final Servo shooterServo;

  public ShooterSubsystem(SpeedController motor, Servo servo) {
    shooterMotor = motor;
    shooterServo = servo;
  }

  public void setSpeed(double speed) {
    shooterMotor.set(speed);
  }

  public void retract() {
    shooterServo.set(SERVO_MIN);
  }

  public void fire() {
    shooterServo.set(SERVO_MAX);
  }
}
