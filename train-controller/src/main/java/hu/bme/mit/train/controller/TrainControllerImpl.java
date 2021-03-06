package hu.bme.mit.train.controller;
// Editing.
import hu.bme.mit.train.interfaces.TrainController;
// This comment will cause problems.
public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;

	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
			referenceSpeed += step;
		}

		enforceSpeedLimit();
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		} else if(referenceSpeed < 0) {
			referenceSpeed = 0;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = -1 * joystickPosition;
	}

}
