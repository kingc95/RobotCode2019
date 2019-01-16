package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class TankDriveCom extends Command {
  public TankDriveCom() {
    requires(Robot.driveTrainSys);
  }

  @Override
  protected void initialize() {
      Robot.driveTrainSys.tankDrive();
  }

  @Override
  protected void execute() {

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
