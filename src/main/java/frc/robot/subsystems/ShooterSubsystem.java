package frc.robot.subsystems;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.experimental.command.SendableSubsystemBase;

public class ShooterSubsystem extends SendableSubsystemBase {

  protected final SpeedController shooterMotor;
  private final Servo shooterServo;
  private boolean servoRetracted = true;

  public ShooterSubsystem(SpeedController motor, Servo servo) {
    shooterMotor = motor;
    shooterServo = servo;
  }

  public void setSpeed(final double speed) {
    shooterMotor.set(speed);
  }

  public void retract() {
    shooterServo.set(SHOOTER_SERVO_MIN);
    servoRetracted = true;
  }

  public void fire() {
    shooterServo.set(SHOOTER_SERVO_MAX);
    servoRetracted = false;
  }

  public void toggle() {
    if (servoRetracted) {
      fire();
    } else {
      retract();
    }
  }

  public void reset() {
    setSpeed(0.0);
    retract();
  }

  public boolean isServoArmRetracted() {
    return servoRetracted;
  }
}
