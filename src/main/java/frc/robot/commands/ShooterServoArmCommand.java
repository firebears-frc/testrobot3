package frc.robot.commands;

import edu.wpi.first.wpilibj.experimental.command.*;
import frc.robot.subsystems.*;

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

  @Override
  public boolean runsWhenDisabled() {
    return true;
  }
}
