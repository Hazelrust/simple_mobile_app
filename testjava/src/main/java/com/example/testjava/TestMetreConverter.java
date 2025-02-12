package com.example.testjava;
import javax.swing.JOptionPane;
public class TestMetreConverter {
    public static void main (String args[ ]) {
        String input,output;
        MetreConverter inchConverter = new MetreConverter();
        float changeRate, amountInMetre, amountInInch;
        output = "Metre Converter System\n";
        output = output +"Convert Inch and Metre system\n";
        input = JOptionPane.showInputDialog("Enter change rate");
        changeRate = Float.parseFloat(input);
        output= "\nInch change rate is " + changeRate;
        inchConverter.setChangeRate(changeRate);
// รับข้อมูลจำนวนหน่วยเมตรที่ต้องการเปลี่ยนเป็นหน่วยนิ้ว
        input = JOptionPane.showInputDialog("Enter Metre amount to convert to Inch");
        amountInMetre = Float.parseFloat(input);
// ทำการคำนวณหน่วยเป็นนิ้วที่เปลี่ยนได้
        amountInInch = inchConverter.fromMetre(amountInMetre);
        output = output + "\n" + amountInMetre + " metres equal to " +amountInInch + " inch.";
// รับข้อมูลจำนวนหน่วยนิ้วที่ต้องการเปลี่ยนเป็นหน่วยเมตร
        input = JOptionPane.showInputDialog("Enter Inch amount to convert to Metre");
        amountInInch = Float.parseFloat(input);
// ทำการคำนวณจำนวนหน่วยเมตรที่เปลี่ยนได้
        amountInMetre = inchConverter.toMetre(amountInInch);
        output = output +"\n" + amountInInch + " inch equal to " + amountInMetre + "metre.";
        JOptionPane.showMessageDialog(null,output);
        System.exit(0);
    }
}


class MetreConverter {
    private float changeRate;
    private String unit;
    public MetreConverter (float rate, String unit) {
        changeRate = rate;
        this.unit = unit;
    }
    public MetreConverter () {}

    public void setChangeRate (float rate) {
        changeRate = rate;
    }
    public String getUnit( ) {
        return(unit);
    }
    public float toMetre (float otherUnit) {
        return (otherUnit * changeRate);
    }
    public float fromMetre ( float metre) {
        return (metre / changeRate);
    }
}
