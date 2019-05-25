package frc.robot.commands;

import edu.wpi.first.wpilibj.experimental.command.InstantCommand;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterSetSpeedCommand extends InstantCommand {

  public ShooterSetSpeedCommand(double speed, ShooterSubsystem shooter) {
    super(() -> { shooter.setSpeed(speed); }, shooter);
  }

}
