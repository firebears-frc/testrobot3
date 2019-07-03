package frc.robot.commands;

import edu.wpi.first.wpilibj.experimental.command.*;
import frc.robot.subsystems.*;

public class AutoShootCommand extends SequentialCommandGroup {
    public AutoShootCommand(ShooterSubsystem shooter) {
        super(
                new PrintCommand("BEGIN: AutoShootCommand"),
                new ShooterServoArmCommand(false, shooter),
                new ShooterSetSpeedCommand(1.0, shooter),
                new WaitCommand(0.5),
                new ShooterServoArmCommand(true, shooter),
                new WaitCommand(0.5),
                new ShooterSetSpeedCommand(0.0, shooter),
                new ShooterServoArmCommand(false, shooter),
                new PrintCommand("END: AutoShootCommand")
        );
    }

    @Override
    public boolean runsWhenDisabled() {
        return true;
    }
}
