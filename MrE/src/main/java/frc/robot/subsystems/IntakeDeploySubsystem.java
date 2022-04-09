// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: PIDSubsystem.

package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.MathUtil;

import com.ctre.phoenix.motorcontrol.NeutralMode;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class IntakeDeploySubsystem extends PIDSubsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private Encoder m_encoderIntakeDeploy;
    private WPI_TalonSRX m_intakeDeploy;
    // P I D Variables
    private static final double kP = 0.02;
    private static final double kI = 0.0;
    private static final double kD = 0.0;
    private static final double kF = 0.0;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // Initialize your subsystem here
    public IntakeDeploySubsystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super(new PIDController(kP, kI, kD));
        getController().setTolerance(0.2);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        m_encoderIntakeDeploy = new Encoder(0, 1, false, EncodingType.k4X);
        addChild("m_encoderIntakeDeploy", m_encoderIntakeDeploy);
        m_encoderIntakeDeploy.setDistancePerPulse(1.0);
        m_encoderIntakeDeploy.setReverseDirection(true);

        m_intakeDeploy = new WPI_TalonSRX(4);
        m_intakeDeploy.setNeutralMode(NeutralMode.Brake);
        m_intakeDeploy.setInverted(true);
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        // Use these to get going:
        // setSetpoint() - Sets where the PID controller should move the system
        // to
        // enable() - Enables the PID controller.
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        super.periodic();
        SmartDashboard.putNumber("Intake Position", m_encoderIntakeDeploy.getDistance());

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    @Override
    public double getMeasurement() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
        // return m_encoderIntakeDeploy.pidGet();
        return m_encoderIntakeDeploy.getDistance();

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
    }

    @Override
    public void useOutput(double output, double setpoint) {
        output += setpoint * kF;
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        m_intakeDeploy.set(output);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        // m_intakeDeploy.setNeutralMode(NeutralMode.Coast);
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS
    public void resetEncoder(){
    
        m_encoderIntakeDeploy.reset();
    }

    public void stopMotors() {
        m_intakeDeploy.set(0.0);
    }

    public void setBrake() {
        m_intakeDeploy.setNeutralMode(NeutralMode.Brake);
    }
    public void setCoast() {
        m_intakeDeploy.setNeutralMode(NeutralMode.Coast);
    }

    public double getPosition() {
        return m_encoderIntakeDeploy.getDistance();
    }
}
