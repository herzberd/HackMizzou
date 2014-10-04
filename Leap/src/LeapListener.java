import com.leapmotion.leap.*;

public class LeapListener extends Listener
{
	public Gesture.Type gestureType;
	
	public void onConnect(Controller leapMotion)
	{
		System.out.println("Controller connected...");
		leapMotion.enableGesture(Gesture.Type.TYPE_SWIPE);
		leapMotion.enableGesture(Gesture.Type.TYPE_CIRCLE);
		leapMotion.enableGesture(Gesture.Type.TYPE_KEY_TAP);
		leapMotion.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
		leapMotion.config().save();
	}
	
	public void onDisconnect(Controller leapMotion)
	{
		System.out.println("Controller disconnected...");
	}
	

	private void setGestureType(Gesture.Type newGestureType)
	{
		this.gestureType = newGestureType;
	}

	public Gesture.Type getGestureType()
	{
		return gestureType;
	}
	
	public void onFrame(Controller leapMotion)
	{
		Frame frame = leapMotion.frame();
		GestureList gestures = frame.gestures();
		for (int x = 0; x < gestures.count(); x++)
		{
			Gesture gesture = gestures.get(x);
			
			setGestureType(gesture.type());

			switch (gesture.type())
			{
			case TYPE_SWIPE:
				SwipeGesture swipe = new SwipeGesture(gesture);
				setGestureType(swipe.type());
				break;
			case TYPE_CIRCLE:
				CircleGesture circle = new CircleGesture(gesture);
				setGestureType(circle.type());
				break;
			case TYPE_KEY_TAP:
				KeyTapGesture keytap = new KeyTapGesture(gesture);
				setGestureType(keytap.type());
				break;
			case TYPE_SCREEN_TAP:
				ScreenTapGesture screentap = new ScreenTapGesture(gesture);
				setGestureType(screentap.type());
				break;
			default:
				setGestureType(null);
				break;
			}
		}
		
		setGestureType(null);

	}
}