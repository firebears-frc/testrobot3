package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.experimental.command.SendableSubsystemBase;

/**
 * Drive motors and wheels.
 */
public class ChassisSubsystem extends SendableSubsystemBase {

  private final SpeedControllerGroup m_leftMotors;
  private final SpeedControllerGroup m_rightMotors;
  private final DifferentialDrive m_drive;

  public ChassisSubsystem(SpeedController leftFrontMotor, SpeedController leftRearMotor, 
      SpeedController rightFrontMotor, SpeedController rightRearMotor) {
    m_leftMotors = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
    m_rightMotors = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);
    m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot);
  }

  /**
   * Sets the max output of the drive. Useful for scaling the drive to drive more
   * slowly.
   *
   * @param maxOutput the maximum output to which the drive will be constrained
   */
  public void setMaxOutput(double maxOutput) {
    m_drive.setMaxOutput(maxOutput);
  }
}
