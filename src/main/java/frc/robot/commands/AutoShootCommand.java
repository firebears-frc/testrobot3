package frc.robot.commands;

import edu.wpi.first.wpilibj.experimental.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.experimental.command.WaitCommand;
import frc.robot.subsystems.ShooterSubsystem;

public class AutoShootCommand extends SequentialCommandGroup {
    public AutoShootCommand(ShooterSubsystem shooter) {
        super(
                new ShooterServoArmCommand(false, shooter),
                new ShooterSetSpeedCommand(1.0, shooter),
                new WaitCommand(0.25),
                new ShooterServoArmCommand(true, shooter),
                new ShooterSetSpeedCommand(0.0, shooter),
                new ShooterServoArmCommand(false, shooter)
        );
    }
}
