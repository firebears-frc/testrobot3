package frc.robot;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.experimental.command.Command;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.AutoDriveCommand;
import frc.robot.commands.ChassisDriveCommand;
import frc.robot.subsystems.ChassisSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // Low level components
  private final SpeedController leftFrontMotor;
  private final SpeedController leftRearMotor;
  private final SpeedController rightFrontMotor;
  private final SpeedController rightRearMotor;

  private final AnalogGyro gyro;

  private final SpeedController shooterMotor;
  private final Servo shooterServo;

  // The robot's subsystems
  public final ChassisSubsystem chassis;
  public final ShooterSubsystem shooter;

  // A chooser for autonomous commands
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  // The driver's controller
  private final XboxController xboxController = new XboxController(0);

  public RobotContainer() {

      // Create low level components
      leftFrontMotor = new WPI_TalonSRX(CHASSIS_LEFTFRONT_CANID);
      leftRearMotor = new WPI_TalonSRX(CHASSIS_LEFTREAR_CANID);
      rightFrontMotor = new WPI_TalonSRX(CHASSIS_RIGHTFRONT_CANID);
      rightRearMotor = new WPI_TalonSRX(CHASSIS_RIGHTREAR_CANID);
      gyro = new AnalogGyro(1);

      shooterMotor = new WPI_TalonSRX(SHOOTER_MOTOR_CANID);
      shooterServo = new Servo(SHOOTER_SERVO_DIO);

      // Create subsystems
      chassis = new ChassisSubsystem(leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor, gyro);
      chassis.setDefaultCommand(new ChassisDriveCommand(xboxController, chassis));

      shooter = new ShooterSubsystem(shooterMotor, shooterServo);

    // Add commands to the autonomous command chooser
    m_chooser.addOption("Drive 3", new AutoDriveCommand(chassis, 3.0));
    m_chooser.addOption("Drive 5", new AutoDriveCommand(chassis, 5.0));

    // Put the chooser on the dashboard
    Shuffleboard.getTab("Autonomous").add(m_chooser);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }
}
