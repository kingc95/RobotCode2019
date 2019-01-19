package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ArcadeDriveCom;
import frc.robot.commands.TankDriveCom;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

 //https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599745-scheduling-commands
 //Add commands for every height and then other options. We should have manual control over parts too in case encoders drop out.
 //Maybe use sliders for arm angle and intake angle or potentiometers. We can use more than 2 joysticks as well.
public class OI {

    public Joystick driver1 = new Joystick(0);
    public Joystick driver2 = new Joystick(1);
    public Joystick operator = new Joystick(2);

    //Driver Controls
    //Start? or Whatever Buttons
    public Button arcadeToggle = new JoystickButton(driver1, 1);
    //Back? or Whatever Buttons
    public Button tankToggle = new JoystickButton(driver1, 2);



    //Operator Controls
    public Button camera1Cycle = new JoystickButton(operator, 1);

    public OI(){
      //Just an Example
      arcadeToggle.whenPressed(new ArcadeDriveCom());
      tankToggle.whenPressed(new TankDriveCom());
    }
}
