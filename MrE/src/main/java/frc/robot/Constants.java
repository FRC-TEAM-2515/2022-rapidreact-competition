package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

public class Constants {
    public static final class DriveConstants {

        public static final int kDriveRightLeaderID = 13;
        public static final int kDriveRigthFollowerID = 14;
        public static final int kDriveLeftLeaderID = 11;
        public static final int kDriveLeftFollowerID = 12;

        public static final double kDeadband = 0.07;
        public static final double kAcellerationLimit = 0.8; // Slew rate limiter
        public static final double kSteeringOutputModifier = 0.6; //Turn speed

        public static final double kWheelDiameterMeter = 0.1524;
        public static final double kWheelDiameterInches = 6.0;
        public static final double kDriveGearRatio = 10.71;
        public static final double kEncoderTicksPerRevolution = 168; // 96 tested, actual from documentation is 42;
        public static final double kEncoderTick2Feet = 1.0 / kEncoderTicksPerRevolution * kDriveGearRatio
                * kWheelDiameterInches * Math.PI / 12;
        public static final double kEncoderTick2Meter = 1.0 / kEncoderTicksPerRevolution * kDriveGearRatio
                * kWheelDiameterMeter * Math.PI;

        public static final double kEncoderPositionConversionFactor = kEncoderTick2Meter;
        public static final double kEncoderVelocityConversionFactor = kDriveGearRatio * Math.PI * kWheelDiameterMeter
                / 60;

        public static final double kAutoDriveForwardSpeed = 0.5;
        public static final double kAutoDriveForwardDistance = 5;
        public static double kAutoDriveDistance = -1.3; //Meters


        // The Robot Characterization Toolsuite provides a convenient tool for obtaining
        // these
        // values for your robot.
        public static final double ksVolts = 0.11653;
        public static final double kvVoltSecondsPerMeter = 0.12895;
        public static final double kaVoltSecondsSquaredPerMeter = 0.016919;
        // Example value only - as above, this must be tuned for your drive!
        public static final double kPDriveVel = 0.5;

        public static final double kTrackwidthMeters = 0.5588;
        public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(
                kTrackwidthMeters);

        public static final double kMaxSpeedMetersPerSecond = 3;
        public static final double kMaxAccelerationMetersPerSecondSquared = 1.5;

        public static final double kRamseteB = 2;
        public static final double kRamseteZeta = 0.7;
    }

    public static final class ShooterConstants {
        public static final double kVelocityConversionFactor = 1.0;
        public static int kShooterLeaderID = 19;
        public static int kShooterFollowerID = 18;
        public static double kShooterPercentOutput = 0.55;
        public static double kMaxRPM = 5700;
        public static double kMinRPM = 0;
        public static double kAutonomousSetpoint = 2000;
        public static double kIz = 0;
        public static double kFF = 0.00025;
        public static double kMinOutput = 0.0;
        public static double kMidOutput = 0.57;  //2800 RPM
        public static double kMaxOutput = 0.75;
        public static double kP = 0.00012;
        public static double kI = 0.0;
        public static double kD = 0.0;
        // public static final double kF = 0.00025;
        public static final double kSpinupDelay = 1;

    }

    public static final class IntakeConstants {
            public static final double kMaxEncoderPosition = 130.0; //144 full deployed
    }

    public static final class HopperConstants {
            public static final double kLoadedProximity = 100;
    }

    public static final class VisionConstants {
          
            public static final double kLimelightMountAngleDegrees = 20.0 ;
            public static final double kLimelightLensHeightInches = 32.0;
            public static final double kGoalHeightInches = 104;
    }
}
