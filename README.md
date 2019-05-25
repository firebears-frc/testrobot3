# TestRobot

Robot program for the Firebear's 2016 robot.  This program uses an 
[experimental branch](https://github.com/Oblarg/allwpilib/tree/scheduler_command_rewrite) of WPILib.

This repositiory is also a test-bed for unit tests in WPILib.

## Notes on experimental command changes

* CommandScheduler creates a lot of CommandState objects.  It might be better to accomplish the same function without object creation or to at least create a resource pool.
* CommandScheduler uses static methods in RobotState to determine if the robot is disabled.  It would be nice if we could override this somehow, so commands could be tested despite the disabled state.
* CommandScheduler:  It would be really nice if we could get a non-singleton instance of the scheduler.