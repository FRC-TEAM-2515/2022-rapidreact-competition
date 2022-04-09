package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class cmdSafeReset extends InstantCommand {

    // Called once when this command runs
    @Override
    public void initialize() {
        RobotContainer.getInstance().safeReset();
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
