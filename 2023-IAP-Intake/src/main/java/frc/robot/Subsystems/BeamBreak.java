// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class BeamBreak extends SubsystemBase {
  /** Creates a new beamBreak. */

  //Crreate variables and set them with values 
  Timer timer = new Timer();
  double seconds;
  DigitalInput beamBreak = new DigitalInput(Constants.BallHandlerPorts.beamBreakPort);
  DigitalInput beamBreak2 = new DigitalInput(Constants.BallHandlerPorts.beamBreakPort2);

  public BeamBreak() {
  }

  public boolean getSensor(){
    return !beamBreak.get();
  }
  public boolean getSecondSensor(){
    return !beamBreak2.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //if it get the sensor, the timer will start 
    if(getSensor()){
      timer.start();
    }

    //record the sensor timer in seconds 
    if(getSecondSensor()){
      //if the timer is start 
      if(timer.get() > 0){
        //record the timer in second 
        seconds = timer.get();
      }
      timer.stop(); //Stop timer
      timer.reset(); //Reset timer 
    }

    SmartDashboard.putBoolean("beamBreak1", getSensor());
    SmartDashboard.putBoolean("beamBreak2", getSecondSensor());
    SmartDashboard.putNumber("seconds", seconds);
    SmartDashboard.putNumber("timer", timer.get());

  }
}