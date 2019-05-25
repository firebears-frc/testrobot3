package frc.robot.commands;

import edu.wpi.first.wpilibj.experimental.command.SendableCommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterServoArmCommand extends SendableCommandBase {

  private final boolean fire;
  private final ShooterSubsystem shooter;

  public ShooterServoArmCommand(boolean fireArm, ShooterSubsystem shooterSubsystem) {
    fire = fireArm;
    shooter = shooterSubsystem;
    addRequirements(shooter);
  }

  @Override
  public void execute() {
    if (fire) {
      shooter.fire();
    } else {
      shooter.retract();
    }
  }

  @Override
  public boolean isFinished() {
    return true;
  }

}
