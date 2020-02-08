package frc.robot.utils;

import edu.wpi.first.wpilibj.Encoder;

public class PID{

    public double   kP = 0.00,
                    kI = 0.00, 
                    kD = 0.00;
    double integral, prevError = 0, setPoint = 0, error, rcw;
    int wheelSize = 6, pulsesPerRevolution = 20;
    double delta, derivitive;
    Encoder leftEnc, rightEnc;

    public PID(Encoder lEncoder, Encoder rEncoder, double kP, double kI, double kD){
        leftEnc = lEncoder;
        rightEnc = rEncoder;

        this.kP  = kP;
        this.kI = kI;
        this.kD = kD;

        

        PIDStuff();
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

    private void PIDStuff(){
        //math behind PID
        delta = leftEnc.getDistance() - rightEnc.getDistance();
        error = setPoint - (delta);
        integral = error * 0.2;
        derivitive = (error - prevError) / 0.2;
        rcw = kP * error + kI * integral + kD * derivitive;

    }


}