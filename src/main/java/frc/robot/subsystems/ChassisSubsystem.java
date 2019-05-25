package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.experimental.command.SendableSubsystemBase;

/**
 * Drive motors and wheels.
 */
public class ChassisSubsystem extends SendableSubsystemBase {

  private final SpeedControllerGroup leftMotors;
  private final SpeedControllerGroup rightMotors;
  private final DifferentialDrive robotDrive;
  private final AnalogGyro gyro;

  public ChassisSubsystem(SpeedController leftFrontMotor, SpeedController leftRearMotor,
      SpeedController rightFrontMotor, SpeedController rightRearMotor, AnalogGyro analogGyro) {
    leftMotors = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
    rightMotors = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);
    robotDrive = new DifferentialDrive(leftMotors, rightMotors);
    gyro = analogGyro;
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void arcadeDrive(double fwd, double rot) {
    robotDrive.arcadeDrive(fwd, rot);
  }

  /**
   * Sets the max output of the drive. Useful for scaling the drive to drive more
   * slowly.
   *
   * @param maxOutput the maximum output to which the drive will be constrained
   */
  public void setMaxOutput(double maxOutput) {
    robotDrive.setMaxOutput(maxOutput);
  }

  public int getAngle() {
    return simplifyAngle((int)Math.round(gyro.getAngle()));
  }

  protected int simplifyAngle(int angle) {
    while (angle > 180) {
      angle = angle - 360;
    }
    while (angle < -180) {
      angle = angle + 360;
    }
    return angle;
  }
}
