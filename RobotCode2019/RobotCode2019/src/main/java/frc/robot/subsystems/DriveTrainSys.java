package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;

public class DriveTrainSys extends Subsystem {
    CANSparkMax rFront = new CANSparkMax(0, MotorType.kBrushless);
    CANSparkMax lFront = new CANSparkMax(1, MotorType.kBrushless);
    CANSparkMax rBack = new CANSparkMax(2, MotorType.kBrushless);
    CANSparkMax lBack = new CANSparkMax(3, MotorType.kBrushless);

    SpeedControllerGroup m_right = new SpeedControllerGroup(rFront, rBack);

    SpeedControllerGroup m_left = new SpeedControllerGroup(lFront, lBack);
     
    DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);

    public void arcadeDrive(){
        //http://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/drive/DifferentialDrive.html#arcadeDrive(double,double)

        rBack.follow(CANSparkMax.ExternalFollower.kFollowerSparkMax, 0);
        lBack.follow(CANSparkMax.ExternalFollower.kFollowerSparkMax, 1);

        //Flips Motor Polarity on Right Side to use same values as left side.
        m_drive.setRightSideInverted(true);
        //Front and Back Axis = 0, Turning Axis = 1
        m_drive.arcadeDrive(Robot.m_oi.driver.getRawAxis(0), Robot.m_oi.driver.getRawAxis(1));
    }

    public void tankDrive(){
        //http://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/drive/DifferentialDrive.html#tankDrive(double,double)

        rBack.follow(CANSparkMax.ExternalFollower.kFollowerSparkMax, 0);
        lBack.follow(CANSparkMax.ExternalFollower.kFollowerSparkMax, 1);

        //Flips Motor Polarity on Right Side to use same values as left side.
        m_drive.setRightSideInverted(true);
        //Uses Both Joysticks X Axis or needs 2 joysticks just for driver
        m_drive.tankDrive(Robot.m_oi.driver.getRawAxis(0), Robot.m_oi.driver.getRawAxis(1));
    }

    public void stop(){
        rFront.stopMotor();
        lFront.stopMotor();
        rBack.stopMotor();
        lBack.stopMotor();
    }

  @Override
  public void initDefaultCommand() {

  }
}
