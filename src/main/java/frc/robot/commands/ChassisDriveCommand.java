package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.experimental.command.SendableCommandBase;
import frc.robot.subsystems.ChassisSubsystem;

/**
 * Default command for driving the robot with the game controller.
 * When the {@link ChassisSubsystem} isn't doing anything else, this 
 * command runs.
 */
public class ChassisDriveCommand extends SendableCommandBase {

  private final XboxController controller;
  private final ChassisSubsystem chassis;

  public ChassisDriveCommand(XboxController xboxController, ChassisSubsystem chassisSubsystem) {
    controller = xboxController;
    chassis = chassisSubsystem;
    addRequirements(chassis);
  }

  @Override
  public void execute() {
    double fwd = controller.getY();
    double rot = controller.getX();
    chassis.arcadeDrive(fwd, rot);
  }

}
