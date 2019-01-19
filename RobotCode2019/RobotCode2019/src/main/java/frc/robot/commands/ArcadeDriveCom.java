package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ArcadeDriveCom extends Command {
  public ArcadeDriveCom() {
    requires(Robot.driveTrainSys);
  }

  @Override
  protected void initialize() {
      
  }

  @Override
  protected void execute() {
    Robot.driveTrainSys.arcadeDrive();
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
      Robot.driveTrainSys.stop();
  }

  @Override
  protected void interrupted() {
      end();
  }
}