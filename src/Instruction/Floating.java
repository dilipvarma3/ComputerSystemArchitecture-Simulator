package Instruction;

import Memory.Memory;
import Registers.Registers;
import Utilities.EffectiveAddress;
import cs.simulator.simulator;

/* Floating Instructions deal with floating point numbers
 * Vector operations are performed memory to memory.
 * format same as Load/Store: opcode (0-5) + reg (6-7) + ireg (8-9) + i (10) + address (11-15)
 */
public class Floating {
    Memory mem;
    Registers R;
    simulator GUI;
    String address;
    int intFR;
    String s;
    String q;
    String op;
    String FR;
    String IX;
    String I;
    int intIX, intI;

    public Floating(Registers register, Memory memory, String[] instruction) throws Exception {
        R = register;
        mem = memory;
        
        op = instruction[0];
        FR = instruction[1];
        //intFR=Integer.parseInt(FR);
        IX = instruction[2];
        I = instruction[3];
        intIX = Integer.parseInt(IX);
        intI = Integer.parseInt(I);
        if (FR.equals("")) {
        } else {
            intFR = Integer.parseInt(FR);
        }
        address = EffectiveAddress.computeEA(intI, intIX, instruction[4], R, mem);
        System.out.println("address:" + address);
        
    }


    // FADD: Floating Add Memory To Register
    public void FADD() throws Exception {
        if(I=="0")
        {
        String value = String.valueOf(Integer.parseInt(R.getGPR(intFR)) + Integer.parseInt(mem.getMemValue(address))); // value = c(FR) + c(EA)
        R.setFR(intFR,value);
        }
        else
        {
             String value = String.valueOf(Integer.parseInt(R.getGPR(intFR)) + Integer.parseInt(mem.getMemValue(mem.getMemValue(address)))); // value = c(FR) + c(EA)
        R.setFR(intFR,value);
        }
        int j = Integer.parseInt(address);

        q = Integer.toBinaryString(j);
        int j1;

        int count = 0;
       /* while (j1 > 0) {
            j1 = j1 / 10;
            count = count + 1;

        }
        if (count < 5) {
            int count1 = 5 - count;
            while (count1 != 0) {
                q = 0 + q;
                count1--;
            }
        }*/
       j1=(int)(Math.log(j) /Math.log(2) + 1);
     System.out.println("j1:"+j1);
    
     if(j1<=6)
     {
         count=6-j1;
         while(count!=0)
         {
             q=0+q;
             count--;
         }
     }
     else
     {
        
     }
        // System.out.println("hi");
        s = op + String.valueOf(Integer.toBinaryString(Integer.parseInt(FR))) + String.valueOf(Integer.toBinaryString(Integer.parseInt(IX))) + I + q;

        //  s="0000011010010110";
        // System.out.println("s:"+s);
        //System.out.println(Integer.parseInt(s,2));
        int dec = Integer.parseInt(s, 2);
        // System.out.println("dec:"+dec);
        //reg.setMAR(reg.getPC());                        //setting MAR value
        System.out.println(R.getPC());
        R.setMAR(R.getPC());

        cs.simulator.simulator.mar.setText(R.getMAR());                    //Displaying MAR value
        R.setMBR(String.valueOf(dec));              //setting MBR value
        cs.simulator.simulator.mbr.setText(R.getMBR());                    //Displaying MBR value
        R.setIR(String.valueOf(dec));               //setting IR value
        cs.simulator.simulator.ir.setText(R.getIR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "Register value(R" + intFR + ")" + ":");     //Log is used to display the description of what is happening to the values of MAR,MBR,IR,PC whenever we execute a instruction
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getGPR(intFR));
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "MAR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getMAR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "MBR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getMBR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "IR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getIR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "PC value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getPC());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
    }

    // FSUB: Floating Subtract Memory From Register
   public void FSUB() throws Exception {
        if(I=="0")
        {
        String value = String.valueOf(Integer.parseInt(R.getGPR(intFR)) - Integer.parseInt(mem.getMemValue(address))); // value = c(FR) + c(EA)
        R.setFR(intFR,value);
        }
        else
        {
             String value = String.valueOf(Integer.parseInt(R.getGPR(intFR)) - Integer.parseInt(mem.getMemValue(mem.getMemValue(address)))); // value = c(FR) + c(EA)
        R.setFR(intFR,value);
        }
        int j = Integer.parseInt(address);

        q = Integer.toBinaryString(j);
        int j1;

        int count = 0;
       /* while (j1 > 0) {
            j1 = j1 / 10;
            count = count + 1;

        }
        if (count < 5) {
            int count1 = 5 - count;
            while (count1 != 0) {
                q = 0 + q;
                count1--;
            }
        }*/
       j1=(int)(Math.log(j) /Math.log(2) + 1);
     System.out.println("j1:"+j1);
    
     if(j1<=6)
     {
         count=6-j1;
         while(count!=0)
         {
             q=0+q;
             count--;
         }
     }
     else
     {
        
     }
        // System.out.println("hi");
        s = op + String.valueOf(Integer.toBinaryString(Integer.parseInt(FR))) + String.valueOf(Integer.toBinaryString(Integer.parseInt(IX))) + I + q;

        //  s="0000011010010110";
        // System.out.println("s:"+s);
        //System.out.println(Integer.parseInt(s,2));
        int dec = Integer.parseInt(s, 2);
        // System.out.println("dec:"+dec);
        //reg.setMAR(reg.getPC());                        //setting MAR value
        System.out.println(R.getPC());
        R.setMAR(R.getPC());

        cs.simulator.simulator.mar.setText(R.getMAR());                    //Displaying MAR value
        R.setMBR(String.valueOf(dec));              //setting MBR value
        cs.simulator.simulator.mbr.setText(R.getMBR());                    //Displaying MBR value
        R.setIR(String.valueOf(dec));               //setting IR value
        cs.simulator.simulator.ir.setText(R.getIR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "Register value(R" + intFR + ")" + ":");     //Log is used to display the description of what is happening to the values of MAR,MBR,IR,PC whenever we execute a instruction
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getGPR(intFR));
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "MAR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getMAR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "MBR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getMBR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "IR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getIR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "PC value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getPC());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
    }

    // VADD: Vector Add
    public void JCC() {
        System.out.println("jcc1");
        if (R.getCC(intFR).equals("1")) {                      // if of cc[intIX] == 1, jump to address
            System.out.println("jumping");
            R.setPC(address);
            cs.simulator.simulator.pc.setText(R.getPC());
        } else {                                         // else PC + 1
            R.incrementPC();
            cs.simulator.simulator.pc.setText(R.getPC());
        }

        int j = Integer.parseInt(address);

        q = Integer.toBinaryString(j);
        int j1 = Integer.parseInt(q);

        int count = 0;
        while (j1 > 0) {
            j1 = j1 / 10;
            count = count + 1;

        }
        if (count < 5) {
            int count1 = 5 - count;
            while (count1 != 0) {
                q = 0 + q;
                count1--;
            }

        }
        s = op + String.valueOf(Integer.toBinaryString(Integer.parseInt(IX))) + I + q;
        System.out.println("s:" + s);
        int dec = Integer.parseInt(s, 2);
        System.out.println("dec:" + dec);
        //reg.setMAR(reg.getPC());                        //setting MAR value
        System.out.println(R.getPC());
        R.setMAR(R.getPC());

        cs.simulator.simulator.mar.setText(R.getMAR());                    //Displaying MAR value
        R.setMBR(String.valueOf(dec));              //setting MBR value
        cs.simulator.simulator.mbr.setText(R.getMBR());                    //Displaying MBR value
        R.setIR(String.valueOf(dec));               //setting IR value
        cs.simulator.simulator.ir.setText(R.getIR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "Register value(R" + intFR + ")" + ":");     //Log is used to display the description of what is happening to the values of MAR,MBR,IR,PC whenever we execute a instruction
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getGPR(intFR));
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "MAR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getMAR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "MBR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getMBR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "IR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getIR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "PC value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getPC());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");

    }

    // VSUB: Vector Subtract
    public void JMA() {// JMA: Unconditional Jump To Address
        R.setPC(address);
        cs.simulator.simulator.pc.setText(R.getPC());
        int j = Integer.parseInt(address);

        q = Integer.toBinaryString(j);
        int j1 = Integer.parseInt(q);

        int count = 0;
        while (j1 > 0) {
            j1 = j1 / 10;
            count = count + 1;

        }
        if (count < 5) {
            int count1 = 5 - count;
            while (count1 != 0) {
                q = 0 + q;
                count1--;
            }

        }
        s = op + String.valueOf(Integer.toBinaryString(Integer.parseInt(IX))) + I + q;
        //  System.out.println("s:"+s);
        int dec = Integer.parseInt(s, 2);
        // System.out.println("dec:"+dec);
        //reg.setMAR(reg.getPC());                        //setting MAR value
        //  System.out.println(R.getPC());
        R.setMAR(R.getPC());

        cs.simulator.simulator.mar.setText(R.getMAR());                    //Displaying MAR value
        R.setMBR(String.valueOf(dec));              //setting MBR value
        cs.simulator.simulator.mbr.setText(R.getMBR());                    //Displaying MBR value
        R.setIR(String.valueOf(dec));               //setting IR value
        cs.simulator.simulator.ir.setText(R.getIR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "Register value(R" + intFR + ")" + ":");     //Log is used to display the description of what is happening to the values of MAR,MBR,IR,PC whenever we execute a instruction
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getGPR(intFR));
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "MAR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getMAR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "MBR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getMBR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "IR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getIR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "PC value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getPC());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");

    }

    // CNVRT: Convert to Fixed/FloatingPoint:
    public void JSR() {// JSR: Jump and Save Return Address
        R.setGPR(3, R.incrementPC());                    // R3 <- PC + 1
        cs.simulator.simulator.r3.setText(R.getGPR(3));
        R.setPC(address);                                     // PC <- EA
// R0 should contain pointer to arguments
        cs.simulator.simulator.pc.setText(R.getPC());
        int j = Integer.parseInt(address);

        q = Integer.toBinaryString(j);
        int j1 = Integer.parseInt(q);

        int count = 0;
        while (j1 > 0) {
            j1 = j1 / 10;
            count = count + 1;

        }
        if (count < 5) {
            int count1 = 5 - count;
            while (count1 != 0) {
                q = 0 + q;
                count1--;
            }

        }
        s = op + String.valueOf(Integer.toBinaryString(Integer.parseInt(IX))) + I + q;
        System.out.println("s:" + s);
        int dec = Integer.parseInt(s, 2);
        System.out.println("dec:" + dec);
        //reg.setMAR(reg.getPC());                        //setting MAR value
        System.out.println(R.getPC());
        R.setMAR(R.getPC());

        cs.simulator.simulator.mar.setText(R.getMAR());                    //Displaying MAR value
        R.setMBR(String.valueOf(dec));              //setting MBR value
        cs.simulator.simulator.mbr.setText(R.getMBR());                    //Displaying MBR value
        R.setIR(String.valueOf(dec));               //setting IR value
        cs.simulator.simulator.ir.setText(R.getIR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "Register value(R3):");     //Log is used to display the description of what is happening to the values of MAR,MBR,IR,PC whenever we execute a instruction
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getGPR(3));
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "MAR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getMAR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "MBR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getMBR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "IR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getIR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "PC value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getPC());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");

    }


    // LDFR: Load Floating Register From Memory
    public void RFS() throws Exception {// RFS: return from subroutine with return code stored in address
        R.setGPR(0, mem.getMemValue(address));              // R0 <- return code
        cs.simulator.simulator.r0.setText(R.getGPR(0));
        R.setPC(R.getGPR(3));// PC <- R3
        cs.simulator.simulator.pc.setText(R.getPC());
        int j = Integer.parseInt(address);

        q = Integer.toBinaryString(j);
        int j1 = Integer.parseInt(q);

        int count = 0;
        while (j1 > 0) {
            j1 = j1 / 10;
            count = count + 1;

        }
        if (count < 5) {
            int count1 = 5 - count;
            while (count1 != 0) {
                q = 0 + q;
                count1--;
            }
        }
        // System.out.println("hi");
        s = op + q;

        //  s="0000011010010110";
        System.out.println("s:" + s);
        //System.out.println(Integer.parseInt(s,2));
        int dec = Integer.parseInt(s, 2);
        System.out.println("dec:" + dec);
        //reg.setMAR(reg.getPC());                        //setting MAR value
        System.out.println(R.getPC());
        R.setMAR(R.getPC());

        cs.simulator.simulator.mar.setText(R.getMAR());                    //Displaying MAR value
        R.setMBR(String.valueOf(dec));              //setting MBR value
        cs.simulator.simulator.mbr.setText(R.getMBR());                    //Displaying MBR value
        R.setIR(String.valueOf(dec));               //setting IR value
        cs.simulator.simulator.ir.setText(R.getIR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "Register value(R0)" + ":");     //Log is used to display the description of what is happening to the values of MAR,MBR,IR,PC whenever we execute a instruction
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getGPR(0));
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "MAR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getMAR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "MBR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getMBR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "IR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getIR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "PC value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getPC());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");


    }


    // STFR: Store Floating Register to Memory
    public void SOB() {// SOB: Subtract One and Branch
        R.setGPR(intFR, String.valueOf(Integer.parseInt(R.getGPR(intFR)) - 1)); // reg <- c(reg) - 1
        switch (intFR) {
            case 0:
                cs.simulator.simulator.r0.setText(R.getGPR(intFR));
                break;
            case 1:
                cs.simulator.simulator.r1.setText(R.getGPR(intFR));
                break;
            case 2:
                cs.simulator.simulator.r2.setText(R.getGPR(intFR));
                break;
            case 3:
                cs.simulator.simulator.r3.setText(R.getGPR(intFR));
                break;
            default:
                break;
        }
        if (Integer.parseInt(R.getGPR(intFR)) > 0) {   // if c(reg) > 0, jump to address
            R.setPC(address);
            cs.simulator.simulator.pc.setText(R.getPC());
        } else {                                         // else PC + 1
            R.incrementPC();
            cs.simulator.simulator.pc.setText(R.getPC());
        }
        int j = Integer.parseInt(address);

        q = Integer.toBinaryString(j);
        int j1 = Integer.parseInt(q);

        int count = 0;
        while (j1 > 0) {
            j1 = j1 / 10;
            count = count + 1;

        }
        if (count < 5) {
            int count1 = 5 - count;
            while (count1 != 0) {
                q = 0 + q;
                count1--;
            }
        }
        // System.out.println("hi");
        s = op + String.valueOf(Integer.toBinaryString(Integer.parseInt(GPR))) + String.valueOf(Integer.toBinaryString(Integer.parseInt(IX))) + I + q;

        //  s="0000011010010110";
        //  System.out.println("s:"+s);
        //System.out.println(Integer.parseInt(s,2));
        int dec = Integer.parseInt(s, 2);
        System.out.println("dec:" + dec);
        //reg.setMAR(reg.getPC());                        //setting MAR value
        System.out.println(R.getPC());
        R.setMAR(R.getPC());

        cs.simulator.simulator.mar.setText(R.getMAR());                    //Displaying MAR value
        R.setMBR(String.valueOf(dec));              //setting MBR value
        cs.simulator.simulator.mbr.setText(R.getMBR());                    //Displaying MBR value
        R.setIR(String.valueOf(dec));               //setting IR value
        cs.simulator.simulator.ir.setText(R.getIR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "Register value(R" + intFR + ")" + ":");     //Log is used to display the description of what is happening to the values of MAR,MBR,IR,PC whenever we execute a instruction
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getGPR(intFR));
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "MAR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getMAR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "MBR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getMBR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "IR value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getIR());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "PC value:");
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "" + R.getPC());
        cs.simulator.simulator.log.setText(cs.simulator.simulator.log.getText() + "\n");


    }


}
