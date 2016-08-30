/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hand_test;

/**
 *
 * @author rahulthawal
 */
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.HandList;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.Matrix;
import com.leapmotion.leap.Vector;
public class HAND_TEST {

    
    public void onFrame(Controller controller)
    {   Frame frame = HAND_TEST.frame();
for( int h = 0; h < frame.hands().count(); h++ )
{
    Hand leapHand = frame.hands().get(h);

    Vector handXBasis =  leapHand.palmNormal().cross(leapHand.direction()).normalized();
    Vector handYBasis = leapHand.palmNormal().opposite();
    Vector handZBasis = leapHand.direction().opposite();
    Vector handOrigin =  leapHand.palmPosition();
    Matrix handTransform = new Matrix(handXBasis, handYBasis, handZBasis, handOrigin);
    handTransform = handTransform.rigidInverse();

    for( int f = 0; f < leapHand.fingers().count(); f++ )
    {
        Finger leapFinger = leapHand.fingers().get(f);
        Vector transformedPosition = handTransform.transformPoint(leapFinger.tipPosition());
        Vector transformedDirection = handTransform.transformDirection(leapFinger.direction());
        // Do something with the transformed fingers
    }
}
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Controller controller = new Controller();  
        
    }
    
}
