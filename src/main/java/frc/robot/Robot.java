package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {
  private DifferentialDrive robotDrive;
  private Joystick leftStick;
  private Joystick rightStick;

  private final CANSparkMax leftMotor = new CANSparkMax(11, MotorType.kBrushed);
  private final CANSparkMax rightMotor = new CANSparkMax(12, MotorType.kBrushed);

  @Override
  public void robotInit() {
    rightMotor.setInverted(true);
    SendableRegistry.addChild(robotDrive, leftMotor);
    SendableRegistry.addChild(robotDrive, rightMotor);

    leftStick = new Joystick(0);
    rightStick = new Joystick(1);
  }

  @Override
  public void teleopPeriodic() {
    robotDrive.tankDrive(-leftStick.getY(), -rightStick.getY());
 }
}