// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Command.

package frc.robot.commands;
import frc.robot.RobotContainer;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.hal.simulation.RoboRioDataJNI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class autoDistanceDrive extends CommandBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private final DriveSubsystem m_driveSubsystem;
    private final double distance;

    final double kP = 0.2;
    final double kI = 0.2;
    final double kD = 0.05;
    final double iLimit = 1;

    double errorSum = 0;
    double lastTimestamp = 0;
    double lastError = 0;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    public autoDistanceDrive(DriveSubsystem subsystem, double distance) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // m_subsystem = subsystem;
        // addRequirements(m_subsystem);    

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        this.m_driveSubsystem = subsystem;
        this.distance = m_driveSubsystem.getAverageEncoderDistance() + distance;
        addRequirements(m_driveSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        System.out.println("Auto distance drive started!");
        System.out.println("Driving distance of: " + distance);

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    
        // Drive robot straight for distance
            // get sensor position
        double sensorPosition = m_driveSubsystem.getAverageEncoderDistance();
        System.out.println("Sensor Position: " + sensorPosition);
        // calculations
        double error = distance - sensorPosition;
        double dt = Timer.getFPGATimestamp() - lastTimestamp;
        if (Math.abs(error) < iLimit) {
            errorSum += error * dt;
        }
        double errorRate = (error - lastError) / dt;
        System.out.println("Error Rate: " + errorRate);
        // double outputSpeed = kP * error;
        double outputSpeed = kP * error + kI * errorSum + kD * errorRate;
        System.out.println("Output Speed: " + outputSpeed);
        m_driveSubsystem.tankDriveSpeed(outputSpeed, outputSpeed);
        //diffDrive1.tankDrive(outputSpeed, outputSpeed);
        // update last- variables
        lastTimestamp = Timer.getFPGATimestamp();
        lastError = error;
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_driveSubsystem.stopMotors();
        System.out.println("Auto distance drive ended!");
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        // Measured in reverse
        if (m_driveSubsystem.getAverageEncoderDistance() < distance){
            return true;
        } else {
            return false;
        } 
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED

    }
}