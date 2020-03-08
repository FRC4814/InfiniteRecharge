package frc.robot.utils;

import edu.wpi.first.wpilibj.Encoder;

public class PID{

    public double   kP = 0.00,
                    kI = 0.00, 
                    kD = 0.00;
    double integral, prevError = 0, setPoint = 0, error, rcw;
    double delta, derivitive;
    Encoder Enc;

    public PID(Encoder Encoder, double kP, double kI, double kD){
        Enc = Encoder;

        this.kP  = kP;
        this.kI = kI;
        this.kD = kD;

    }

    public void setSetPoint(int toSet){
        this.setPoint = toSet;
    }

    public void update(double kP, double kI, double kD){
        this.kP  = kP;
        this.kI = kI;
        this.kD = kD;
    }

    public double getOutput(){
        return rcw;
    }

    public void enablePID(){
        PIDStuff();
    }

    private void PIDStuff(){
        //math behind PID
        delta = Enc.getDistance();
        error = setPoint - (delta);
        integral = error * 0.2;
        derivitive = (error - prevError) / 0.2;
        rcw = kP * error + kI * integral + kD * derivitive;

    }


}