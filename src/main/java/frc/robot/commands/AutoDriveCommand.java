package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.experimental.command.SendableCommandBase;
import frc.robot.subsystems.ChassisSubsystem;

/**
 * Autonomous command for driving forward a given number of seconds.
 */
public class AutoDriveCommand extends SendableCommandBase {

  private final ChassisSubsystem chassis;
  private final Timer timer = new Timer();
  private final double maxTime;

  public AutoDriveCommand(ChassisSubsystem chassisSubsystem, double seconds) {
    chassis = chassisSubsystem;
    addRequirements(chassis);
    maxTime = seconds;
  }

  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  @Override
  public void execute() {
    chassis.arcadeDrive(0.5, 0.0);
  }

  @Override
  public boolean isFinished() {
    return timer.get() > maxTime;
  }

  @Override
  public void end(boolean interrupted) {
    chassis.arcadeDrive(0.0, 0.0);
  }
}
