/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ArcadeDriveCom;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    public Joystick driver = new Joystick(0);
    public Joystick operator = new Joystick(1);

    //Driver Controls
    //Start? or Whatever Buttons
    public Button arcadeToggle = new JoystickButton(driver, 1);
    //Back? or Whatever Buttons
    public Button tankToggle = new JoystickButton(driver, 2);

    

    //Operator Controls
    public Button camera1Cycle = new JoystickButton(operator, 1);

    public OI(){
      //Just an Example
      arcadeToggle.whenPressed(new ArcadeDriveCom());
      tankToggle.whenPressed(new ArcadeDriveCom());
    }
}
