package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmSys extends Subsystem {
    CANSparkMax arm1 = new CANSparkMax(4, MotorType.kBrushless);
    CANSparkMax arm2 = new CANSparkMax(5, MotorType.kBrushless);

    CANEncoder arm1Encode = arm1.getEncoder();
    CANEncoder arm2Encode = arm2.getEncoder();

    public static final int countsPerRev = 42;
    public static final int gearBoxMultiplier = 256;
    public static final int countsPerDegree = (countsPerRev * gearBoxMultiplier) / 360;

   public void armLevel1(){
       arm2.setInverted(true);

        //Check for Encoder Position. 42 counts per 1 Rev of Motor. Multiply by Gearbox ratio. Example 256:1 gearbox means 10752 counts per 1 rev of gearbox.
        //Then divide the 10752 / 360 to get counts per degree of movement. Should use hard coded constants for gear ratio, counts per rev on motor and then counts per degree

        //Set arm encoders Output Ratio in Spark Max client to the ratio of the gearbox.
        //This allows use to use Degrees of the Arm instead of encoder counts. Numbers in if/elseif are degrees of motion
        
        //Operator will need to hold down the button for each level. Upon release of level button motors are stopped.
      if ((arm1Encode.getPosition() / countsPerDegree) < 15.0){
          arm1.set(1);
          arm2.set(1);
      }
      else if ((arm1Encode.getPosition() / countsPerDegree) > 15.0 && (arm1Encode.getPosition() / countsPerDegree) < 16.0){
        arm1.set(0);
        arm2.set(0);
      }
      else if ((arm1Encode.getPosition() / countsPerDegree) < 16.0){
        arm1.set(-1);
        arm2.set(-1);
      }
      else {
          SmartDashboard.putString("Errors:", "Message 1: Arm Motor Failure. Encoder may be non functional");
      }

   }

   public void armLevel2(){
        arm2.setInverted(true);

        //Check for Encoder Position. 42 counts per 1 Rev of Motor. Multiply by Gearbox ratio. Example 256:1 gearbox means 10752 counts per 1 rev of gearbox.
        //Then divide the 10752 / 360 to get counts per degree of movement. Should use hard coded constants for gear ratio, counts per rev on motor and then counts per degree

        //Set arm encoders Output Ratio in Spark Max client to the ratio of the gearbox.
        //This allows use to use Degrees of the Arm instead of encoder counts. Numbers in if/elseif are degrees of motion
        
        //Operator will need to hold down the button for each level. Upon release of level button motors are stopped.
    if ((arm1Encode.getPosition() / countsPerDegree) < 35.0){
        arm1.set(1);
        arm2.set(1);
    }
    else if ((arm1Encode.getPosition() / countsPerDegree) > 35.0 && (arm1Encode.getPosition() / countsPerDegree) < 36.0){
        arm1.set(0);
        arm2.set(0);
    }
    else if ((arm1Encode.getPosition() / countsPerDegree) < 36.0){
        arm1.set(-1);
        arm2.set(-1);
    }
    else {
        SmartDashboard.putString("Errors:", "Message 1: Arm Motor Failure. Encoder may be non functional");
    }

    }

    public void armLevel3(){
        arm2.setInverted(true);
 
         //Check for Encoder Position. 42 counts per 1 Rev of Motor. Multiply by Gearbox ratio. Example 256:1 gearbox means 10752 counts per 1 rev of gearbox.
         //Then divide the 10752 / 360 to get counts per degree of movement. Should use hard coded constants for gear ratio, counts per rev on motor and then counts per degree
 
         //Set arm encoders Output Ratio in Spark Max client to the ratio of the gearbox.
         //This allows use to use Degrees of the Arm instead of encoder counts. Numbers in if/elseif are degrees of motion
         
         //Operator will need to hold down the button for each level. Upon release of level button motors are stopped.
       if ((arm1Encode.getPosition() / countsPerDegree) < 75.0){
           arm1.set(1);
           arm2.set(1);
       }
       else if ((arm1Encode.getPosition() / countsPerDegree) > 75.0 && (arm1Encode.getPosition() / countsPerDegree) < 76.0){
         arm1.set(0);
         arm2.set(0);
       }
       else if ((arm1Encode.getPosition() / countsPerDegree) < 76.0){
         arm1.set(-1);
         arm2.set(-1);
       }
       else {
           SmartDashboard.putString("Errors:", "Message 1: Arm Motor Failure. Encoder may be non functional");
       }
 
    }

    public void stop(){
        arm1.stopMotor();
        arm2.stopMotor();
    }

  @Override
  public void initDefaultCommand() {

  }
}

