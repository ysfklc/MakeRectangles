/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makerectangles;

/**
 *
 * @author yusufalikilic
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MakeRectangles {
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        System.out.println("Which file do you want to read(Enter a number)??");//this line ask to user the which file do you want to read..
        Scanner input =new Scanner(System.in);
        int sayı =input.nextInt();
        String klm=null;
        int i=0,say=0;
        BufferedReader br = new BufferedReader(new FileReader("input_"+sayı+".txt"));
        String satir = br.readLine();
        while (satir!=null) {
          if(satir.length()>0){
           say++;
          }
          satir = br.readLine();                
         }  
        br.close();
        BufferedReader br1 = new BufferedReader(new FileReader("input_"+sayı+".txt"));
        Point[] p=new Point[10];//max #points is 10
            while ((klm = br1.readLine()) != null) {
                    String[] ayr=klm.split(", ");
                    if(ayr[0]==null || ayr[1]==null){
                        throw new Exception("point cannot be null");
                    }
                    p[i]=new Point(Double.parseDouble(ayr[0]),Double.parseDouble(ayr[1]));
                    i++;
            }
            br1.close();
        int fct;                    //int these lines I calculate 
        fct=say*(say-1);            //how many lines will be create..
        fct=fct/2;                  //combination of the #points of 2.. 
        Line[] l=new Line[fct];
        int j,k,m,n;
        int h=1;
        Rectangle[] r=new Rectangle[210];
        for(j=0;j<say-3;j++){
            for(k=j+1;k<say-2;k++){
                for(m=k+1;m<say-1;m++){
                    for(n=m+1;n<say;n++){
                        double s1l=Math.sqrt(Math.abs(((p[k].getX()-p[j].getX())*(p[k].getX()-p[j].getX()))+((p[k].getY()-p[j].getY())*(p[k].getY()-p[j].getY()))));
                        double s2l=Math.sqrt(Math.abs(((p[m].getX()-p[j].getX())*(p[m].getX()-p[j].getX()))+((p[m].getY()-p[j].getY())*(p[m].getY()-p[j].getY()))));
                        double s3l=Math.sqrt(Math.abs(((p[n].getX()-p[m].getX())*(p[n].getX()-p[m].getX()))+((p[n].getY()-p[m].getY())*(p[n].getY()-p[m].getY()))));
                        double s4l=Math.sqrt(Math.abs(((p[n].getX()-p[k].getX())*(p[n].getX()-p[k].getX()))+((p[n].getY()-p[k].getY())*(p[n].getY()-p[k].getY()))));
                        double Gx=(p[j].getX()+p[k].getX()+p[m].getX()+p[n].getX())/4;
                        double Gy=(p[j].getY()+p[k].getY()+p[m].getY()+p[n].getY())/4;
                        double d1=Math.pow(p[j].getX()-Gx,2)+Math.pow(p[j].getY()-Gy,2);
                        double d2=Math.pow(p[k].getX()-Gx,2)+Math.pow(p[k].getY()-Gy,2);
                        double d3=Math.pow(p[m].getX()-Gx,2)+Math.pow(p[m].getY()-Gy,2);
                        double d4=Math.pow(p[n].getX()-Gx,2)+Math.pow(p[n].getY()-Gy,2);
                        if(d1==d2 && d1==d3 && d1==d4){
                            l[0]=new Line(p[j],p[k],s1l);
                            l[1]=new Line(p[j],p[m],s2l);
                            l[2]=new Line(p[m],p[n],s3l);
                            l[3]=new Line(p[k],p[n],s4l);
                            r[h]=new Rectangle(Integer.toString(h),l[0],l[1]);
                            h++;
                        }
                    }
                }
            }
        }
        FileWriter fw = new FileWriter("output_"+sayı+".txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.println("Rectangles");
        for(int z=1;z<h;z++){
            pw.print(z+", ");
            pw.printf("%.2f\n",r[z].getPerimeter());
        }
        pw.close(); 
        
    }  
}

