// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.Constants.HopperConstants;
import frc.robot.Constants.ShooterConstants;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class HopperSubsystem extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonSRX m_hopperStage1Leader;
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    private Color detectedColor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    /**
    *
    */
    public HopperSubsystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        m_hopperStage1Leader = new WPI_TalonSRX(5);
        m_hopperStage1Leader.setNeutralMode(NeutralMode.Brake);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        detectedColor = m_colorSensor.getColor();
        double IR = m_colorSensor.getIR();
        SmartDashboard.putNumber("Red", detectedColor.red);
        SmartDashboard.putNumber("Blue", detectedColor.blue);
        SmartDashboard.putNumber("IR", IR);
        int proximity = m_colorSensor.getProximity();
        SmartDashboard.putNumber("Proximity", proximity);
        SmartDashboard.putBoolean("Hopper Loaded", isLoaded());
        SmartDashboard.putNumber("Hopper Motor", m_hopperStage1Leader.get());
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void setOutput(double output){
        m_hopperStage1Leader.set(output);
    }

    public void stopMotors(){
        m_hopperStage1Leader.set(0.0);
    }

    public boolean isRunning(){
        if(Math.abs(m_hopperStage1Leader.getMotorOutputPercent()) > 0.0){
            
            return true;
        }
        return false;
     }

    public boolean isLoaded(){
        if (m_colorSensor.getProximity() > HopperConstants.kLoadedProximity){
            RobotContainer.getInstance().m_intakeSubsystem.stopMotors();
            return true;
        }
<<<<<<< HEAD
       // RobotContainer.getInstance().m_intakeSubsystem.setOutput(1);
=======
        RobotContainer.getInstance().m_intakeSubsystem.setOutput(1);
>>>>>>> 25fd40fb3421b5d78bef3348e92e2eac7de85fad
        return false;
    }

    public boolean isCorrectColor(){
        return false;
    }
}
