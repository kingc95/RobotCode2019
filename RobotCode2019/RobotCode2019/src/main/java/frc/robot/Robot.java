package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ArcadeDriveCom;
import frc.robot.commands.ArmLevel1;
import frc.robot.subsystems.ArmSys;
import frc.robot.subsystems.DriveTrainSys;

public class Robot extends TimedRobot {
  public static OI m_oi;

  public static CameraServer cameraServer;

  public static ArcadeDriveCom arcadeCommand = new ArcadeDriveCom();
  public static DriveTrainSys driveTrainSys =  new DriveTrainSys();

  public static ArmSys armSys = new ArmSys();
  public static ArmLevel1 armLevel1Com = new ArmLevel1();

  public UsbCamera lowerCamera = new UsbCamera("Lower Camera", 0);
  public UsbCamera upperCamera = new UsbCamera("Upper Camera", 1);

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    m_oi = new OI();
    m_chooser.setDefaultOption("Default Auto", new ArcadeDriveCom());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);

    lowerCamera.setResolution(320, 240);
    upperCamera.setResolution(320, 240);

    cameraServer.startAutomaticCapture(0);
    cameraServer.startAutomaticCapture(1);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

  }

  @Override
  public void testPeriodic() {
  }
}
